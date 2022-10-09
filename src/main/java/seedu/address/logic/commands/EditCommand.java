package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM_BOUGHT_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM_EXPIRY_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM_QUANTITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM_UNIT;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.item.Item;
import seedu.address.model.item.ItemBoughtDate;
import seedu.address.model.item.ItemExpiryDate;
import seedu.address.model.item.ItemName;
import seedu.address.model.item.ItemQuantity;
import seedu.address.model.item.ItemUnit;

/**
 * Edits the details of an existing person in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the person identified "
        + "by the index number used in the displayed person list. "
        + "Existing values will be overwritten by the input values.\n"
        + "Parameters: INDEX (must be a positive integer) "
        + "[" + PREFIX_ITEM_NAME + "NAME] "
        + "[" + PREFIX_ITEM_QUANTITY + "QUANTITY] "
        + "[" + PREFIX_ITEM_UNIT + "UNIT] "
        + "[" + PREFIX_ITEM_BOUGHT_DATE + "BOUGHT DATE] "
        + "[" + PREFIX_ITEM_EXPIRY_DATE + "EXPIRY DATE]...\n"
        + "Example: " + COMMAND_WORD + " 1 "
        + PREFIX_ITEM_QUANTITY + "1000 "
        + PREFIX_ITEM_QUANTITY + "grams";

    public static final String MESSAGE_EDIT_ITEM_SUCCESS = "Edited Item: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_ITEM = "This item already exists in the FoodRem.";
    private final EditItemDescriptor editItemDescriptor;
    private final Index index;

    /**
     * @param index              of the person in the filtered person list to edit
     * @param editItemDescriptor details to edit the person with
     */
    public EditCommand(Index index, EditItemDescriptor editItemDescriptor) {
        requireNonNull(index);
        requireNonNull(editItemDescriptor);

        this.index = index;
        this.editItemDescriptor = new EditItemDescriptor(editItemDescriptor);
    }

    /**
     * Creates and returns a {@code Item} with the details of {@code itemToEdit}
     * edited with {@code editItemDescriptor}.
     */
    private static Item createEditedItem(Item itemToEdit, EditItemDescriptor editItemDescriptor) {
        assert itemToEdit != null;

        ItemName updatedName = editItemDescriptor.getName().orElse(itemToEdit.getName());
        ItemQuantity updatedQuantity = editItemDescriptor.getQuantity().orElse(itemToEdit.getQuantity());
        ItemUnit updatedUnit = editItemDescriptor.getItemUnit().orElse(itemToEdit.getUnit());
        ItemBoughtDate updatedBoughtDate = editItemDescriptor.getItemBoughtDate().orElse(itemToEdit.getBoughtDate());
        ItemExpiryDate updatedExpiryDate = editItemDescriptor.getItemExpiryDate().orElse(itemToEdit.getExpiryDate());

        return new Item(updatedName, updatedQuantity, updatedUnit, updatedBoughtDate, updatedExpiryDate);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Item> lastShownList = model.getFilteredItemList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Item itemToEdit = lastShownList.get(index.getZeroBased());
        Item editedItem = createEditedItem(itemToEdit, editItemDescriptor);

        if (!itemToEdit.isSameItem(editedItem) && model.hasItem(editedItem)) {
            throw new CommandException(MESSAGE_DUPLICATE_ITEM);
        }

        model.setItem(itemToEdit, editedItem);
        model.updateFilteredItemList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_EDIT_ITEM_SUCCESS, editedItem));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }

        // state check
        EditCommand e = (EditCommand) other;
        return index.equals(e.index)
            && editItemDescriptor.equals(e.editItemDescriptor);
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditItemDescriptor {
        private ItemName name;
        private ItemQuantity quantity;
        private ItemUnit unit;
        private ItemBoughtDate boughtDate;
        private ItemExpiryDate expiryDate;

        public EditItemDescriptor() {
        }

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditItemDescriptor(EditItemDescriptor toCopy) {
            setItemName(toCopy.name);
            setItemQuantity(toCopy.quantity);
            setItemUnit(toCopy.unit);
            setItemBoughtDate(toCopy.boughtDate);
            setItemExpiryDate(toCopy.expiryDate);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, quantity, unit, boughtDate, expiryDate);
        }

        public Optional<ItemName> getName() {
            return Optional.ofNullable(name);
        }

        public void setItemName(ItemName name) {
            this.name = name;
        }

        public Optional<ItemQuantity> getQuantity() {
            return Optional.ofNullable(quantity);
        }

        public void setItemQuantity(ItemQuantity quantity) {
            this.quantity = quantity;
        }

        public Optional<ItemUnit> getItemUnit() {
            return Optional.ofNullable(unit);
        }

        public void setItemUnit(ItemUnit unit) {
            this.unit = unit;
        }

        public Optional<ItemBoughtDate> getItemBoughtDate() {
            return Optional.ofNullable(boughtDate);
        }

        public void setItemBoughtDate(ItemBoughtDate boughtDate) {
            this.boughtDate = boughtDate;
        }

        public Optional<ItemExpiryDate> getItemExpiryDate() {
            return Optional.ofNullable(expiryDate);
        }

        public void setItemExpiryDate(ItemExpiryDate expiryDate) {
            this.expiryDate = expiryDate;
        }

        ///**
        // * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
        // * if modification is attempted.
        // * Returns {@code Optional#empty()} if {@code tags} is null.
        // */
        //public Optional<Set<Tag>> getTags() {
        //    return (tags != null) ? Optional.of(Collections.unmodifiableSet(tags)) : Optional.empty();
        //}

        ///**
        // * Sets {@code tags} to this object's {@code tags}.
        // * A defensive copy of {@code tags} is used internally.
        // */
        //public void setTags(Set<Tag> tags) {
        //    this.tags = (tags != null) ? new HashSet<>(tags) : null;
        //}

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditItemDescriptor)) {
                return false;
            }

            // state check
            EditItemDescriptor e = (EditItemDescriptor) other;

            return getName().equals(e.getName())
                && getQuantity().equals(e.getQuantity())
                && getItemUnit().equals(e.getItemUnit())
                && getItemBoughtDate().equals(e.getItemBoughtDate())
                && getItemExpiryDate().equals(e.getItemExpiryDate());
        }
    }
}
