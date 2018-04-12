package ru.test.directories.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Post {

    @NotNull
    @NotEmpty(message = "Path cannot be empty")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}