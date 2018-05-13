package org.minions.devfund.yuri.moviedatabase;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Verifies all functionality of Movie class.
 */
public class MovieTest {
  /**
   * New movie object with not defined name test.
   */
  @Test
  public void testNewMovieWithEmptyName() {
    final Movie movie = new Movie();
    final String expectedMovieName = "";
    assertEquals(expectedMovieName, movie.getName());
  }

  /**
   * New movie object with custom name test.
   */
  @Test
  public void testNewMovieWithCustomName() {
    final Movie movie = new Movie("Interstellar");
    final String expectedMovieName = "Interstellar";
    assertEquals(expectedMovieName, movie.getName());
  }

  /**
   * Set movie object name with custom value test.
   */
  @Test
  public void testSetMovieName() {
    final Movie movie = new Movie("Batman");
    final String newMovieName = "Batman Returns";
    movie.setName(newMovieName);
    assertEquals(newMovieName, movie.getName());
  }

  /**
   * Set movie object rating with custom value test.
   */
  @Test
  public void testSetMovieRating() {
    final Movie movie = new Movie("Blade Runner 2049");
    final double newMovieRating = 10;
    final double delta = 0;
    movie.setRating(newMovieRating);
    assertEquals(newMovieRating, movie.getRating(), delta);
  }

  /**
   * Set movie object actors list test.
   */
  @Test
  public void testSetActorsMovies() {
    final Movie movie = new Movie("Bohemian Rhapsody");
    final ArrayList<Actor> newActors = new ArrayList<>();
    newActors.add(new Actor("Aidan Gillen"));
    newActors.add(new Actor("Rami Malek"));
    movie.setActors(newActors);
    assertEquals(newActors, movie.getActors());
  }
}
