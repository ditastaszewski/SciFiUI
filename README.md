# SciFi UI Project

Name: Alexander Staszewski

Student Number: C17705971

# Description of the assignment

The assignment was to create a sci-fi themed UI. I went with a starmap theme where the user has a sector/star system map with many various star systems and empty sectors (filled with asteroids) and by clicking on an individual sector on this map they can view it up close displaying the star and all the planets rotating around it.

![Rough Prototype](https://i.imgur.com/i2qnaMC.png)

I created a rough prototype (seen above) to visualize what kind of elements I wanted to see in the UI and expanded on this mostly on my own but I realized that Starbound's navigation system also had something similar to what I was doing.

# Instructions

There are 3 sections visible when the program starts up. To the top left there is a sector map which has 12 populated sectors and extra empty sectors to fill up the extra spaces. Each sector has its own set of celestial objects whether it be asteroids or planets and a sun, these objects will be displayed in the section that takes up the right half of the screen. You should be able to click on each object or press space to cycle through the objects to view more information on them. The window that pops up when you view the information pertaining to an object can be removed by clicking somewhere other than the object you clicked (and other objects as well of course.)

Arrow keys can be used to navigate the sectors, this can also be done by clicking on the grids in the sector map.
When viewing a sector press space to move through the objects in the sector to show more information about each object. You can click on each object to view more info as well.

# How it works



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

