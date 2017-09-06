package ru.gdgkazan.popularmoviesclean.domain;

import java.util.List;

import ru.gdgkazan.popularmoviesclean.domain.model.Review;
import ru.gdgkazan.popularmoviesclean.domain.model.Video;
import rx.Observable;

/**
 * @author Artur Vasilov
 */
public interface MoviesRepository {

    Observable<List<ru.gdgkazan.popularmoviesclean.domain.model.Movie>> popularMovies();

    Observable<List<Video>> getVideos(int id);

    Observable<List<Review>> getReviews(int id);

}
