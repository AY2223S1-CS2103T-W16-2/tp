package seedu.foodrem.model.util;

import java.util.HashSet;

import seedu.foodrem.model.FoodRem;
import seedu.foodrem.model.ReadOnlyFoodRem;
import seedu.foodrem.model.item.Item;
import seedu.foodrem.model.item.ItemBoughtDate;
import seedu.foodrem.model.item.ItemExpiryDate;
import seedu.foodrem.model.item.ItemName;
import seedu.foodrem.model.item.ItemPrice;
import seedu.foodrem.model.item.ItemQuantity;
import seedu.foodrem.model.item.ItemRemark;
import seedu.foodrem.model.item.ItemUnit;

/**
 * Contains utility methods for populating {@code FoodRem} with sample data.
 */
public class SampleDataUtil {
    public static Item[] getSampleItems() {
        return new Item[]{
            new Item(new ItemName("Potatoes"),
                    new ItemQuantity("10"),
                    new ItemUnit("kg"),
                    ItemBoughtDate.of("11-11-2022"),
                    ItemExpiryDate.of("11-11-2022"),
                    new ItemPrice("10.20"),
                    new ItemRemark("For Mashed Potatoes"),
                    new HashSet<>()),
            new Item(new ItemName("Cucumbers"),
                    new ItemQuantity("2000"),
                    new ItemUnit("grams"),
                    ItemBoughtDate.of("12-12-2022"),
                    ItemExpiryDate.of("12-12-2022"),
                    new ItemPrice("10"),
                    new ItemRemark("For Salad"),
                    new HashSet<>())
        };
    }

    public static ReadOnlyFoodRem getSampleFoodRem() {
        FoodRem sampleFoodRem = new FoodRem();
        for (Item sampleItem : getSampleItems()) {
            sampleFoodRem.addItem(sampleItem);
        }
        return sampleFoodRem;
    }

    // TODO: Check if we can delete this. Implement with tags
    ///**
    // * Returns a tag set containing the list of strings given.
    // */
    //public static Set<Tag> getTagSet(String... strings) {
    //    return Arrays.stream(strings)
    //            .map(Tag::new)
    //            .collect(Collectors.toSet());
    //}
}
