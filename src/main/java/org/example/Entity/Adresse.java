package org.example.Entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String rue;
    private String ville;
}
