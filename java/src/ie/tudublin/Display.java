package ie.tudublin;

import processing.core.PApplet;

public class Display
{
    private float x1;
    private float y1;
    private float x2;
    private float y2;
    private float dx = 1;

    private float radius;
    UI ui;

    private float a = 0;
    private int displacement;
    

    public Display(UI ui, float x1, float y1, float x2, float y2)
    {
        this.ui = ui;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.displacement = (int) (ui.height * 0.05);
    }
    
    public void render()
    {
        ui.stroke(203,203,203);
        ui.noFill();
        ui.line(ui.width - x1, displacement, ui.width - displacement, displacement);
        ui.rect(ui.width - x1, displacement * 2, x1 - displacement, y1 - displacement);

    }

    public void update()
    {

    }
}
