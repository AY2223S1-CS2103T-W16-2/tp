package seedu.foodrem.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.foodrem.model.item.Item;
import seedu.foodrem.model.item.ItemBoughtDate;
import seedu.foodrem.model.item.ItemExpiryDate;
import seedu.foodrem.model.item.ItemName;
import seedu.foodrem.model.item.ItemPrice;
import seedu.foodrem.model.item.ItemQuantity;
import seedu.foodrem.model.item.ItemRemark;
import seedu.foodrem.model.item.ItemUnit;
import seedu.foodrem.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Item}.
 */
class JsonAdaptedItem {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Item's %s field is missing!";

    private final String name;
    private final String quantity;
    private final String unit;
    private final String boughtDate;
    private final String expiryDate;
    private final String price;
    private final String remarks;
    private final List<JsonAdaptedTag> tags = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedItem} with the given item details.
     */
    @JsonCreator
    public JsonAdaptedItem(@JsonProperty("name") String name,
                           @JsonProperty("quantity") String quantity,
                           @JsonProperty("unit") String unit,
                           @JsonProperty("bought") String boughtDate,
                           @JsonProperty("expiry") String expiryDate,
                           @JsonProperty("price") String price,
                           @JsonProperty("remarks") String remarks,
                           @JsonProperty("tags") List<JsonAdaptedTag> tagSet) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.boughtDate = boughtDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.remarks = remarks;
        this.tags.addAll(tagSet);
    }

    /**
     * Converts a given {@code Item} into this class for Jackson use.
     */
    public JsonAdaptedItem(Item source) {
        name = Objects.toString(source.getName());
        quantity = Objects.toString(source.getQuantity());
        unit = Objects.toString(source.getUnit(), "");
        boughtDate = Objects.toString(source.getBoughtDate(), "");
        expiryDate = Objects.toString(source.getExpiryDate(), "");
        price = Objects.toString(source.getPrice(), "");
        remarks = Objects.toString(source.getRemarks(), "");
        tags.addAll(source.getTagSet().stream().map(JsonAdaptedTag::new).collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted item object into the model's {@code Item} object.
     *
     * @throws IllegalArgumentException if there were any data constraints violated in the adapted item.
     */
    public Item toModelType() throws IllegalArgumentException {

        if (name == null) {
            throw new IllegalArgumentException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ItemName.class.getSimpleName()));
        }
        final ItemName modelItemName = new ItemName(name);

        if (quantity == null) {
            throw new IllegalArgumentException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ItemQuantity.class.getSimpleName()));
        }
        final ItemQuantity modelItemQuantity = new ItemQuantity(quantity);

        if (unit == null) {
            throw new IllegalArgumentException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ItemUnit.class.getSimpleName()));
        }
        final ItemUnit modelItemUnit = new ItemUnit(unit);

        if (boughtDate == null) {
            throw new IllegalArgumentException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ItemBoughtDate.class.getSimpleName()));
        }
        final ItemBoughtDate modelItemBoughtDate = new ItemBoughtDate(boughtDate);

        if (expiryDate == null) {
            throw new IllegalArgumentException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ItemExpiryDate.class.getSimpleName()));
        }
        final ItemExpiryDate modelItemExpiryDate = new ItemExpiryDate(expiryDate);

        if (price == null) {
            throw new IllegalArgumentException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ItemPrice.class.getSimpleName()));
        }
        final ItemPrice modelItemPrice = new ItemPrice(price);

        if (remarks == null) {
            throw new IllegalArgumentException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ItemRemark.class.getSimpleName()));
        }
        final ItemRemark modelItemRemark = new ItemRemark(remarks);

        final List<Tag> itemTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tags) {
            itemTags.add(tag.toModelType());
        }

        final Set<Tag> modelTags = new HashSet<>(itemTags);
        return new Item(modelItemName,
                modelItemQuantity,
                modelItemUnit,
                modelItemBoughtDate,
                modelItemExpiryDate,
                modelItemPrice,
                modelItemRemark,
                modelTags);
    }

}
