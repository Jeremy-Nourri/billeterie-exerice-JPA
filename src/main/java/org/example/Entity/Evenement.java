package org.example.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Data;

@Data
@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    @Embedded
    private Lieu lieu;
    private LocalDate date;
    private LocalTime heure;
    private int nombreDePlace;
    @OneToMany (mappedBy = "Evenement")
    private List<Billet> billetList;
}
