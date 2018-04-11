package ru.test.directories.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.test.directories.other.SizeFormatUtil;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Directory {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String path;

    @CreatedDate
    private Date createdDate = new Date();

    @OneToMany
    private List<Entry> nested;

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

    public List<Entry> getNested() {
        return nested;
    }

    public void setNested(List<Entry> nested) {
        this.nested = nested;
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

    public Directory() {
    }

    public Directory(String path) {
        this.path = path;
    }

    public String getSummarySizeReadable()
    {
        return SizeFormatUtil.getSizeReadable(summarySize);
    }
}
