package ie.tudublin;

public class Sun extends SectorObject
{
    public Sun(UI ui, Sector sector, Colour colour, int size)
    {
        super(ui, sector, colour, size);
    }

    public void render(float x, float y)
    {
        int r = sector.getColour().r;
        int g = sector.getColour().g;
        int b = sector.getColour().b;
        
        ui.stroke(r, g, b);
        ui.fill(r, g, b);
        ui.circle(x, y, sector.size * 20);
        ui.stroke(203, 203, 203);
        ui.noFill();
    }
}
