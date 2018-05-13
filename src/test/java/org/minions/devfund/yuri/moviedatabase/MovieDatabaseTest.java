package org.minions.devfund.yuri.moviedatabase;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Verifies all the functionality of Movie data base.
 */
public class MovieDatabaseTest {
  private static final int FIRST_MOVIE_INDEX = 0;
  private static final double DELTA = 0;

  /**
   * New Movie Database object has empty actors and movies lists.
   */
  @Test
  public void testNewMovieDatabaseHasEmptyActorsAndMoviesLists() {
    final MovieDatabase movieDatabase = new MovieDatabase();
    assertTrue(movieDatabase.getMovieList().isEmpty());
    assertTrue(movieDatabase.getActorList().isEmpty());
  }

  /**
   * Add new movie object to database.
   */
  @Test
  public void testAddMovieToDatabase() {
    final MovieDatabase movieDatabase = new MovieDatabase();
    final String movieTitle = "Interstellar";
    final String[] actors = new String[] {"Anne Hathaway", "Matthew McConaughey"};
    final int expectedMovieListSize = 1;
    final int expectedActorsListSize = 2;
    movieDatabase.addMovie(movieTitle, actors);
    assertEquals(expectedMovieListSize, movieDatabase.getMovieList().size());
    assertEquals(expectedActorsListSize, movieDatabase.getActorList().size());
  }

  /**
   * Add duplicated movie object to database.
   */
  @Test
  public void testAddDuplicatedMovieToDatabase() {
    final MovieDatabase movieDatabase = new MovieDatabase();
    final String movieTitle = "Blade Runner 2049";
    final String[] actors = new String[] {"Ryan Gosling", "Harrison Ford"};
    final int expectedMovieListSize = 1;
    final int expectedActorsListSize = 2;
    movieDatabase.addMovie(movieTitle, actors);
    movieDatabase.addMovie(movieTitle, actors);
    assertEquals(expectedMovieListSize, movieDatabase.getMovieList().size());
    assertEquals(expectedActorsListSize, movieDatabase.getActorList().size());
  }

  /**
   * Add duplicated movie object to database.
   */
  @Test
  public void testAddMovieWithExistentActorToDatabase() {
    final MovieDatabase movieDatabase = new MovieDatabase();
    final String movieOneTitle = "Avengers";
    final String[] movieOneActors = new String[] {"Steve Rogers", "Tony Stark"};
    final String movieTwoTitle = "Avenengers Infinity War";
    final String[] movieTwoActors = new String[] {"Hulk", "Tony Stark"};
    final int expectedMovieListSize = 2;
    final int expectedActorsListSize = 3;
    movieDatabase.addMovie(movieOneTitle, movieOneActors);
    movieDatabase.addMovie(movieTwoTitle, movieTwoActors);
    assertEquals(expectedMovieListSize, movieDatabase.getMovieList().size());
    assertEquals(expectedActorsListSize, movieDatabase.getActorList().size());
  }

  /**
   * Add new movie rating to existing movie object in database.
   */
  @Test
  public void testAddMovieRatingToDatabase() {
    final MovieDatabase movieDatabase = new MovieDatabase();
    final String movieTitle = "Bohemian Rhapsody";
    final String[] actors = new String[] {"Rami Malek", "Ben Hardy"};
    final int newMovieRating = 10;
    movieDatabase.addMovie(movieTitle, actors);
    movieDatabase.addRating(movieTitle, newMovieRating);
    assertEquals(newMovieRating, movieDatabase.getMovieList().get(FIRST_MOVIE_INDEX).getRating(), DELTA);
  }

  /**
   * Get best actor from movie database.
   */
  @Test
  public void testGetBestActorFromDatabase() {
    final MovieDatabase movieDatabase = new MovieDatabase();
    final String movieOneTitle = "Ghost in the Shell";
    final String[] movieOneActors = new String[] {"Scarlett Johansson"};
    final int movieOneRating = 10;
    final String movieTwoTitle = "Zoolander";
    final String[] movieTwoActors = new String[] {"Christian Slater"};
    final int movieTwoRating = 7;
    final String expectedBestActor = "Scarlett Johansson";
    movieDatabase.addMovie(movieOneTitle, movieOneActors);
    movieDatabase.addMovie(movieTwoTitle, movieTwoActors);
    movieDatabase.addRating(movieOneTitle, movieOneRating);
    movieDatabase.addRating(movieTwoTitle, movieTwoRating);
    assertEquals(expectedBestActor, movieDatabase.getBestActor());
  }

  /**
   * Get best movie from movie database.
   */
  @Test
  public void testGetBestMovieFromDatabase() {
    final MovieDatabase movieDatabase = new MovieDatabase();
    final String movieOneTitle = "Star Wars: The Force Awakens";
    final String[] movieOneActors = new String[] {"Daisy Ridley", "Mark Hamill"};
    final int movieOneRating = 10;
    final String movieTwoTitle = "Star Trek 2009";
    final String[] movieTwoActors = new String[] {"Leonard Nimoy", "Chris Pine"};
    final int movieTwoRating = 7;
    final String expectedBestMovie = "Star Wars: The Force Awakens";
    movieDatabase.addMovie(movieOneTitle, movieOneActors);
    movieDatabase.addMovie(movieTwoTitle, movieTwoActors);
    movieDatabase.updateRating(movieOneTitle, movieOneRating);
    movieDatabase.updateRating(movieTwoTitle, movieTwoRating);
    assertEquals(expectedBestMovie, movieDatabase.getBestMovie());
  }
}
