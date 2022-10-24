package seedu.foodrem.logic.commands.itemcommands;

import static java.util.Objects.requireNonNull;
import static seedu.foodrem.commons.enums.CommandType.NEW_COMMAND;

import seedu.foodrem.logic.commands.Command;
import seedu.foodrem.logic.commands.CommandResult;
import seedu.foodrem.logic.commands.exceptions.CommandException;
import seedu.foodrem.model.Model;
import seedu.foodrem.model.item.Item;

/**
 * Creates a new an item in FoodRem.
 */
public class NewCommand extends Command {
    public static final String MESSAGE_SUCCESS = "New item added:\n%1$s";
    public static final String MESSAGE_DUPLICATE_ITEM = "This item already exists in FoodRem";

    private final Item newItem;

    /**
     * Creates a NewCommand to add the specified {@code Item}
     */
    public NewCommand(Item item) {
        requireNonNull(item);
        newItem = item;
    }

    @Override
    public CommandResult<String> execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasItem(newItem)) {
            throw new CommandException(MESSAGE_DUPLICATE_ITEM);
        }

        model.addItem(newItem);
        return CommandResult.from(String.format(MESSAGE_SUCCESS, newItem));
    }

    public static String getUsage() {
        return NEW_COMMAND.getUsage();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NewCommand // instanceof handles nulls
                && newItem.equals(((NewCommand) other).newItem));
    }
}
