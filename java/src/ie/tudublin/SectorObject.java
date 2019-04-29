package ie.tudublin;

public class SectorObject
{
    public int brightness;
    public int size;

    Colour colour;
    Sector sector;

    CelestialObject CO;
    UI ui;

    public SectorObject(UI ui, Sector sector, Colour colour, int size)
    {
        this.ui = ui;
        this.colour = colour;
        this.size = size;
        this.sector = sector;
    }

    public void render(float x, float y)
    {

    }
}
