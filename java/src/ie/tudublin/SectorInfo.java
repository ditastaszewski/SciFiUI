package ie.tudublin;

public class SectorInfo extends Display {

    public SectorInfo(UI ui, float x1, float y1, float dWidth, float dHeight, String displayName) 
    {
        super(ui, x1, y1, dWidth, dHeight, displayName);
        
    }

    public void render() 
    {
        super.render();
        ui.rect(x1 + displacement, y1 + displacement * 2, x2 - displacement * 2, y2 - displacement);
    }

    public void update(Sector sector)
    {
        ui.textSize(20);
        
        

        if (!sector.getName().equals("Empty Sector"))
        {
            ui.text("Sector: " + sector.getName(), x1 + displacement * 1.5f, y1 + displacement * 3);
            ui.text(sector.getDescription() + "\n" + sector.getPlanetsDesc() + sector.getHabitableDesc(), x1 + displacement * 1.5f, y1 + displacement * 3.5f, x2 - displacement * 3, y2 - displacement);
            ui.text("Star Colour: " + sector.getColour().getColourName().toUpperCase() + " - Star Brightness: " + sector.brightness + "\n" + sector.getPopulationDesc(), x1 + displacement * 1.5f, y1 + displacement * 6.5f);
        }
        else
        {
            ui.text(sector.getDescription(), x1 + displacement * 1.5f, y1 + displacement * 3.5f, x2 - displacement * 3, y2 - displacement);
            ui.text(sector.getName(), x1 + displacement * 1.5f, y1 + displacement * 3);
        }
        

        

        

    }
}
