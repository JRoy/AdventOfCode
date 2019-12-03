# AdventOfCode
My solutions for the Advent of Code

You can learn more about the advent of code at [adventofcode.com/](https://adventofcode.com/)!

# Write-ups

## Day 1
For day one's challenge: calculate the amount of fuel need to lift a given module based 
on its mass. We are then told that to accomplish this we have to take the module's mass,
divide it by three, round the quotient down, and then subtract two. This can be expressed
as `⌊x/3⌋ - 2` where *x* is the given modules mass.

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
variable and `fuel` is set to the previous `fuel`'s fuel cost. Once we run this method
through all our inputs and add them all together, we end up with the absolute fuel cost
for all the modules needed to take off.

## Day 2
For day two's challenge: Implement a parser for a fake programming language dubbed "Intcode".
Intcode programs are lists of comma separated integers. The first integer is called the
opcode. The possible opcodes are: `1` for addition, `2` for multiplication, and `99` for
exiting the program. For opcodes `1` and `2`, three additional parameters in the form of
integers will follow; the first two are pointers to memory locations where we will find
integers to add/multiply and the third is a pointer to where the result should be stored.
These memory locations are simply zero-indexed positions inside our Intcode program. Now for
opcode `99`, this opcode doesn't require any parameters as it will simply stop execution of
the program upon being read.

### Part 1
For part one we are told to make an Intcode parser, parse and execute our input as Intcode
and submit the first integer (position zero) as the answer. For my implementation, I again
used Apache's Commons-IO FileUtils API to take read the Intcode from the input file. Once
I then used a helper method I made to convert a string of comma separated integers into an
`ArrayList` of `Integer` objects. Once I had a list of all the integers in the program, I
passed them off to another help method, 
`public static List<Integer> processIntCode(List<Integer> code)`, which parsed and executed
the int code. Once it was executed, the method returns the result Intcode. In the
`processIntCode` method, I first create an create a while loop for an integer iterator
as that will make processing over each integer in the Intcode a lot less tedious. In the
`while` loop, a local variable called `opCode` is assigned to `iterator.next()`. Since the
first position of Intcode is always an opcode, we can safely assume this is an opcode.
Next, that opcode is tested to see if it's `1`, `2`, `99`, or an invalid code. If it's `1`
or `2`, then the variables `arg1` and `arg2` are both assigned the next two integers in the
iterator via `iterator.next()`. Then `arg1` and `arg2` are either added or multiplied for
opcodes `1` and `2` respectively. Once we have the result, we read the next integer in the
iterator as the memory address for where to store result of the calculation we did previously.
If we get the opcode `99` in the while loop, the `ArrayList`, `code` is returned thus stopping
execution. Then all we got to do to get the answer for part one is fetch the integer at
position one.

### Part 2
For part two we are told to modify positions `1` and `2` (otherwise known as the noun and the
verb respectively) of our input until we produce the output of `19690720`. We were also told that
the noun and the verb would both be between zero and ninety-nine. With our existing Intcode
parser this would be a simple brute force attack to get the answer. To start, we take the comma
separated Intcode and place it into an `ArrayList` of `Integer` objects. Once we have that list,
I created two variables, `noun` and `verb`, and two nested `for` loops to increment both `noun`
and `verb` respectively. Inside these `for` loops I simply cloned the Intcode into the variable
`caseCode` and set positions `1` and `2` of `caseCode` to the current `noun` and `verb`
iteration. Then I would execute the Intcode and if position `1` of the returned Intcode was
`19690720`, we know we got our desired `noun` and `verb`. Now, all we had to do was the
equation `100 * noun + verb` to get our answer. 

## Day 3
I completed this challenge at 4am and am quite tired of it and don't really remember how
the code the works. Nevertheless, the code is there and it works but Day 3 will not have
a write up!