package org.minions.devfund.sergio.movie_database;

import java.util.ArrayList;

public class Actor {

    private String name;
    private ArrayList<Movie> movies;

    public Actor(String name, ArrayList<Movie> movies) {
        this.name = name;
        this.movies = new ArrayList<>();
        this.movies.addAll(movies);
    }

    public Actor() {
        this.name = "";
        this.movies = new ArrayList<>();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Actor actor = (Actor) other;

        return name.equals(actor.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public int compareTo(Actor that) {
        return this.getName().compareTo(that.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    private ArrayList<String> getMovieNames() {
        ArrayList<String> movieNames = new ArrayList<>();
        for (Movie movie: this.movies) {
            movieNames.add(movie.getName());
        }
        return movieNames;
    }

    public void addMovie(Movie movie) {
        if (!this.getMovieNames().contains(movie.getName())) {
            this.movies.add(movie);
        }
    }
}
