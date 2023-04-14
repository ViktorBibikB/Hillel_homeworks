import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomEntityManagerFactory {

    private static final String PERSISTENCE_UNIT_NAME = "myPersistenceUnit";
    private static final EntityManagerFactory entityManagerFactory;
    private static List<Class<?>> entityClasses = new ArrayList<>();

    static {
        try {
            Map<String, String> persistenceProperties = new HashMap<>();
            persistenceProperties.put("javax.persistence.jdbc.url", System.getenv("URL"));
            persistenceProperties.put("javax.persistence.jdbc.user", System.getenv("USER"));
            persistenceProperties.put("javax.persistence.jdbc.password", System.getenv("PASSWORD"));
            persistenceProperties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
            persistenceProperties.put("hibernate.show_sql", "true");
            persistenceProperties.put("hibernate.hbm2ddl.auto", "create");

            for (Class<?> c : entityClasses) {
                persistenceProperties.put("javax.persistence.classes", c.getCanonicalName());
            }

            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, persistenceProperties);
        } catch (Throwable ex) {
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void addEntityClass(Class<?> entity) {
        if (entity.isAnnotationPresent(Entity.class)) {
            entityClasses.add(entity);
        }
        else System.out.println(entity.getSimpleName() + " have not anno @Entity");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static List<Class<?>> getEntityClasses() {
        return entityClasses;
    }
}
