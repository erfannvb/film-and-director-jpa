package nvb.dev.service;

import nvb.dev.base.service.BaseService;
import nvb.dev.entity.Director;
import nvb.dev.entity.Film;

import java.util.List;

public interface FilmService extends BaseService<Long, Film> {

    Film addFilm(Film film);

    List<Film> getFilmsProducedByDirector(Director director);

    Director getDirector(Film film);

}
