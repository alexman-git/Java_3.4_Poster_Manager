package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Movie;

import java.util.ArrayList;
import java.util.Arrays;

@Data

public class PosterManager {
    private Movie[] movies = new Movie[0];
    int posterLength;

    public PosterManager(int posterLength) {
        this.posterLength = posterLength;
    }

    public PosterManager() {
        posterLength = 10;
    }

    public void addMovieToPoster(Movie item) {
        ArrayList<Movie> moviesList = new ArrayList<>(Arrays.asList(movies));
        if (moviesList.contains(item)) {
            return;
        } else {
            int length = movies.length + 1;
            Movie[] tmp = new Movie[length];
            System.arraycopy(movies, 0, tmp, 0, movies.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = item;
            movies = tmp;
        }
    }

    public Movie[] showPoster() {
        int resultLength;
        if (posterLength < movies.length) {
            resultLength = posterLength;
        } else {
            resultLength = movies.length;
        }
        Movie[] poster = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            poster[i] = movies[index];
        }
        return poster;
    }
}
