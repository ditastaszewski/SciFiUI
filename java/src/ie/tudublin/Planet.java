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
        this.a = rand.nextInt(500) / 100;
    }

    
}
