# Test Plan


**Author**: Team 1

## 1 Testing Strategy

### 1.1 Overall strategy

Manual testing will primarily be executed by our QA tester (Zain Syed). Some of our testing will be manually done by each developer. At each step we plan to test functionality to ensure everything is working as expected. Since this app is not complex on the back-end level, we are comfortable with using black-box and white-box testing to fulfill any bug catching and fixing.

### 1.2 Test Selection

At the initial checkpoints of the application black box testing will be needed to ensure internal components are functioning correctly. In the final stages of the app's creation, white-box techniques will be used, since the previous black-box techniques are going to be utilized to ensure correct functionality.

### 1.3 Adequacy Criterion

Test cases must be documented thoroughly, with steps being concise enough to reproduce when needed. Test cases should not combine to many functional parts, making sure to isolate certain parts of the application, then slowly building up complexity.

### 1.4 Bug Tracking

- GitHub Issues will be used to track bug and enhancement requests. 

### 1.5 Technology

- Android system required for manual testing

## 2 Test Cases

| Purpose                                | Steps                                    | Expected Result                          | Actual Result(Filled Later) | Pass/Fail Info (Filled Later) | Misc. (Filled Later) |
|----------------------------------------|------------------------------------------|------------------------------------------|-----------------------------|-------------------------------|----------------------|
| List added correctly                   | Start on main page, press the add list button and attempt to add a list with a non-empty name. | New list appears on the first activity with its proper name |                             |                               |                      |
| List removed correctly                   | Start on main page, press the remove list button and attempt to remove a list with a non-empty name. | Removed list no longer appears on the first activity |                             |                               |                      |
| List renamed correctly                   | Start on main page, press the rename list button and attempt to rename a list with a non-empty name. | renamed list appears with the new name |                             |                               |                      |
| List unable to be added with empty name                   | Start on main page, press the add list button and attempt to add a list with a empty name. | error message should appear (toast) |                             |                               |                      |
| List can be selected                   | Start on main page, select a list| List should be opened |                             |                               |                      |
| User is able to add an item                   | Start on list page, press the add item button and attempt to add an item with a non-empty name. | item should be added to the list |   
| User is able to remove an item                   | Start on list page, press the remove item button and attempt to remove an item. | item should be removed from the list |   
| User is unable to add an item with an empty name                   | Start on list page, press the add item button and attempt to add a item with a empty name. | error message should appear |   
| User is able to check an item                   | Start on list page, press the check item button and attempt to check an item | item should be marked as checked on the list |   
| User is able to uncheck an item                   | Start on list page, press the uncheck item button and attempt to uncheck an item | item should be marked as unchecked on the list | 
| User is able to uncheck all items                   | Start on list page, press the uncheck all items button and attempt to uncheck an item | all items should be marked as unchecked on the list | 
| User is able to adjust item quantity                   | Start on list page, enter the quantity| The quantity should be adjusted | 
| User is able to adjust item quantity                   | Start on list page, enter the quantity| The quantity should be adjusted | 
| User cannot have a negative item quantity                   | Start on list page, enter a negative quantity| The quantity should not be adjusted | 
| User should be able to search for items                   | Start on list page, click search button, enter item name| search results should display in a popup | 
| User should be able to create an item from search that does not exist                   | Start on list page, click search button, enter item name that does not exist, click create item button| new item should be created and show on search | 
| Data should persist                 | Test entire system | All data should persist on change of any list/item