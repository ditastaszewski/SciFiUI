package ie.tudublin;

public class SectorObject
{
    public int brightness;
    public int size;

    private String colour;
    private Sector sector;


    public SectorObject(Sector sector, String colour, int size)
    {
        this.colour = colour;
        this.size = size;
        this.sector = sector;
    }
}
