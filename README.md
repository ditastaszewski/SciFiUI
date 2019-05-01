# SciFi UI Project

Name: Alexander Staszewski

Student Number: C17705971

# Description of the assignment

The assignment was to create a sci-fi themed UI. I went with a starmap theme where the user has a sector/star system map with many various star systems and empty sectors (filled with asteroids) and by clicking on an individual sector on this map they can view it up close displaying the star and all the planets rotating around it.

![Rough Prototype](https://i.imgur.com/i2qnaMC.png)

I created a rough prototype (seen above) to visualize what kind of elements I wanted to see in the UI and expanded on this mostly on my own but I realized that [Starbound's navigation system](https://starbounder.org/Navigation) also had something similar to what I was doing.

# Instructions

There are 3 sections visible when the program starts up. To the top left there is a sector map which has 12 populated sectors and extra empty sectors to fill up the extra spaces. Each sector has its own set of celestial objects whether it be asteroids or planets and a sun, these objects will be displayed in the section that takes up the right half of the screen. You should be able to click on each object or press space to cycle through the objects to view more information on them. The window that pops up when you view the information pertaining to an object can be removed by clicking somewhere other than the object you clicked (and other objects as well of course.) Finally, to the bottom left part of the screen there should be a small section which tells you some information about the sector as a whole (lore, name, inhabitants.) 

Arrow keys can be used to navigate the sectors, this can also be done by clicking on the grids in the sector map.
When viewing a sector press space to move through the objects in the sector to show more information about each object. You can click on each object to view more info as well.

# How it works

## Display Class

Each section of the screen extends from the Display class, it is a straightforward class that creates a simple outline for a section by placing the name of section at the top and a line under it. Another purpose of the display class is to calculate delays between objects. Although only used in the sector map the UI class fetches the time taken since the last action (in this case keypress) and once it reaches a certain time the delay is reset to 0. This is done to make sure an action can be done at least once at a reasonable pace.

```Java
public float getDelay(float last) {
float now = ui.millis();        
delay = (now - last) / 1000.0f;

return delay;
}
```

## Sector Map

The program displays the first sector by default, to move through sectors you can do one of 2 things:
1. Use the arrow keys to move through the sector map. It is a basic decrement/increment when you press the LEFT/RIGHT key, when the UP key is used it removes the amount of sectors in a row from the current value (and makes sure that it is not out of bounds) and when the DOWN key is used it adds the amount of sectors in a row to the current value (also making sure it remains in bounds.) There is a delay that is calculated everytime the user presses/holds down a button, once a key hasn't been pressed for a set amount of time the sector changes to the next one the user chose. This is to prevent a user from changing sectors too quickly.

2. Use the mouse to click on a SectorButton object within the sector map section. When you click within the area of the sector map section the code uses a formula to get the location of the node on the X axis and adds that to its location on the Y axis multiplied by the number of nodes in a row. ```which = (int) ((mouseX - startX) / size) + (int) ((mouseY - startY) / size) * sectorColumns;```
This method also checks the last active sector that was pressed, so that if you click somewhere else on the screen that doesn't select a sector the sector you last chose is still displayed without changing anything.

The grid in the sector map actually has a SectorButton object in each grid spot, each SectorButton object renders the star inside the center of its grid spot using its size and colour while empty sectors have nothing rendered in them apart from the background stars that appear. These stars change position slightly based on the mouse's location to create a minor small effect.

The SectorButton objects are generated within the SectorMap class and added to the sectorButtons arraylist in the UI class using nested for loops when the class is initialized and the UI class gets the data necessary to determine which SectorButton belongs to which x/y coordinate from this class as well.

```Java
public SectorMap(UI ui, float x1, float y1, float dWidth, float dHeight, String displayName) 
{
super(ui, x1, y1, dWidth, dHeight, displayName);
float distWidth = x2 - displacement * 2 - 6;
float distHeight = y2 - displacement - 6;
int distMultiplier = 12; //how many sectors we want in one row
float gridCubeSize = distWidth / distMultiplier;
int gridCubeHeight = (int) (distHeight / gridCubeSize);
int sectorCount = 0;

startX = x1 + displacement + 3;
startY = y1 + displacement * 2 + 3;
gridSize = gridCubeSize;

//Creates the sectorbuttons for the grid so that the user can click on them
for (int i = 0; i < gridCubeHeight; i++) {
    for (int j = 0; j < distMultiplier; j++) {


	ui.sectorButtons.add(new SectorButton(ui, startX + gridCubeSize * j, startY + gridCubeSize * i, gridCubeSize));

	sectorCount ++;
    }
}
totalSectors = sectorCount;
totalSectorsWidth = distMultiplier;
}

```

## Sector Info

The SectorInfo class is simple in that it fetches the Sector object of the currently active sector and displays the descriptive variables on the screen. Within the Sector class when the sector is intialized a series of if/else statements determines the strings that pops up for the amount of planets and the habitable planets.

## Sector Display

The SectorDisplay class displays all the objects found in the sector's SectorObject arraylist. These are asteroids for empty sectors and planets and stars for named sectors. It is quite simple in that all it does is render each object in the given arraylist using a for loop and making sure it renders from the center of the rectangle.

![Populated Sector](https://i.imgur.com/eAP4d3v.png)
![Empty Sector](https://i.imgur.com/hotpLCH.png)

## Sector Object Info Class

When a user clicks on a celestial object within the sector display (or presses space) a small box pops up that displays info about the object. The data for the object isn't stored within the class for the celestial object but rather it gets it using the colour of the object and retrieving a CelestialObject class through a function in UI. The information that wasn't necessary to render the objects in the sector display was put into another csv file to keep things separate and easy to manage.

## Sector Class

When a sector is created it is usually done by checking the sectors.csv file for pre-existing information on sectors. This is done in the UI class using the loadSectors function which accesses the csv file and creates new sectors to add to the sectors arraylist. When the values are initialized several strings relating to the amount of planets and amount of habitable planets in the sector are created as well. The necessary planets for the sector are created as well alongside its sun. When the planets are created they are given random values depending on how many habitable planets there are in a system. Everytime a habitable planet is created a variable is decremented and once it reaches 0 only uninhabitable planets (magma/frozen/barren) are created instead. All aesthetic factors for the planet are randomized but as mentioned before the info display through the SectorObjectInfo class are obtained through objects.csv. 

In the case that the sector is empty the createAsteroids function is called instead which creates between 30 and 50 asteroid objects all of varying size to populate the sector.

## Colour Class

colours.csv holds columns, one for the name of the colour and 3 for the RGB values, using this a Colour class was created so that if it a certain colour was needed a findColour function in the UI class would allow me to get the RGB values for a colour with just its name. In the case that a colour wasn't specified it returns the orange colour to prevent things from breaking.

```Java
public Colour findColour(String colourName)
{
for (int i = 0 ; i < colours.size() ; i ++)
{
    if (colours.get(i).getColourName().equals(colourName))
    {
	return colours.get(i);
    }
}
return colours.get(4);
}

```

## Celestial Object Class

Identical in purpose to the Colour class the CelestialObject class loads data from the objects.csv file in the UI class so that it can be accessed later again in the UI class using the findObject function. This allows the descriptive data regarding an object to be stored somewhere else and accessed only when necessary.

```Java
public CelestialObject findObject(String colourName)
{
for (int i = 0 ; i < celestialObjects.size() ; i ++)
{
    if (celestialObjects.get(i).getColourName().equals(colourName))
    {
	return celestialObjects.get(i);
    }
}
return celestialObjects.get(4);
}
```

## Sector Object Class

SectorObject is the base class which all classes that are supposed to be displayed in the SectorDisplay class inherit from. This extends to the Asteroid, Planet, and Sun class.

This class renders the object in orbit around the center of the sector display and depending on the type of object it may not move at all. Usually objects that are at the center of the sector display won't move, however asteroids do not move regardless of where they are as they don't particularly orbit around anything within the sector. If the object is a planet the Planet class will make sure it renders a circle indicating its orbit as well.

```Java
public void render(float x, float y)
{
int r = colour.r;
int g = colour.g;
int b = colour.b;
rX = x + (float)(Math.sin(a) * distance);
rY = y + (float)(Math.cos(a) * distance);

ui.stroke(r, g, b);
ui.fill(r, g, b);
ui.circle(rX, rY, size * 5);
ui.noFill();
ui.stroke(203, 203, 203);

orbit();
}
```

# What I am most proud of in the assignment

For me this project provided me the challenge of using Java continuously on a project that was unlike other projects I have done because of the large usage of visual elements. I am proud that I was able to start off with a very rough idea and gradually add pieces to it which resulted in it becoming a more complete product. Of course I do feel like I could have added some more things if I had the time for it but overall I am satisfied that I managed to put the main concept that was in my head into code and have something aesthetically pleasing come out of it.

One other big change I had by the time I finished this project was that I was far more comfortable with using git and no longer had any worries that I would mess anything up unlike with my previous labs and lab test.

# Video

[![YouTube](http://img.youtube.com/vi/sRnSObLEJSI/0.jpg)](https://www.youtube.com/watch?v=sRnSObLEJSI)

