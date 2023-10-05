package nvb.dev.base.service.impl;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import nvb.dev.base.entity.BaseEntity;
import nvb.dev.base.repository.BaseRepository;
import nvb.dev.base.service.BaseService;
import org.hibernate.TransactionException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BaseServiceImpl<ID extends Serializable, Entity extends BaseEntity<ID>,
        Repository extends BaseRepository<ID, Entity>> implements BaseService<ID, Entity> {

    protected final EntityManager entityManager;
    protected final Repository repository;

    @Override
    public void save(Entity entity) {
        try {
            entityManager.getTransaction().begin();
            repository.save(entity);
            entityManager.getTransaction().commit();
        } catch (TransactionException e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Entity entity) {
        try {
            entityManager.getTransaction().begin();
            repository.update(entity);
            entityManager.getTransaction().commit();
        } catch (TransactionException e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void remove(Entity entity) {
        try {
            entityManager.getTransaction().begin();
            repository.remove(entity);
            entityManager.getTransaction().commit();
        } catch (TransactionException e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Optional<Entity> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<Entity> findAll() {
        entityManager.getTransaction().begin();
        List<Entity> entities = repository.findAll();
        entityManager.getTransaction().commit();
        return entities;
    }
}
