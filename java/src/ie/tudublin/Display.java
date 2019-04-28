package ie.tudublin;

public class Display {
    protected float x1;
    protected float y1;
    protected float x2;
    protected float y2;
    private String displayName;
    private float delay;

    UI ui;

    protected int displacement;

    public Display(UI ui, float x1, float y1, float dWidth, float dHeight, String displayName) 
    {
        this.ui = ui;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = dWidth;
        this.y2 = dHeight;
        this.displayName = displayName;
        this.displacement = (int) (ui.height * 0.05);
    }

    public void render() 
    {
        ui.stroke(203, 203, 203);
        ui.fill(203, 203, 203);
        ui.textSize(25);
        ui.textAlign(0, 0);
        ui.text(displayName, x1 + displacement, y1 + (float)(displacement/1.5));
        ui.line(x1 + displacement, y1 + displacement, x1 + x2 - displacement, y1 + displacement);
        ui.noFill();
        
    }

    public void update() 
    {

    }

    public float getDelay(float last) {
        float now = ui.millis();        
        delay = (now - last) / 1000.0f;
        last = now;

        return delay;
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
