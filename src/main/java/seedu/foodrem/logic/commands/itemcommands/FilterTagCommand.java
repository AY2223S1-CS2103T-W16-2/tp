package seedu.foodrem.logic.commands.itemcommands;

import static seedu.foodrem.commons.enums.CommandType.FILTER_TAG_COMMAND;

import seedu.foodrem.model.tag.Tag;

/**
 * Filters all items in FoodRem for items that contain the specified tag
 */
public class FilterTagCommand extends FilterCommand {
    private final Tag tag;

    /**
     * @param tag to filter the Item list for Items tagged with it
     */
    public FilterTagCommand(Tag tag) {
        super(item -> item.containsTag(tag));
        this.tag = tag;
    }

    public static String getUsage() {
        return FILTER_TAG_COMMAND.getUsage();
    }

    @Override
    protected String getSuccessMessage() {
        return String.format("Filtered by tag: %s\n%s", this.tag.getName(), super.getSuccessMessage());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FilterTagCommand // instanceof handles nulls
                && this.tag.equals(((FilterTagCommand) other).tag));
    }
}
