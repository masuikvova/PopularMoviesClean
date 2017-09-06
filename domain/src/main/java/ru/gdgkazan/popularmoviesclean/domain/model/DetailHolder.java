package ru.gdgkazan.popularmoviesclean.domain.model;

import java.util.List;



public class DetailHolder {
    private List<Video> videos;
    private List<Review> reviews;

    public DetailHolder(List<Video> videos, List<Review> reviews) {
        this.videos = videos;
        this.reviews = reviews;
    }

    public DetailHolder() {
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
