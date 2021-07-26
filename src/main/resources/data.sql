DROP TABLE IF EXISTS BRAND CASCADE;
CREATE TABLE BRAND(
    ID SERIAL PRIMARY KEY,
    NAZIV VARCHAR(255) UNIQUE
);

INSERT INTO BRAND(NAZIV) VALUES
    ('LOGITECH'),
    ('RAZER'),
    ('MS'),
    ('ACER'),
    ('HP'),
    ('LENOVO'),
    ('XIAOMI');

DROP TABLE IF EXISTS PROIZVOD CASCADE;
CREATE TABLE PROIZVOD(
    ID SERIAL PRIMARY KEY,
    BRAND_ID INTEGER,
    NAZIV VARCHAR(255) UNIQUE,
    OPIS TEXT,
    CIJENA DECIMAL,
    KOLICINA INTEGER
);

INSERT INTO PROIZVOD(BRAND_ID, NAZIV, OPIS, CIJENA, KOLICINA) VALUES
    (1, 'Miš LOGITECH G102 LIGHTSYNC', 'Logitech G102 LIGHTSYNC gaming miš ima klasični i bezvremenski dizajn sa 6 tipki, koji se može izravno koristiti izvan okvira ili u potpunosti konfigurirati za pojednostavljenje ili prilagodbu radnji.Novi miš za igru uključuje visoko precizni senzor s podesivim DPI-om do 8000 DPI-ja, pružajući najveću preciznost, brzinu i konzistentnost.G102 LIGHTSYNC RGB uključuje paletu do 16.8 milijuna boja i različitih razina svjetlije, što pruža mogućnost prikazivanja efekta osvjetljenja duginih boja.',229.00, 25),
    (2, 'Miš RAZER Basilisk V2', 'Gaming miš Razer Basilisk V2 se hvali odličnim optičkim senzorom Razer Focus+ koji ima 20 000 DPI te 650 IPS. Ima 11 programibilnih gumba, kojima se mogu dodijeliti makro i sekundarne funkcije. Uključuje i multi-funkcionalnu sklopku za brze pokrete. Miš ima dvije Razer Chroma osvjetljene zone s čak 16,8 milijuna boja. Ergonomski je dizajniran, primjeren za dešnjake i ima 100 % PTFE nogice, pružajući glatko pomicanje miša.Razer Hypershift duplicirat će naredbe za unos miša. Možete im pristupiti jednim pritiskom na gumb i pomoću sekundarnog profila.', 699.00, 11),
    (3, 'Hladnjak za prijenosno računalo MS FREEZE DUAL 2', 'MS FREEZE DUAL 2 - hladnjak za prijenosna računala s dva ventilatora primjenjiv na 15.6" i 17.1" modelima prijenosnih računala. Tihi rad, dva ventilatora brzine do 1.000 okretaja, anti-slip podloga, plavo LED svjetlo te dvije moguće visine optimalan su dodatak svakom prijenosnom računalu. Uz dva dodatna USB priključka ne gubite niti jedan USB port za napajanje.', 109.00, 50),
    (4, 'Laptop ACER Aspire 5', 'Iza mnogo dostupnih boja ovog atraktivnog prijenosnog računala kriju se različiti moćni procesori i grafičke kartice koje će korisnicima omogućiti da na najbolji način iskoriste njegov velik zaslon. Kao što biste i očekivali od prijenosnog računala ovog kalibra, opremljeno je i brzom Wi-Fi vezom te mnoštvom memorije i prostora za pohranu.', 5790.25, 6),
    (5, 'Laptop HP 250 G8', 'Laptop HP 250 ide u korak s mobilnim stilovima rada tankog i laganog dizajna. Prekrasan zaslon uskog dizajna obruba i velikog omjera zaslona i tijela pruža dovoljno prostora za rad ili streaming sadržaj.Izgrađen za posao i spreman za zabavu.', 3899.00, 1),
    (6, 'Laptop LENOVO Legion 5', 'Dominirajte prostorijom i top listom uz Legion 5 seriju laptopa, koji su dizajnirani s mnoštvom opcija visokih performansi, a pritom zadržavaju minimalistički izgled i nadopunjuju vaš životni stil. Doživite svaki detalj i trenirajte nadljudske reflekse uz FHD zaslone s osvježavanjem prikaza do 240 Hz, svjetlinom od 500 nita i 100 % pokrivenošću sRGB prostora boja.', 7999.00, 3),
    (7, 'Električni romobil XIAOMI MI PRO 2', 'Mi Electric Scooter Pro2 je izrađen od visokog aluminija i skoro zanemarive težine od 14 kg, s razlogom nosi titulu jednog od najtraženijih električnih romobila na tržištu. Električni kočni ABS sustav i mogućnost brzog oporavka energije, čini ga efikasnim prijevoznim sredstvom. Povećani kapacitet baterije, veliko napajanje i učinkovito ubrzanje omogućuju vožnju od 45 km sa samo jednim punjenjem baterije. Pametni sustav upravljanja nudi šest različitih zaštitnih mjera, a pored navedenog, tehnološki napredni romobil može se povezati na pametni telefon putem aplikacije Mi Home uz pomoć koje možete pratiti prijeđene kilometre te promatrati izdržljivost baterije.', 4498.95, 4),
    (2, 'Podloga za miš RAZER Chroma', 'Podloga za miš, crne boje/ Razer Chroma prilagodljiva rasvjeta. Dimenzije: 355 mm x 255 mm x 4 mm.', 499.00, 5),
    (7, 'Bluetooth slušalice XIAOMI Mi True', 'XIAOMI Mi True odlikuje IPX4 otpornost na prskanje i znoj, optimiziran način međusobnog povezivanja lijeve i desne slušalice tako se još jednostavnije možete prebaciti iz rada jedne ili obje slušalice', 229.00, 18),
    (1, 'Web kamera LOGITECH MeetUp', 'Konferencija kamera Logitech Meetup izrađena je posebno za male sobe za sastanke. Odlikuje se širokim kutom gledanja(120), koji se lako hvata cijelu sobu. 4K Ultra HD senzor osigurava izvanrednu razlučivost i balans boja. Za odličan zvuk se brine integrirani audio, optimiziran za akustiku prostora (tri mikrofona i zvučnika).', 8998.84, 2);
