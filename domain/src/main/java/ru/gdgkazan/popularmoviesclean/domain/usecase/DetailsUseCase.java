package ru.gdgkazan.popularmoviesclean.domain.usecase;

import ru.gdgkazan.popularmoviesclean.domain.MoviesRepository;
import ru.gdgkazan.popularmoviesclean.domain.model.DetailHolder;
import rx.Observable;


public class DetailsUseCase {
    private MoviesRepository mRepository;
    private final Observable.Transformer<DetailHolder, DetailHolder> mAsyncTransformer;

    public DetailsUseCase(MoviesRepository repository,
                          Observable.Transformer<DetailHolder, DetailHolder> asyncTransformer) {
        mRepository = repository;
        mAsyncTransformer = asyncTransformer;
    }

    public Observable<DetailHolder> getDetails(int id) {
        return Observable.combineLatest(mRepository.getVideos(id), mRepository.getReviews(id), DetailHolder::new)
                .compose(mAsyncTransformer);
    }
}
