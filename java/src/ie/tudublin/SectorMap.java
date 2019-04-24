package ie.tudublin;

import processing.core.PApplet;

public class SectorMap extends Display
{

    public SectorMap(UI ui, float x1, float y1, float dWidth, float dHeight, String displayName)
    {
        super(ui, x1, y1, dWidth, dHeight, displayName);   
    }

    public void render() {
        super.render();
        float distWidth = x2 - displacement * 2;
        float distHeight = y2 - displacement;
        int distMultiplier = 20;
        float gridCubeSize = distWidth/distMultiplier;
        int gridCubeHeight = (int) (distHeight/gridCubeSize);

        for (int i = 0 ; i < gridCubeHeight; i ++)
        {
            for (int j = 0 ; j < distMultiplier; j ++)
            {
                ui.rect(x1 + displacement + gridCubeSize * j, y1 + gridCubeSize * i + displacement * 2, gridCubeSize, gridCubeSize);
            }
        }
    }

    public void update()
    {

    }
}
