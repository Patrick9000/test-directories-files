package ru.test.directories.models;

import org.hibernate.annotations.GenericGenerator;
import ru.test.directories.other.SizeFormatUtil;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Entry {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private boolean directory;

    private long size;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Entry() {
    }

    public Entry(String name, boolean directory, long size) {
        this.name = name;
        this.directory = directory;
        this.size = size;
    }

    public String getSizeReadable()
    {
        return SizeFormatUtil.getSizeReadable(size);
    }
}
