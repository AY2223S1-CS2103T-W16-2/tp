<!-- markdownlint-disable-file first-line-h1 -->
Example of a [Tag](#tag):

![Tags](images/TagImage.png)

#### Create a new tag: `newtag`

**Format**: `newtag n/TAG_NAME`

> Creates a new tag with the provided tag name

**Example:**

{% capture notes %}
**Assumption:**

FoodRem does not already contain a tag called "Vegetables".
{% endcapture %}
{%
  include command-format.md
  notes=notes
  input="newtag n/Vegetables"
  commandOutputBox="images/tagCommands/commandOutputBox/newtag.png"
%}

---

#### List all tags: `listtag`

**Format**: `listtag`

> List all tags in FoodRem

**Example Input:**

```text
listtag
```

**Example Output:**<br>Command Output Box:

```text
Listed all tags:
Vegetables
Carrots
```

---

#### Tag an item: `tag`

**Format**: `tag INDEX n/TAG_NAME`

> Tags the item at the specified index

**Example Input:**

```text
tag 1 n/Vegetables
```

**Example Output:**<br>Command Output Box:

```text
Item tagged successfully.
Name: Onions
Quantity: 8 kg
Bought Date: 10-10-2022
Expiry Date: 10-11-2022
Price: $6
Remarks: No Remarks
Tags: {Vegetables}
```

---

#### Untag an item: `untag`

**Format**: `untag INDEX n/TAG_NAME`

> Untags the item at the specified index

**Example Input:**

```text
untag 1 n/Vegetables
```

**Example Output:**<br>Command Output Box:

```text
Item untagged successfully
Name: Onions
Quantity: 8 kg
Bought Date: 10-10-2022
Expiry Date: 10-11-2022
Price: $6
Remarks: No Remarks
Tags: {}
```

---

#### Rename a tag: `renametag`

**Format**: `renametag n/TAG_NAME n/TAG_NAME`

> Renames a tag currently in FoodRem

```info
The first `TAG_NAME` in the command refers to the current tag you wish to rename while the second `TAG_NAME` refers to the new name you wish to rename the current tag to.
```

**Example Input:**

```text
renametag n/Vegetables n/Veggies
```

**Example Output:**<br>Command Output Box:

```text
Original tag: Vegetables
Renamed tag: Veggies
```

---

#### Delete a tag: `deletetag`

**Format**: `deletetag n/TAG_NAME`

> Deletes a tag that exists in FoodRem

**Example Input:**

```text
deletetag n/Veggies
```

**Example Output:**<br>Command Output Box:

```text
Tag deleted: Veggies
```

---

#### Filter by a tag: `filtertag`

**Format**: `filtertag n/TAG_NAME`

> Filters and shows items that contain a specific tag

**Example Input:**

```text
filtertag n/fruits
```

**Example Output:**<br>Command Output Box:

```text
Filtered by tag: fruits
2 items left after filtering!
```

Item List Box:

```text
1. Apples 8 kg (Bought Date: 10-10-2022) (Expiry Date: 10-11-2022)
2. Onions 8 kg $1 (Bought Date: 10-10-2022) (Expiry Date: 10-11-2022)
```
