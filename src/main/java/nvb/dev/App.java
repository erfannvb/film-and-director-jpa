package nvb.dev;

import jakarta.persistence.EntityManager;
import nvb.dev.entity.Director;
import nvb.dev.entity.Film;
import nvb.dev.repository.DirectorRepository;
import nvb.dev.repository.FilmRepository;
import nvb.dev.repository.impl.DirectorRepositoryImpl;
import nvb.dev.repository.impl.FilmRepositoryImpl;
import nvb.dev.service.DirectorService;
import nvb.dev.service.FilmService;
import nvb.dev.service.impl.DirectorServiceImpl;
import nvb.dev.service.impl.FilmServiceImpl;
import nvb.dev.util.HibernateUtil;

public class App {
    public static void main(String[] args) {

        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        FilmRepository filmRepository = new FilmRepositoryImpl(entityManager);
        FilmService filmService = new FilmServiceImpl(entityManager, filmRepository);

        DirectorRepository directorRepository = new DirectorRepositoryImpl(entityManager);
        DirectorService directorService = new DirectorServiceImpl(entityManager, directorRepository);

        Director wrongDirector = new Director(null, null);
        directorService.register(wrongDirector);

        Film film = Film.builder()
                .title("xxx")
                .language("German")
                .director(wrongDirector)
                .rate(4.2f)
                .length(2)
                .build();

        filmService.addFilm(film);


    }
}
