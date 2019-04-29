package ie.tudublin;

import java.util.Random;

public class Planet extends SectorObject
{
    int size;
    float a;

    Random rand = new Random();

    public Planet(UI ui, Sector sector, Colour colour, int size)
    {
        super(ui, sector, colour, size);
        this.distance = rand.nextInt((int) (ui.width * 0.15) - 100) + 100;
        this.size = rand.nextInt(5) + 1;
        this.a = rand.nextInt(500) / 100;
    }

    public void render(float x, float y)
    {
        int r = colour.r;
        int g = colour.g;
        int b = colour.b;
        
        ui.stroke(r, g, b);
        ui.fill(r, g, b);
        ui.circle(x + (float)(Math.sin(a) * distance), y + (float)(Math.cos(a) * distance), size * 5);
        ui.stroke(203, 203, 203);
        ui.noFill();

        a += 0.001 / (distance * distance) * 50000;
    }
}
