package seedu.foodrem.logic.parser;

import static seedu.foodrem.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.foodrem.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.foodrem.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_DESC_ITEM_BOUGHT_DATE_POTATOES;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_DESC_ITEM_EXPIRY_DATE_POTATOES;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_DESC_ITEM_NAME_CUCUMBERS;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_DESC_ITEM_NAME_POTATOES;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_DESC_ITEM_QUANTITY_CUCUMBERS;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_DESC_ITEM_QUANTITY_POTATOES;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_DESC_ITEM_UNIT_CUCUMBERS;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_DESC_ITEM_UNIT_POTATOES;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_ITEM_BOUGHT_DATE_POTATOES;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_ITEM_EXPIRY_DATE_POTATOES;
import static seedu.foodrem.logic.commands.CommandTestUtil.VALID_ITEM_NAME_POTATOES;
import static seedu.foodrem.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.foodrem.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.foodrem.testutil.TypicalItems.CUCUMBERS;

import org.junit.jupiter.api.Test;

import seedu.foodrem.logic.commands.AddCommand;
import seedu.foodrem.model.item.Item;
import seedu.foodrem.testutil.ItemBuilder;

public class AddCommandParserTest {
    private final AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Item expectedItem = new ItemBuilder(CUCUMBERS).build();

        // whitespace only preamble
        assertParseSuccess(parser,
            PREAMBLE_WHITESPACE + " "
                + VALID_DESC_ITEM_NAME_CUCUMBERS + " "
                + VALID_DESC_ITEM_QUANTITY_CUCUMBERS + " "
                + VALID_DESC_ITEM_UNIT_CUCUMBERS + " "
                + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS + " "
                + VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, new AddCommand(expectedItem));

        // multiple names - last name accepted
        assertParseSuccess(parser,
            PREAMBLE_WHITESPACE + " "
                + VALID_DESC_ITEM_NAME_POTATOES + " "
                + VALID_DESC_ITEM_NAME_CUCUMBERS + " "
                + VALID_DESC_ITEM_QUANTITY_CUCUMBERS + " "
                + VALID_DESC_ITEM_UNIT_CUCUMBERS + " "
                + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS + " "
                + VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, new AddCommand(expectedItem));

        // multiple quantities - last quantity accepted
        assertParseSuccess(parser,
            PREAMBLE_WHITESPACE + " "
                + VALID_DESC_ITEM_NAME_CUCUMBERS + " "
                + VALID_DESC_ITEM_QUANTITY_POTATOES + " "
                + VALID_DESC_ITEM_QUANTITY_CUCUMBERS + " "
                + VALID_DESC_ITEM_UNIT_CUCUMBERS + " "
                + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS + " "
                + VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, new AddCommand(expectedItem));

        // multiple units - last unit accepted
        assertParseSuccess(parser,
            PREAMBLE_WHITESPACE + " "
                + VALID_DESC_ITEM_NAME_CUCUMBERS + " "
                + VALID_DESC_ITEM_QUANTITY_CUCUMBERS + " "
                + VALID_DESC_ITEM_UNIT_POTATOES + " "
                + VALID_DESC_ITEM_UNIT_CUCUMBERS + " "
                + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS + " "
                + VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, new AddCommand(expectedItem));

        // multiple bought dates - last bought date accepted
        assertParseSuccess(parser,
            PREAMBLE_WHITESPACE + " "
                + VALID_DESC_ITEM_NAME_CUCUMBERS + " "
                + VALID_DESC_ITEM_QUANTITY_CUCUMBERS + " "
                + VALID_DESC_ITEM_UNIT_CUCUMBERS + " "
                + VALID_DESC_ITEM_BOUGHT_DATE_POTATOES + " "
                + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS + " "
                + VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, new AddCommand(expectedItem));


