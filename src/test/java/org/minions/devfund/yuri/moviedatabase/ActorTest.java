package org.minions.devfund.yuri.moviedatabase;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Verifies all functionality of actor class.
 */
public class ActorTest {

  /**
   * New actor object with not defined name test.
   */
  @Test
  public void testNewActorWithEmptyName() {
    final Actor actor = new Actor();
    final String expectedActorName = "";
    assertEquals(expectedActorName, actor.getName());
  }

  /**
   * New actor object with custom name test.
   */
  @Test
  public void testNewActorWithCustomName() {
    final Actor actor = new Actor("Russel Crowe");
    final String expectedActorName = "Russel Crowe";
    assertEquals(expectedActorName, actor.getName());
  }

  /**
   * Set actor object name with custom value test.
   */
  @Test
  public void testSetActorsName() {
    final Actor actor = new Actor("Matthew McConaughey");
    final String newActorsName = "Matthew McConaughey Jr.";
    actor.setName(newActorsName);
    assertEquals(newActorsName, actor.getName());
  }

  /**
   * Set actor object movies list test.
   */
  @Test
  public void testSetActorsMovies() {
    final Actor actor = new Actor("Anne Hathaway");
    final List<Movie> newMovies = Arrays.asList(new Movie("Interstellar"), new Movie("Passengers"));
    actor.setMovies(newMovies);
    assertEquals(newMovies, actor.getMovies());
  }

  /**
   * Calculate actor's movies rating average test.
   */
  @Test
  public void testActorsMovieRatingAverageCalculation() {
    final Actor actor = new Actor("Natalie Portman");
    final double movieOneRating = 10;
    final double movieTwoRating = 7;
    final double expectedAverage = (movieOneRating + movieTwoRating) / 2;
    final double delta = 0;
    final Movie movieOne = new Movie("Black Swan");
    movieOne.setRating(movieOneRating);
    final Movie movieTwo = new Movie("Jane Got a Gun");
    movieTwo.setRating(movieTwoRating);
    actor.getMovies().add(movieOne);
    actor.getMovies().add(movieTwo);
    assertEquals(expectedAverage, actor.getAverage(), delta);
  }

}
