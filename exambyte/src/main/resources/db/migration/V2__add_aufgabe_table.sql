create table aufgabe(
    quiz int references quiz(id),
    quiz_key int, --Da wir eine Liste benutzen
    frage varchar(255),
    aufgabentyp varchar(50)
)