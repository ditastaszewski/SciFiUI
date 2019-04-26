package ie.tudublin;

public class SectorDisplay extends Display {

    public SectorDisplay(UI ui, float x1, float y1, float dWidth, float dHeight, String displayName) 
    {
        super(ui, x1, y1, dWidth, dHeight, displayName);
        
    }

    public void render() 
    {
        super.render();
        ui.rect(x1 + displacement, y1 + displacement * 2, x2 - displacement * 2, y2 - displacement);
    }

    public void update()
    {

    }
}
