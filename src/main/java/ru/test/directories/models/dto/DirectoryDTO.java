package ru.test.directories.models.dto;

import ru.test.directories.models.Directory;
import ru.test.directories.other.SizeFormatUtil;

import java.util.Date;

public class DirectoryDTO {

    private String id;

    private String path;

    private Date createdDate;

    private int nestedDirsCount;
    private int nestedFilesCount;

    private long summarySize;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getNestedDirsCount() {
        return nestedDirsCount;
    }

    public void setNestedDirsCount(int nestedDirsCount) {
        this.nestedDirsCount = nestedDirsCount;
    }

    public int getNestedFilesCount() {
        return nestedFilesCount;
    }

    public void setNestedFilesCount(int nestedFilesCount) {
        this.nestedFilesCount = nestedFilesCount;
    }

    public long getSummarySize() {
        return summarySize;
    }

    public void setSummarySize(long summarySize) {
        this.summarySize = summarySize;
    }

    public DirectoryDTO(String id, String path, Date createdDate, int nestedDirsCount, int nestedFilesCount, long summarySize) {
        this.id = id;
        this.path = path;
        this.createdDate = createdDate;
        this.nestedDirsCount = nestedDirsCount;
        this.nestedFilesCount = nestedFilesCount;
        this.summarySize = summarySize;
    }

    public DirectoryDTO(Directory directory)
    {
        this.id = directory.getId();
        this.path = directory.getPath();
        this.createdDate = directory.getCreatedDate();
        this.nestedDirsCount = directory.getNestedDirsCount();
        this.nestedFilesCount = directory.getNestedFilesCount();
        this.summarySize = directory.getSummarySize();
    }

    public String getSummarySizeReadable()
    {
        return SizeFormatUtil.getSizeReadable(summarySize);
    }
}
