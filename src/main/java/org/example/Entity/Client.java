package org.example.Entity;


import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    @OneToOne
    private Adresse adresse;
    private int age;
    private String numeroTelephone;
    @OneToMany(mappedBy = "Client")
    private List<Billet> billetList;
}
