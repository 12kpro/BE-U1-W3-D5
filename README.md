Creare le classi necessarie a gestire un catalogo
bibliotecario. II catalogo è formato da elementi che possono
essere Libri o Riviste. Sia Libri che riviste hanno i
seguenti attributi:

- Codice ISBN (codice univoco)
- Titolo
- Anno pubblicazione
- Numero pagine

I libri hanno inoltre:
- Autore
- Genere

Le riviste hanno:
- Periodicitå [SETTIMANALE,MENSILE,SEMESTRALE]

L' utente é caratterizzato dai seguenti attributi:
- Nome
- Cognome
- Data di nascita
- Numero di tessera

II prestito é caratterizzato da:
- Utente
- Elemento prestato (può essere un Libro o una rivista)
- Data inizio prestito
- Data restituzione prevista (calcolata automaticamente a 30 gg dalla data inizio prestito)
- Data restituzione effettiva

L' archivio deve permettere Ie seguenti operazioni :
- Aggiunta di un elemento del catalogo
- Rimozione di un elemento del catalogo dato un codice ISBN
- Ricerca per ISBN
- Ricerca per anno pubblicazione
- Ricerca per autore
- Ricerca per titolo o parte di esso
- Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
- Ricerca di tutti i prestiti scaduti e non ancora restituiti