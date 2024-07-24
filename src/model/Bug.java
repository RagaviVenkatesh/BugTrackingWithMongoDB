package model;

import java.util.Date;

import org.bson.types.ObjectId;

public class Bug {
	private ObjectId id;
    private String description;
    private ObjectId categoryId;
    private ObjectId assignedTo;
    private String status;
    private Date createdDate;
    private Date resolvedDate;

    public Bug() {}

    public Bug(ObjectId id, String description, ObjectId categoryId, ObjectId assignedTo, String status, Date createdDate, Date resolvedDate) {
        this.id = id;
        this.description = description;
        this.categoryId = categoryId;
        this.assignedTo = assignedTo;
        this.status = status;
        this.createdDate = createdDate;
        this.resolvedDate = resolvedDate;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ObjectId getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(ObjectId categoryId) {
        this.categoryId = categoryId;
    }

    public ObjectId getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(ObjectId assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }
}
