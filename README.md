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

## Sector Map

The program displays the first sector by default, to move through sectors you can do one of 2 things:
1. Use the arrow keys to move through the sector map. It is a basic decrement/increment when you press the LEFT/RIGHT key, when the UP key is used it removes the amount of sectors in a row from the current value (and makes sure that it is not out of bounds) and when the DOWN key is used it adds the amount of sectors in a row to the current value (also making sure it remains in bounds.) There is a delay that is calculated everytime the user presses/holds down a button, once a key hasn't been pressed for a set amount of time the sector changes to the next one the user chose. This is to prevent a user from changing sectors too quickly.

2. Use the mouse to click on a SectorButton object within the sector map section. When you click within the area of the sector map section the code uses a formula to get the location of the node on the X axis and adds that to its location on the Y axis multiplied by the number of nodes in a row. ```which = (int) ((mouseX - startX) / size) + (int) ((mouseY - startY) / size) * sectorColumns;```
This method also checks the last active sector that was pressed, so that if you click somewhere else on the screen that doesn't select a sector the sector you last chose is still displayed without changing anything.

The grid in the sector map actually has a SectorButton object in each grid spot, each SectorButton object renders the star inside the center of its grid spot using its size and colour while empty sectors have nothing rendered in them apart from the background stars that appear. These stars change position slightly based on the mouse's location to create a minor small effect.

The SectorButton objects are generated within the SectorMap class and the UI class gets the data necessary to determine which SectorButton belongs to which x/y coordinate.

## Sector Info

The SectorInfo class is simple in that it fetches the Sector object of the currently active sector and displays the descriptive variables on the screen. Within the Sector class when the sector is intialized a series of if/else statements determines the strings that pops up for the amount of planets and the habitable planets.

## Sector Display

The SectorDisplay class displays all the objects found in the sector's SectorObject arraylist. These are asteroids for empty sectors and planets and stars for named sectors. It is quite simple in that all it does is render each object in the given arraylist using a for loop and making sure it renders from the center of the rectangle.

## Sector Object Info Class

When a user clicks on a celestial object within the sector display (or presses space) a small box pops up that displays info about the object. The data for the object isn't stored within the class for the celestial object but rather it gets it using the colour of the object and retrieving a CelestialObject class through a function in UI. The information that wasn't necessary to render the objects in the sector display was put into another csv file to keep things separate and easy to manage.

## Sector Class

When a sector is created it is usually done by checking the sectors.csv file for pre-existing information on sectors. This is done in the UI class using the loadSectors function which accesses the csv file and creates new sectors to add to the sectors arraylist. When the values are initialized several strings relating to the amount of planets and amount of habitable planets in the sector are created as well. The necessary planets for the sector are created as well alongside its sun. When the planets are created they are given random values depending on how many habitable planets there are in a system. Everytime a habitable planet is created a variable is decremented and once it reaches 0 only uninhabitable planets (magma/frozen/barren) are created instead. All aesthetic factors for the planet are randomized but as mentioned before the info display through the SectorObjectInfo class are obtained through objects.csv. 

In the case that the sector is empty the createAsteroids function is called instead which creates between 30 and 50 asteroid objects all of varying size to populate the sector.

## Colour Class



## Celestial Object Class

## Sector Object Class

SectorObject is the base class which all classes that are supposed to be displayed in the SectorDisplay class inherit from. This extends to the Asteroid, Planet, and Sun class.


# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

