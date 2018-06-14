package org.minions.devfund.sergio.movie_databaseTest;

import org.junit.Before;
import org.junit.Test;
import org.minions.devfund.sergio.movie_database.Actor;
import org.minions.devfund.sergio.movie_database.Movie;
import org.minions.devfund.sergio.movie_database.MovieDatabase;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieDatabaseTest {
    private MovieDatabase mdb_1;
    private MovieDatabase mdb_2;
    private MovieDatabase mdb_3;

    private Movie movie_1;
    private Movie movie_2;
    private Movie movie_3;

    private ArrayList<Movie> movieList_1;
    private ArrayList<Movie> movieList_2;
    private ArrayList<Movie> movieList_3;

    private Actor actor_1;
    private Actor actor_2;
    private Actor actor_3;

    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;



    @Before
    public void setUpMovieDatabases() {
        mdb_1 = new MovieDatabase();
        mdb_2 = new MovieDatabase();
        mdb_3 = new MovieDatabase();

        movie_1 = new Movie("movie_1");
        movie_2 = new Movie("movie_2");
        movie_3 = new Movie("movie_3");

        movieList_1 = new ArrayList<>();
        movieList_1.add(movie_1);
        movieList_2 = new ArrayList<>();
        movieList_2.add(movie_2);
        movieList_3 = new ArrayList<>();
        movieList_3.add(movie_3);

        actor_1 = new Actor("actor_1", movieList_1);
        actor_2 = new Actor("actor_2", movieList_2);
        actor_3 = new Actor("actor_3", movieList_3);

        movie_1.addActor(actor_1);
        movie_2.addActor(actor_2);
        movie_3.addActor(actor_3);

        movieList = new ArrayList<>();
        actorList = new ArrayList<>();

    }

    @Test
    public void testConstructor() {
        assertEquals(movieList, mdb_1.getMovieList());
        assertEquals(actorList, mdb_2.getActorList());
    }

    @Test
    public void testAddMovie() {
        String [] actors_1;
        actors_1 = new String[] {"actor_1", "actor_2"};
        mdb_3.addMovie("movie_1", actors_1);
        movie_1.addActor(actor_2);
        actor_2.addMovie(movie_2);
        movieList.add(movie_1);
        actorList.add(actor_1);
        actorList.add(actor_2);

        assertTrue(movieList.equals(mdb_3.getMovieList()));

        String[] actors_2;
        actors_2 = new String[] {"actor_1","actor_2","actor_3"};
        ArrayList<Actor> newActorList;
        newActorList = new ArrayList<>(actorList);
        newActorList.add(actor_3);
        movieList.add(movie_2);

        mdb_3.addMovie("movie_2", actors_2);
        assertTrue(movieList.equals(mdb_3.getMovieList()));
        assertTrue(newActorList.equals(mdb_3.getActorList()));

        String[] newActors_2 = actors_2.clone();
        assertArrayEquals(newActors_2, actors_2);
        assertFalse(newActors_2 == actors_2);
        mdb_3.addMovie("movie_2", newActors_2);
        assertTrue(movieList.equals(mdb_3.getMovieList()));
        assertTrue(newActorList.equals(mdb_3.getActorList()));
    }

    @Test
    public void testAddUpdateRating() {
        String[] actors = new String[] {"actor_1", "actor_2"};
        mdb_2.addMovie("movie_2", actors);
        mdb_2.addRating("movie_2", 7.8);
        assertEquals(7.8, mdb_2.getMovieList().get(0).getRating(), 0);
        mdb_2.updateRating("movie_2", 8.8);
        assertEquals(8.8, mdb_2.getMovieList().get(0).getRating(), 0);
    }
}
