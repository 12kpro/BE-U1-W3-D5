package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.Periodicita;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("rivista")
@Getter
@Setter
@NoArgsConstructor
public class Rivista extends Pubblicazione {
    private Periodicita periodicita;

    public Rivista(String id, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}