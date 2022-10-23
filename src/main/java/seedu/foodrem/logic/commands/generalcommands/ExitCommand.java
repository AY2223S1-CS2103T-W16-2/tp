package seedu.foodrem.logic.commands.generalcommands;

import static seedu.foodrem.commons.enums.CommandType.EXIT_COMMAND;

import seedu.foodrem.logic.commands.Command;
import seedu.foodrem.logic.commands.CommandResult;
import seedu.foodrem.model.Model;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {
    private static final String MESSAGE_SUCCESS = "Exiting Address Book as requested ...";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult() {
            @Override
            public String getFeedbackToUser() {
                return MESSAGE_SUCCESS;
            }

            @Override
            public boolean shouldExit() {
                return true;
            }
        };
    }

    public static String getUsage() {
        return EXIT_COMMAND.getUsage();
    }
}
