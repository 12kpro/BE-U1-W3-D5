package app;


import dao.*;
import entities.*;
import lombok.extern.slf4j.Slf4j;
import utils.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
public class Application {
	public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	static final Boolean populate = false;
	public static void main(String[] args) {
		try {
			EntityManager em = emf.createEntityManager();

			PubblicazioneDAO pubblicazione = new PubblicazioneDAO(em);
			LibroDAO libri = new LibroDAO(em);
			RivistaDAO riviste = new RivistaDAO(em);
			UtenteDAO utenti = new UtenteDAO(em);
			PrestitoDAO prestiti = new PrestitoDAO(em);


			if (populate == true) {
				Utente user_1 = new Utente("Mauro","Simoni","10-04-1979");
				Utente user_2 = new Utente("Mario","Rossi","15-08-1995");
				utenti.create(user_1);
				utenti.create(user_2);

				Libro book_1 = new Libro("8806259571","Il passeggero",2010,56,"Cormac McCarthy","cultura");
				Libro book_2 = new Libro("8817179272","Una brava ragazza è una ragazza morta",2015,560,"Holly Jackson","thriller");
				Libro book_3 = new Libro("8817175455","Sorelle. Una storia di Sara",2019,272,"Maurizio de Giovanni","narrativa");
				libri.create(book_1);
				libri.create(book_2);
				libri.create(book_3);

				Rivista magazine_1 = new Rivista("8817175487","Linux Magazine",2010,110,Periodicita.SETTIMANALE);
				Rivista magazine_2 = new Rivista("8217175469","PC professionale",2015,85,Periodicita.MENSILE);
				Rivista magazine_3 = new Rivista("8517175414","Quattroruote",2019,142,Periodicita.SEMESTRALE);
				riviste.create(magazine_1);
				riviste.create(magazine_2);
				riviste.create(magazine_3);

				Prestito loan_1 = new Prestito(user_1,book_1,"10-04-2023");
				Prestito loan_2 = new Prestito(user_1,magazine_2,"10-04-2023");
				Prestito loan_3 = new Prestito(user_2,magazine_1,"11-05-2023");
				Prestito loan_4 = new Prestito(user_2,book_2,"25-04-2023");
				prestiti.create(loan_1);
				prestiti.create(loan_2);
				prestiti.create(loan_3);
				prestiti.create(loan_4);

			}
			log.info(pubblicazione.findByIsbn("8806259571").toString());
			log.info(pubblicazione.findAll().toString());
			log.info(pubblicazione.findByAutore("Cormac McCarthy").toString());
			log.info(pubblicazione.findByAnnoPubblicazione(2015).toString());
			log.info(pubblicazione.findByTitolo("s").toString());
			log.info(prestiti.findExpired().toString());
			log.info(prestiti.findByTesseraUtente("0aefeedd-7649-4279-9f7a-1fe3be8defcd").toString());

			Libro book_rm = new Libro("8806254587","Prova a cancellarmi",2010,56,"Toni momy","cultura");
			libri.create(book_rm);
			pubblicazione.deleteByIsbn("8806254587");

		} catch (ExceptionInInitializerError e) {
			log.error(e.getMessage());
		} finally {
			emf.close();
		}
	}
}
