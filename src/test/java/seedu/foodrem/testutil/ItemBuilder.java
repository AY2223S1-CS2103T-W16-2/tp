package seedu.foodrem.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.foodrem.model.item.Item;
import seedu.foodrem.model.item.ItemBoughtDate;
import seedu.foodrem.model.item.ItemExpiryDate;
import seedu.foodrem.model.item.ItemName;
import seedu.foodrem.model.item.ItemPrice;
import seedu.foodrem.model.item.ItemQuantity;
import seedu.foodrem.model.item.ItemUnit;
import seedu.foodrem.model.tag.Tag;

/**
 * A utility class to help with building Item objects.
 */
public class ItemBuilder {
    public static final String DEFAULT_NAME = "NONE";
    public static final String DEFAULT_QUANTITY = "0";
    public static final String DEFAULT_ITEM_UNIT = "";
    public static final String DEFAULT_BOUGHT_DATE = "";
    public static final String DEFAULT_EXPIRY_DATE = "";
    public static final String DEFAULT_PRICE = "";

    // Identity fields
    private ItemName name;
    // Data fields
    private ItemQuantity quantity;
    private ItemUnit unit;
    private ItemBoughtDate boughtDate;
    private ItemExpiryDate expiryDate;
    private ItemPrice price;
    private Set<Tag> tags;

    /**
     * Creates a {@code ItemBuilder} with the default details.
     */
    public ItemBuilder() {
        name = new ItemName(DEFAULT_NAME);
        quantity = new ItemQuantity(DEFAULT_QUANTITY);
        unit = new ItemUnit(DEFAULT_ITEM_UNIT);
        boughtDate = new ItemBoughtDate(DEFAULT_BOUGHT_DATE);
        expiryDate = new ItemExpiryDate(DEFAULT_EXPIRY_DATE);
        price = new ItemPrice(DEFAULT_PRICE);
        tags = new HashSet<>();
    }

    /**
     * Initializes the ItemBuilder with the data of {@code itemToCopy}.
     */
    public ItemBuilder(Item itemToCopy) {
        name = itemToCopy.getName();
        quantity = itemToCopy.getQuantity();
        unit = itemToCopy.getUnit();
        boughtDate = itemToCopy.getBoughtDate();
        expiryDate = itemToCopy.getExpiryDate();
        price = itemToCopy.getPrice();
        tags = new HashSet<>(itemToCopy.getTagSet());
    }

    /**
     * Sets the {@code Name} of the {@link Item} that we are building.
     */
    public ItemBuilder withItemName(String name) {
        this.name = new ItemName(name);
        return this;
    }

    /**
     * Sets the item quantity of the {@link Item} that we are building.
     */
    public ItemBuilder withItemQuantity(String quantity) {
        this.quantity = new ItemQuantity(quantity);
        return this;
    }

    /**
     * Sets the item unit of the {@link Item} that we are building.
     */
    public ItemBuilder withItemUnit(String unit) {
        this.unit = new ItemUnit(unit);
        return this;
    }

    /**
     * Sets the item bought date of the {@link Item} that we are building.
     */
    public ItemBuilder withItemBoughtDate(String boughtDate) {
        this.boughtDate = new ItemBoughtDate(boughtDate);
        return this;
    }

    /**
     * Sets the item expiry date of the {@link Item} that we are building.
     */
    public ItemBuilder withItemExpiryDate(String expiryDate) {
        this.expiryDate = new ItemExpiryDate(expiryDate);
        return this;
    }

    /**
     * Sets the item price of the {@link Item} that we are building.
     */
    public ItemBuilder withItemPrice(String price) {
        this.price = new ItemPrice(price);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@link Item} that we are building.
     */
    public ItemBuilder withTags(String... tagNames) {
        for (String tagName : tagNames) {
            this.tags.add(new TagBuilder().withTagName(tagName).build());
        }
        return this;
    }

    public Item build() {
        return new Item(name, quantity, unit, boughtDate, expiryDate, price, tags);
    }
}
