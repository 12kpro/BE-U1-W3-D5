package entities;

import app.Application;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
@Getter
@Setter
@NoArgsConstructor
public class Prestito {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utente_id", referencedColumnName = "numerotessera")
    private Utente utente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pubblicazione_id")
    private Pubblicazione pubblicazione;
    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzioneEffettiva;

    public Prestito( Utente utente, Pubblicazione pubblicazione, String dataInizioPrestito) {
        this.utente = utente;
        this.pubblicazione = pubblicazione;
        this.dataInizioPrestito = LocalDate.parse(dataInizioPrestito, Application.dateFormatter);
    }
    @PrePersist
    public void dataRestituzioneEffettiva(){
        this.dataRestituzioneEffettiva = dataInizioPrestito.plusDays(30);
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", pubblicazione=" + pubblicazione +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
