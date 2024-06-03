package com.example.testspringboot.service;

import com.example.testspringboot.dto.FilmDTO;
import com.example.testspringboot.exception.FilmNotFoundException;
import com.example.testspringboot.mapper.FilmMapper;
import com.example.testspringboot.model.Film;
import com.example.testspringboot.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public FilmDTO getFilmById(Long id) {
        Film film =  filmRepository.findById(id)
                .orElseThrow(() -> new FilmNotFoundException("Film avec le ID " + id + " est introuvable"));
        return FilmMapper.INSTANCE.toDTO(film);
    }

    public FilmDTO createFilm(FilmDTO filmDTO) {
        Film film = FilmMapper.INSTANCE.toEntity(filmDTO);
        Film createdFilm = filmRepository.save(film);
        return FilmMapper.INSTANCE.toDTO(createdFilm);
    }

}
