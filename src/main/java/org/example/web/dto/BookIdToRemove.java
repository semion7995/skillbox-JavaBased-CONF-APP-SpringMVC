package org.example.web.dto;

import javax.validation.constraints.NotEmpty;

public class BookIdToRemove {
    private String id;

    @NotEmpty
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
