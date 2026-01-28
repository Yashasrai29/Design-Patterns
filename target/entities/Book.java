package target.entities;

import target.enums.Category;

import java.util.UUID;

public class Book {

    private UUID id;

    private Category category;

    private String name;

    public Book(UUID id, Category category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
