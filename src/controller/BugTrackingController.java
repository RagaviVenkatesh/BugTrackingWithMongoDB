package controller;

import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.client.MongoDatabase;

import dao.BugDAO;
import dao.CategoryDAO;
import dao.DeveloperDAO;
import model.Bug;
import model.Category;
import model.Developer;
import utility.DBConnection;

public class BugTrackingController {
	private final BugDAO bugDAO;
    private final CategoryDAO categoryDAO;
    private final DeveloperDAO developerDAO;

    public BugTrackingController() {
        MongoDatabase database = DBConnection.getDatabase("BugTrackingSystem");
        this.bugDAO = new BugDAO(database);
        this.categoryDAO = new CategoryDAO(database);
        this.developerDAO = new DeveloperDAO(database);
    }

    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    public void deleteCategory(ObjectId id) {
        categoryDAO.deleteCategory(id);
    }
    
    public void addDeveloper(Developer developer) {
        developerDAO.addDeveloper(developer);
    }

    public List<Developer> getAllDevelopers() {
        return developerDAO.getAllDevelopers();
    }

    public void updateDeveloper(Developer developer) {
        developerDAO.updateDeveloper(developer);
    }

    public void deleteDeveloper(ObjectId id) {
        developerDAO.deleteDeveloper(id);
    }

    public void addBug(Bug bug) {
        bugDAO.addBug(bug);
    }

    public List<Bug> getAllBugs() {
        return bugDAO.getAllBugs();
    }

    public void updateBug(Bug bug) {
        bugDAO.updateBug(bug);
    }
    
    public void deleteBug(ObjectId id) {
        bugDAO.deleteBug(id);
    }
}
