Joan Chirinos
APCS2 pd08
HW12 -- __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018-03-01

0. I encountered this at the beginning of the year and I thought it would be
	similar to helper functions. Rather than designating a separate file
	for a new "helper class", you could define it within the public
	class's file. It can be useful when you just need a small helper
	class, but I think it's generally wise to refrain from declaring
	mutiple classes in one file because it may be hard to find the class
	later on. Additionally, only one class's main method may be run.
1. They are taken from args[] and checked to see if they are integers. If not,
	the default values are used instead.
2. The code in the try block throws an Exception so default values are used
3. I don't think you neeeeeeeed recursions, but it's a lot easier to backtrack
	using recursion. Iteration would be more of a pain to code and you might
	need a while loop, which can be risky if you don't have a good
	exit case. You could also use a for loop somehow subtract a certain
	amount from the counter every time you run into something that isn't
	a solution, but that's a lot of work for something that can be much
	more simply accomplished with recursion
4. You see a board of 0s surrounded by 2 layers of -1s. As the code runs,
	random spots in the inner board (the ones that were originally 0) are
	replaced by the "turn number"
5. One should expect it to run for about (n * n * delay) / 1000 seconds,
	where n is the board size and delay is the delay, in milliseconds,
	between screen refreshes
6. American National Standards Institute. It's useful for the same reason that
	interfaces are useful: it sets standards for things that should be
	followed in order to be consistent
7. I was about right
8.
The -1s are useful so that the knight will not move if it would land on
	any spot but 0. I was planning on writing code that would test if the
	next projected spot is within [0, n). However, I wouldn't print the 
	-1s cuz it looks bad
The method of displaying and the delay are polished and useful for showing
	our algorithm at work.
Also I would actually code a Knight's tour algo rather than picking random
	spots
