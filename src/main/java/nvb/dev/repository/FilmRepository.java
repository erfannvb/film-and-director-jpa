package nvb.dev.repository;

import nvb.dev.base.repository.BaseRepository;
import nvb.dev.entity.Director;
import nvb.dev.entity.Film;

import java.util.List;

public interface FilmRepository extends BaseRepository<Long, Film> {

    List<Film> getFilmsProducedByDirector(Director director);

    Director getDirector(Film film);

}
