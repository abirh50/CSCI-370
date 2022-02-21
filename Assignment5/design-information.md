GroceryListManager UML class diagram creates users and lists and has access to item database.

The are 4 class: User, List, ItemType, Items.

User class:
Allows users to create account with id and password using addUser() method.
Allows deletion of the account using removeUser() method.
Allows the user to change password using editUser() method;
Allows creation of list(s) using addList() method.
Allows editing/changing list name using setName() method.
Allows selecting from multiple lists using selectList() method.
Allows deleting list(s) using removeList() method.

List class:
Allows user to add item(s) to list using 2 addItem() method one for quantity which uses int and another for weight which uses double.
Items are added to the list by category/type using HashMap.
Allows editing item(s) by quantity or weight using editItem() methods.
Allows removing item(s) from list using removeItem() method.
Allows checking-off item(s) from the list using checkOff() method.
Allows clearing check-offs from list using deleteCheckOff() method.
Allows saving list data every time List class is called using saveList() method.

ItemType and Items class:
Both class part of Item database.
ItemType class is a parent class of Items class which stores item data by type/category in a HashMap.
Items Class inherits addItem() method which adds new item(s) that doesn't exist in the database already.
Item class allows item search by similar name using findItem() method.
Item class allows naming new item(s) in the database by setName() method.
Item class assigns id to new item(s) by using assignId() method.