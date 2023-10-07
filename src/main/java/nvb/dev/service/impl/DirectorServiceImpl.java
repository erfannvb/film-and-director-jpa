package nvb.dev.service.impl;

import jakarta.persistence.EntityManager;
import nvb.dev.base.service.impl.BaseServiceImpl;
import nvb.dev.entity.Director;
import nvb.dev.exception.ValidationException;
import nvb.dev.repository.DirectorRepository;
import nvb.dev.service.DirectorService;
import nvb.dev.util.validation.CheckValidation;

public class DirectorServiceImpl extends BaseServiceImpl<Long, Director, DirectorRepository>
        implements DirectorService {

    protected final EntityManager entityManager;

    CheckValidation checkValidation = new CheckValidation();

    public DirectorServiceImpl(EntityManager entityManager, DirectorRepository repository) {
        super(entityManager, repository);
        this.entityManager = entityManager;
    }

    @Override
    public void register(Director director) {
        if (!checkValidation.isValid(director)) throw new ValidationException("Invalid Data!!!");
        repository.save(director);
    }
}
