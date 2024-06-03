package com.example.testspringboot.mapper;

import com.example.testspringboot.dto.FilmDTO;
import com.example.testspringboot.model.Film;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilmMapper {

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    FilmDTO toDTO(Film film);
    Film toEntity(FilmDTO filmDTO);

}
