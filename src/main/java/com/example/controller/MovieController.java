package com.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Movie;

@RestController
@RequestMapping(value="/movie")
public class MovieController {

	@RequestMapping(value="/{movieId}", method=RequestMethod.GET)
	public Movie getMovieInfo(@PathVariable(value="movieId")String movieId) {
		return new Movie(movieId,"action");
	}
	
}
