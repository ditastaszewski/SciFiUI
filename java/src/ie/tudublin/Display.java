package ie.tudublin;

import processing.core.PApplet;

public class Display
{
    private float x;
    private float dx = 1;
    private float y;
    private float radius;
    UI ui;

    private float a = 0;
    private int displacement = 50;

    public Display(UI ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
    }
    
    public void render()
    {
        ui.stroke(203,203,203);
        ui.noFill();
        ui.line(ui.width - x, displacement, ui.width - displacement, displacement);
        ui.rect(ui.width - x, displacement * 2, x - displacement, y - displacement);

    }

    public void update()
    {

    }
}
