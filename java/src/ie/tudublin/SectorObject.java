package ie.tudublin;

public class SectorObject
{
    public int brightness;
    public int size;

    private Colour colour;
    private Sector sector;


    public SectorObject(Sector sector, Colour colour, int size)
    {
        this.colour = colour;
        this.size = size;
        this.sector = sector;
    }
}
