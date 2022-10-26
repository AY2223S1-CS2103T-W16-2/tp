package seedu.foodrem.logic.commands.tagcommands;

import static java.util.Objects.requireNonNull;
import static seedu.foodrem.commons.enums.CommandType.UNTAG_COMMAND;

import java.util.Set;

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
        Set<Tag> itemTags = itemToUntag.getTagSet();
        if (!itemTags.contains(tag)) {
            throw new CommandException(ERROR_ITEM_DOES_NOT_CONTAIN_TAG);
        }
        itemTags.remove(tag);
        Item newTagSetItem = Item.createItemWithTags(itemToUntag, itemTags);
        model.setItem(itemToUntag, newTagSetItem);
        model.updateFilteredItemList(Model.PREDICATE_SHOW_ALL_ITEMS);

        return CommandResult.from(
                new ItemWithMessage(newTagSetItem, "Item untagged successfully. View updated item below:"));
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
