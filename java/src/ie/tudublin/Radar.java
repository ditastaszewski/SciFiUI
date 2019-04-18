package ie.tudublin;

import processing.core.PApplet;

public class Radar
{
    private float x;
    private float dx = 1;
    private float y;
    private float diameter;
    private float radius;
    UI ui;

    private float a = 0;

    public Radar(UI ui, float x, float y, float diameter)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        radius = diameter / 2;
    }
    
    public void render()
    {
        ui.stroke(255,50,50);
        ui.noFill();
        //ui.ellipse(x, y, diameter, diameter);
        ui.fill(255);
        ui.strokeWeight((int)(4 + Math.sin(a)*3));

        //ui.text("lol", x, y);
        //ui.line(x, y, x + (float)(Math.sin(a) * radius), y + (float)(Math.cos(a) * radius));
        ui.line(x - (float)(Math.sin(a) * radius), y - (float)(Math.sin(a) * radius), x + (float)(Math.sin(a) * radius), y + (float)(Math.cos(a) * radius));
        ui.line(x + (float)(Math.sin(a) * radius), y + (float)(Math.sin(a) * radius), x - (float)(Math.sin(a) * radius), y - (float)(Math.cos(a) * radius));
        ui.line(x - (float)(Math.sin(a) * radius), y - (float)(Math.sin(a) * radius), x - (float)(Math.sin(a) * radius), y - (float)(Math.cos(a) * radius));
        ui.line(x + (float)(Math.sin(a) * radius), y + (float)(Math.sin(a) * radius), x + (float)(Math.sin(a) * radius), y + (float)(Math.cos(a) * radius));
        //ui.line(x + 25, y + 50, x + (float)(Math.sin(a) * radius), y + (float)(Math.cos(a) * radius));

        ui.line(x - (float)(Math.sin(a) * radius) + 50, y - (float)(Math.sin(a) * radius), x + (float)(Math.sin(a) * radius) + 50, y + (float)(Math.cos(a) * radius));
        ui.line(x + (float)(Math.sin(a) * radius) + 50, y + (float)(Math.sin(a) * radius), x - (float)(Math.sin(a) * radius) + 50, y - (float)(Math.cos(a) * radius));
        ui.line(x - (float)(Math.sin(a) * radius) + 50, y - (float)(Math.sin(a) * radius), x - (float)(Math.sin(a) * radius) + 50, y - (float)(Math.cos(a) * radius));
        ui.line(x + (float)(Math.sin(a) * radius) + 50, y + (float)(Math.sin(a) * radius), x + (float)(Math.sin(a) * radius) + 50, y + (float)(Math.cos(a) * radius));

        ui.line(x - (float)(Math.sin(a) * radius) - 50, y - (float)(Math.sin(a) * radius), x + (float)(Math.sin(a) * radius) - 50, y + (float)(Math.cos(a) * radius));
        ui.line(x + (float)(Math.sin(a) * radius) - 50, y + (float)(Math.sin(a) * radius), x - (float)(Math.sin(a) * radius) - 50, y - (float)(Math.cos(a) * radius));
        ui.line(x - (float)(Math.sin(a) * radius) - 50, y - (float)(Math.sin(a) * radius), x - (float)(Math.sin(a) * radius) - 50, y - (float)(Math.cos(a) * radius));
        ui.line(x + (float)(Math.sin(a) * radius) - 50, y + (float)(Math.sin(a) * radius), x + (float)(Math.sin(a) * radius) - 50, y + (float)(Math.cos(a) * radius));
        // Static field
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);

        ui.strokeWeight(1);

    }

    public void update()
    {
        /*x += dx;
        if ((x > ui.width - radius) || (x < radius))
        {
            dx *= -1;
        }*/
        //a = a + (float).03 + (x/100 - 1800/100);
        a = a + (float)Math.sqrt(Math.pow((ui.mouseX - x), 2) + Math.pow((ui.mouseY - y), 2))/77777 + (float).01;
    }
}
