package dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.Category;

public class CategoryDAO {
	private final MongoCollection<Document> collection;

    public CategoryDAO(MongoDatabase database) {
        this.collection = database.getCollection("categories");
    }

    public void addCategory(Category category) {
        Document doc = new Document("categoryName", category.getCategoryName());
        collection.insertOne(doc);
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        for (Document doc : collection.find()) {
            Category category = new Category(doc.getObjectId("_id"), doc.getString("categoryName"));
            categories.add(category);
        }
        return categories;
    }

    public void updateCategory(Category category) {
        Document doc = new Document("categoryName", category.getCategoryName());
        collection.updateOne(new Document("_id", category.getId()), new Document("$set", doc));
    }

    public void deleteCategory(ObjectId id) {
        collection.deleteOne(new Document("_id", id));
    }
}
