import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.bson.types.ObjectId;

import controller.BugTrackingController;
import model.Bug;
import model.Category;
import model.Developer;

public class Main {

	public static void main(String[] args) {
		BugTrackingController controller = new BugTrackingController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bug Tracking System");
            System.out.println("1. Add Category");
            System.out.println("2. Update Category");
            System.out.println("3. Delete Category");
            System.out.println("4. List All Categories");
            System.out.println("5. Add Developer");
            System.out.println("6. Update Developer");
            System.out.println("7. Delete Developer");
            System.out.println("8. List All Developers");
            System.out.println("9. Add Bug");
            System.out.println("10. Update Bug");
            System.out.println("11. Delete Bug");
            System.out.println("12. List All Bugs");
            System.out.println("13. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter category name: ");
                        String categoryName = scanner.nextLine();
                        controller.addCategory(new Category(null, categoryName));
                        System.out.println("Category added.");
                        break;
                    case 2:
                        System.out.print("Enter category ID to update: ");
                        String updateCategoryId = scanner.nextLine();
                        System.out.print("Enter new category name: ");
                        String newCategoryName = scanner.nextLine();
                        controller.updateCategory(new Category(new ObjectId(updateCategoryId), newCategoryName));
                        System.out.println("Category updated.");
                        break;
                    case 3:
                        System.out.print("Enter category ID to delete: ");
                        String deleteCategoryId = scanner.nextLine();
                        controller.deleteCategory(new ObjectId(deleteCategoryId));
                        System.out.println("Category deleted.");
                        break;
                    case 4:
                        List<Category> categories = controller.getAllCategories();
                        categories.forEach(category -> System.out.println("ID: " + category.getId() + ", Name: " + category.getCategoryName()));
                        break;
                    case 5:
                        System.out.print("Enter developer name: ");
                        String developerName = scanner.nextLine();
                        System.out.print("Enter developer email: ");
                        String developerEmail = scanner.nextLine();
                        controller.addDeveloper(new Developer(null, developerName, developerEmail));
                        System.out.println("Developer added.");
                        break;
                    case 6:
                        System.out.print("Enter developer ID to update: ");
                        String updateDeveloperId = scanner.nextLine();
                        System.out.print("Enter new developer name: ");
                        String newDeveloperName = scanner.nextLine();
                        System.out.print("Enter new developer email: ");
                        String newDeveloperEmail = scanner.nextLine();
                        controller.updateDeveloper(new Developer(new ObjectId(updateDeveloperId), newDeveloperName, newDeveloperEmail));
                        System.out.println("Developer updated.");
                        break;
                    case 7:
                        System.out.print("Enter developer ID to delete: ");
                        String deleteDeveloperId = scanner.nextLine();
                        controller.deleteDeveloper(new ObjectId(deleteDeveloperId));
                        System.out.println("Developer deleted.");
                        break;
                    case 8:
                        List<Developer> developers = controller.getAllDevelopers();
                        developers.forEach(developer -> System.out.println("ID: " + developer.getId() + ", Name: " + developer.getName() + ", Email: " + developer.getEmail()));
                        break;
                    case 9:
                        System.out.print("Enter bug description: ");
                        String bugDescription = scanner.nextLine();
                        System.out.print("Enter category ID: ");
                        String categoryId = scanner.nextLine();
                        System.out.print("Enter assigned developer ID: ");
                        String assignedTo = scanner.nextLine();
                        controller.addBug(new Bug(null, bugDescription, new ObjectId(categoryId), new ObjectId(assignedTo), "Open", new Date(), null));
                        System.out.println("Bug added.");
                        break;
                    case 10:
                        System.out.print("Enter bug ID to update: ");
                        String updateBugId = scanner.nextLine();
                        System.out.print("Enter new bug description: ");
                        String newBugDescription = scanner.nextLine();
                        System.out.print("Enter new category ID: ");
                        String newCategoryId = scanner.nextLine();
                        System.out.print("Enter new assigned developer ID: ");
                        String newAssignedTo = scanner.nextLine();
                        System.out.print("Enter new status: ");
                        String newStatus = scanner.nextLine();
                        System.out.print("Enter new resolved date (yyyy-mm-dd hh:mm:ss) or leave blank if not resolved: ");
                        String resolvedDateStr = scanner.nextLine();
                        Date resolvedDate = resolvedDateStr.isEmpty() ? null : Timestamp.valueOf(resolvedDateStr);
                        controller.updateBug(new Bug(new ObjectId(updateBugId), newBugDescription, new ObjectId(newCategoryId), new ObjectId(newAssignedTo), newStatus, null, resolvedDate));
                        System.out.println("Bug updated.");
                        break;
                    case 11:
                        System.out.print("Enter bug ID to delete: ");
                        String deleteBugId = scanner.nextLine();
                        controller.deleteBug(new ObjectId(deleteBugId));
                        System.out.println("Bug deleted.");
                        break;
                    case 12:
                        List<Bug> bugs = controller.getAllBugs();
                        bugs.forEach(bug -> System.out.println("ID: " + bug.getId() + ", Description: " + bug.getDescription() + ", Category ID: " + bug.getCategoryId() + ", Assigned To: " + bug.getAssignedTo() + ", Status: " + bug.getStatus() + ", Created Date: " + bug.getCreatedDate() + ", Resolved Date: " + bug.getResolvedDate()));
                        break;
                    case 13:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

	}

}
