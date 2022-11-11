package com.esprit.examen.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureDTO {
    private Long idFacture;
    private float montantRemise;
    private float montantFacture;
}
