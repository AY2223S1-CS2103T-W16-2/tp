package seedu.foodrem.logic.commands.itemcommands;

import static java.util.Objects.requireNonNull;
import static seedu.foodrem.commons.enums.CommandType.SORT_COMMAND;

import java.util.Comparator;

import seedu.foodrem.commons.core.Messages;
import seedu.foodrem.logic.commands.Command;
import seedu.foodrem.logic.commands.CommandResult;
import seedu.foodrem.model.Model;
import seedu.foodrem.model.item.Item;

/**
 * Sorts a list of all items in FoodRem depending on the
 * provided comparator. The comparator is specified by the
 * Sort Command, and supports the following sorting criteria:
 * - Name
 * - Quantity
 * - Unit
 * - Bought Date
 * - Expiry Date
 * - Price
 * - Remarks
 */
public class SortCommand extends Command {
    private final Comparator<Item> comparator;

    public SortCommand(Comparator<Item> comparator) {
        this.comparator = comparator;
    }

    public static String getUsage() {
        return SORT_COMMAND.getUsage();
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateSortedItemList(comparator);
        return new CommandResult(String.format(Messages.MESSAGE_ITEMS_SORTED_OVERVIEW,
                model.getCurrentList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SortCommand // instanceof handles nulls
                && comparator.getClass()
                .getSimpleName()
                .equals(((SortCommand) other).comparator.getClass().getSimpleName())); // state check
    }
}
