package org.example.Entity;

import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable

public class Lieu extends Adresse {

    private int capacite;
    public Lieu() {
        super();
    }
}
