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
    

    public Display(UI ui, float x1, float y1, float dWidth, float dHeight)
    {
        this.ui = ui;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = dWidth;
        this.y2 = dHeight;
        this.displacement = (int) (ui.height * 0.05);
    }
    
    public void render()
    {
        ui.stroke(203,203,203);
        ui.noFill();
        ui.line(x1 + displacement, y1 + displacement, x1 + x2 - displacement, y1 + displacement);
        ui.rect(x1 + displacement, y1 + displacement * 2, x2 - displacement * 2, y2 - displacement);
    }

    public void update()
    {

    }
}
