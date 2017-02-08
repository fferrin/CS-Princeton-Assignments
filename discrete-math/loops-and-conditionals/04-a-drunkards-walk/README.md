A drunkard's walk
=====================

A drunkard begins walking aimlessly, starting at a lamp post. At each time step,
the drunkard forgets where he or she is, and takes one step at random, either
north, east, south, or west, with probability 25%. How far will the drunkard be
from the lamp post after `N` steps?

* Write a program `RandomWalker.java` that takes an integer command-line
argument `N` and simulates the motion of a random walker for `N` steps. After
each step, print the location of the random walker, treating the lamp post as
the origin `(0, 0)`. Also, print the square of the final distance from the
origin.

   ```
   % java RandomWalker 10
   (0, -1)
   (0, 0)
   ...
   6 more steps
   ...
   (-2, 1)
   (-3, 1)
   squared distance = 10
   ```

   ```
   % java RandomWalker 20
   (0, 1)
   (-1, 1)
   ...
   16 more steps
   ...
   (-3, -2)
   (-3, -3)
   squared distance = 18
   ```

* Write a program `RandomWalkers.java` that takes two integer command-line
arguments `N` and `T`. In each of `T` independent experiments, simulate a random
walk of `N` steps and compute the squared distance. Output the mean squared
distance (the average of the `T` squared distances).

   ```
   % java RandomWalkers 100 100000
   mean squared distance = 100.15086
   ```

   ```
   % java RandomWalkers 400 100000
   mean squared distance = 401.22024
   ```

   ```
   % java RandomWalkers 100 100000
   mean squared distance = 99.95274
   ```

   ```
   % java RandomWalkers 800 100000
   mean squared distance = 797.5106
   ```

   ```
   % java RandomWalkers 200 100000
   mean squared distance = 199.57664
   ```

   ```
   % java RandomWalkers 1600 100000
   mean squared distance = 1600.13064
   ```

*Remark: this process is a discrete version of a natural phenomenon known as*
*Brownian motion. It serves as a scientific model for an astonishing range of*
*physical processes from the dispersion of ink flowing in water, to the*
*formation of polymer chains in chemistry, to cascades of neurons firing in the*
*brain.*

---------------------
*[From COS 126: Introduction to Computer Science, Princeton University]*