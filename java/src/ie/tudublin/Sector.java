package ie.tudublin;

public class Sector
{
    public int brightness;
    public int size;
    public int population;
    public int planets;
    public int habitable;

    private String name;
    private String colour;
    private String description;


    public Sector(String colour, int brightness, int size, String name, int population, int planets, int habitable, String description)
    {
        this.colour = colour;
        this.brightness = brightness;
        this.size = size;
        this.name = name;
        this.population = population;
        this.planets = planets;
        this.habitable = habitable;
        this.description = description;
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
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(String colour) {
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

}
