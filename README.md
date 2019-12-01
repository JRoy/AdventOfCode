# AdventOfCode
My solutions for the Advent of Code

You can learn more about the advent of code at [adventofcode.com/](https://adventofcode.com/)!

# Write-ups

## Day 1
For day one's challenge: calculate the amount of fuel need to lift a given module based 
on its mass. We are then told that to accomplish this we have to take the module's mass,
divide it by three, round the quotient down, and then subtract two. This can be expressed
as `⌊x/3⌋ - 3` where *x* is the given modules mass.

### Part 1
For part one we are given an input of numbers of which we should treat as modules. The
puzzle wants the sum of the the fuel required to lift all of the input modules. This is
easy enough to implement. So for my implementation, I put the inputs I was given into a
resource file and iterated over the lines using Apache's Commons-IO FileUtils API. Then
I simply took the lines, parsed them as integers and made a helper method to run
`Math.floorDiv(mass, 3) - 2` (where *mass* is the mass of the given module) to calculate
the amount the fuel needed for each module. Now we just add up all the inputs and we got
our answer.

### Part 2
For part two we are told that fuel itself also requires fuel to carry, and we must 
calculate it. But, we also need to have fuel for the fuel and so on and so on. This was
also very trivial to implement and would require very little change of my existing code.
So for my implementation, I setup a helper method,
`public static int recursivelyCalculateFuel(int mass)`, to calculate the fuel cost of
each module and the total fuel cost of that module's fuel cost. In this method I setup
two variables, `totalFuel` & `fuel`, to store the total fuel cost and the last processed
fuel cost respectively. `totalFuel` is initialized as zero while `fuel` is initialized
as the the fuel cost for the given module using the helper method from part one. Now a
while loop is started with the condition `fuel > 0`. This ensures that once the fuel
cost of a given set of fuel becomes negative or zero, we exit the loop as we cannot
carry negative fuel. Inside the loop, the `fuel` variable is added onto the `totalFuel`
variable and `fuel` is set to the previous `fuel`'s fuel cost. Once we run this function
through all our inputs and add them all together, we end up with the absolute fuel cost
for all the modules needed to take off.