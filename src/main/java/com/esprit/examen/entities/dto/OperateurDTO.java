package com.esprit.examen.entities.dto;

import com.esprit.examen.entities.Facture;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperateurDTO {
    private Long idOperateur;
    private String nom;
    private String prenom;
    private String password;
}
