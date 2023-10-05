package nvb.dev.service.impl;

import jakarta.persistence.EntityManager;
import nvb.dev.base.service.impl.BaseServiceImpl;
import nvb.dev.entity.Director;
import nvb.dev.entity.Film;
import nvb.dev.repository.FilmRepository;
import nvb.dev.service.FilmService;

import java.util.List;

public class FilmServiceImpl extends BaseServiceImpl<Long, Film, FilmRepository>
        implements FilmService {

    protected final EntityManager entityManager;

    public FilmServiceImpl(EntityManager entityManager, FilmRepository repository) {
        super(entityManager, repository);
        this.entityManager = entityManager;
    }

    @Override
    public Film addFilm(Film film) {
        entityManager.getTransaction().begin();
        repository.save(film);
        entityManager.getTransaction().commit();
        return film;
    }

    @Override
    public List<Film> getFilmsProducedByDirector(Director director) {
        return repository.getFilmsProducedByDirector(director);
    }

    @Override
    public Director getDirector(Film film) {
        return repository.getDirector(film);
    }
}
