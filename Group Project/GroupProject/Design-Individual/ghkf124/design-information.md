1. A grocery list consists of items the users want to buy at a grocery store. The application
must allow users to add items to a list, delete items from a list, and change the quantity
of items in the list (e.g., change from one to two pounds of apples).
First, I created classes GroceryList, Items, User, and Store. I added the Store class because
the User might have different locations to go for grocery shopping. I added the operations
for the GroceryList to add the items, delete items, and change the quantity of items.
I gave Items class, three attributes, type, name, and amount. Later down the line, I create
a new class caled Lists which consists of 0 or more GroceryList objects. 

2. The application must contain a database (DB) of items and corresponding item types.
To realize this requirement, I added to the design a class X with attributes Y and Z. Class X...


3. Users must be able to add items to a list by picking them from a hierarchical list, where
the first level is the item type (e.g., cereal), and the second level is the name of the
actual item (e.g., shredded wheat). After adding an item, users must be able to specify a
quantity for that item.
Instead of User accessing the GroceryList class, I created separate classes like Types, Name,
and Amount so that the User had the option to add Items in that order.

4. Users must also be able to specify an item by typing its name. In this case, the
application must look in its DB for items with similar names and ask the users, for each
of them, whether that is the item they intended to add. If a match cannot be found, the
application must ask the user to select a type for the item and then save the new item,
together with its type, in its DB.
In order to consider the case where the User wanted to look for an Item by its name, I created
getter operations for the Name and the Types classes. The algorithm beind finding the similar
named Items, or adding the new Item with its Type was not implemented because I figured that
it wasn't necessary to show in a model like this. 

5. Lists must be saved automatically and immediately after they are modified.
I did not do anything for this because creating new instances or modifying anything will 
automatically saved in real life application. 

6. Users must be able to check off items in a list (without deleting them).
In order to check if the Items from the GroceryList are checked, I created a new class called
CheckList. In the GroceryList class, I created checkOff operations to mark off the specified
Items that will be saved in the CheckList class. 

7. Users must also be able to clear all the check-off marks in a list at once.
For this case, I created a clear operation to delete all Items in the CheckList. This can
be done because CheckList is a separate class from the GroceryList so it shouldn't affect
each other.

8. Check-off marks for a list are persistent and must also be saved immediately.
Once the User checks off something, it will immediately be saved in the CheckList class through
the checkOff(Items) operation in the GroceryList. It is not required to have a save operation
because it is done automatically in the CheckList class.

9. The application must present the items in a list grouped by type, so as to allow users to
shop for a specific type of products at once (i.e., without having to go back and forth
between aisles).
In order to group the Items by their Types, I created an operation called groupTypes. This will
trigger the getTypes operation from the Types class which is connected through Items class and
will organize the Items based on their Types. I figured that a separate class was not needed 
for groups because they can be organized in the GroceryList class by an operation call. 

10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly
farmer’s market list”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete lists.
I created a class called Lists which holds all the GroceryList objects created by the User. This
is organized by the name in the Store class, which is connected by the GroceryList. User can "use"
the Lists class because of its dependency relationship with it. Lists consists of 0 or more 
numbers of GroceryLists. User can create, name, select, and delete the GroceryList objects 
through the List class. 

11. The User Interface (UI) must be intuitive and responsive
Not considered because it does not affect the design directly.
