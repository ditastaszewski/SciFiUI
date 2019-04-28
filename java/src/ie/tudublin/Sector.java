package ie.tudublin;

import sun.net.www.content.text.plain;

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

    

}
