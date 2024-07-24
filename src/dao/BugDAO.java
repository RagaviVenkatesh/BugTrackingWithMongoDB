package dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.Bug;

public class BugDAO {
	private final MongoCollection<Document> collection;

    public BugDAO(MongoDatabase database) {
        this.collection = database.getCollection("bugs");
    }

    public void addBug(Bug bug) {
        Document doc = new Document("description", bug.getDescription())
                .append("categoryId", bug.getCategoryId())
                .append("assignedTo", bug.getAssignedTo())
                .append("status", bug.getStatus())
                .append("createdDate", bug.getCreatedDate())
                .append("resolvedDate", bug.getResolvedDate());
        collection.insertOne(doc);
    }

    public List<Bug> getAllBugs() {
        List<Bug> bugs = new ArrayList<>();
        for (Document doc : collection.find()) {
            Bug bug = new Bug(doc.getObjectId("_id"),
                              doc.getString("description"),
                              doc.getObjectId("categoryId"),
                              doc.getObjectId("assignedTo"),
                              doc.getString("status"),
                              doc.getDate("createdDate"),
                              doc.getDate("resolvedDate"));
            bugs.add(bug);
        }
        return bugs;
    }
    
    public void updateBug(Bug bug) {
        Document doc = new Document("description", bug.getDescription())
                .append("categoryId", bug.getCategoryId())
                .append("assignedTo", bug.getAssignedTo())
                .append("status", bug.getStatus())
                .append("createdDate", bug.getCreatedDate())
                .append("resolvedDate", bug.getResolvedDate());
        collection.updateOne(new Document("_id", bug.getId()), new Document("$set", doc));
    }

    public void deleteBug(ObjectId id) {
        collection.deleteOne(new Document("_id", id));
    }
}
