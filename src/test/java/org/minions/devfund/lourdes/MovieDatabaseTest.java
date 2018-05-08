package org.minions.devfund.lourdes;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Implemented tests for {@link MovieDatabase}.
 */
public class MovieDatabaseTest {
    private static final String ACTOR_NAME = "Bruce Willis";
    private static final String MOVIE_NAME_1 = "Sexto sentido";
    private static final String MOVIE_NAME_2 = "Duro de Matar";
    private static final String[] ACTORS_1 = new String[]{ACTOR_NAME, "Haley Joel"};
    private static final String[] ACTORS_2 = new String[]{ACTOR_NAME, "Alam Rickman"};
    private MovieDatabase movieDatabase;

    /**
     * Method that setup all initial values.
     */
    @Before
    public void setup() {
        movieDatabase = new MovieDatabase();
    }

    /**
     * Verify add new movie to the list.
     */
    @Test
    public void testAddMovie() {
        movieDatabase.addMovie(MOVIE_NAME_1, ACTORS_1);
        assertEquals(movieDatabase.getMovieList().get(0).getName(), MOVIE_NAME_1);
    }

    /**
     * Verify add a duplicated movie.
     */
    @Test
    public void testAddExistMovie() {
        final int totalMovie = 1;
        movieDatabase.addMovie(MOVIE_NAME_1, ACTORS_1);
        movieDatabase.addMovie(MOVIE_NAME_1, ACTORS_1);
        assertEquals(movieDatabase.getMovieList().size(), totalMovie);
    }

    /**
     * Verify add a new movie with new actors.
     */
    @Test
    public void testAddMovieNewActors() {
        movieDatabase.addMovie(MOVIE_NAME_1, ACTORS_1);
        assertEquals(ACTORS_1.length, movieDatabase.getActorList().size());
        assertEquals(movieDatabase.getActorList().get(0).getName(), ACTOR_NAME);
        assertEquals(movieDatabase.getActorList().get(1).getName(), ACTORS_1[1]);
    }

    /**
     * Verify add a second movie.
     */
    @Test
    public void testAddMovie2() {
        final int totalMovies = 2;
        movieDatabase.addMovie(MOVIE_NAME_1, ACTORS_1);
        movieDatabase.addMovie(MOVIE_NAME_2, ACTORS_2);
        List<Movie> movieList = movieDatabase.getMovieList();
        assertEquals(movieList.size(), totalMovies);
        assertEquals(movieDatabase.getMovieList().get(0).getName(), MOVIE_NAME_1);
        assertEquals(movieDatabase.getMovieList().get(1).getName(), MOVIE_NAME_2);
    }

    /**
     * Verify Add second movie with existing actors.
     */
    @Test
    public void testAddNewMovieActorExist() {
        final int totalNumberActors = 3;
        movieDatabase.addMovie(MOVIE_NAME_1, ACTORS_1);
        movieDatabase.addMovie(MOVIE_NAME_2, ACTORS_2);
        assertEquals(movieDatabase.getActorList().size(), totalNumberActors);
        assertEquals(movieDatabase.getActorList().get(0).getName(), ACTORS_1[0]);
        assertEquals(movieDatabase.getActorList().get(1).getName(), ACTORS_1[1]);
        assertEquals(movieDatabase.getActorList().get(2).getName(), ACTORS_2[1]);
    }

    /**
     * Verify to add duplicated Actors.
     */
    @Test
    public void testAddMovieDuplicatedActors() {
        movieDatabase.addMovie(MOVIE_NAME_1, ACTORS_1);
        movieDatabase.addMovie(MOVIE_NAME_1, ACTORS_1);
        assertEquals(movieDatabase.getActorList().get(0).getName(), ACTORS_1[0]);
        assertEquals(movieDatabase.getActorList().get(1).getName(), ACTORS_1[1]);
    }

    /**
     * Verify update movie rating.
     */
    @Test
    public void testUpdateRating() {
        final double rating = 23.4;
        final double updaterating = 40.8;
        movieDatabase.addMovie(MOVIE_NAME_1, ACTORS_1);
        movieDatabase.updateRating(MOVIE_NAME_1, rating);
        movieDatabase.updateRating(MOVIE_NAME_1, updaterating);
        assertEquals(movieDatabase.getMovieList().get(0).getRating(), updaterating, 0);
    }

    /**
     * Verify get best actor.
     */
    @Test
    public void testGetBestActor() {
        movieDatabase.addMovie(MOVIE_NAME_1, ACTORS_1);
        movieDatabase.addMovie(MOVIE_NAME_2, ACTORS_2);
        assertEquals(movieDatabase.getBestActor(), ACTOR_NAME);
    }

    /**
     * Verify get the best movie.
     */
    @Test
    public void testGetBestMovie() {
        final double ratingMovie1 = 23.4;
        final double ratingMovie2 = 44.6;
        movieDatabase.addMovie(MOVIE_NAME_1, ACTORS_1);
        movieDatabase.addMovie(MOVIE_NAME_2, ACTORS_2);

        movieDatabase.updateRating(MOVIE_NAME_1, ratingMovie1);
        movieDatabase.updateRating(MOVIE_NAME_2, ratingMovie2);
        assertEquals(movieDatabase.getBestMovie(), MOVIE_NAME_2);
    }
}
