package ru.test.directories.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.directories.models.Entry;

@Repository
public interface EntryDAO extends JpaRepository<Entry,String> {
}
