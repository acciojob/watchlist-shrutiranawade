package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
@Autowired
    MovieService movieService;

@PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
   movieService.addMovie(movie);
return new ResponseEntity<>("New movie Added Successfully",HttpStatus.CREATED);
}
@PostMapping("/add-director")
    public ResponseEntity<String>addDirector(@RequestBody Director director){
    movieService.addDirector(director);
    return new ResponseEntity<>("New Director Added Successfully",HttpStatus.CREATED);
}
@PutMapping("/add-movie-director-pair")
    public ResponseEntity<String>addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
    movieService.addMovieDirectorPair(movie,director);
    return new ResponseEntity<>("New MovieDirector Pair Created.",HttpStatus.CREATED);
}
@GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
    Movie movie1 = movieService.findMovie(name);
    return new ResponseEntity<>(movie1,HttpStatus.CREATED) ;
}
@GetMapping("/get-director-by-name/{director}")
    public ResponseEntity<Director>getDirectorByName(@PathVariable String director){
    Director d1 = movieService.findDirector(director);
    return new ResponseEntity<>(d1,HttpStatus.CREATED);
}
@GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
     List<String>movieList = movieService.findMoviesByDirector(director);
     return new ResponseEntity<>(movieList,HttpStatus.CREATED);
}
@GetMapping("/get-all-movies")
    public ResponseEntity<List<String>>findAllMovies(){
    List<String> allmovieslist = movieService.findAllMovies();
    return new ResponseEntity<>(allmovieslist,HttpStatus.CREATED);
}
@DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>deleteDirectorByName(@RequestParam String director){
    movieService.deleteDirector(director);
    return new ResponseEntity<>(director +"Deleted  Successfully",HttpStatus.CREATED);
}
@DeleteMapping("/delete-all-directors")
    public ResponseEntity<String>deleteAllDirectors(){
    movieService.deleteAllDirector();
    return new ResponseEntity<>("All Directors deleted Successfully",HttpStatus.CREATED);
}
}
