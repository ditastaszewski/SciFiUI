package ie.tudublin;


public class Colour
{
    public int r;
    public int g;
    public int b;
    private String colour;

    public Colour(String colour, int r, int g, int b)
    {
        this.colour = colour;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(String colour) {
        this.colour = colour;
    }
}