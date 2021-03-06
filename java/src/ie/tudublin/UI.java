package ie.tudublin;

import java.util.ArrayList;
import java.util.Collections;

import javax.lang.model.util.ElementScanner6;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    Radar r, rn;
    SectorDisplay sd;
    SectorMap sm;
    SectorInfo si;
    SectorObjectInfo soi;
    int sectorOption = 0;
    float last = 0;
    float minDelay = 0.2f;

    int which = -1;
    int activeWhich = 0;

    int objectWhich = -1;

    boolean[] keys = new boolean[1024];

    public ArrayList<SectorButton> sectorButtons = new ArrayList<SectorButton>(); 
    public ArrayList<Sector> sectors = new ArrayList<Sector>();
    public ArrayList<Colour> colours = new ArrayList<Colour>();
    public ArrayList<CelestialObject> celestialObjects = new ArrayList<CelestialObject>();

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {   
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        fullScreen(); 
    }

    public void setup()
    {
        //b = new Button(this, 50, 50, 100, 50, "I am a button");
        //mc = new MovingCircle(this, width / 2, height / 2, 50);
        //r = new Radar(this, width / 2, height / 2, 250);

        loadColours();
        loadCelestialObjects();

        sd = new SectorDisplay(this, width/2, 0, width/2, (int) (height * 0.90), "Sector Display");
        sm = new SectorMap(this, 0, 0, width/2, (int) (height * 0.50), "Sector Map");
        si = new SectorInfo(this, 0, (int) (height * 0.55), width/2, (int) (height * 0.35), "Sector Info");
        soi = new SectorObjectInfo(this);
        loadSectors();
        //rn = new Radar(this, width / 2, height / 2, 500);
    }

    public void loadCelestialObjects()
    {
        Table table = loadTable("objects.csv", "header");
        for(TableRow tr:table.rows())
        {
            String colourName = tr.getString("colour");
            String objectType = tr.getString("type");
            String temperature = tr.getString("temperature");
            String weather = tr.getString("weather");

            celestialObjects.add(new CelestialObject(colourName, objectType, temperature, weather));
        }
    }

    public void loadColours()
    {
        Table table = loadTable("colours.csv", "header");
        for(TableRow tr:table.rows())
        {
            String colourName = tr.getString("colour");

            int colourR = tr.getInt("r");
            int colourG = tr.getInt("g");
            int colourB = tr.getInt("b");
            colours.add(new Colour(colourName, colourR, colourG, colourB));
        }
    }

    public void loadSectors()
    {
        Table table = loadTable("sectors.csv", "header");
        for(TableRow tr:table.rows())
        {
            String sectorName = tr.getString("name");
            String sectorSunColour = tr.getString("colour");
            String sectorDesc = tr.getString("description");

            int sectorSunBrightness = tr.getInt("brightness");
            int sectorSunSize = tr.getInt("size");
            int sectorPopulation = tr.getInt("population");
            int sectorPlanets = tr.getInt("planets");
            int sectorHabitablePlanets = tr.getInt("habitable");
            
            sectors.add(new Sector(this, findColour(sectorSunColour), sectorSunBrightness, sectorSunSize, sectorName, sectorPopulation, sectorPlanets, sectorHabitablePlanets, sectorDesc));
        }
        
        //add empty sectors to the arraylist
        while (sectors.size() < sectorButtons.size())
        {
            sectors.add(new Sector(this, findColour("white"), 0, 0, "Empty Sector", 0, 0, 0, "An empty sector, nothing to be found here but asteroids and debris."));
        }

        //randomize the arraylist for fun and variety
        Collections.shuffle(sectors);

        //assign the sectors to sectorbuttons
        for (int i = 0 ; i < sectorButtons.size() ; i ++)
        {
            sectorButtons.get(i).setSector(sectors.get(i));
        }
    }

    public Colour findColour(String colourName)
    {
        for (int i = 0 ; i < colours.size() ; i ++)
        {
            if (colours.get(i).getColourName().equals(colourName))
            {
                return colours.get(i);
            }
        }
        return colours.get(4);
    }

    public CelestialObject findObject(String colourName)
    {
        for (int i = 0 ; i < celestialObjects.size() ; i ++)
        {
            if (celestialObjects.get(i).getColourName().equals(colourName))
            {
                return celestialObjects.get(i);
            }
        }
        return celestialObjects.get(4);
    }

    public void mouseClicked()
    {        
        //Checking the sector buttons
        int totalSectors = sm.getTotalSectors();
        int sectorColumns = sm.getTotalSectorsWidth();
        int sectorRows = totalSectors / sectorColumns;

        float startX = sm.getStartX();
        float startY = sm.getStartY();
        float size = sm.getGridSize();

        int oldWhich = which;
        
        //check if mouse is in the sectormap grid and assign it to the proper sectorbutton object
        if (mouseX > startX && mouseX < startX + size * sectorColumns && mouseY > startY && mouseY < startY + size * sectorRows)
        {
            if (activeWhich != -1)
            {
                sectorButtons.get(activeWhich).setActive(false);
            }

            which = (int) ((mouseX - startX) / size) + (int) ((mouseY - startY) / size) * sectorColumns;
            sectorButtons.get(which).setActive(true);
            activeWhich = which;
            sectorOption = which;
            objectWhich = -1;
        }
        else
        {
            which = -1;
            
        }


        if (which != -1 && oldWhich != -1)
        {
            sectorButtons.get(oldWhich).setActive(false);
        }

        //Checking the sector planets/sun/asteroids
        objectWhich = -1;
        Sector sector = sectors.get(sectorOption);
        for (int i = 0 ; i < sector.getSectorObjects().size() ; i ++)
        {
            SectorObject so = sector.getSectorObjects().get(i);
            int clickSize = so.size * 3;
            if (mouseX > so.rX - clickSize && mouseX < so.rX + clickSize && mouseY > so.rY - clickSize && mouseY < so.rY + clickSize)
            {
                if (objectWhich == i)
                {
                    objectWhich = -1;
                }
                else
                {
                    objectWhich = i;
                }
            }
        }
    }

    public void draw()
    {
        background(0);

        if (sectorOption > sm.getTotalSectors() - 1) 
        {
            sectorOption = 0;
            activeWhich = 0;
        }
        
        if (sectorOption < 0)
        {
            sectorOption = sm.getTotalSectors() - 1;
            activeWhich = sectorOption;
        }

        Sector sector = sectors.get(sectorOption);
       
        if (objectWhich > sector.getSectorObjects().size() - 1)
        {
            objectWhich = 0;
        }

        sd.render();
        sm.render();
        si.render();
        soi.render();

        sd.update(sector);
        sm.update();

        sectorButtons.get(sectorOption).setActive(true);

        for (int i = sectorButtons.size() - 1 ; i >= 0 ; i --)
        {
            SectorButton sb = sectorButtons.get(i);
            sb.render();
            sb.update();
        }

        si.update(sector);
        if (objectWhich != -1)
        {
            soi.update(sector.getSectorObjects().get(objectWhich));
        }

        if (checkKey(LEFT))
        {
            //System.out.println("Left arrow key pressed");
            float delay = sm.getDelay(last);
            
            if (delay > minDelay)
            {
                last = millis();
                sectorOption --;
            }
            
        }
        if (checkKey(RIGHT))
        {
            float delay = sm.getDelay(last);
            
            if (delay > minDelay)
            {
                last = millis();
                sectorOption ++;
            }
        }
        if (checkKey(UP))
        {
            float delay = sm.getDelay(last);
            
            if (delay > minDelay)
            {
                last = millis();
                sectorOption -= sm.getTotalSectorsWidth();
                if (sectorOption < 0)
                {
                    sectorOption += sm.getTotalSectorsWidth() * (sm.getTotalSectors() / sm.getTotalSectorsWidth());
                }
            }
        }
        if (checkKey(DOWN))
        {
            float delay = sm.getDelay(last);
            
            if (delay > minDelay)
            {
                last = millis();
                sectorOption += sm.getTotalSectorsWidth();
                if (sectorOption > sm.getTotalSectors())
                {
                    sectorOption -= sm.getTotalSectorsWidth() * (sm.getTotalSectors() / sm.getTotalSectorsWidth());
                }
            }
        }

        if (checkKey(LEFT) || checkKey(RIGHT) || checkKey(UP) || checkKey(DOWN))
        {

            sectorButtons.get(activeWhich).setActive(false);
            activeWhich = sectorOption;
            objectWhich = -1;

        }

        if (keyPressed)
        {
            float delay = sm.getDelay(last);

            if (delay > minDelay)
            {
                last = millis();
                if (key == ' ')
                {
                    objectWhich ++;
                }
               
            }
        }
    }
}

