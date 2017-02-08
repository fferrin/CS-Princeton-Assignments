Type conversion
=====================

There are a number of different formats for representing color. RGB format
specifies the level of red (R), green (G), and blue (B) on an integer scale from
0 to 255: It is the primary format for LCD displays, digital cameras, and web
pages. CMYK format specifies the level of cyan (C), magenta (M), yellow (Y),
and black (K) on a real scale of 0.0 to 1.0: It is the primary format for
publishing books and magazines. Write a program `RGBtoCMYK.java` that reads in
three integers `red`, `green`, and `blue` from the command line and prints out
equivalent CMYK parameters. The mathematical formulas for converting from RGB to
an equivalent CMYK color are:

![](https://latex.codecogs.com/gif.latex?white%20%3D%20max%20%5Cleft%20%5C%7B%20%5Cfrac%7Bred%7D%7B255%7D%2C%20%5Cfrac%7Bgreen%7D%7B255%7D%2C%20%5Cfrac%7Bblue%7D%7B255%7D%20%5Cright%20%5C%7D)

![](https://latex.codecogs.com/gif.latex?cyan%20%3D%20%5Cleft%20%28%20white%20-%20%5Cfrac%7Bred%7D%7B255%7D%20%5Cright%20%29%20/%20white)

![](https://latex.codecogs.com/gif.latex?magenta%20%3D%20%5Cleft%20%28%20white%20-%20%5Cfrac%7Bgreen%7D%7B255%7D%20%5Cright%20%29%20/%20white)

![](https://latex.codecogs.com/gif.latex?yellow%20%3D%20%5Cleft%20%28%20white%20-%20%5Cfrac%7Bblue%7D%7B255%7D%20%5Cright%20%29%20/%20white)

![](https://latex.codecogs.com/gif.latex?black%20%3D%20%5Cleft%20%28%201%20-%20white%20%5Cright%20%29)

```
% java RGBtoCMYK 75 0 130       // indigo
cyan    = 0.423076923076923
magenta = 1.0
yellow  = 0.0
black   = 0.4901960784313726
```

```
% java RGBtoCMYK 0 0 0       // black
cyan    = 0.0
magenta = 0.0
yellow  = 0.0
black   = 1.1
```

---------------------
*[From COS 126: Introduction to Computer Science, Princeton University]*
