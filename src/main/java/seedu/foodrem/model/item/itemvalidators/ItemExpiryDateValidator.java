package seedu.foodrem.model.item.itemvalidators;

import static seedu.foodrem.commons.util.AppUtil.checkArgument;
import static seedu.foodrem.model.item.ItemExpiryDate.EXPIRY_DATE_FORMATTER;
import static seedu.foodrem.model.item.ItemExpiryDate.EXPIRY_DATE_PATTERN_REGEX;

import java.time.LocalDate;

import seedu.foodrem.model.item.Item;
import seedu.foodrem.model.item.ItemExpiryDate;
import seedu.foodrem.model.util.DateParser;

/**
 * Validation class for item dates.
 */
public class ItemExpiryDateValidator implements Validator {

    // Validation for parsing
    public static final String MESSAGE_FOR_UNABLE_TO_PARSE_EXPIRY_DATE =
            String.format("The item expiry date must follow the format %s.", EXPIRY_DATE_PATTERN_REGEX);

    // Validation for year
    private static final int MIN_YEAR = 1900;
    public static final String MESSAGE_FOR_YEAR_TOO_SMALL =
            String.format("The year for item expiry date should be larger than %d.", MIN_YEAR);

    private static final int MAX_YEAR = 2300;
    public static final String MESSAGE_FOR_YEAR_TOO_LARGE =
            String.format("The year for item expiry date should be less than %d.", MAX_YEAR);

    /**
     * Validates a given input String.
     *
     * @param dateString String representation of date to validate against.
     */
    public static Void validate(String dateString) {
        checkArgument(isParsableItemExpiryDate(dateString), MESSAGE_FOR_UNABLE_TO_PARSE_EXPIRY_DATE);
        LocalDate date = LocalDate.parse(dateString, EXPIRY_DATE_FORMATTER);
        checkArgument(isYearLessThanEqualToMaxYear(date), MESSAGE_FOR_YEAR_TOO_LARGE);
        checkArgument(isYearMoreThanEqualToMinYear(date), MESSAGE_FOR_YEAR_TOO_SMALL);
        return null;
    }

    /**
     * Returns true if an item date is parsable, false otherwise.
     *
     * @param dateTimeString a string that represents the itemDate of the format
     *                       {@link ItemExpiryDate#EXPIRY_DATE_FORMATTER}
     */
    private static boolean isParsableItemExpiryDate(String dateTimeString) {
        DateParser validator = new DateParser(EXPIRY_DATE_FORMATTER);
        return validator.isParsableDateString(dateTimeString);
    }

    /**
     * Returns true if an item date has a year more than {@link ItemExpiryDateValidator#MIN_YEAR}, false otherwise.
     *
     * @param date a local date that represents the date of the {@link Item}.
     */
    private static boolean isYearMoreThanEqualToMinYear(LocalDate date) {
        return date.getYear() >= MIN_YEAR;
    }

    /**
     * Returns true if an item date has a year less than {@link ItemExpiryDateValidator#MAX_YEAR}, false otherwise.
     *
     * @param date a LocalDate that represents the date of the {@link Item}.
     */
    private static boolean isYearLessThanEqualToMaxYear(LocalDate date) {
        return date.getYear() <= MAX_YEAR;
    }
}