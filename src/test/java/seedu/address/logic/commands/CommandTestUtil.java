package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM_BOUGHT_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM_EXPIRY_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM_QUANTITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM_UNIT;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand.EditItemDescriptor;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.item.Item;
import seedu.address.model.item.NameContainsKeywordsPredicate;
import seedu.address.testutil.EditItemDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_ITEM_NAME_POTATOES = "Potatoes";
    public static final String VALID_ITEM_QUANTITY_POTATOES = "10";
    public static final String VALID_ITEM_UNIT_POTATOES = "kg";
    public static final String VALID_ITEM_BOUGHT_DATE_POTATOES = "2022-11-11";
    public static final String VALID_ITEM_EXPIRY_DATE_POTATOES = "2022-11-11";

    public static final String VALID_ITEM_NAME_CUCUMBERS = "Cucumbers";
    public static final String VALID_ITEM_QUANTITY_CUCUMBERS = "2000";
    public static final String VALID_ITEM_UNIT_CUCUMBERS = "grams";
    public static final String VALID_ITEM_BOUGHT_DATE_CUCUMBERS = "2022-12-12";
    public static final String VALID_ITEM_EXPIRY_DATE_CUCUMBERS = "2022-12-12";

    public static final String VALID_DESC_ITEM_NAME_POTATOES = PREFIX_ITEM_NAME
        + VALID_ITEM_NAME_POTATOES;
    public static final String VALID_DESC_ITEM_QUANTITY_POTATOES = PREFIX_ITEM_QUANTITY
        + VALID_ITEM_QUANTITY_POTATOES;
    public static final String VALID_DESC_ITEM_UNIT_POTATOES = PREFIX_ITEM_UNIT
        + VALID_ITEM_UNIT_POTATOES;
    public static final String VALID_DESC_ITEM_BOUGHT_DATE_POTATOES = PREFIX_ITEM_BOUGHT_DATE
        + VALID_ITEM_BOUGHT_DATE_POTATOES;
    public static final String VALID_DESC_ITEM_EXPIRY_DATE_POTATOES = PREFIX_ITEM_EXPIRY_DATE
        + VALID_ITEM_EXPIRY_DATE_POTATOES;

    public static final String VALID_DESC_ITEM_NAME_CUCUMBERS = PREFIX_ITEM_NAME
        + VALID_ITEM_NAME_CUCUMBERS;
    public static final String VALID_DESC_ITEM_QUANTITY_CUCUMBERS = PREFIX_ITEM_QUANTITY
        + VALID_ITEM_QUANTITY_CUCUMBERS;
    public static final String VALID_DESC_ITEM_UNIT_CUCUMBERS = PREFIX_ITEM_UNIT
        + VALID_ITEM_UNIT_CUCUMBERS;
    public static final String VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS = PREFIX_ITEM_BOUGHT_DATE
        + VALID_ITEM_BOUGHT_DATE_CUCUMBERS;
    public static final String VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS = PREFIX_ITEM_EXPIRY_DATE
        + VALID_ITEM_EXPIRY_DATE_CUCUMBERS;

    public static final String INVALID_ITEM_NAME_POTATOES = "Potatoes|/";
    public static final String INVALID_ITEM_QUANTITY_POTATOES = "10|/";
    public static final String INVALID_ITEM_UNIT_POTATOES = "kg|/";
    public static final String INVALID_ITEM_BOUGHT_DATE_POTATOES = "2022-11-11|/";
    public static final String INVALID_ITEM_EXPIRY_DATE_POTATOES = "2022-11-11|/";

    public static final String INVALID_ITEM_NAME_CUCUMBERS = "Cucumbers|/";
    public static final String INVALID_ITEM_QUANTITY_CUCUMBERS = "2000|/";
    public static final String INVALID_ITEM_UNIT_CUCUMBERS = "grams|/";
    public static final String INVALID_ITEM_BOUGHT_DATE_CUCUMBERS = "2022-12-12|/";
    public static final String INVALID_ITEM_EXPIRY_DATE_CUCUMBERS = "2022-12-12|/";

    public static final String INVALID_DESC_ITEM_NAME_CUCUMBERS = PREFIX_ITEM_NAME
        + INVALID_ITEM_NAME_CUCUMBERS;
    public static final String INVALID_DESC_ITEM_QUANTITY_CUCUMBERS = PREFIX_ITEM_QUANTITY
        + INVALID_ITEM_QUANTITY_CUCUMBERS;
    public static final String INVALID_DESC_ITEM_UNIT_CUCUMBERS = PREFIX_ITEM_UNIT
        + INVALID_ITEM_UNIT_CUCUMBERS;
    public static final String INVALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS = PREFIX_ITEM_BOUGHT_DATE
        + INVALID_ITEM_BOUGHT_DATE_CUCUMBERS;
    public static final String INVALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS = PREFIX_ITEM_EXPIRY_DATE
        + INVALID_ITEM_EXPIRY_DATE_CUCUMBERS;

    public static final String INVALID_DESC_ITEM_NAME_POTATOES = PREFIX_ITEM_NAME
        + INVALID_ITEM_NAME_POTATOES;
    public static final String INVALID_DESC_ITEM_QUANTITY_POTATOES = PREFIX_ITEM_QUANTITY
        + INVALID_ITEM_QUANTITY_POTATOES;
    public static final String INVALID_DESC_ITEM_UNIT_POTATOES = PREFIX_ITEM_UNIT
        + INVALID_ITEM_UNIT_POTATOES;
    public static final String INVALID_DESC_ITEM_BOUGHT_DATE_POTATOES = PREFIX_ITEM_BOUGHT_DATE
        + INVALID_ITEM_BOUGHT_DATE_POTATOES;
    public static final String INVALID_DESC_ITEM_EXPIRY_DATE_POTATOES = PREFIX_ITEM_EXPIRY_DATE
        + INVALID_ITEM_EXPIRY_DATE_POTATOES;

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditItemDescriptor DESC_POTATOES;
    public static final EditItemDescriptor DESC_CUCUMBERS;

    static {
        DESC_POTATOES = new EditItemDescriptorBuilder()
            .withItemName(VALID_ITEM_NAME_POTATOES)
            .withItemQuantity(VALID_ITEM_QUANTITY_POTATOES)
            .withItemUnit(VALID_ITEM_UNIT_POTATOES)
            .withItemBoughtDate(VALID_ITEM_BOUGHT_DATE_POTATOES)
            .withItemExpiryDate(VALID_ITEM_EXPIRY_DATE_POTATOES)
            .build();
        DESC_CUCUMBERS = new EditItemDescriptorBuilder()
            .withItemName(VALID_ITEM_EXPIRY_DATE_CUCUMBERS)
            .withItemQuantity(VALID_ITEM_EXPIRY_DATE_CUCUMBERS)
            .withItemUnit(VALID_ITEM_EXPIRY_DATE_CUCUMBERS)
            .withItemBoughtDate(VALID_ITEM_EXPIRY_DATE_CUCUMBERS)
            .withItemExpiryDate(VALID_ITEM_EXPIRY_DATE_CUCUMBERS)
            .build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
                                            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
                                            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Item> expectedFilteredList = new ArrayList<>(actualModel.getFilteredItemList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredItemList());
    }

    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showItemAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredItemList().size());

        Item item = model.getFilteredItemList().get(targetIndex.getZeroBased());
        final String name = item.getName().toString();
        model.updateFilteredItemList(new NameContainsKeywordsPredicate(List.of(name)));

        assertEquals(1, model.getFilteredItemList().size());
    }
}
