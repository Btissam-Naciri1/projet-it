import com.example.Controller.MODEL.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProjectDAO {

    private final EntityManagerFactory entityManagerFactory;

    public ProjectDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpaweb");
    }

    public void createProject(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(project);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log exception as needed
        } finally {
            entityManager.close();
        }
    }

    public Project getProjectById(Long projectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Project project = null;

        try {
            project = entityManager.find(Project.class, projectId);
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log exception as needed
        } finally {
            entityManager.close();
        }

        return project;
    }

    public void updateProject(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(project);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log exception as needed
        } finally {
            entityManager.close();
        }
    }

    public void deleteProject(Long projectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Project projectToRemove = entityManager.find(Project.class, projectId);
            if (projectToRemove != null) {
                entityManager.remove(projectToRemove);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log exception as needed
        } finally {
            entityManager.close();
        }
    }
}
