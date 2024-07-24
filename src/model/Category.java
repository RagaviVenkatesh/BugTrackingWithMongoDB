package model;

import org.bson.types.ObjectId;

public class Category {
	private ObjectId id;
    private String categoryName;

    public Category() {}

    public Category(ObjectId id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
