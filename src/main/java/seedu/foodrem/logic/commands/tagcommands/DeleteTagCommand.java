package seedu.foodrem.logic.commands.tagcommands;

import static java.util.Objects.requireNonNull;
import static seedu.foodrem.commons.enums.CommandType.DELETE_TAG_COMMAND;

import seedu.foodrem.logic.commands.Command;
import seedu.foodrem.logic.commands.CommandResult;
import seedu.foodrem.logic.commands.exceptions.CommandException;
import seedu.foodrem.model.Model;
import seedu.foodrem.model.tag.Tag;

/**
 * Deletes an existing tag in FoodRem.
 */
public class DeleteTagCommand extends Command {
    private final Tag toDelete;

    /**
     * Creates an DeleteTagCommand to delete the specified {@code Tag}
     */
    public DeleteTagCommand(Tag tagToDelete) {
        requireNonNull(tagToDelete);
        toDelete = tagToDelete;
    }

    @Override
    public CommandResult<String> execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.hasTag(toDelete)) {
            throw new CommandException("This tag does not exist in the FoodRem");
        }

        model.deleteTag(toDelete);
        return CommandResult.from(String.format("Tag deleted: %1$s", toDelete));
    }

    public static String getUsage() {
        return DELETE_TAG_COMMAND.getUsage();
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof DeleteTagCommand
                && toDelete.equals(((DeleteTagCommand) other).toDelete));
    }
}
