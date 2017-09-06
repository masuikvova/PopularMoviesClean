package ru.gdgkazan.popularmoviesclean.data.repository;

import java.util.List;

import ru.gdgkazan.popularmoviesclean.data.cache.MoviesCacheTransformer;
import ru.gdgkazan.popularmoviesclean.data.cache.ReviewCacheTransformer;
import ru.gdgkazan.popularmoviesclean.data.cache.VideoCacheTransformer;
import ru.gdgkazan.popularmoviesclean.data.mapper.MoviesMapper;
import ru.gdgkazan.popularmoviesclean.data.mapper.ReviewMapper;
import ru.gdgkazan.popularmoviesclean.data.mapper.VideoMapper;
import ru.gdgkazan.popularmoviesclean.data.model.response.MoviesResponse;
import ru.gdgkazan.popularmoviesclean.data.model.response.ReviewsResponse;
import ru.gdgkazan.popularmoviesclean.data.model.response.VideosResponse;
import ru.gdgkazan.popularmoviesclean.data.network.ApiFactory;
import ru.gdgkazan.popularmoviesclean.domain.MoviesRepository;
import ru.gdgkazan.popularmoviesclean.domain.model.Movie;
import ru.gdgkazan.popularmoviesclean.domain.model.Review;
import ru.gdgkazan.popularmoviesclean.domain.model.Video;
import rx.Observable;

/**
 * @author Artur Vasilov
 */
public class MoviesDataRepository implements MoviesRepository {

    @Override
    public Observable<List<Movie>> popularMovies() {
        return ApiFactory.getMoviesService()
                .popularMovies()
                .map(MoviesResponse::getMovies)
                .compose(new MoviesCacheTransformer())
                .flatMap(Observable::from)
                .map(new MoviesMapper())
                .toList();
    }

    @Override
    public Observable<List<Video>> getVideos(int id) {
        return ApiFactory.getMoviesService()
                .getVideos(id)
                .map(VideosResponse::getVideos)
                .compose(new VideoCacheTransformer())
                .flatMap(Observable::from)
                .map(new VideoMapper())
                .toList();
    }

    @Override
    public Observable<List<Review>> getReviews(int id) {
        return ApiFactory.getMoviesService()
                .getReviews(id)
                .map(ReviewsResponse::getReviews)
                .compose(new ReviewCacheTransformer())
                .flatMap(Observable::from)
                .map(new ReviewMapper())
                .toList();
    }
}

