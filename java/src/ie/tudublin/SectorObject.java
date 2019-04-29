package ie.tudublin;

public class SectorObject
{
    public int brightness;
    public int size;
    public int distance;
    public float a;

    Colour colour;
    Sector sector;

    CelestialObject CO;
    UI ui;

    public SectorObject(UI ui, Sector sector, Colour colour, int size, int distance)
    {
        this.ui = ui;
        this.colour = colour;
        this.size = size;
        this.sector = sector;
        this.distance = distance;
    }

    public void render(float x, float y)
    {
        int r = colour.r;
        int g = colour.g;
        int b = colour.b;
        
        ui.stroke(r, g, b);
        ui.fill(r, g, b);
        ui.circle(x + (float)(Math.sin(a) * distance), y + (float)(Math.cos(a) * distance), size * 5);
        ui.noFill();
        ui.circle(x, y, distance * 2);
        ui.stroke(203, 203, 203);
        
        if (distance > 0)
        {
            a += 0.001 / (distance * distance) * 50000;
        }
        else
        {
            a = 0;
        }
        
    }
}
