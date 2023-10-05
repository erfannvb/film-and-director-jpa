package nvb.dev.repository.impl;

import jakarta.persistence.EntityManager;
import nvb.dev.base.repository.impl.BaseRepositoryImpl;
import nvb.dev.entity.Director;
import nvb.dev.repository.DirectorRepository;

public class DirectorRepositoryImpl extends BaseRepositoryImpl<Long, Director> implements DirectorRepository {

    protected final EntityManager entityManager;

    public DirectorRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Class<Director> getEntityClass() {
        return Director.class;
    }
}
