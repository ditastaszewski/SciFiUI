package ie.tudublin;

import javax.lang.model.util.ElementScanner6;

public class Sector
{
    public int brightness;
    public int size;
    public int population;
    public int planets;
    public int habitable;

    private String name;
    private Colour colour;
    private String description;
    private String planetsDesc;
    private String habitableDesc;
    private String populationDesc;


    public Sector(Colour colour, int brightness, int size, String name, int population, int planets, int habitable, String description)
    {
        this.colour = colour;
        this.brightness = brightness;
        this.size = size;
        this.name = name;
        this.population = population;
        this.planets = planets;
        this.habitable = habitable;
        this.description = description;

        if (habitable == 0)
        {
            this.habitableDesc = "none of these planets are capable of hosting life.";
        }
        else if (habitable == 1)
        {
            this.habitableDesc = "only one is habitable.";
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
            this.populationDesc = "This sector is home to around " + population + " million beings.";
        }
    }

    public void createStar()
    {

    }

    public void createPlanets()
    {

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

}
