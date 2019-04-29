package ie.tudublin;

public class SectorObjectInfo {

    
    SectorObject sectorObject;
    UI ui;

    public SectorObjectInfo(UI ui) 
    {
        this.ui = ui;

    }

    public void render() 
    {

    }

    public void update(SectorObject so)
    {
        float x;
        float y;
        int size;
        int width;
        int height;

        x = so.rX;
        y = so.rY;
        size = so.size;
        if (size < 10)
        {
            size = 10;
        }
        width = ui.width/10;
        height = ui.height/10;

        CelestialObject objectData = ui.findObject(so.colour.getColourName());

        ui.line(x, y, x - size * 3, y - size * 4);
        ui.fill(0);
        ui.rect(x - size * 3 - width, y - size * 4 - height, width, height);
        ui.noFill();

        ui.textSize(10);
        ui.fill(203, 203, 203);

        String celestialType = "Body Type: " + objectData.getColourName().toUpperCase();
        String weatherType = "";
        
        if (!objectData.getColourName().equals("asteroid"))
        {
            celestialType += " " + objectData.getObjectType().toUpperCase();
            weatherType += "\nWeather: " + objectData.getWeather();
        }

        String infoString = celestialType + "\nSurface Temperature: " + objectData.getTemperature() + weatherType;

        ui.text(infoString, x - size * 3 - width + 10, y - size * 4 - height + 10, width * 0.9f, height);

        ui.noFill();
    }
}
