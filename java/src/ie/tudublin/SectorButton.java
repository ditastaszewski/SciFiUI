package ie.tudublin;

import processing.core.PApplet;

public class SectorButton {
    private int totalSectors;
    private int totalSectorsHeight;

    public float x;
    public float y;
    private float size;

    private boolean isActive = false;

    UI ui;

    public SectorButton(UI ui, float x, float y, float size) 
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.size = size;
    }
    
    public void render() 
    {
        //ui.stroke(0, 255, 0);
        ui.rect(x, y, size, size);
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
