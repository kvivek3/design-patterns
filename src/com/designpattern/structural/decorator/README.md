General Problem Statement : Suppose that an implementation is given for a class. Also, we need to 
provide some new behaviour without modifying the existing code, then we can use decorator 
pattern to achieve this.

Case Problem Statement : Imagine we have a coffee shop where customers can order 
coffee, and they can add extra ingredients like milk, sugar, or whipped cream. Instead of 
creating separate classes for every possible combination (MilkCoffee, SugarCoffee,
MilkSugarCoffee), we use the Decorator Pattern.

The implementation of Interface Coffee and Class Simple Coffee is given. We need to
add behaviour for MilkCoffee, Sugar Coffee and Milk Sugar Coffee.

Real World Application
Imagine we are developing a backend system where different components need logging.

Some logs go to the console.
Some logs go to a file.
Some logs need timestamps, while others need error levels (INFO, ERROR, etc.).