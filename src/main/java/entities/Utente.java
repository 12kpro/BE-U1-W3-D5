package entities;

import app.Application;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue
    private UUID numeroTessera;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;

    public Utente(String nome, String cognome, String dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = LocalDate.parse(dataNascita, Application.dateFormatter);

    }

    @Override
    public String toString() {
        return "Utente{" +
                "numero tessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}
