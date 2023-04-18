package repo;

import model.Order;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class OrderJpaRepository implements OrderRepository {
    private SessionFactory sessionFactory;
    private static Logger log = LogManager.getLogger(OrderJpaRepository.class);

    @Override
    public Order getById(int id) {
        log.info("CALL METHOD getById WITH ID {}", id);
        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        try {
            return entityManager.find(Order.class, id);
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public List<Order> getAll() {
        log.info("CALL METHOD getAll");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            return entityManager.createQuery("SELECT o FROM Order o", Order.class).getResultList();
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public Order add(Order order) {
        log.info("CALL METHOD add WITH {}", order);
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            entityManager.persist(order);
            entityManager.flush();
            return order;
        } finally {
            entityManager.getTransaction().commit();
        }
    }
}