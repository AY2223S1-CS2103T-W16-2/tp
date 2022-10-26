package seedu.foodrem.logic.commands.tagcommands;

import static java.util.Objects.requireNonNull;
import static seedu.foodrem.commons.enums.CommandType.NEW_TAG_COMMAND;

import java.util.List;

import seedu.foodrem.logic.commands.Command;
import seedu.foodrem.logic.commands.CommandResult;
import seedu.foodrem.logic.commands.exceptions.CommandException;
import seedu.foodrem.model.Model;
import seedu.foodrem.model.tag.Tag;
import seedu.foodrem.viewmodels.tag.TagsWithMessage;

/**
 * Adds a tag to FoodRem.
 */
public class NewTagCommand extends Command {
    private static final String MESSAGE_SUCCESS = "New tag added:";
    private static final String ERROR_DUPLICATE = "This tag already exists in FoodRem";

    private final Tag toAdd;

    /**
     * Creates an AddTagCommand to add the specified {@code Tag}
     */
    public NewTagCommand(Tag tag) {
        requireNonNull(tag);
        toAdd = tag;
    }

    @Override
    public CommandResult<TagsWithMessage> execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasTag(toAdd)) {
            throw new CommandException(ERROR_DUPLICATE);
        }

        model.addTag(toAdd);
        return CommandResult.from(new TagsWithMessage(List.of(toAdd), MESSAGE_SUCCESS));
    }

    public static String getUsage() {
        return NEW_TAG_COMMAND.getUsage();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                // instanceof handles nulls
                || (other instanceof NewTagCommand
                && toAdd.equals(((NewTagCommand) other).toAdd));
    }
}
