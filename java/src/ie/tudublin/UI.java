package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    Radar r, rn;
    Display d;
    SectorMap sm;
    int sectorOption = 0;
    float last = 0;
    float minDelay = 0.2f;

    boolean[] keys = new boolean[1024];

    public ArrayList<SectorButton> sectorButtons = new ArrayList<SectorButton>(); 

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
        r = new Radar(this, width / 2, height / 2, 250);
        d = new Display(this, width/2, 0, width/2, (int) (height * 0.90), "Sector XV");
        sm = new SectorMap(this, 0, 0, width/2, (int) (height * 0.50), "Sector Map");
        //rn = new Radar(this, width / 2, height / 2, 500);
    }

    public void mouseClicked()
    {
        int which = -1;
        int totalSectors = sm.getTotalSectors();
        int sectorColumns = sm.getTotalSectorsWidth();
        int sectorRows = totalSectors / sectorColumns;

        float startX = sm.getStartX();
        float startY = sm.getStartY();
        float size = sm.getGridSize();
        if (mouseX > startX && mouseX < startX + size * sectorColumns && mouseY > startY && mouseY < startY + size * sectorRows)
        {
            which = (int) ((mouseX - startX) / size) + (int) ((mouseY - startY) / size) * sectorColumns;
        }
        
        
       
    }

    public void draw()
    {
        

        background(0);
        //b.render();
        

        //mc.update();
        //mc.render();

        r.update();
        r.render();

        //rn.update();
        //rn.render();
        d.update();
        d.render();
        sm.update();
        sm.render(sectorOption);

        for (int i = sectorButtons.size() - 1 ; i >= 0 ; i --)
        {
            SectorButton sb = sectorButtons.get(i);
            sb.render();
            sb.update();
            //System.out.println(sb.x);
            //System.out.println(sb.y);
        }

        if (sectorOption > sm.getTotalSectors() - 1) 
        {
            sectorOption = 0;
        }
        
        if (sectorOption < 0)
        {
            sectorOption = sm.getTotalSectors() - 1;
        }

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
            float delay = sm.getDelay(last);
            
            if (delay > minDelay)
            {
                last = millis();
                sectorOption --;
            }
            
        }
        if (checkKey(RIGHT))
        {
            System.out.println("Right arrow key pressed");
            float delay = sm.getDelay(last);
            
            if (delay > minDelay)
            {
                last = millis();
                sectorOption ++;
            }
        }
        if (checkKey(UP))
        {
            System.out.println("Right arrow key pressed");
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
            System.out.println("Down arrow key pressed");
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
    }
}

