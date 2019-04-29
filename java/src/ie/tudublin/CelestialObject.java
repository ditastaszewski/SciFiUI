package ie.tudublin;


public class CelestialObject
{
    private String colourName;
    private String temperature;
    private String weather;

    public CelestialObject(String colourName, String temperature, String weather)
    {
        this.colourName = colourName;
        this.temperature = temperature;
        this.weather = weather;
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

    /**
     * @return the temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the weather
     */
    public String getWeather() {
        return weather;
    }

    /**
     * @param weather the weather to set
     */
    public void setWeather(String weather) {
        this.weather = weather;
    }
}