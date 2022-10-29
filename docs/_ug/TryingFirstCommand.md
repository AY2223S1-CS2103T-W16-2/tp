<!-- markdownlint-disable-file first-line-h1 -->

To let you become more familiar with FoodRem, let's practice executing some commands.

To start off, let's try out the `new` command! This command lets you add an [Item](#item) to FoodRem.

One of the available commands in FoodRem is the command to create a new item.

**Format:** `new n/ITEM_NAME [qty/QUANTITY] [u/UNIT] [bgt/BOUGHT_DATE] [exp/EXPIRY_DATE] [p/PRICE] [r/REMARKS]`

**What does the format mean?**

The first word of every command allows FoodRem to distinguish different commands.

* `new` tells FoodRem that this is the command to create a new item.
* [Flags](#flags) such as `n/` and `qty/` are delimiters that enable FoodRem to distinguish different parameters supplied by you without ambiguity.
* [Placeholders](#placeholders) such as `ITEM_NAME` and `QUANTITY` shows you what you should place in each portion of the command.

Notice that there is a pair of square brackets `[]` surrounding some parameters like `qty/QUANTITY` in the format. This indicates that the parameter is **optional**. Each of these placeholders have a default value based on the commands. These are documented in the [Commands](#commands) section for each command.

```note
The [Placeholder](#placeholders) section covers the restrictions for respective placeholders. For example, the date format of BOUGHT_DATE, certain characters you cannot use and the limit and precision of numbers.
```

**Let's try an example!**

Suppose you just bought 30 kg worth of potatoes, today is 5th September 2022, and you do not feel the need to record an expiry date, price or remarks for this item.

`ITEM_NAME`: Potatoes

`QUANTITY`: 30

`UNIT`: kg

`BOUGHT_DATE`: 05-09-2022

The command you would like to enter into the command box would be:

`new n/Potatoes qty/30 u/kg bgt/05-09-2022`

Alternatively, executing these would do the same thing:

* `new qty/30 n/Potatoes bgt/05-09-2022 u/kg` _(Reordering the flags)_
* `new qty/100 n/Carrots qty/30 n/Potatoes bgt/05-09-2022 u/kg` _(Only last parameters are taken if multiple parameters are provided)_

However, note that the following executions are invalid:

* `newn/Potatoesqty/30u/kgbgt/05-09-2022` _(Removing spaces between the placeholders and flags)_
* `new qty/-48 n/PÖtátÖes bgt/05/09/22 u/|kg|` _(Restrictions of placeholders not followed)_
* `new` _(Insufficient information provided, you must minimally provide a name)_

_Find out more about restrictions in the sections [Flags](#flags), [Placeholders](#placeholders) and [Commands](#commands)._

---
Let's try out another command - the `inc` command! `inc` lets you increment the quantity of an item.

```warning
The format for different commands are not always identical. For example, executing the `new` command and the `inc` command will have different formats!
```

For example, after creating the potatoes item, you decided to buy 40 kg more of potatoes.

**Format:** `inc INDEX [qty/QUANTITY]`

Suppose the `INDEX` for potatoes is `1` in the application, the command you would like to enter into the [Command Input Box](#layout) would be:

`inc 1 qty/40`

You should now have a better understanding of how commands are formatted and used. All commands are consolidated in the [Command Summary](#command-summary).

Here is a checklist you can use before running a command:

* [ ] I know the restrictions of the command
* [ ] I know what parameters are supplied to the command
* [ ] I know the flags for each parameter to be supplied
* [ ] I know the restrictions of each placeholder
* [ ] I know the effects of not specifying each optional flag.
