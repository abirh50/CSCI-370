
  

**1.  A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).**  
    The user is able to search items in the store with the searchItems() method which returns an instance of the GroceryStoreItemsClass containing all the items and item types to choose from. Once the user finds an item, they could add it to the list. Now that the item is in the list it has become a GroceryListItem. The user can now remove the item or set its quantity.
    
**2.  The application must contain a database (DB) of _items_  and corresponding _item types_.**
This is shown in the diagram. The GroceryStoreItems class queries the DB  that contains Items and itemTypes.

**3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.**  
    The user can view a list of all the item types with the getItemTypes() method and can view a list of all items associated with a type by using the findItemsByType(itemType) method. The user can select an item in the list and add it to the List and then set its quantity
    
**4.  Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.**  
    The findItemByName() method allows the user to find an item by typing its name. If an item is not found the user can search through similar items with the getSimilarItems method. Then they could set the item’s type and save the item with its type in the DB

**5.  Lists must be saved automatically and immediately after they are modified.**  
    Each time a list is modified, the save() method is called

**6.  Users must be able to check off items in a list (without deleting them).**  
    Once an item is added to a list and has become a GroceryListItem the user can check it off or uncheck the item without deleting it from the list. The checkOffItem() and unCheckOffItem() methods allow us to do this.

**7.  Users must also be able to clear all the check-off marks in a list at once.**  
    The clearChecks() method of GroceryList clears all check-off marks from items

**8.  Check-off marks for a list are persistent and must also be saved immediately.**  
    The state of GroceryListItems is also saved whenever they’re modified

**9.  The application must present the items in a list grouped by type, so as to allow users to  
    shop for a specific type of products at once (i.e., without having to go back and forth  
    between aisles).**  
    The findItemsByType() method of the GroceryStoreItems class allows us to do this. It returns all items associated with a type.

**10.  The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly  
    farmer’s market list”). Therefore, the application must provide the users with the ability to  
    create, (re)name, select, and delete lists.**  
    The methods addList() and deleteList() of the User class, and the setName() method of the GroceryList class allow us to do this,

**11.  The User Interface (UI) must be intuitive and responsive.**  
    Not considered because it does not affect the design directly.
