package seedu.foodrem.testutil;

import static seedu.foodrem.logic.parser.CliSyntax.PREFIX_NAME;

import seedu.foodrem.logic.commands.tagcommands.NewTagCommand;
import seedu.foodrem.model.tag.Tag;

/**
 * A utility class for Tag.
 */
public class TagUtil {
    /**
     * Returns an add command string for adding the {@code tag}.
     */
    public static String getNewTagCommand(Tag tag) {
        return NewTagCommand.COMMAND_WORD + " " + getTagDetails(tag);
    }

    /**
     * Returns the part of command string for the given {@code tag}'s details.
     */
    public static String getTagDetails(Tag tag) {
        return String.format("%s%s",
                PREFIX_NAME,
                tag.getName());
    }
}
