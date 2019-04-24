package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    Radar r, rn;
    Display d;
    SectorMap sm;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {   
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        fullScreen(); 
    }

    public void setup()
    {
        //b = new Button(this, 50, 50, 100, 50, "I am a button");
        //mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new Radar(this, width / 2, height / 2, 250);
        d = new Display(this, width/2, 0, width/2, (int) (height * 0.90), "Sector XV");
        sm = new SectorMap(this, 0, 0, width/2, (int) (height * 0.50), "Sector Map");
        //rn = new Radar(this, width / 2, height / 2, 500);
    }

    public void draw()
    {
        background(0);
        //b.render();
        

        //mc.update();
        //mc.render();

        r.update();
        r.render();

        //rn.update();
        //rn.render();
        d.update();
        d.render();
        sm.update();
        sm.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

