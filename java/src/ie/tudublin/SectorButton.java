package ie.tudublin;

import processing.core.PApplet;

public class SectorButton {
    private int totalSectors;
    private int totalSectorsHeight;

    public float x;
    public float y;
    private float size;

    UI ui;

    public SectorButton(UI ui, float x, float y, float size) 
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public boolean checkPress()
    {
        return false;
    }

    public void render() 
    {
        //ui.stroke(0, 255, 0);
        ui.rect(x, y, size, size);
        //ui.stroke(203, 203, 203);
    }

    public void update()
    {

    }
}
