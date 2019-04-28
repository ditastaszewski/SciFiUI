package ie.tudublin;

import processing.core.PApplet;
import java.util.Random;

public class SectorButton {
    private int totalSectors;
    private int totalSectorsHeight;

    public float x;
    public float y;
    private float size;

    private boolean isActive = false;
    
    private Sector sector;

    UI ui;

    Random rand = new Random();

    private int randX;
    private int randY;
    private int randDisplacement;


    public SectorButton(UI ui, float x, float y, float size) 
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.size = size;
        this.randX = rand.nextInt((int) (size * 0.75)) + 10;
        this.randY = rand.nextInt((int) (size * 0.75)) + 10;
        this.randDisplacement = rand.nextInt(10);
    }
    
    public void render() 
    {
        //ui.stroke(0, 255, 0);
        ui.rect(x, y, size, size);

        ui.fill(255, 255, 62);
        ui.circle(x + randX + PApplet.map(ui.mouseX, 0, ui.width, -1, 3 + randDisplacement), y + randY + PApplet.map(ui.mouseY, 0, ui.height, -1, 3 + randDisplacement) , 1);
        ui.noFill();
        //ui.stroke(203, 203, 203);
    }

    public void update()
    {
        if (isActive)
        {
            ui.stroke(0, 255, 0);
            ui.rect(x + 5, y + 5, size - 10, size - 10);
            ui.stroke(203, 203, 203);
        }

        if (sector != null)
        {
            int r = sector.getColour().r;
            int g = sector.getColour().g;
            int b = sector.getColour().b;
            
            ui.stroke(r, g, b);
            ui.fill(r, g, b);
            ui.circle(x + size/2, y + size/2, 4 * sector.size);
            ui.stroke(203, 203, 203);
            ui.noFill();
        }

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

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(float size) {
        this.size = size;
    }

    /**
     * @return the isActive
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the sector
     */
    public Sector getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(Sector sector) {
        this.sector = sector;
    }

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }
}
