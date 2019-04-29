package ie.tudublin;

import java.util.Random;

public class Planet extends SectorObject
{

    Random rand = new Random();

    public Planet(UI ui, Sector sector, Colour colour, int size, int distance)
    {
        super(ui, sector, colour, size, distance);
        //this.distance = rand.nextInt((int) (ui.width * 0.15) - 100) + 100;
        this.size = size;
        this.a = rand.nextInt(500);
    }

    public void render(float x, float y)
    {
        super.render(x, y);
        
        int r = colour.r;
        int g = colour.g;
        int b = colour.b;

        ui.stroke(r, g, b);
        ui.circle(x, y, distance * 2);
        ui.stroke(203, 203, 203);
    }

    
}
