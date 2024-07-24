package dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.Developer;

public class DeveloperDAO {
	private final MongoCollection<Document> collection;

    public DeveloperDAO(MongoDatabase database) {
        this.collection = database.getCollection("developers");
    }

    public void addDeveloper(Developer developer) {
        Document doc = new Document("name", developer.getName())
                .append("email", developer.getEmail());
        collection.insertOne(doc);
    }

    public List<Developer> getAllDevelopers() {
        List<Developer> developers = new ArrayList<>();
        for (Document doc : collection.find()) {
            Developer developer = new Developer(doc.getObjectId("_id"), doc.getString("name"), doc.getString("email"));
            developers.add(developer);
        }
        return developers;
    }

    public void updateDeveloper(Developer developer) {
        Document doc = new Document("name", developer.getName())
                .append("email", developer.getEmail());
        collection.updateOne(new Document("_id", developer.getId()), new Document("$set", doc));
    }

    public void deleteDeveloper(ObjectId id) {
        collection.deleteOne(new Document("_id", id));
    }
}
