package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> Moviemap ;
    HashMap<String,Director>Directormap;
    HashMap<String, List<String>>MovieDirectormap;

    public MovieRepository(){
        this.Moviemap = new HashMap<String,Movie>();
        this.Directormap = new HashMap<String,Director>();
        this.MovieDirectormap = new HashMap<String,List<String>>();
    }
    public void saveMovie(Movie movie){
        Moviemap.put(movie.getName(),movie);
    }
    public void saveDirector(Director director){
        Directormap.put(director.getName(),director);
    }

    public void  saveMovieDirectorPair(String movie,String director){
        //chk movie & director is present in their respective maps
        if(Moviemap.containsKey(movie) && Directormap.containsKey(director)){
            Moviemap.put(movie,Moviemap.get(movie));
            Directormap.put(director,Directormap.get(director));
            List<String> currentMovies = new ArrayList<String>();
            if (MovieDirectormap.containsKey(director)){
                currentMovies = MovieDirectormap.get(director);
            }
                currentMovies.add(movie);
                MovieDirectormap.put(director, currentMovies);

        }
    }
    public Movie findMovie(String movie){
       return Moviemap.get(movie);
    }
 public Director findDirector(String directorname){
        return Directormap.get(directorname);
 }


 public List findMoviesbyDirector(String director){
        List<String>MovieList = new ArrayList<>();
        if(MovieDirectormap.containsKey(director)){
            MovieList = MovieDirectormap.get(director);

            }

 return MovieList;
    }
    public List findAllMovies(){
        return new ArrayList(Moviemap.keySet());
    }
public void deleteDirector(String director){
        List<String>movies = new ArrayList<>();
        if(MovieDirectormap.containsKey(director)){
            movies = MovieDirectormap.get(director);  //getting movies by dirrector
            for (String movie1 : movies){
                if(Moviemap.containsKey(movie1)){
                    Moviemap.remove(movie1);
                }
            }
          MovieDirectormap.remove(director);
        }
        if(Directormap.containsKey(director))Directormap.remove(director);
}
public void deleteAllDirector(){
    HashSet<String> MovieSet = new HashSet<>();
    for (String director : MovieDirectormap.keySet()){
        for (String movie :MovieDirectormap.get(director)){
            MovieSet.add(movie);
        }
    }
    for (String movie : MovieSet){
        if (Moviemap.containsKey(movie)){
            Moviemap.remove(movie);
        }
    }
}

}