        // multiple expiry dates - last expiry date accepted
        assertParseSuccess(parser,
            PREAMBLE_WHITESPACE + " "
                + VALID_DESC_ITEM_NAME_CUCUMBERS + " "
                + VALID_DESC_ITEM_QUANTITY_CUCUMBERS + " "
                + VALID_DESC_ITEM_UNIT_CUCUMBERS + " "
                + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS + " "
                + VALID_DESC_ITEM_EXPIRY_DATE_POTATOES + " "
                + VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, new AddCommand(expectedItem));

    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        // zero tags
        Item expectedItem = new ItemBuilder()
            .withItemName(VALID_ITEM_NAME_POTATOES)
            .withItemExpiryDate(VALID_ITEM_EXPIRY_DATE_POTATOES)
            .withItemBoughtDate(VALID_ITEM_BOUGHT_DATE_POTATOES)
            .build();
        assertParseSuccess(parser,
            PREAMBLE_WHITESPACE + " "
                + VALID_DESC_ITEM_NAME_POTATOES + " "
                + VALID_DESC_ITEM_BOUGHT_DATE_POTATOES + " "
                + VALID_DESC_ITEM_EXPIRY_DATE_POTATOES,
            new AddCommand(expectedItem));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser,
            PREAMBLE_NON_EMPTY + " "
                + VALID_DESC_ITEM_QUANTITY_POTATOES + " "
                + VALID_DESC_ITEM_BOUGHT_DATE_POTATOES,
            expectedMessage);

        // all prefixes missing
        assertParseFailure(parser,
            PREAMBLE_NON_EMPTY + " "
                + VALID_ITEM_NAME_POTATOES,
            expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // TODO: Implement after validation and method to show error messages are done.
        assert true;
        // invalid name
        //assertParseFailure(parser,
        //    PREAMBLE_WHITESPACE + " "
        //        + INVALID_DESC_ITEM_NAME_CUCUMBERS + " "
        //        + VALID_DESC_ITEM_QUANTITY_CUCUMBERS + " "
        //        + VALID_DESC_ITEM_UNIT_CUCUMBERS + " "
        //        + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS + " "
        //        + VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, Name.MESSAGE_CONSTRAINTS);
        //
        //// invalid quantity
        //assertParseFailure(parser,
        //    VALID_DESC_ITEM_NAME_CUCUMBERS
        //        + INVALID_DESC_ITEM_QUANTITY_CUCUMBERS
        //        + VALID_DESC_ITEM_UNIT_CUCUMBERS
        //        + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS
        //        + VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, Name.MESSAGE_CONSTRAINTS);
        //
        //// invalid unit
        //assertParseFailure(parser,
        //    VALID_DESC_ITEM_NAME_CUCUMBERS
        //        + VALID_DESC_ITEM_QUANTITY_CUCUMBERS
        //        + INVALID_DESC_ITEM_UNIT_CUCUMBERS
        //        + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS
        //        + VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, Name.MESSAGE_CONSTRAINTS);
        //
        //// invalid bought date
        //assertParseFailure(parser,
        //    VALID_DESC_ITEM_NAME_CUCUMBERS
        //        + VALID_DESC_ITEM_QUANTITY_CUCUMBERS
        //        + VALID_DESC_ITEM_UNIT_CUCUMBERS
        //        + INVALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS
        //        + VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, Name.MESSAGE_CONSTRAINTS);
        //
        //// invalid expiry date
        //assertParseFailure(parser,
        //    VALID_DESC_ITEM_NAME_CUCUMBERS
        //        + VALID_DESC_ITEM_QUANTITY_CUCUMBERS
        //        + VALID_DESC_ITEM_UNIT_CUCUMBERS
        //        + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS
        //        + INVALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, Name.MESSAGE_CONSTRAINTS);
        //
        //// two invalid values, only first invalid value reported
        //assertParseFailure(parser,
        //    INVALID_DESC_ITEM_NAME_CUCUMBERS
        //        + VALID_DESC_ITEM_QUANTITY_CUCUMBERS
        //        + VALID_DESC_ITEM_UNIT_CUCUMBERS
        //        + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS
        //        + INVALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS, Name.MESSAGE_CONSTRAINTS);
        //
        //// non-empty preamble
        //assertParseFailure(parser,
        //    PREAMBLE_NON_EMPTY
        //        + VALID_DESC_ITEM_NAME_CUCUMBERS
        //        + VALID_DESC_ITEM_QUANTITY_CUCUMBERS
        //        + VALID_DESC_ITEM_UNIT_CUCUMBERS
        //        + VALID_DESC_ITEM_BOUGHT_DATE_CUCUMBERS
        //        + VALID_DESC_ITEM_EXPIRY_DATE_CUCUMBERS,
        //    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }
}
