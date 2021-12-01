package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    private Movie first = new Movie(1, "first", "detective", "url1");
    private Movie second = new Movie(2, "second", "documentary", "url2");
    private Movie third = new Movie(3, "third", "thriller", "url3");
    private Movie fourth = new Movie(4, "fourth", "detective", "url4");
    private Movie fifth = new Movie(5, "fifth", "drama", "url5");
    private Movie sixth = new Movie(6, "sixth", "comedy", "url6");
    private Movie seventh = new Movie(7, "seventh", "detective", "url7");
    private Movie eighth = new Movie(8, "eighth", "adventures", "url8");
    private Movie ninth = new Movie(9, "ninth", "blockbuster", "url9");
    private Movie tenth = new Movie(10, "tenth", "fantasy", "url10");
    private Movie eleventh = new Movie(11, "eleventh", "cartoon", "url11");
    private Movie twelfth = new Movie(12, "twelfth", "sci-fi", "url12");

    // менеджер без предустановленного параметра posterLength (default = 10)
    PosterManager manager = new PosterManager();

    @Test
    void shouldShowEmptyPosterIfNoMoviesAdded() {
        Movie[] expected = new Movie[]{};
        Movie[] actual = manager.showPoster();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddOneMovieAndShowItInPoster() {
        manager.addMovieToPoster(first);
        Movie[] expected = new Movie[]{first};
        Movie[] actual = manager.showPoster();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowAddedMoviesInReverseOrder() {
        manager.addMovieToPoster(second);
        manager.addMovieToPoster(third);
        Movie[] expected = new Movie[]{third, second};
        Movie[] actual = manager.showPoster();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotAddSameMoviesToPoster() {
        manager.addMovieToPoster(first);
        manager.addMovieToPoster(first);
        manager.addMovieToPoster(seventh);
        manager.addMovieToPoster(first);
        manager.addMovieToPoster(seventh);
        manager.addMovieToPoster(fifth);
        Movie[] expected = new Movie[]{fifth, seventh, first};
        Movie[] actual = manager.showPoster();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowMoviesInPosterIfItContainsLessThanTen() {
        manager.addMovieToPoster(fourth);
        manager.addMovieToPoster(fifth);
        manager.addMovieToPoster(eighth);
        manager.addMovieToPoster(sixth);
        manager.addMovieToPoster(ninth);
        manager.addMovieToPoster(tenth);
        manager.addMovieToPoster(eleventh);
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, sixth, eighth, fifth, fourth};
        Movie[] actual = manager.showPoster();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowTenMoviesIfPosterContainsMoreThanTen() {
        manager.addMovieToPoster(fourth);
        manager.addMovieToPoster(fifth);
        manager.addMovieToPoster(eighth);
        manager.addMovieToPoster(sixth);
        manager.addMovieToPoster(ninth);
        manager.addMovieToPoster(tenth);
        manager.addMovieToPoster(eleventh);
        manager.addMovieToPoster(twelfth);
        manager.addMovieToPoster(first);
        manager.addMovieToPoster(second);
        manager.addMovieToPoster(seventh);
        Movie[] expected = new Movie[]{seventh, second, first, twelfth, eleventh, tenth, ninth, sixth, eighth, fifth};
        Movie[] actual = manager.showPoster();
        assertArrayEquals(expected, actual);
    }

    // менеджер с предустановленным параметром posterLength < 10 (меньше дефолтного)
    PosterManager manager1 = new PosterManager(5);

    @Test
    void shouldShowAddedMoviesInPosterIfItHasLessThanPredefined() {
        manager1.addMovieToPoster(ninth);
        manager1.addMovieToPoster(tenth);
        manager1.addMovieToPoster(eleventh);
        Movie[] expected = new Movie[]{eleventh, tenth, ninth};
        Movie[] actual = manager1.showPoster();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowPredefinedAmountOfMoviesIfPosterHasMore() {
        manager1.addMovieToPoster(fourth);
        manager1.addMovieToPoster(fifth);
        manager1.addMovieToPoster(eighth);
        manager1.addMovieToPoster(sixth);
        manager1.addMovieToPoster(ninth);
        manager1.addMovieToPoster(tenth);
        manager1.addMovieToPoster(eleventh);
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, sixth, eighth};
        Movie[] actual = manager1.showPoster();
        assertArrayEquals(expected, actual);
    }

    // менеджер с предустановленным параметром posterLength > 10 (больше дефолтного)
    PosterManager manager2 = new PosterManager(11);

    @Test
    void shouldShowAllMoviesInPosterIfItHasLessThanPredefined() {
        manager2.addMovieToPoster(ninth);
        manager2.addMovieToPoster(tenth);
        manager2.addMovieToPoster(eleventh);
        Movie[] expected = new Movie[]{eleventh, tenth, ninth};
        Movie[] actual = manager2.showPoster();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowPredefinedQuantityOfMoviesIfPosterHasMore() {
        manager2.addMovieToPoster(fourth);
        manager2.addMovieToPoster(fifth);
        manager2.addMovieToPoster(eighth);
        manager2.addMovieToPoster(sixth);
        manager2.addMovieToPoster(ninth);
        manager2.addMovieToPoster(tenth);
        manager2.addMovieToPoster(eleventh);
        manager2.addMovieToPoster(first);
        manager2.addMovieToPoster(second);
        manager2.addMovieToPoster(seventh);
        manager2.addMovieToPoster(third);
        manager2.addMovieToPoster(twelfth);
        Movie[] expected = new Movie[]{twelfth, third, seventh, second, first, eleventh, tenth, ninth, sixth, eighth, fifth};
        Movie[] actual = manager2.showPoster();
        assertArrayEquals(expected, actual);
    }
}
