package org.example.Entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numeroDePlace;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Evenement evenement;
    @Enumerated(EnumType.STRING)
    private TypeDePlace typeDePlace;
}
