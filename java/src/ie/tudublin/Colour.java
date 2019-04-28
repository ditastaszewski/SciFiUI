package ie.tudublin;


public class Colour
{
    public int r;
    public int g;
    public int b;
    private String colourName;

    public Colour(String colourName, int r, int g, int b)
    {
        this.colourName = colourName;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * @return the colour
     */
    public String getColourName() {
        return colourName;
    }

    /**
     * @param colour the colour to set
     */
    public void setColourName(String colourName) {
        this.colourName = colourName;
    }
}