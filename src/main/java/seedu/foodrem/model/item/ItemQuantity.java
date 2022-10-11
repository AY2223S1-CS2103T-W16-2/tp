package seedu.foodrem.model.item;

import static java.util.Objects.requireNonNull;

import seedu.foodrem.model.item.itemvalidators.ItemQuantityValidator;


/**
 * Represents an item quantity in an {@link Item}.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class ItemQuantity {

    private static final double DEFAULT_QUANTITY = 0;

    private final double itemQuantity;

    /**
     * {@inheritDoc}
     */
    public ItemQuantity(String itemQuantityString) {
        requireNonNull(itemQuantityString);
        if (itemQuantityString.isEmpty()) {
            itemQuantity = DEFAULT_QUANTITY;
            return;
        }
        ItemQuantityValidator.validate(itemQuantityString);
        itemQuantity = Double.parseDouble(itemQuantityString);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ItemQuantity // instanceof handles nulls
                && itemQuantity == ((ItemQuantity) other).itemQuantity); // state check
    }

    /**
     * Compares two item quantities. The method returns 0 if the quantity is equal to the other quantity.
     * A value less than 0 is returned if the quantity is less than the other quantity and
     * a value greater than 0 if the quantity is greater than the other quantity.
     *
     * @param other The ItemQuanitty to compare this ItemQuantity against.
     */
    public int compareTo(ItemQuantity other) {
        if (itemQuantity < other.itemQuantity) {
            return -1;
        } else if (itemQuantity > other.itemQuantity) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.valueOf(itemQuantity);
    }
}
