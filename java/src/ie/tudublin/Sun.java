package ie.tudublin;

public class Sun extends SectorObject
{
    public Sun(UI ui, Sector sector, Colour colour, int size, int distance)
    {
        super(ui, sector, colour, size, distance);
        this.distance = 0;
        this.size = size * 8;
    }
}
