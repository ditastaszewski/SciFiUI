package ie.tudublin;

import static processing.core.PConstants.PROJECT;
import static processing.core.PConstants.ROUND;

import processing.core.PApplet;

public class SectorMap extends Display {
    private int totalSectors;
    private int totalSectorsHeight;

    public SectorMap(UI ui, float x1, float y1, float dWidth, float dHeight, String displayName) 
    {
        super(ui, x1, y1, dWidth, dHeight, displayName);
    }

    public void render(int activeSector) 
    {
        super.render();
        float distWidth = x2 - displacement * 2;
        float distHeight = y2 - displacement;
        int distMultiplier = 12;
        float gridCubeSize = distWidth / distMultiplier;
        int gridCubeHeight = (int) (distHeight / gridCubeSize);
        int sectorCount = 0;
        for (int i = 0; i < gridCubeHeight; i++) {
            for (int j = 0; j < distMultiplier; j++) {
                //ui.rect(x1 + displacement + gridCubeSize * j, y1 + gridCubeSize * i + displacement * 2, gridCubeSize,
                //        gridCubeSize);

                if (activeSector == sectorCount) {
                    ui.stroke(255, 50, 50);
                    ui.strokeWeight(5);
                    ui.strokeCap(PROJECT);
                }
                ui.rect(x1 + displacement + 5 + gridCubeSize * j, y1 + gridCubeSize * i + displacement * 2 + 5,
                        gridCubeSize - 10, gridCubeSize - 10);
                ui.stroke(203, 203, 203);
                ui.strokeWeight(1);
                ui.strokeCap(ROUND);

                ui.sectorButtons.add(new SectorButton(ui, x1 + displacement + gridCubeSize * j, y1 + gridCubeSize * i + displacement * 2, gridCubeSize));

                sectorCount ++;
            }
        }
        totalSectors = sectorCount;
        totalSectorsHeight = distMultiplier;
    }

    public void update()
    {

    }

    /**
     * @return the totalSectors
     */
    public int getTotalSectors() {
        return totalSectors;
    }

    /**
     * @param totalSectors the totalSectors to set
     */
    public void setTotalSectors(int totalSectors) {
        this.totalSectors = totalSectors;
    }

    /**
     * @return the totalSectorsHeight
     */
    public int getTotalSectorsHeight() {
        return totalSectorsHeight;
    }

    /**
     * @param totalSectorsHeight the totalSectorsHeight to set
     */
    public void setTotalSectorsHeight(int totalSectorsHeight) {
        this.totalSectorsHeight = totalSectorsHeight;
    }
}
