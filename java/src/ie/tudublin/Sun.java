package ie.tudublin;

public class Sun extends SectorObject
{
    public Sun(UI ui, Sector sector, Colour colour, int size, int distance)
    {
        super(ui, sector, colour, size, distance);
        this.distance = 0;
    }

    public void render(float x, float y)
    {
        int r = colour.r;
        int g = colour.g;
        int b = colour.b;
        
        ui.stroke(r, g, b);
        ui.fill(r, g, b);
        ui.circle(x, y, sector.size * 40);
        ui.stroke(203, 203, 203);
        ui.noFill();
    }
}
