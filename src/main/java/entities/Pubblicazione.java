package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "pubblicazioni")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
@Getter
@Setter
@NoArgsConstructor
public class Pubblicazione {
    @Id
    //Non lo genero automaticamente perche l'isbn appartiene già al libro, quindi lo devo passare come parametro e non generarlo automaticamente
    private String isbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public Pubblicazione(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Pubblicazione{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
