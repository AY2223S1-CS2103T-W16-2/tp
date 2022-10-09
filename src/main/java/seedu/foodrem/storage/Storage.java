package seedu.foodrem.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.foodrem.commons.exceptions.DataConversionException;
import seedu.foodrem.model.ReadOnlyFoodRem;
import seedu.foodrem.model.ReadOnlyUserPrefs;
import seedu.foodrem.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends AddressBookStorage, UserPrefsStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getAddressBookFilePath();

    @Override
    Optional<ReadOnlyFoodRem> readAddressBook() throws DataConversionException, IOException;

    @Override
    void saveAddressBook(ReadOnlyFoodRem addressBook) throws IOException;

}
