-- GENRES 
insert into genres (name) values ('Education');
insert into genres (name) values ('Classic');   
insert into genres (name) values ('Action');
insert into genres (name) values ('Comedy');
insert into genres (name) values ('Drama');
insert into genres (name) values ('Fantasy');

-- WRITERS

insert into writers (name,surname) values ('Dzordz','Orvel');
insert into writers (name,surname) values ('Mirjana','Bobic');
insert into writers (name,surname) values ('Onore','De Balzak');
insert into writers (name,surname) values ('Dejan','Stojiljkovic');
insert into writers (name,surname) values ('Slavenka','Drakulic');
insert into writers (name,surname) values ('Miloslav','Samardzic');


-- BOOKS
    -- DZORDZ ORVEL
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('1984', 1 , 4, 1000, DATE('1949-4-14'), DATE('2023-1-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Zivotinjska Farma', 1 , 2, 250, DATE('1952-6-8'), DATE('2012-3-24'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Knjige ili cigarete', 1 , 6, 440, DATE('1966-1-13'), DATE('2023-1-1'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Kataloniji u cast', 1 , 4, 680, DATE('1946-11-22'), DATE('2021-7-22'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('U utorbi kita', 1 , 3, 1198, DATE('1944-1-12'), DATE('2020-5-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Put za Vigan', 1 , 3, 730, DATE('1949-4-11'), DATE('2019-3-15'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Niko i nista u Parizu i Londonu', 1 , 5, 512, DATE('1951-10-10'), DATE('2021-12-13'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('U borbi za vazduh', 1 , 1, 560, DATE('1953-11-25'), DATE('2017-10-12'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Svestenikova kci', 1 , 5, 755, DATE('1949-10-22'), DATE('2015-1-13'), 0, 0);

    --MIRJANA BOBIC
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Sazvezdje Svitaca', 2 , 6, 1040, DATE('1949-4-14'), DATE('2022-1-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Baba, nemoj nista da me pitas', 2 ,1, 430, DATE('1952-6-8'), DATE('2023-3-24'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Knjige ili cigarete',2 , 5, 230, DATE('1966-1-13'), DATE('2022-1-1'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Kataloniji u cast', 2 , 4, 330, DATE('1946-11-22'), DATE('2022-7-22'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('U utorbi kita', 2 , 2, 435, DATE('1944-1-12'), DATE('2020-5-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Put za Vigan', 2 , 3, 740, DATE('1949-4-11'), DATE('2023-3-15'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Niko i nista u Parizu i Londonu', 2 , 5, 512, DATE('1951-10-10'), DATE('2021-12-13'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('U borbi za vazduh', 2 , 3, 590, DATE('1953-11-25'), DATE('2017-10-12'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Svestenikova kci', 2 , 2, 950, DATE('1949-10-22'), DATE('2015-1-13'), 0, 0);

    --ONORE DE BALZAK
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Malogradjani', 3 , 3, 1000, DATE('2023-4-14'), DATE('2022-1-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Cica Gorio', 3 , 2, 250, DATE('1952-6-8'), DATE('2012-3-24'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Kad zena zri', 3 , 3, 440, DATE('1966-1-13'), DATE('2023-1-1'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Sagrinska Koza', 3 , 1, 680, DATE('1946-11-22'), DATE('2023-7-22'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Evgenija Grande', 3 , 2, 1198, DATE('1944-1-12'), DATE('2020-5-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Serafita', 3 , 3, 730, DATE('2023-4-11'), DATE('2022-3-15'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Melmot Lutalica', 3 , 5, 512, DATE('2023-10-10'), DATE('2021-12-13'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Eliksir dugovecnosti', 3 , 3, 560, DATE('1953-11-25'), DATE('2017-10-12'), 0, 0);

    --DEJAN STOJILJKOVIC
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Zvezda nad prazninom', 4 ,1, 460, DATE('2017-4-14'), DATE('2022-1-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Senka i san', 4 , 5, 750, DATE('2011-6-8'), DATE('2012-3-24'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Neonski bluz', 4 , 5, 440, DATE('2019-1-13'), DATE('2022-1-1'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Dukat za Ladjara', 4 , 1, 680, DATE('2017-11-22'), DATE('2021-7-22'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Konstantinovo raskrsce - Nebo iznad Nisa', 4 , 2, 1069, DATE('2017-1-12'), DATE('2020-5-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Konstantinovo raskrsce - Nasledje', 4 , 6, 1069, DATE('2018-4-11'), DATE('2019-3-15'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Konstantinovo raskrsce - Kraljevstvo Krvi', 4  , 1, 1069, DATE('2021-10-10'), DATE('2022-12-13'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Konstantinovo raskrsce - Prosireno', 4 , 1, 993, DATE('2016-11-25'), DATE('2017-10-12'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Olujni Bedemi', 4 , 3, 917, DATE('2020-11-25'), DATE('2021-10-12'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Duge noci i crne zastave', 4 , 2, 764, DATE('2019-11-25'), DATE('2021-10-12'), 0, 0);

    --SLAVENKA DRAKULIC
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Mileva Ajnstajn, Teorija tuge', 5 , 1, 540, DATE('2017-4-14'), DATE('2019-1-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Nevidljiva zena i druge price', 5 , 2, 250, DATE('2014-6-8'), DATE('2016-3-24'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Basne o komunizmu', 5 , 4, 445, DATE('2017-1-13'), DATE('2022-1-1'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Dora i Minotaur', 5 , 5, 480, DATE('2012-11-22'), DATE('2023-7-22'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Cafe Europa', 5 , 6, 1640, DATE('2008-1-12'), DATE('2022-5-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Frida ili o bolu', 5 , 4, 330, DATE('2017-4-11'), DATE('2020-3-15'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Optuzena', 5 , 5, 232, DATE('2009-10-10'), DATE('2012-12-13'), 0, 0);

    --MILOSLAV SAMARDZIC
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Saradnja partizana sa Nemcima', 6 , 3, 1000, DATE('2004-4-14'), DATE('2010-1-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Istina o Kalabicu', 6 , 4, 250, DATE('2006-6-8'), DATE('2012-3-24'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Albm srpskih cetnika generala Draze', 6 , 1, 440, DATE('2004-1-13'), DATE('2009-1-1'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Knjiga o Racicu', 6 , 1, 680, DATE('2006-11-22'), DATE('2021-7-22'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('The Serbs Against the Wehrmacht', 6 , 1, 1198, DATE('2005-1-12'), DATE('2011-5-4'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Major Palosevic', 6 , 1, 730, DATE('2012-4-11'), DATE('2014-5-5'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('General Draza Mihajlovic i Opsta Istorija', 6 , 3, 512, DATE('2013-10-10'), DATE('2015-12-13'), 0, 0);
insert into books (title, writer_id, genre_id, cost, publish_date, release_date, rating, rate_count) values ('Falsifikati komunisticke istorije', 6 , 3, 560, DATE('2009-11-25'), DATE('2010-1-22'), 0, 0);


-- USERS

insert into users_table (name, surname, email, username, password, type) values ('genericA', 'genero1', 'mail1@mail.com', 'user1', 'pw1', 'REGULAR');
insert into users_table (name, surname, email, username, password, type) values ('genericB', 'genero2', 'mail2@mail.com', 'user2', 'pw2', 'REGULAR');
insert into users_table (name, surname, email, username, password, type) values ('genericC', 'genero3', 'mail3@mail.com', 'user3', 'pw3', 'REGULAR');
insert into users_table (name, surname, email, username, password, type) values ('genericD', 'genero4', 'mail4@mail.com', 'user4', 'pw4', 'REGULAR');
insert into users_table (name, surname, email, username, password, type) values ('genericE', 'genero5', 'mail5@mail.com', 'user5', 'pw5', 'REGULAR');
insert into users_table (name, surname, email, username, password, type) values ('genericF', 'genero6', 'mail6@mail.com', 'user6', 'pw6', 'REGULAR');
insert into users_table (name, surname, email, username, password, type) values ('genericG', 'genero7', 'mail7@mail.com', 'user7', 'pw7', 'REGULAR');
insert into users_table (name, surname, email, username, password, type) values ('genericH', 'genero8', 'mail8@mail.com', 'user8', 'pw8', 'REGULAR');
insert into users_table (name, surname, email, username, password, type) values ('genericI', 'genero9', 'mail9@mail.com', 'user9', 'pw9', 'REGULAR');
insert into users_table (name, surname, email, username, password, type) values ('Filip', 'Milosevic', 'mail9@mail.com', 'cofara', '$2a$10$pOs0fsWQe3yNPAL1wKK5P.3aX77602reFAIBx79LToqp6ZSdjke/i', 'REGULAR');
--10 | mail@mail.com  | Filip    | $2a$10$pOs0fsWQe3yNPAL1wKK5P.3aX77602reFAIBx79LToqp6ZSdjke/i | Milosevic | REGULAR | cofara
-- RATINGS

    --USER1
insert into ratings (rate,book_id,user_id) values (5,11,1);
insert into ratings (rate,book_id,user_id) values (4,12,1);
insert into ratings (rate,book_id,user_id) values (3,13,1);
insert into ratings (rate,book_id,user_id) values (5,34,1);
insert into ratings (rate,book_id,user_id) values (1,51,1);
insert into ratings (rate,book_id,user_id) values (2,50,1);
insert into ratings (rate,book_id,user_id) values (4,23,1);
insert into ratings (rate,book_id,user_id) values (3,1,1);
insert into ratings (rate,book_id,user_id) values (3,19,1);
insert into ratings (rate,book_id,user_id) values (2,17,1);
insert into ratings (rate,book_id,user_id) values (1,33,1);
insert into ratings (rate,book_id,user_id) values (4,40,1);
insert into ratings (rate,book_id,user_id) values (5,41,1);
insert into ratings (rate,book_id,user_id) values (4,42,1);
insert into ratings (rate,book_id,user_id) values (3,39,1);
insert into ratings (rate,book_id,user_id) values (2,31,1);
insert into ratings (rate,book_id,user_id) values (4,29,1);
insert into ratings (rate,book_id,user_id) values (2,21,1);
insert into ratings (rate,book_id,user_id) values (3,43,1);

    --USER2
insert into ratings (rate,book_id,user_id) values (5,22,2);
insert into ratings (rate,book_id,user_id) values (1,32,2);
insert into ratings (rate,book_id,user_id) values (1,9,2);
insert into ratings (rate,book_id,user_id) values (2,8,2);
insert into ratings (rate,book_id,user_id) values (3,4,2);
insert into ratings (rate,book_id,user_id) values (4,44,2);
insert into ratings (rate,book_id,user_id) values (5,35,2);
insert into ratings (rate,book_id,user_id) values (5,39,2);
insert into ratings (rate,book_id,user_id) values (4,31,2);
insert into ratings (rate,book_id,user_id) values (4,29,2);
insert into ratings (rate,book_id,user_id) values (2,21,2);
insert into ratings (rate,book_id,user_id) values (1,16,2);
insert into ratings (rate,book_id,user_id) values (2,33,2);
insert into ratings (rate,book_id,user_id) values (3,40,2);
insert into ratings (rate,book_id,user_id) values (2,41,2);
insert into ratings (rate,book_id,user_id) values (1,42,2);
insert into ratings (rate,book_id,user_id) values (3,1,2);
insert into ratings (rate,book_id,user_id) values (4,19,2);
insert into ratings (rate,book_id,user_id) values (4,17,2);
insert into ratings (rate,book_id,user_id) values (5,43,2);
insert into ratings (rate,book_id,user_id) values (4,33,2);

    --USER3
insert into ratings (rate,book_id,user_id) values (1,13,3);
insert into ratings (rate,book_id,user_id) values (3,11,3);
insert into ratings (rate,book_id,user_id) values (4,49,3);
insert into ratings (rate,book_id,user_id) values (5,18,3);
insert into ratings (rate,book_id,user_id) values (5,9,3);
insert into ratings (rate,book_id,user_id) values (5,4,3);
insert into ratings (rate,book_id,user_id) values (4,38,3);
insert into ratings (rate,book_id,user_id) values (3,43,3);
insert into ratings (rate,book_id,user_id) values (3,33,3);
insert into ratings (rate,book_id,user_id) values (4,40,3);
insert into ratings (rate,book_id,user_id) values (1,41,3);
insert into ratings (rate,book_id,user_id) values (4,42,3);
insert into ratings (rate,book_id,user_id) values (3,1,3);
insert into ratings (rate,book_id,user_id) values (3,19,3);
insert into ratings (rate,book_id,user_id) values (4,17,3);
insert into ratings (rate,book_id,user_id) values (1,39,3);
insert into ratings (rate,book_id,user_id) values (2,31,3);
insert into ratings (rate,book_id,user_id) values (4,29,3);
insert into ratings (rate,book_id,user_id) values (2,21,3);

    --USER4
insert into ratings (rate,book_id,user_id) values (2,2,4);
insert into ratings (rate,book_id,user_id) values (3,3,4);
insert into ratings (rate,book_id,user_id) values (5,5,4);
insert into ratings (rate,book_id,user_id) values (1,25,4);
insert into ratings (rate,book_id,user_id) values (4,14,4);
insert into ratings (rate,book_id,user_id) values (5,15,4);
insert into ratings (rate,book_id,user_id) values (4,48,4);
insert into ratings (rate,book_id,user_id) values (5,49,4);
insert into ratings (rate,book_id,user_id) values (4,36,4);
insert into ratings (rate,book_id,user_id) values (3,37,4);
insert into ratings (rate,book_id,user_id) values (4,38,4);
insert into ratings (rate,book_id,user_id) values (2,33,4);
insert into ratings (rate,book_id,user_id) values (1,40,4);
insert into ratings (rate,book_id,user_id) values (2,41,4);
insert into ratings (rate,book_id,user_id) values (3,42,4);
insert into ratings (rate,book_id,user_id) values (3,1,4);
insert into ratings (rate,book_id,user_id) values (5,19,4);
insert into ratings (rate,book_id,user_id) values (4,17,4);
insert into ratings (rate,book_id,user_id) values (5,39,4);
insert into ratings (rate,book_id,user_id) values (3,31,4);
insert into ratings (rate,book_id,user_id) values (2,29,4);
insert into ratings (rate,book_id,user_id) values (1,21,4);
insert into ratings (rate,book_id,user_id) values (3,43,4);
insert into ratings (rate,book_id,user_id) values (4,33,4);
insert into ratings (rate,book_id,user_id) values (4,40,4);

    --USER5
insert into ratings (rate,book_id,user_id) values (3,6,5);
insert into ratings (rate,book_id,user_id) values (5,7,5);
insert into ratings (rate,book_id,user_id) values (2,5,5);
insert into ratings (rate,book_id,user_id) values (3,10,5);
insert into ratings (rate,book_id,user_id) values (5,21,5);
insert into ratings (rate,book_id,user_id) values (3,15,5);
insert into ratings (rate,book_id,user_id) values (4,16,5);
insert into ratings (rate,book_id,user_id) values (1,24,5);
insert into ratings (rate,book_id,user_id) values (4,25,5);
insert into ratings (rate,book_id,user_id) values (5,26,5);
insert into ratings (rate,book_id,user_id) values (4,30,5);
insert into ratings (rate,book_id,user_id) values (1,35,5);
insert into ratings (rate,book_id,user_id) values (2,45,5);
insert into ratings (rate,book_id,user_id) values (4,46,5);
insert into ratings (rate,book_id,user_id) values (4,33,5);
insert into ratings (rate,book_id,user_id) values (4,40,5);
insert into ratings (rate,book_id,user_id) values (5,41,5);
insert into ratings (rate,book_id,user_id) values (2,42,5);
insert into ratings (rate,book_id,user_id) values (3,1,5);
insert into ratings (rate,book_id,user_id) values (3,19,5);
insert into ratings (rate,book_id,user_id) values (4,17,5);
insert into ratings (rate,book_id,user_id) values (5,39,5);
insert into ratings (rate,book_id,user_id) values (4,31,5);
insert into ratings (rate,book_id,user_id) values (4,29,5);
insert into ratings (rate,book_id,user_id) values (2,21,5);
insert into ratings (rate,book_id,user_id) values (3,43,5);

    --USER6
insert into ratings (rate,book_id,user_id) values (5,20,6);
insert into ratings (rate,book_id,user_id) values (2,27,6);
insert into ratings (rate,book_id,user_id) values (4,28,6);
insert into ratings (rate,book_id,user_id) values (3,33,6);
insert into ratings (rate,book_id,user_id) values (2,40,6);
insert into ratings (rate,book_id,user_id) values (1,41,6);
insert into ratings (rate,book_id,user_id) values (4,42,6);
insert into ratings (rate,book_id,user_id) values (3,43,6);
insert into ratings (rate,book_id,user_id) values (2,45,6);
insert into ratings (rate,book_id,user_id) values (5,47,6);
insert into ratings (rate,book_id,user_id) values (2,14,6);
insert into ratings (rate,book_id,user_id) values (4,15,6);
insert into ratings (rate,book_id,user_id) values (1,48,6);
insert into ratings (rate,book_id,user_id) values (3,4,6);
insert into ratings (rate,book_id,user_id) values (5,44,6);
insert into ratings (rate,book_id,user_id) values (2,35,6);
insert into ratings (rate,book_id,user_id) values (4,39,6);
insert into ratings (rate,book_id,user_id) values (2,31,6);
insert into ratings (rate,book_id,user_id) values (3,1,6);
insert into ratings (rate,book_id,user_id) values (1,19,6);
insert into ratings (rate,book_id,user_id) values (4,17,6);
insert into ratings (rate,book_id,user_id) values (5,39,6);
insert into ratings (rate,book_id,user_id) values (4,31,6);
insert into ratings (rate,book_id,user_id) values (3,29,6);
insert into ratings (rate,book_id,user_id) values (3,21,6);
insert into ratings (rate,book_id,user_id) values (2,43,6);
insert into ratings (rate,book_id,user_id) values (5,33,6);
insert into ratings (rate,book_id,user_id) values (4,40,6);

    --USER7
insert into ratings (rate,book_id,user_id) values (4,22,7);
insert into ratings (rate,book_id,user_id) values (2,32,7);
insert into ratings (rate,book_id,user_id) values (5,9, 7);
insert into ratings (rate,book_id,user_id) values (5,8, 7);
insert into ratings (rate,book_id,user_id) values (4,4, 7);
insert into ratings (rate,book_id,user_id) values (3,44,7);
insert into ratings (rate,book_id,user_id) values (2,35,7);
insert into ratings (rate,book_id,user_id) values (5,39,7);
insert into ratings (rate,book_id,user_id) values (4,31,7);
insert into ratings (rate,book_id,user_id) values (3,29,7);
insert into ratings (rate,book_id,user_id) values (1,21,7);
insert into ratings (rate,book_id,user_id) values (4,16,7);
insert into ratings (rate,book_id,user_id) values (2,33,7);
insert into ratings (rate,book_id,user_id) values (3,40,7);
insert into ratings (rate,book_id,user_id) values (2,41,7);
insert into ratings (rate,book_id,user_id) values (1,42,7);
insert into ratings (rate,book_id,user_id) values (2,1, 7);
insert into ratings (rate,book_id,user_id) values (4,19,7);
insert into ratings (rate,book_id,user_id) values (2,17,7);
insert into ratings (rate,book_id,user_id) values (5,43,7);
insert into ratings (rate,book_id,user_id) values (4,33,7);

    --USER8
insert into ratings (rate,book_id,user_id) values (4,6, 8);
insert into ratings (rate,book_id,user_id) values (4,7, 8);
insert into ratings (rate,book_id,user_id) values (1,5, 8);
insert into ratings (rate,book_id,user_id) values (3,10,8);
insert into ratings (rate,book_id,user_id) values (4,21,8);
insert into ratings (rate,book_id,user_id) values (2,15,8);
insert into ratings (rate,book_id,user_id) values (5,16,8);
insert into ratings (rate,book_id,user_id) values (3,24,8);
insert into ratings (rate,book_id,user_id) values (2,25,8);
insert into ratings (rate,book_id,user_id) values (5,26,8);
insert into ratings (rate,book_id,user_id) values (3,30,8);
insert into ratings (rate,book_id,user_id) values (4,35,8);
insert into ratings (rate,book_id,user_id) values (4,45,8);
insert into ratings (rate,book_id,user_id) values (4,46,8);
insert into ratings (rate,book_id,user_id) values (5,33,8);
insert into ratings (rate,book_id,user_id) values (1,40,8);
insert into ratings (rate,book_id,user_id) values (3,41,8);
insert into ratings (rate,book_id,user_id) values (4,42,8);
insert into ratings (rate,book_id,user_id) values (4,1, 8);
insert into ratings (rate,book_id,user_id) values (3,19,8);
insert into ratings (rate,book_id,user_id) values (2,17,8);
insert into ratings (rate,book_id,user_id) values (1,39,8);
insert into ratings (rate,book_id,user_id) values (3,31,8);
insert into ratings (rate,book_id,user_id) values (5,29,8);
insert into ratings (rate,book_id,user_id) values (2,21,8);
insert into ratings (rate,book_id,user_id) values (3,43,8);

    --USER9
insert into ratings (rate,book_id,user_id) values (4,2, 9);
insert into ratings (rate,book_id,user_id) values (5,3, 9);
insert into ratings (rate,book_id,user_id) values (2,5, 9);
insert into ratings (rate,book_id,user_id) values (4,25,9);
insert into ratings (rate,book_id,user_id) values (5,14,9);
insert into ratings (rate,book_id,user_id) values (3,15,9);
insert into ratings (rate,book_id,user_id) values (3,48,9);
insert into ratings (rate,book_id,user_id) values (4,49,9);
insert into ratings (rate,book_id,user_id) values (5,36,9);
insert into ratings (rate,book_id,user_id) values (5,37,9);
insert into ratings (rate,book_id,user_id) values (4,38,9);
insert into ratings (rate,book_id,user_id) values (2,33,9);
insert into ratings (rate,book_id,user_id) values (4,40,9);
insert into ratings (rate,book_id,user_id) values (1,41,9);
insert into ratings (rate,book_id,user_id) values (4,42,9);
insert into ratings (rate,book_id,user_id) values (2,1, 9);
insert into ratings (rate,book_id,user_id) values (2,19,9);
insert into ratings (rate,book_id,user_id) values (4,17,9);
insert into ratings (rate,book_id,user_id) values (1,39,9);
insert into ratings (rate,book_id,user_id) values (4,31,9);
insert into ratings (rate,book_id,user_id) values (5,29,9);
insert into ratings (rate,book_id,user_id) values (4,21,9);
insert into ratings (rate,book_id,user_id) values (3,43,9);
insert into ratings (rate,book_id,user_id) values (2,33,9);
insert into ratings (rate,book_id,user_id) values (1,40,9);

-- Cofara user
insert into ratings (rate,book_id,user_id) values (4,2, 10);
insert into ratings (rate,book_id,user_id) values (5,3, 10);
insert into ratings (rate,book_id,user_id) values (2,5, 10);
insert into ratings (rate,book_id,user_id) values (4,25,10);
insert into ratings (rate,book_id,user_id) values (5,14,10);
insert into ratings (rate,book_id,user_id) values (3,15,10);
insert into ratings (rate,book_id,user_id) values (3,48,10);
insert into ratings (rate,book_id,user_id) values (4,49,10);
insert into ratings (rate,book_id,user_id) values (5,36,10);
insert into ratings (rate,book_id,user_id) values (5,37,10);
insert into ratings (rate,book_id,user_id) values (4,38,10);
insert into ratings (rate,book_id,user_id) values (2,33,10);
insert into ratings (rate,book_id,user_id) values (4,40,10);
insert into ratings (rate,book_id,user_id) values (1,41,10);
insert into ratings (rate,book_id,user_id) values (4,42,10);
insert into ratings (rate,book_id,user_id) values (2,1, 10);
insert into ratings (rate,book_id,user_id) values (2,19,10);
insert into ratings (rate,book_id,user_id) values (4,17,10);
insert into ratings (rate,book_id,user_id) values (1,39,10);
insert into ratings (rate,book_id,user_id) values (4,31,10);
insert into ratings (rate,book_id,user_id) values (5,29,10);
insert into ratings (rate,book_id,user_id) values (4,21,10);
insert into ratings (rate,book_id,user_id) values (3,43,10);
insert into ratings (rate,book_id,user_id) values (2,33,10);
insert into ratings (rate,book_id,user_id) values (1,40,10);
-- insert into users_table (name, surname, email, username, password, type) values ('asd', 'qwer', 'asdf', 'asd', 'asd', 'ADMIN');
