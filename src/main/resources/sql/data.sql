INSERT INTO company (name)
VALUES ('Company A'),
       ('Company B'),
       ('Company C');

INSERT INTO company_locales (company_id, lang, description)
VALUES (1, 'en', 'English Description for Company A'),
       (1, 'ru', 'Русское описание для Company A'),
       (2, 'en', 'English Description for Company B'),
       (2, 'ru', 'Русское описание для Company B'),
       (3, 'en', 'English Description for Company C'),
       (3, 'ru', 'Русское описание для Company C');


INSERT INTO users (username, birth_date, firstname, lastname, role, company_id)
VALUES ('userA', '1990-01-01', 'Alex', 'Smith', 'user', 1),
       ('userB', '1991-02-02', 'Bob', 'Johnson', 'admin', 2),
       ('userC', '1992-03-03', 'Charlie', 'Williams', 'moderator', 3);


INSERT INTO payment (amount, receiver_id)
VALUES (500, 1),
       (300, 2),
       (700, 3);


INSERT INTO chat (name)
VALUES ('Chat A'),
       ('Chat B'),
       ('Chat C');


INSERT INTO users_chat (user_id, chat_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (1, 3),
       (2, 1),
       (3, 2);