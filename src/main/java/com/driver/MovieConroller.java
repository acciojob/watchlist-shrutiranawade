package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieConroller {
@Autowired
    MovieService movieService;

@PostMapping("/add-movie")
    public ResponseEntity<String> addmovie(@RequestBody Movie movie){
movieService.addMovie(movie);
return new ResponseEntity<>("New movie Added Successfully",HttpStatus.CREATED);
}
@PostMapping("/add-director")
    public ResponseEntity<String>addDirector(@RequestBody Director director){
    movieService.addDirector(director);
    return new ResponseEntity<>("New Director Added Successfully",HttpStatus.CREATED);
}
@PutMapping("/add-moviedirectorPair")
    public ResponseEntity<String>addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
    movieService.addMovieDirectorPair(movie,director);
    return new ResponseEntity<>("New MovieDirector Pair Created.",HttpStatus.CREATED);
}
@GetMapping("/getmovie-byname/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
    Movie movie1 = movieService.findMovie(name);
    return new ResponseEntity<>(movie1,HttpStatus.CREATED) ;
}
@GetMapping("/getDirectorByName/{dname}")
    public ResponseEntity<Director>findDirectorByName(@PathVariable String dname){
    Director d1 = movieService.findDirector(dname);
    return new ResponseEntity<>(d1,HttpStatus.CREATED);
}
@GetMapping("/find-moviesByDirector/{director}")
    public ResponseEntity<List<String>>findMoviesbyDirectorName(@PathVariable String director){
     List<String>movieList =movieService.findMoviesByDirector(director);
     return new ResponseEntity<>(movieList,HttpStatus.CREATED);
}
@GetMapping("/get-allmovies")
    public ResponseEntity<List<String>>getallMovies(){
    List<String>allmovies = movieService.findAllMovies();
    return new ResponseEntity<>(allmovies,HttpStatus.CREATED);
}
@DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>deleteDirector(@RequestParam String director){
    movieService.deleteDirector(director);
    return new ResponseEntity<>(director +"Delected  Successfully",HttpStatus.CREATED);
}
@DeleteMapping("/deleteall-directors")
    public ResponseEntity<String>deleteAllDirectors(){
    movieService.deleteAllDirector();
    return new ResponseEntity<>("All Directors deleted Successfully",HttpStatus.CREATED);
}
}
