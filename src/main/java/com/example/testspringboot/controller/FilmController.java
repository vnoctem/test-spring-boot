package com.example.testspringboot.controller;

import com.example.testspringboot.dto.FilmDTO;
import com.example.testspringboot.model.Film;
import com.example.testspringboot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getFilmById(@PathVariable Long id) {
        FilmDTO film = filmService.getFilmById(id);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FilmDTO> createFilm(@RequestBody FilmDTO film) {
        FilmDTO createdFilm = filmService.createFilm(film);
        return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
    }

}
