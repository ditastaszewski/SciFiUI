package ie.tudublin;

public class Sun
{
    public int brightness;
    public int size;

    private String colour;
    private Sector sector;


    public Sun(Sector sector, String colour, int brightness, int size)
    {
        this.colour = colour;
        this.brightness = brightness;
        this.size = size;
        this.sector = sector;
    }
}
