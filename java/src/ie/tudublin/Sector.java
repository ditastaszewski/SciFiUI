package ie.tudublin;

import java.util.Random;
import java.util.ArrayList;

public class Sector
{
    public int brightness;
    public int size;
    public int population;
    public int planets;
    public int habitable;
    public int habitableCount;

    private String name;
    private Colour colour;
    private String description;
    private String planetsDesc;
    private String habitableDesc;
    private String populationDesc;

    public ArrayList<SectorObject> sectorObjects = new ArrayList<SectorObject>();

    UI ui;

    Random rand = new Random();


    public Sector(UI ui, Colour colour, int brightness, int size, String name, int population, int planets, int habitable, String description)
    {
        this.ui = ui;
        this.colour = colour;
        this.brightness = brightness;
        this.size = size;
        this.name = name;
        this.population = population;
        this.planets = planets;
        this.habitable = habitable;
        this.habitableCount = habitable;
        this.description = description;

        if (size > 0)
        {
            createStar();
        }

        if (planets > 0)
        {
            createPlanets();
        }
        
        if (name.equals("Empty Sector"))
        {
            createAsteroids();
        }

        //Descriptions for info about the sector 
        if (habitable == 0 && planets > 1)
        {
            this.habitableDesc = "none of these planets are capable of hosting life.";
        }
        else if (habitable == 0 && planets == 1)
        {
            this.habitableDesc = "it is not capable of hosting life.";
        }
        else if (habitable == 1 && planets > 1)
        {
            this.habitableDesc = "only one is habitable.";
        }
        else if (planets == 1)
        {
            this.habitableDesc = "it is capable of hosting life.";
        }
        else
        {
            this.habitableDesc = habitable + " of which are habitable.";
        }

        if (planets == 0)
        {
            this.planetsDesc = "There are no planets in this sector.";
            this.habitableDesc = "";
        }
        else if (planets == 1)
        {
            this.planetsDesc = "There is 1 planet in this sector, ";
        }
        else
        {
            this.planetsDesc = "There are " + planets + " planets in this sector, ";
        }

        if (population == 0)
        {
            this.populationDesc = "There is no life to be found in this sector.";
        }
        else
        {
            this.populationDesc = "This sector is home to around " + population + " million life forms.";
        }

    }

    public void createStar()
    {
        sectorObjects.add(new Sun(ui, this, colour, size, 0));
    }

    public void createPlanets()
    {
        int distance = rand.nextInt(150 / planets) + 70;
        Colour newPlanetColour;
        //int distance = 150 / planets + 70;
        for (int i = 0 ; i < planets ; i ++)
        {
            if (habitableCount > 0)
            {
                newPlanetColour = ui.colours.get(rand.nextInt(11) + 7);
                habitableCount --;
            }
            else
            {
                newPlanetColour = ui.colours.get(rand.nextInt(3) + 18);
            }

            sectorObjects.add(new Planet(ui, this, newPlanetColour, rand.nextInt(4) + 2, distance));

            distance += rand.nextInt(200 / planets) + 20;
            //distance += 200 / planets + 20;
        }
    }

    public void createAsteroids()
    {
        int distance = 15;
        for (int i = 0 ; i < rand.nextInt(20) + 30 ; i ++)
        {
            sectorObjects.add(new Asteroid(ui, this, ui.findColour("asteroid"), rand.nextInt(2) + 1, distance));
            distance += rand.nextInt(5) + 5;
        }
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the colour
     */
    public Colour getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getPlanetsDesc() {
        return planetsDesc;
    }

    /**
     * @param description the description to set
     */
    public void setPlanetsDesc(String planetsDesc) {
        this.planetsDesc = planetsDesc;
    }

    /**
     * @return the description
     */
    public String getHabitableDesc() {
        return habitableDesc;
    }

    /**
     * @param description the description to set
     */
    public void getHabitableDesc(String habitableDesc) {
        this.habitableDesc = habitableDesc;
    }

    /**
     * @return the description
     */
    public String getPopulationDesc() {
        return populationDesc;
    }

    /**
     * @param description the description to set
     */
    public void getPopulationDesc(String populationDesc) {
        this.populationDesc = populationDesc;
    }

    /**
     * @return the brightness
     */
    public int getBrightness() {
        return brightness;
    }

    /**
     * @param brightness the brightness to set
     */
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * @return the planets
     */
    public int getPlanets() {
        return planets;
    }

    /**
     * @param planets the planets to set
     */
    public void setPlanets(int planets) {
        this.planets = planets;
    }

    /**
     * @return the habitable
     */
    public int getHabitable() {
        return habitable;
    }

    /**
     * @param habitable the habitable to set
     */
    public void setHabitable(int habitable) {
        this.habitable = habitable;
    }

    /**
     * @param habitableDesc the habitableDesc to set
     */
    public void setHabitableDesc(String habitableDesc) {
        this.habitableDesc = habitableDesc;
    }

    /**
     * @param populationDesc the populationDesc to set
     */
    public void setPopulationDesc(String populationDesc) {
        this.populationDesc = populationDesc;
    }

    /**
     * @return the sectorObjects
     */
    public ArrayList<SectorObject> getSectorObjects() {
        return sectorObjects;
    }

    /**
     * @param sectorObjects the sectorObjects to set
     */
    public void setSectorObjects(ArrayList<SectorObject> sectorObjects) {
        this.sectorObjects = sectorObjects;
    }

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }

}
