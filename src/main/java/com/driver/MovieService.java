package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired          //object single all over the project
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }
    public void addMovieDirectorPair(String movie,String director){
        movieRepository.saveMovieDirectorPair(movie,director);
    }
    public Movie findMovie(String moviename){
        return movieRepository.findMovie(moviename);
    }
    public Director findDirector(String directorname){
        return movieRepository.findDirector(directorname);
    }
    public List<String>findMoviesByDirector(String director){
        return  movieRepository.findMoviesbyDirector(director);
    }
public List findAllMovies(){
        return movieRepository.findAllMovies();
}
public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
}
public void deleteAllDirector(){
        movieRepository.deleteAllDirector();
}
}
