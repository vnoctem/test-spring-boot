package com.example.testspringboot.dto;

import com.example.testspringboot.model.Acteur;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FilmDTO {

    private Long id;
    private String titre;
    private String description;
    private List<Acteur> acteurs;

}
