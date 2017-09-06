package ru.gdgkazan.popularmoviesclean.domain.usecase;

import java.util.List;

import ru.gdgkazan.popularmoviesclean.domain.MoviesRepository;
import ru.gdgkazan.popularmoviesclean.domain.model.DetailHolder;
import rx.Observable;


public class DetailsUseCase {
    private MoviesRepository mRepository;
    private final Observable.Transformer<List<DetailHolder>, List<DetailHolder>> mAsyncTransformer;

    public DetailsUseCase(MoviesRepository repository,
                          Observable.Transformer<List<DetailHolder>, List<DetailHolder>> asyncTransformer) {
        mRepository = repository;
        mAsyncTransformer = asyncTransformer;
    }

    public Observable<List<DetailHolder>> getDetails(int id) {
        return Observable.combineLatest(mRepository.getVideos(id), mRepository.getReviews(id), DetailHolder::new)
                .toList()
                .compose(mAsyncTransformer);
    }
}
