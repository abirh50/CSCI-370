# Project Plan


**Author**: Team 1

## 1 Introduction

This android application is used to manage grocery lists. A user can add lists to the first page, and add items to the second page. A search function will allow the user to search the database, and add items to their list, or add custom items to the list.

## 2 Process Description

### GroceryLists
- This activity is used to add and remove grocery lists. This activity will have a button to add a list. After clicking this button, they can input a name an confirm the creation of the new list. Upon holding down the tile of an existing list, they can choose to edit the name of, or delete a list. Clicking briefly on a list's tile will navigate to the GroceryItem activity.
- Entrance Criteria: Name of the new list, and buttons to delete a list
- Exit Criteria: Added items would show up in home page. Also, deleted items would disappear from the user's view, and in data. When a list has its name changed, and once the user confirms, the list's name will be altered to reflect the change. If the user clicks on a list tile, the current activity will be changed the the GroceryItems activity.

### GroceryItems
- This activity shows the items in a selected list, allowing adding and deleting items. When adding an item, another window will come into focus to allow for searching. If the item doesn't exist in the database the user will have the choice to add it to the database. Upon holding the tile of an existing item, the user will have the choice to edit the item's quantity or delete the item.
- Entrance Criteria: Inputs would names of the items, also each item will have a checkbox next to it for selection. Another input would be the different value and unit when editing quantity.
- Exit Criteria: When something is added to this list, the item is saved to the list and shows up on the screen. A checkbox will toggle on and off when selected. When an items quantity is changed, the tile containing the item will have its text altered. When an item is deleted, the will be removed from data and the list of items.


## 3 Team

*Describe the team and their roles (there may be more roles than there are team members)*


| Member  | Role                            |
|---------|---------------------------------|
| Jamil   | Front End, Testing              |
| Ilyun   | Back End, Testing               |
| Zain    | Back End, Testing               |
| Ibraham | Database, Testing               |
| Abir    | Front End, Testing              |
| Kevin   | Manager, Testing                |

#### Roles:

Front End- Responsible for UI & UX, over design of the app.

Back End- Responsible for connecting elements from the UI with actual methods and functionality.

Testing- Responsible for testing methods, finding bugs, and fixing bugs in the app.

Database- Responsible for interaction between that app the the local database.

Manager- Responsible for tracking progress in the app and providing documentation about the application.
