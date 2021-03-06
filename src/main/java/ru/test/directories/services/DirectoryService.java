package ru.test.directories.services;

import ru.test.directories.models.Entry;
import ru.test.directories.models.dto.DirectoryDTO;

import java.util.List;

public interface DirectoryService {
    void addDirectory(String directoryPath);

    boolean isValidPathAndItsExistsAndItsDirectory(String path);

    List<DirectoryDTO> getDirectoriesList();

    List<Entry> getFilesForDirectory(String dirId);

    DirectoryDTO getDirectoryDTO(String dirId);
}
