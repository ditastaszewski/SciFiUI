package ie.tudublin;

import java.util.Random;

public class Asteroid extends SectorObject
{

    Random rand = new Random();

    public Asteroid(UI ui, Sector sector, Colour colour, int size, int distance)
    {
        super(ui, sector, colour, size, distance);
        //this.distance = rand.nextInt((int) (ui.width * 0.15) - 100) + 100;
        this.size = size;
        this.a = rand.nextInt(500) / 1;
    }

    public void orbit()
    {

    }
    
}
