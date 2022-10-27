package seedu.foodrem.logic.commands.statscommands;

import static java.util.Objects.requireNonNull;
import static seedu.foodrem.commons.enums.CommandType.STATS_COMMAND;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import seedu.foodrem.logic.commands.Command;
import seedu.foodrem.logic.commands.CommandResult;
import seedu.foodrem.model.Model;
import seedu.foodrem.model.item.Item;
import seedu.foodrem.model.tag.Tag;
import seedu.foodrem.model.util.SampleDataUtil;
import seedu.foodrem.viewmodels.Stats;

/**
 * Displays FoodRem statistics to the user.
 */
public class StatsCommand extends Command {
    @Override
    public CommandResult<Stats> execute(Model model) {
        requireNonNull(model);
        List<Item> expensiveItems = getTopThreeExpensiveItems();
        List<Tag> commonTags = getTopThreeCommonTags();
        double amountWasted = getAmountWastedFromWastage();
        return CommandResult.from(new Stats(amountWasted, expensiveItems, commonTags));
    }

    public static String getUsage() {
        return STATS_COMMAND.getUsage();
    }

    private List<Item> getTopThreeExpensiveItems() {
        return Arrays.stream(SampleDataUtil.getSampleItems()).limit(3).collect(Collectors.toList());
    }

    private List<Tag> getTopThreeCommonTags() {
        return Arrays.stream(SampleDataUtil.getSampleTags()).limit(3).collect(Collectors.toList());
    }

    private double getAmountWastedFromWastage() {
        return 120;
    }
}