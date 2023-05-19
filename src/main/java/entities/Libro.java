package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("libro")
@Getter
@Setter
@NoArgsConstructor
public class Libro extends Pubblicazione {
    private String autore;
    private String genere;

    public Libro(String id, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
}
