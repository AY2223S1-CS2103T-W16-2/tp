package seedu.foodrem.views;

import static java.util.Objects.requireNonNull;

import seedu.foodrem.model.item.Item;
import seedu.foodrem.ui.ResultDisplay;
import seedu.foodrem.viewmodels.item.ItemWithMessage;
import seedu.foodrem.viewmodels.tag.TagToRename;
import seedu.foodrem.viewmodels.tag.TagsWithMessage;
import seedu.foodrem.views.item.ItemView;
import seedu.foodrem.views.item.ItemWithMessageView;
import seedu.foodrem.views.tag.TagToRenameView;
import seedu.foodrem.views.tag.TagsWithMessageView;

/**
 * A UI view manager to handle view updates to a result display.
 * @author Richard Dominick
 */
public class UiView {
    private final ResultDisplay display;

    /**
     * Creates a UI view manager linked to the given display box.
     * @param display the display box to show the views at.
     */
    public UiView(ResultDisplay display) {
        this.display = display;
    }

    // TODO: Use a less hacky method

    /**
     * Updates the display with the view generated from the given object.
     * @param object the object to generate the view for.
     */
    public void viewFrom(Object object) {
        requireNonNull(object);
        display.clear();
        if (object instanceof String) {
            display.place(StringView.from((String) object));
            return;
        }
        if (object instanceof Item) {
            display.place(ItemView.from((Item) object));
            return;
        }
        if (object instanceof ItemWithMessage) {
            display.place(ItemWithMessageView.from((ItemWithMessage) object));
            return;
        }
        if (object instanceof TagsWithMessage) {
            display.place(TagsWithMessageView.from((TagsWithMessage) object));
            return;
        }
        if (object instanceof TagToRename) {
            display.place(TagToRenameView.from((TagToRename) object));
            return;
        }

        // Code should not reach here unless there is programmer error
        throw new UnsupportedOperationException();
    }
}
