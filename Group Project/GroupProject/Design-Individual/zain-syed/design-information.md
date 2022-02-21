## Design Information [Project 5]

---

1.  > A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).

I first added 3 classes to the diagram, **User**, **Grocery List** and **Item**, all with a property **id** of type _Integer_. In class **User** I added the defining properties it would have like **username** and **password** of type _String_. I added the typical functions **register()** and **login()**. To the class **Item**, I inititally added the property **name** of type _String_. Then to allow the user to:

- add items to a list, I added the function **addItem()** to the class **Grocery List**.
- delete items from a list, I added the function **deleteItem()** to the class **Grocery List**.
- change the quantity of items, I added the property **quantity** of type _Integer_ and the function **setQuantity()** to class **Item**.

---

2.  > The application must contain a database (DB) of ​items​ and corresponding ​item types​.

I added class **Item Type** to the design as specified, with properties **id** of type _Integer_ and **name** of type _String_.

---

3.  > Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g.,cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.

To satisfy this requirement, I added an aggregation relationship between class **Item** and **Item Type**. This implies that items are grouped by item type, but that items meaningfully exist without item type. For class **Item**, I added an initialization value of 1 to property **quantity**.

---

4.  > Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.

To allows users to search for items and add new ones, I added functions **search4ItemByName()** and **addNewItem()**.

---

5.  > Lists must be saved automatically and immediately after they are modified.

This wouldn't effect the UML diagram.

---

6.  > Users must be able to check off items in a list (without deleting them).

To the class **Item**, I added the propery **checkedOff** and the function **checkOffItem()**

---

7.  > Users must also be able to clear all the check-off marks in a list at once.

To the class **Grocery List**, I added the function **uncheckAllItems()**.

---

8.  > Check-off marks for a list are persistent and must also be saved immediately.

This wouldn't effect the UML diagram.

---

9.  > The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles).

To remedy this requirement, I added an aggregation relationship between the classes **Grocery List** and **Item Type**.

---

10. > The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists.

To support multiple lists, I added the property **name** of type _String_ to the class **Grocery List**. Then to allow users to:

- create lists, I added the function **createList()** to the class **User**.
- (re)name lists, I added functions **getName()** and **setName()** to the class **Grocery List**.
- delete lists, I added the function **deleteList()** to the class **User**.

---

11. > The User Interface (UI) must be intuitive and responsive.

This wouldn't effect the UML diagram.
