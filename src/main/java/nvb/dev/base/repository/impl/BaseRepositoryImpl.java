package nvb.dev.base.repository.impl;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import nvb.dev.base.entity.BaseEntity;
import nvb.dev.base.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public abstract class BaseRepositoryImpl<ID extends Serializable, Entity extends BaseEntity<ID>>
        implements BaseRepository<ID, Entity> {

    protected final EntityManager entityManager;

    public abstract Class<Entity> getEntityClass();

    @Override
    public void save(Entity entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Entity entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(Entity entity) {
        entityManager.remove(entity);
    }

    @Override
    public Optional<Entity> findById(ID id) {
        return Optional.ofNullable(entityManager.find(getEntityClass(), id));
    }

    @Override
    public List<Entity> findAll() {
        return entityManager.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass())
                .getResultList();
    }
}
