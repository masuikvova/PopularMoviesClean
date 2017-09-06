package ru.gdgkazan.popularmoviesclean.data.mapper;

import ru.gdgkazan.popularmoviesclean.data.model.content.Review;
import rx.functions.Func1;


public class ReviewMapper implements Func1<Review, ru.gdgkazan.popularmoviesclean.domain.model.Review> {
    @Override
    public ru.gdgkazan.popularmoviesclean.domain.model.Review call(Review review) {
        return new ru.gdgkazan.popularmoviesclean.domain.model.Review(review.getAuthor(),review.getContent());
    }
}
