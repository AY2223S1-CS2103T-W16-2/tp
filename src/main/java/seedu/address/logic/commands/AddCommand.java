package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.item.Item;

/**
 * Adds a person to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. ";
    //+ "Parameters: "
    //+ PREFIX_NAME + "NAME "
    //+ PREFIX_PHONE + "PHONE "
    //+ PREFIX_EMAIL + "EMAIL "
    //+ PREFIX_ADDRESS + "ADDRESS "
    //+ "[" + PREFIX_TAG + "TAG]...\n"
    //+ "Example: " + COMMAND_WORD + " "
    //+ PREFIX_NAME + "John Doe "
    //+ PREFIX_PHONE + "98765432 "
    //+ PREFIX_EMAIL + "johnd@example.com "
    //+ PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
    //+ PREFIX_TAG + "friends "
    //+ PREFIX_TAG + "owesMoney";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    private final Item toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddCommand(Item item) {
        requireNonNull(item);
        toAdd = item;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasItem(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addItem(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
