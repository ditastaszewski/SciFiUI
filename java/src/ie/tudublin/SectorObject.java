package ie.tudublin;

public class SectorObject
{
    public int brightness;
    public int size;
    public int distance;
    public float a;
    public float rX;
    public float rY;

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
        rX = x + (float)(Math.sin(a) * distance);
        rY = y + (float)(Math.cos(a) * distance);
        
        ui.stroke(r, g, b);
        ui.fill(r, g, b);
        ui.circle(rX, rY, size * 5);
        ui.noFill();
        ui.stroke(203, 203, 203);

        orbit();
    }

    public void orbit()
    {
        if (distance > 0)
        {
            a += 0.001 / (distance * distance) * 20000;
        }
        else
        {
            a = 0;
        }
    }
}
