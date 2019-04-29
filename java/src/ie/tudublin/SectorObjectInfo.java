package ie.tudublin;

public class SectorObjectInfo {

    public float x;
    public float y;
    public int size;
    SectorObject sectorObject;
    UI ui;

    public SectorObjectInfo(UI ui) 
    {
        this.ui = ui;

    }

    public void render() 
    {

    }

    public void update(SectorObject sectorObject)
    {
        x = sectorObject.rX;
        y = sectorObject.rY;
        size = sectorObject.size;
        if (size < 10)
        {
            size = 10;
        }
        ui.line(x, y, x - size * 3, y - size * 4);
        ui.rect(x - size * 9, y - size * 10, size * 6, size * 6);
    }
}
