package ie.tudublin;

import processing.core.PApplet;

public class Display {
    protected float x1;
    protected float y1;
    protected float x2;
    protected float y2;
    protected String displayName;

    UI ui;

    protected int displacement;

    public Display(UI ui, float x1, float y1, float dWidth, float dHeight, String displayName) {
        this.ui = ui;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = dWidth;
        this.y2 = dHeight;
        this.displayName = displayName;
        this.displacement = (int) (ui.height * 0.05);
    }

    public void render() {
        ui.stroke(203, 203, 203);
        ui.noFill();
        ui.textSize(25);
        ui.textAlign(0, 0);
        ui.text(displayName, x1 + displacement, y1 + (float)(displacement/1.5));
        ui.line(x1 + displacement, y1 + displacement, x1 + x2 - displacement, y1 + displacement);
        ui.rect(x1 + displacement, y1 + displacement * 2, x2 - displacement * 2, y2 - displacement);
    }

    public void update() {

    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
