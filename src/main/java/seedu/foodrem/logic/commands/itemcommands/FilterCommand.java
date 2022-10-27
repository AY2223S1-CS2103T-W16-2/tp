package seedu.foodrem.logic.commands.itemcommands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.foodrem.commons.core.Messages;
import seedu.foodrem.logic.commands.Command;
import seedu.foodrem.logic.commands.CommandResult;
import seedu.foodrem.model.Model;
import seedu.foodrem.model.item.Item;
import seedu.foodrem.model.tag.Tag;
import seedu.foodrem.viewmodels.FilterByTag;

/**
 * Represents a filter command for filtering and updating the displayed list of Items
 */
public abstract class FilterCommand extends Command {
    private final Predicate<Item> pred;

    public FilterCommand(Predicate<Item> pred) {
        this.pred = pred;
    }

    @Override
    public CommandResult<FilterByTag> execute(Model model) {
        requireNonNull(model);
        model.updateFilteredItemList(pred);

        String primaryMessage = "Filtered by tag:";
        String secondaryMessage = String.format("%s items filtered", model.getCurrentList().size());
        return CommandResult.from(new FilterByTag(new Tag("Pass tag here"), primaryMessage, secondaryMessage));
    }

    protected String getSuccessMessage() {
        return Messages.MESSAGE_ITEMS_FILTERED_OVERVIEW;
    }
}
