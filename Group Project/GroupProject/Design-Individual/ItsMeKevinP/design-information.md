# Kevin Perez GroceryList Design Info


-Starting with the user, each one has a unique identifies and a first name a last name. A user can change its own first name and last name, and add, delete a specific list, or delete all checked list. They also have a method to save all changes to current lists they have. One user can have many lists, but a list can only belong to one user.

-For a grocery list, each one needs a unique ID, and a name specified by the user. Each list will also have a boolean to bulk delete lists. Each list will have a method to change its name, remove checks on the items contained in the list, return all items contained in the list, add an item by specifying its type, brand, and quantity, add an item by only brand, and delete a specific item in the list. A list can have 0 or more items in it.

-An item constists of an ID, which could be the brand name, what type of item it is (like cereal or milk), the quantity of the item in a float, and a boolean to check and uncheck the item. A method to set the quantity of the current item it available, as is a method to flip the boolean value. An item can only belong to one list.

-For specific items contained in the database, we have a hierarchy where the type of item is the superclass and the subclass is the specific brand. When looking for an item, we would use the itemExists method for the specific type, and see if that item exists. If not, we ask to add it under that specific type, with that name the user specified. If it does exist, them we retrieve the brand name of the item and use the return to add it to the groceryList. An itemType can have many brand associated to is, but each brand only has one itemType it belongs to.

