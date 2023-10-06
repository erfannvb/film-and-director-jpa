package nvb.dev.repository.impl;

import jakarta.persistence.EntityManager;
import nvb.dev.base.repository.impl.BaseRepositoryImpl;
import nvb.dev.entity.Director;
import nvb.dev.entity.Film;
import nvb.dev.repository.FilmRepository;

import java.util.List;

public class FilmRepositoryImpl extends BaseRepositoryImpl<Long, Film> implements FilmRepository {

    protected final EntityManager entityManager;

    public FilmRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Class<Film> getEntityClass() {
        return Film.class;
    }

    @Override
    public List<Film> getFilmsProducedByDirector(Director director) {
        return entityManager
                .createQuery("SELECT film FROM Film film WHERE film.director=:director", Film.class)
                .setParameter("director", director)
                .getResultList();
    }

    @Override
    public Director getDirector(Film film) {
        return entityManager
                .createQuery("SELECT director FROM Director director WHERE director=:director",
                        Director.class)
                .setParameter("director", film.getDirector())
                .getSingleResult();
    }
}
