---
layout: page
title: User Guide
---

# FoodRem User Guide

## About

We want you to spend less time keeping track of perishable goods in your daily operations. 
FoodRem is a command line application that enables you to efficiently record, update and categorise food items.
It is a convenient administrative tool that can answer the following questions in a flash:

- What food items are about to expire?
- How much of each condiment do I have? 
- Which food items are newly purchases?
- ...and many more!

With a few quick commands, you can have complete control of your perishable goods, so you can focus on what 
is important: serving your customers, improving menu recipes, and transforming your business into the next 
success story.

## Key Features

1. Add, update and delete inventory items
2. Search and sort food items by:
   - Name
   - Quantity
   - Bought date
   - Expiry date
   - Tags
3. Tag items to group them into categories

## Purpose, Scope and Audience

Something goes here...

<div style="page-break-after: always"></div> <! ---Testing line break-->

# Tables of Contents

1. [How to use the user guide](#how-to-use-the-user-guide)

2. [Quick Start](#quick-start)

3. [Items and Tags](#items-and-tags)

4. [Navigating around the application](#navigating-around-the-application)

5. [Flags](#flags)

6. [Placeholders](#placeholders)

7. [Features](#features)

   7.1. [Item Features](#item-features)

   &emsp; 7.1.1. [Create a new item](#create-a-new-item)

   &emsp; 7.1.2. [List all items](#list-all-items)

   &emsp; 7.1.3. [Search for an item](#search-for-an-item)
   
   &emsp; 7.1.4. [Sort all items by an attribute](#sort-all-items-by-an-attribute)

   &emsp; 7.1.5. [View the information of an item](#view-the-information-of-an-item)

   &emsp; 7.1.6. [Increase the quantity of an item](#increase-the-quantity-of-an-item)

   &emsp; 7.1.7. [Decrease the quantity of an item](#decrease-the-quantity-of-an-item)

   &emsp; 7.1.8. [Update the information of an item](#update-the-information-of-an-item)

   &emsp; 7.1.9. [Delete an item](#delete-an-item)

   7.2. [Tag Features](#tag-features)

   &emsp; 7.2.1. [Create a new tag](#create-a-new-tag)

   &emsp; 7.2.2. [List all tags](#list-all-tags)

   &emsp; 7.2.3. [Tag an item](#tag-an-item)

   &emsp; 7.2.4. [Untag an item](#untag-an-item)

   &emsp; 7.2.5. [Rename a tag](#rename-a-tag)

   &emsp; 7.2.6. [Delete a tag](#delete-an-item)

   7.3. [Receive help during usage](#receive-help-during-usage)

   7.4. [Reset the application](#reset-the-application)

   7.5. [Exit the application](#exit-the-application)

8. [Command Summary](#command-summary)

9. [Troubleshooting](#troubleshooting)

10. [FAQ](#faq)

11. [Future Extensions](#future-extensions)

12. [Acknowledgements](#acknowledgements)

13. [Glossary](#glossary)

## How to use the User Guide

Thank you for choosing FoodRem! We are delighted to have you as a user and aim to serve you well!

To gain the most out from this User Guide, start off with the [Quick Start](#quick-start) section.
This will give you a brief overview about how to use this application. 

It is **highly recommended** that you read through the User Guide in a **sequential order** up until the section
[Features](#features) where you can find all the information you need for each command. 

[Items and Tags](#items-and-tags) : 
- What FoodRem is capable of storing

[Navigating around the application](#navigating-around-the-application): 
- Terminologies of different parts of the application
- What you are expected to see.

[Flags](#flags) and [Placeholders](#placeholders):
- Important syntax you will come across while reading the user
guide such as `n/`, `bgt/` or `INDEX`, `ITEM_NAME`. 

If you are confident, you can immediately refer to the [Command Summary](#command-summary)
after completing the [Quick Start](#quick-start).

Meaning of icons:
- ℹ️ : additional info
- ❗ : warning

If you are stuck, refer to [Troubleshooting](#troubleshooting) or [FAQ](#faq).
There is also a [Glossary](#glossary) that contains definitions of what common words 
used in this application mean.

It is time for you to unleash the potential of a command line application!

## Quick Start

Hello! This is the command box where we key in our commands.

{Image of a command box}

([Navigating around the application](#navigating-around-the-application))

The format for commands are not identical. One command in FoodRem is the command to create a new item.

Format: `new n/ITEM_NAME [qty/QUANTITY] [type/TYPE] [bgt/BOUGHT_DATE] [exp/EXPIRY_DATE]`

The first word of every command allows FoodRem to distinguish different commands.
`new` tells FoodRem that this is the command to create a new item.
[Flags](#flags) such as `n/` and `qty/` are delimiters that enable FoodRem to distinguish different parameters
supplied by you without ambiguity. [Placeholders](#placeholders) such as `ITEM_NAME` and `QUANTITY` shows you
what you should place in each portion of the command. 

Suppose you just bought 30 kg of potatoes, today is 5th September 22, and you do not feel the need to record
an expiry date for the potatoes.

`ITEM_NAME`: Potatoes

`QUANTITY`: 30

`TYPE`: kg

`BOUGHT_DATE`: 05-09-22

Note: 
- The [Placeholder](#placeholders) section covers the restrictions for respective placeholders.
For example, the date format of BOUGHT_DATE, certain characters you cannot use and the limit and precision of numbers.

The command you would like to enter into the command box would be:

`new n/Potatoes qty/30 type/kg bgt/05-09-22`

Alternatively these commands would do the same thing:
- `new n/Potatoesqty/30type/kgbgt/05-09-22` (Omitting space between tags)
- `new qty/30 n/Potatoes bgt/05-09-22 type/kg` (Reordering the flags)

These commands are invalid:
- `newn/Potatoesqty/30type/kgbgt/05-09-22` (Removing space between command identifier and flag)
- `new qty/-48 n/PÖtátÖes bgt/05/09/22 type/|kg|` (Restrictions of placeholders not followed)

Find out more about restrictions in the sections [Flags](#flags), [Placeholders](#placeholders) and 
[Features](#features).

Notice that there is a pair of square brackets [] surrounding some parameters like `qty/QUANTITY` 
in the format. This indicates that the parameter is optional. Each of these placeholders have a default value
based on the commands. These are documented in the [Features](#features) section for each command. 

Let us try another command!

After creating the potatoes item, you decided to buy 40 kg more of potatoes.

Format: `inc id/INDEX_LIST [qty/QUANTITY]`

`inc` tells FoodRem that this is the command to increment the quantity of an item.
Suppose the `INDEX` for potatoes is `12` in the application, the command you
would like to enter into the command box is `inc id/12 qty/30`.

Note: `INDEX_LIST` can be an `INDEX` (More information in [Placeholders](#placeholders))

Now you should have a general sensing of how commands are used and how to interpret formats. All commands are
consolidated in [Command Summary](#command-summary). However, it is **highly recommended** that you read through 
the User Guide in a  **sequential order** up until the section [Features](#features) where you can find all the
information you need for each command. This covers more details on syntax and common errors. Before using any 
command, take note of the behaviour when certain tags are not included and restrictions.

Checklist before using a command:
- [ ] I know the restrictions of the command
- [ ] I know what flags are supplied to the command
- [ ] I know the restrictions of each placeholder
- [ ] I know the effects of not specifying each optional flag.

## Items and Tags

### Item
An item is a food item that you would like to include in FoodRem.
The following are all the attributes store for each item:
- Item name
- Item quantity
- Item type (Unit of measurement e.g. `kg`, `packets`)
- Item bought date
- Item expiry date

All items in FoodRem are unique. This means that no two items should have the same name.
Uniqueness is not case-sensitive. "potato" and "POTATO" are treated as identical.

FoodRem allows you to include an item that has an expiry date before a bought date. 
However, it will warn you that you are including an expired item into the inventory.

Restrictions for other attributes can be found in [Placeholders](#placeholders).

### Tag

A tag serves as a means to categorise items. These tags are also unique and not case-sensitive.

We can tag multiple items with the same tag and each item can have multiple tags. Tags are optional
and serve as a means to easily categorise items. 

Tags can be renamed and these changes would be reflected on all items immediately. 

## Navigating around the application

{Image of entire application}

<table>
<thead>
  <tr>
    <th>Name</th>
    <th>Description</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>Command Input</td>
    <td>{image}</td>
  </tr>
  <tr>
    <td>Command result</td>
    <td>{image}</td>
  </tr>
  <tr>
    <td>List Component</td>
    <td>{image}</td>
  </tr>
  <tr>
    <td>View Component</td>
    <td>{image}</td>
  </tr>
</tbody>
</table>

## Flags
Flags are delimiters that enable FoodRem to distinguish different parameters without ambiguity.

<table>
<thead>
  <tr>
    <th>Flags</th>
    <th>Related Placeholder</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>id/</td>
    <td>INDEX<br>INDEX_LIST</td>
  </tr>
  <tr>
    <td>n/</td>
    <td>ITEM_NAME<br>TAG_NAME</td>
  </tr>
  <tr>
    <td>qty/</td>
    <td>QUANTITY</td>
  </tr>
  <tr>
    <td>type/</td>
    <td>TYPE</td>
  </tr>
  <tr>
    <td>buy/</td>
    <td>BOUGHT_DATE</td>
  </tr>
  <tr>
    <td>exp/</td>
    <td>EXPIRY DATE</td>
  </tr>
</tbody>
</table>

## Placeholders
Placeholders are words in UPPER_CASE to show you what parameters you can supply to a command.
<table>
<thead>
  <tr>
    <th>Placeholders</th>
    <th>Related Flags</th>
    <th>Description</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>INDEX</td>
    <td>id/</td>
    <td>The INDEX of an item is the number to the left of the item name in the List Component.<br>INDEX is a whole number larger than 0. <br/><br/><br><strong>IMPORTANT</strong>: <br>The index of an item is dependent on the current search performed.<br>There is a limit of 10000 for the index.<br>Do not include thousands separators. <br><br/><strong>Valid Examples</strong>:<br>1<br>124<br><br/><strong>Invalid Examples:</strong><br>-1<br>1.5<br>1,132<br>1 132<br>10001</td>
  </tr>
  <tr>
    <td>INDEX_LIST</td>
    <td>id/</td>
    <td>The INDEX_LIST is a list of INDEX separated by commas. <br>All restrictions to INDEX are relevant.<br/><br><strong>IMPORTANT</strong>: <br>There is a limit of 20 indexes in the list.<br>Do not insert unnecessary commas or spaces.<br>Do not include duplicates in the list.<br><br/><strong>Valid Examples</strong>:<br>1<br>3214<br>3,2,1,4<br><br/><strong>Invalid Examples:</strong><br>,<br>3,2,1,4,<br>3,3,3,3<br>3,,2,1,,,4,<br>3, 2, 1, 4<br>3 2 1 4<br>3/2/1/4<br>1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21</td>
  </tr>
  <tr>
    <td>ITEM_NAME</td>
    <td>n/</td>
    <td>The ITEM_NAME is the term we use to identify an item.<br>ITEM_NAME is a short text.<br/><br><strong>IMPORTANT</strong>: <br>Only English characters, numbers, space, and the following symbols are accepted:<br>~`!@#$%^&amp;*()_-+={}[]:;”’&lt;&gt;,.?<br>There is a limit of 150 characters. Below is a text that is 200 characters long:<br>“Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae purus at nisi aliquet convallis. Aliquam scelerisque in erat ac sodales sed.”<br>ITEM_NAME is unique<br>ITEM_NAME cannot be blank <br>Leading and trailing spaces will be trimmed<br><br/><strong>Valid Examples</strong>:<br>Potatoes<br>Tomatoes! (Sauce :D)?<br>     <br><br/><strong>Invalid Examples:</strong><br>黃瓜<br>Carrots/Cucumbers<br>Carrots|Cucumbers<br>Carrots\Cucumbers</td>
  </tr>
  <tr>
    <td>TAG_NAME</td>
    <td>n/</td>
    <td>The TAG_NAME is the term we use to identify a tag.<br>TAG_NAME is a short text.<br/><br><strong>IMPORTANT</strong>:<br>Only English characters, numbers, space, and the following symbols are accepted: <br>~`!@#$%^&amp;*()_-+={}[]:;”’&lt;&gt;,.?<br>There is a limit of 30 characters in a TAG_NAME. Below is a text that is 30 characters long:<br>“Lorem ipsum dolor sit posuere.”<br>TAG_NAME is unique<br>TAG_NAME cannot be blank <br>Leading and trailing spaces will be trimmed<br><br/><strong>Valid Examples</strong>:<br>Food<br>Yummy! (Delicious :D)?<br><br/><strong>Invalid Examples:</strong><br>Одноразовый<br>Food/Condiments<br>Food|Condiments<br>Food\Condiments<br>Food Food Food Food Food Food Food</td>
  </tr>
  <tr>
    <td>QUANTITY</td>
    <td>qty/</td>
    <td>The QUANTITY is the number representing the amount of an item.<br>QUANTITY is a number larger than 0. It has an accuracy of up to 4 decimal places.<br/><br><strong>IMPORTANT</strong>:<br>There is a limit of 10000000 for the quantity.<br>Do not include thousands separators. <br>Do not include mathematical symbols<br><br/><strong>Valid Examples</strong>:<br>12<br>12.1234<br>1234567<br><br/><strong>Invalid Examples:</strong><br>12.12345<br>1,234,567<br>1 + 1<br>1/2<br>π</td>
  </tr>
  <tr>
    <td>TYPE</td>
    <td>type/</td>
    <td>The TYPE is an optional text indicating the unit of an item.<br>TYPE is a short text.<br/><br><strong>IMPORTANT</strong>:<br>Only English characters, numbers, space, and the following symbols are accepted: <br>~`!@#$%^&amp;*()_-+={}[]:;”’&lt;&gt;,.?<br>There is a limit of 20 characters in a TYPE.<br>Leading and trailing spaces will be trimmed<br><br/><strong>Valid Examples</strong>:<br>kg<br>Packets<br><br/><strong>Invalid Examples:</strong><br>Containers (1000 grams)<br>Containers/grams<br>Containers|grams<br>Containers\grams</td>
  </tr>
  <tr>
    <td>BOUGHT_DATE</td>
    <td>bgt/</td>
    <td>The BOUGHT_DATE is an optional date indicating when the item was bought.<br>BOUGHT_DATE is a date in one of the following formats:<br>yyyy-mm-dd<br>dd-mm-yyyy<br/><br><strong>IMPORTANT</strong>:<br>We only accept years less than 10000<br><br/><strong>Valid Examples</strong>:<br>2022-09-01<br>01-09-2022<br>1-9-2022<br><br/><strong>Invalid Examples:</strong><br>01-11-20222<br>01/09/2022<br>40-40-2022<br>1-9-22<br>1-nov-2202</td>
  </tr>
  <tr>
    <td>EXPIRY_DATE</td>
    <td>exp/</td>
    <td>The EXPIRY_DATE is an optional date indicating when the item will expire.<br>EXPIRY_DATE is a date in one of the following formats:<br>yyyy-mm-dd<br>dd-mm-yyyy<br/><br><strong>IMPORTANT</strong>:<br>We only accept years less than 10000<br><br/><strong>Valid Examples</strong>:<br>2022-09-01<br>01-09-2022<br>1-9-2022<br><br/><strong>Invalid Examples:</strong><br>01-11-20222<br>01/09/2022<br>40-40-2022<br>1-9-22<br>1-nov-2202</td>
  </tr>
</tbody>
</table>

## Features

This section covers how to use each command in detail. 
Before continuing, ensure you have read the section on [Flags](#flags) and [Placeholders](#placeholders).

What you should expect to find:

- A description of the command
- The expected behaviour for the command
- A few valid and invalid examples of the command
- Important points to note

**IMPORTANT:**

- Square brackets indicate an optional parameter.
- For each command, "Format" indicates the syntax of the command.

### Item Features

{Insert an image of items}

#### Create a new item

<!--- Remember to warn users if expiry date < bought date-->

Command: `item new ITEM_NAME`

> Description: Creates a new item with the provided item_name.

---

Example:

Input

```
item new potato
```

Output

```
Item  “potato” successfully created
```

#### List all items

Command: `list`

> Description: Lists all the items in the inventory.

---

Example:

Input

```
list
```

Output

```
Here are the items in your inventory:
Onions
Details about onions
Tomatoes
Details about tomatoes
Chicken wings
Details about chicken wings
```

### Search for an item

<!--- Remember to implement find by tags-->

Command: `find NAME`

> Description: Find an inventory item based on the given keywords
> The search is case-insensitive. (e.g. apples will match Apples)
> The order of the keyword does not matter e.g (rose apple will match apple rose)
> Only the item name is searched

---

Example:

Input

```
find apple
```

Output

```
Here are the results matching your search
Green apple
Rose apple
```

#### Sort all items by an attribute

#### View the information of an item

#### Increase the quantity of an item

#### Decrease the quantity of an item

#### Update the information of an item

#### Delete an item

Command: `[item] delete ITEM_INDEX`

> Description: Deletes a specified item. Returns a warning if the item does not exist. 

---

Example: 

Input
```
delete 1
```
Output
```
(Item exists): Item “potato” successfully deleted!
(Item does not exist): No item to be found at index 1. Use “list items” or “find NAME” to find the index of the item to be deleted.
```

### Tag Features

{Insert an image of tags}

#### Create a new tag

#### List all tags

Command: `list tags`

> Description: Lists all the tags that the user has created.

---

Example:

Input

```
list tags
```

Output

```
Here are the tags that are available:
Fruits
Vegetables
Spices
```

#### Tag an item

#### Untag an item

#### Rename a tag

#### Delete a tag

### Receive help during usage

Command: `help`

> Description: Displays a list of commands that can be used.

---

Example:

Input

```
help
```

Output:

```
list:
    Lists all the items/tags that the user has created.

    Usage:
        List items:  "list items"
        List tags:   "list tags"

item:
    Create / Delete / Increment quantity / Decrement quantity /
    Set quantity / Set expiry date / Set bought date, of an item.

    Flags:
        Name:        n/
        Quantity:    qty/
        Expiry Date: exp/
        Bought Date: bgt/

    Usage:
        Create:      "item new n/Potatoes"
        Delete:      "item del 1"
        Increment:   "item inc 1 10"
        Decrement:   "item dec 1 10"
        Set:         "item set 1 n/Potatoes qty/10"

find:
    Find an inventory item based on the given keywords.

    Usage:
        Find:        "find potato carrots"

tag:
    Create / Rename / Set item tied to / Delete, a tag.

    Flags:
        Name:        n/

    Usage:
        Create:      "tag create food"
        Rename:      "tag rename food n/foodie"
        Set item:    "tag 1 2 7 71 food"
        Delete:      "tag delete food"

bye:
    Exits Foodrem program.

    Usage:
        Exit:       "bye"
```

### Reset the application

### Exit the application

Command: `bye`

> Description: Exits FoodRem program.

---

Example:

Input

```
bye
```

## Command Summary

### Item Commands

<table>
<thead>
  <tr>
    <th>Action</th>
    <th>Format</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>Create a new item</td>
    <td><b>new n/ITEM_NAME [qty/QUANTITY] [type/TYPE] [bgt/BOUGHT_DATE] [exp/EXPIRY_DATE]</b><br><br><u>Valid Example:</u><br>new n/Potato qty/70 type/kg bgt/22-02-11 exp/22-03/11</td>
  </tr>
  <tr>
    <td>List all items</td>
    <td><b>list</b><br><br><u>Valid Example:</u><br>list</td>
  </tr>
  <tr>
    <td>Search for an item</td>
    <td><b>find n/ITEM_NAME</b><br><br><u>Valid Example:</u><br>find n/Potato</td>
  </tr>
  <tr>
    <td>Sort an item by name, quantity, type, bought date or expiry date.</td>
    <td><b>sort [n/] [qty/] [type/] [bgt/] [exp/]</b><br><br><u>Valid Example:</u><br>sort n/<br>sort qty/<br>sort qty/ bgt/<br><br><u>Invalid Example:</u><br>sort</td>
  </tr>
  <tr>
    <td>View information about an item</td>
    <td><b>view id/INDEX</b><br><br><u>Valid Examples:</u><br>view id/1</td>
  </tr>
  <tr>
    <td>Increase the quantity of an item</td>
    <td><b>inc id/INDEX_LIST [qty/QUANTITY]</b><br><br><u>Valid Examples:</u><br>inc id/1 qty/100<br>inc id/1,2,3 qty/100</td>
  </tr>
  <tr>
    <td>Decrease the quantity of an item</td>
    <td><b>dec id/INDEX_LIST [qty/QUANTITY]</b><br><br><u>Valid Examples:</u><br>dec id/1 qty/100<br>dec id/1,2,3 qty/100</td>
  </tr>
  <tr>
    <td>Update the information of an item</td>
    <td><b>set id/INDEX_LIST [n/ITEM_NAME] [qty/QUANTITY] [type/TYPE] [bgt/BOUGHT_DATE] [exp/EXPIRY_DATE]</b><br><br>❗ IMPORTANT:<br>Do not update multiple items to have the same name<br><br><u>Valid Examples:</u><br>set id/1 n/Potatoes qty/60 type/kg<br>set id/1,2,3 qty/60</td>
  </tr>
  <tr>
    <td>Delete an item</td>
    <td><b>del id/INDEX_LIST</b><br><br><u>Valid Examples:</u><br>del id/1<br>del id/1,2,3</td>
  </tr>
</tbody>
</table>

### Tag Commands

<table>
<thead>
  <tr>
    <th>Action</th>
    <th>Format</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>Create a new tag</td>
    <td><b>newtag n/TAG_NAME</b><br><br><u>Valid Examples:</u><br>newtag n/Food<br>newtag n/Condiments<br><br><u>Invalid Examples:</u><br>newtag Food<br>newtag Condiments</td>
  </tr>
  <tr>
    <td>List all tags available<br></td>
    <td><b>listtag</b><br><br><u>Valid Example:</u><br>listtag<br><br><br><u>Invalid Example:</u><br>listtags</td>
  </tr>
  <tr>
    <td>Tag items with a specific tag<br></td>
    <td><b>tag n/TAG_NAME id/INDEX_LIST</b><br><br><u>Valid Examples:</u><br>tag n/Condiments id/1<br>tag n/Condiments id/1,2,4,8<br><br><u>Invalid Example:</u><br>tag Condiments 1</td>
  </tr>
  <tr>
    <td>Untag items with a specific tag</td>
    <td><b>untag n/TAG_NAME id/INDEX_LIST</b><br><br><u>Valid Examples:</u><br>untag n/Condiments id/1<br>untag n/Condiments id/1,2,4,8<br><br><u>Invalid Example:</u><br>untag Condiments 1,2</td>
  </tr>
  <tr>
    <td>Rename a tag</td>
    <td><b>renametag n/TAG_NAME n/TAG_NAME</b><br><br><u>Valid Example:</u><br>renametag n/Condiments n/Condiment<br><br><u>Invalid Example:<br>renametag Condiments Condiment</u><br></td>
  </tr>
  <tr>
    <td>Delete a tag</td>
    <td><b>delete n/TAG_NAME</b><br><br><u>Valid Examples:</u><br>deletetag n/Food<br><br><br><u>Invalid Examples:</u><br>deletetag n/<br>deletetag Food<br>deletetag Condiments</td>
  </tr>
</tbody>
</table>

### Other Commands

<table>
<thead>
  <tr>
    <th>Action</th>
    <th>Format</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>Shows a help dialog with a list of available commands</td>
    <td><b>help</b><br><br><u>Valid Example:</u><br>help</td>
  </tr>
  <tr>
    <td>Reset the application</td>
    <td><b>reset</b><br><u><br>Valid Example:</u><br>reset</td>
  </tr>
  <tr>
    <td>Exit the application</td>
    <td><b>exit</b><br><u><br>Valid Examples:</u><br>exit</td>
  </tr>
</tbody>
</table>

## Troubleshooting

Something goes here...

## FAQ

Something goes here...

## Future Extensions

(NOT COMPLETED)

1. Food expiring soon / Date food bought
   **Glorified search and sort**
   a. Upgrade sort and search b. Sort food items by quantity c. Sort food items by name d. Sort food items by expiry
   date e. Sort food items by purchase date

2. Food buffer a. Rainbow UI / Dashboard b. Optional : Minimum acceptable quantity c. Optional : Percentage of stock
   expiring

3. Purchasing (Hard -> Will not see benefit immediately)
   a. History + Statistics b. Inventory need a price of items

4. (Last priority) Order management a. Grouping of items b. Creation of menu with specific items c. Record menu items
   bought d. Statistics

## Acknowledgements

Something goes here...

## Glossary

Something goes here...
