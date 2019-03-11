### Problem: [Supermarket Pricing](http://codekata.com/kata/kata01-supermarket-pricing/)

#### Part I:

This kata arose from some discussions we’ve been having at the DFW Practioners meetings. 

The problem domain is something seemingly simple: pricing goods at supermarkets.

Some things in supermarkets have simple prices: this can of beans costs $0.65. Other things have
 
more complex prices. For example:

* three for a dollar (so what’s the price if I buy 4, or 5?)
* $1.99/pound (so what does 4 ounces cost?)
* buy two, get one free (so does the third item have a price?)

This kata involves no coding. The exercise is to experiment with various models for representing 

money and prices that are flexible enough to deal with these (and other) pricing schemes, and at 

the same time are generally usable (at the checkout, for stock management, order entry, and 

so on). Spend time considering issues such as:

* does fractional money exist?
* when (if ever) does rounding take place?
* how do you keep an audit trail of pricing decisions (and do you need to)?
* are costs and prices the same class of thing?
* if a shelf of 100 cans is priced using “buy two, get one free”, how do you value the stock?

This is an ideal shower-time kata, but be careful. Some of the problems are more subtle than they 

first appear. I suggest that it might take a couple of weeks worth of showers to exhaust the main 

alternatives.

#### Part II: [Checkout](http://codekata.com/kata/kata09-back-to-the-checkout/)

Back to the supermarket. This week, we’ll implement the code for a checkout system that handles 

pricing schemes such as “apples cost 50 cents, three apples cost $1.30.”

Way back in KataOne we thought about how to model the various options for supermarket 

pricing. We looked at things such as “three for a dollar,” “$1.99 per pound,” and “buy two, get 

one free.”

This week, let’s implement the code for a supermarket checkout that calculates the total price of a 

number of items. In a normal supermarket, things are identified using Stock Keeping Units, or SKUs. 

In our store, we’ll use individual letters of the alphabet (A, B, C, and so on). Our goods are 

priced individually. In addition, some items are multipriced: buy n of them, and they’ll cost you y 

cents. For example, item ‘A’ might cost 50 cents individually, but this week we have a special 

offer: buy three ‘A’s and they’ll cost you $1.30. In fact this week’s prices are:

Item   Unit      Special
       Price     Price
--------------------------     
A      50        3 for 130  
B      30        2 for 45
C      20
D      15