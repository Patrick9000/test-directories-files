package ru.test.directories.services;

import ru.test.directories.models.Directory;
import ru.test.directories.models.Entry;
import ru.test.directories.models.dto.DirectoryDTO;

import java.util.List;

public interface DirectoryService {
    Directory addDirectory(String directoryPath);

    List<DirectoryDTO> getDirectoriesList();

    List<Entry> getFilesForDirectory(String dirId);
}
