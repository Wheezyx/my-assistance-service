INSERT INTO USERS(ID, USERNAME, FIRST_NAME, LAST_NAME, POINTS) VALUES
(1, 'antek', 'Antek', 'Kowalski', 16),
(2, 'Mario', 'Marek', 'Kowalekowk', 0);

INSERT INTO ASSISTANCE(ID, ASSISTANCE_STATUS, DISABILITY_TYPE, HELP_TYPE, LATITUDE, LONGITUDE, ASSISTANT, CREATOR) VALUES
(1, 'ACTIVE', null, 'Mam złamaną nogę, mieszkam na 4 piętrzę i potrzebuję się dostać do szpitala', '52.216902', '20.980143', null, 1),
(2, 'ACTIVE', null, 'Potrzebuję kogoś kto przywiezie mnie 30.11.2019 o godzinie 17:00 swoim samochodem z centrum onkologii', '52.214577', '20.984039', null, 1),
(3, 'ACTIVE', null, 'Szukam kogoś kto 26.11.2019 zrobi mi zakupy i spędzi ze mną trochę czasu', '52.197444', '21.007443', null, 1),
(4, 'ACTIVE', null, 'Witam, poszukuję osoby która pomoże mi w posprzątaniu mieszkania', '52.283405', '21.030151', null, 1),
(5, 'ACTIVE', null, 'Szukam osoby która zabierze mnie na spacer', '52.288087', '21.033464', null, 1);