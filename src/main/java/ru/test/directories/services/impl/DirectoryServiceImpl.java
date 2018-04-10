package ru.test.directories.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.directories.dao.DirectoryDAO;
import ru.test.directories.dao.EntryDAO;
import ru.test.directories.models.Directory;
import ru.test.directories.models.Entry;
import ru.test.directories.models.dto.DirectoryDTO;
import ru.test.directories.other.FilesComparator;
import ru.test.directories.services.DirectoryService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DirectoryServiceImpl implements DirectoryService {

    @Autowired
    private DirectoryDAO directoryDAO;
    @Autowired
    private EntryDAO entryDAO;

    @Override
    public Directory addDirectory(String directoryPath) {
        if (Files.exists(Paths.get(directoryPath))) {
            File folder = new File(directoryPath);
            List<Entry> entryList = new ArrayList<>();
            if (folder.listFiles()!=null&& Objects.requireNonNull(folder.listFiles()).length > 0) {
                for (File file : Objects.requireNonNull(folder.listFiles())) {
                    //if is directory -> no size, else file.length()
                    Entry entry = new Entry(file.getName(), file.isDirectory(), file.isDirectory() ? 0 : file.length());
                    entryDAO.save(entry);
                    entryList.add(entry);
                }
            }
            Directory directory = new Directory(directoryPath);
            int dirs = 0, files = 0;
            long sumSize = 0;
            for (Entry entry : entryList) {
                if (entry.isDirectory()) dirs++;
                else {
                    files++;
                    sumSize += entry.getSize();
                }
            }
            directory.setNestedDirsCount(dirs);
            directory.setNestedFilesCount(files);
            directory.setSummarySize(sumSize);
            directory.setNested(entryList);
            directoryDAO.save(directory);
        }
        return null;
    }

    @Override
    public List<DirectoryDTO> getDirectoriesList() {
        List<Directory> directoryList = directoryDAO.findAll();
        List<DirectoryDTO> dtoList = new ArrayList<>();
        for (Directory directory : directoryList) {
            dtoList.add(new DirectoryDTO(
                    directory.getId(),
                    directory.getPath(),
                    directory.getCreatedDate(),
                    directory.getNestedDirsCount(),
                    directory.getNestedFilesCount(),
                    directory.getSummarySize()));
        }
        return dtoList;
    }

    @Override
    public List<Entry> getFilesForDirectory(String dirId) {
        Directory directory = directoryDAO.findById(dirId).get();
        List<Entry> entries = directory.getNested();
        List<Entry> directories = directory.getNested().stream().filter(e -> e.isDirectory()).collect(Collectors.toList());
        List<Entry> files = directory.getNested().stream().filter(e -> !e.isDirectory()).collect(Collectors.toList());
        Collections.sort(directories, new FilesComparator());
        Collections.sort(files, new FilesComparator());
        directories.addAll(files);
        return directories;
    }
}
