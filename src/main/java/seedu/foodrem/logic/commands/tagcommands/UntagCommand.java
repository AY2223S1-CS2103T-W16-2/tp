package seedu.foodrem.logic.commands.tagcommands;

import static java.util.Objects.requireNonNull;
import static seedu.foodrem.commons.enums.CommandType.UNTAG_COMMAND;

import seedu.foodrem.commons.core.index.Index;
import seedu.foodrem.logic.commands.Command;
import seedu.foodrem.logic.commands.CommandResult;
import seedu.foodrem.logic.commands.exceptions.CommandException;
import seedu.foodrem.model.Model;
import seedu.foodrem.model.item.Item;
import seedu.foodrem.model.tag.Tag;
import seedu.foodrem.viewmodels.ItemWithMessage;

/**
 * Untags an item with a Tag.
 */
public class UntagCommand extends Command {
    // TODO: Test this command
    private static final String MESSAGE_SUCCESS = "Item untagged successfully. View updated item below:";
    private static final String ERROR_ITEM_DOES_NOT_CONTAIN_TAG = "This item is not tagged with this tag";

    private final Index index;
    private final Tag tag;

    /**
     * Creates a TagCommand to tag the specified {@code Item} with a specified {@code Tag}
     */
    public UntagCommand(String tagName, Index index) {
        requireNonNull(tagName);
        requireNonNull(index);
        this.index = index;
        this.tag = new Tag(tagName);
    }

    @Override
    public CommandResult<ItemWithMessage> execute(Model model) throws CommandException {
        Item itemToUntag = TagCommand.validateAndGetTargetItem(model, tag, index);
        if (!itemToUntag.containsTag(tag)) {
            throw new CommandException(ERROR_ITEM_DOES_NOT_CONTAIN_TAG);
        }

        Item newTagSetItem = Item.createUntaggedItem(itemToUntag, tag);

        model.setItem(itemToUntag, newTagSetItem);

        return CommandResult.from(new ItemWithMessage(newTagSetItem, MESSAGE_SUCCESS));
    }

    public static String getUsage() {
        return UNTAG_COMMAND.getUsage();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                // instanceof handles nulls
                || (other instanceof UntagCommand
                && index.equals(((UntagCommand) other).index)
                && tag.equals(((UntagCommand) other).tag));
    }
}