DROP TABLE IF EXISTS NACIN_PLACANJA CASCADE;
CREATE TABLE NACIN_PLACANJA(
    ID SERIAL PRIMARY KEY,
    NAZIV VARCHAR(50) UNIQUE
);

INSERT INTO NACIN_PLACANJA (NAZIV) VALUES
    ('KARTIČNO'),
    ('GOTOVINSKO');

DROP TABLE IF EXISTS POPUST_KOD CASCADE;
CREATE TABLE POPUST_KOD(
    ID SERIAL PRIMARY KEY,
    KOD VARCHAR(10) UNIQUE,
    POPUST DECIMAL,
    ISKORISTEN BOOLEAN,
    DATUM_KREIRANJA TIMESTAMP
);

INSERT INTO POPUST_KOD(KOD, POPUST, ISKORISTEN, DATUM_KREIRANJA) VALUES
    ('TEST20', 0.20, FALSE, current_timestamp),
    ('TEST10', 0.10, TRUE, '2021-07-21 09:00:08.074584+00'),
    ('TEST50', 0.50, FALSE, current_timestamp);

DROP TABLE IF EXISTS NARUDZBA CASCADE;
CREATE TABLE NARUDZBA(
    ID SERIAL PRIMARY KEY,
    POPUST_KOD_ID INTEGER,
    NACIN_PLACANJA_ID INTEGER,
    UKUPNA_CIJENA_BEZ_POPUSTA DECIMAL,
    UKUPNA_CIJENA_S_POPUSTOM DECIMAL,
    DATUM_KREIRANJA TIMESTAMP,
    DATUM_AZURIRANJA TIMESTAMP,
    BROJ_KARTICE VARCHAR(19),
    EMAIL VARCHAR(50),
    BROJ_MOBITELA VARCHAR(30),
    ADRESA_DOSTAVE VARCHAR(100),
    NAPOMENA TEXT
);

INSERT INTO NARUDZBA(POPUST_KOD_ID, NACIN_PLACANJA_ID, UKUPNA_CIJENA_BEZ_POPUSTA, UKUPNA_CIJENA_S_POPUSTOM, DATUM_KREIRANJA, DATUM_AZURIRANJA, BROJ_KARTICE, EMAIL, BROJ_MOBITELA, ADRESA_DOSTAVE, NAPOMENA)
    VALUES(1, 1, 998.00, 798.40, current_timestamp, current_timestamp, '5474765157064399', 'pgalina@foi.hr', '0951975552', 'Madžarevo 212a, 42220 Novi Marof', 'N/A');


DROP TABLE IF EXISTS NARUDZBA_PROIZVOD CASCADE;
CREATE TABLE NARUDZBA_PROIZVOD(
    ID SERIAL PRIMARY KEY,
    NARUDZBA_ID INTEGER,
    PROIZVOD_ID INTEGER,
    KOLICINA INTEGER
);

INSERT INTO NARUDZBA_PROIZVOD(NARUDZBA_ID, PROIZVOD_ID, KOLICINA) VALUES
    (1, 1, 1),
    (1, 2, 1);