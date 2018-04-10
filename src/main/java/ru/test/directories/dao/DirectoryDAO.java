package ru.test.directories.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.directories.models.Directory;

@Repository
public interface DirectoryDAO extends JpaRepository<Directory,String> {
}
