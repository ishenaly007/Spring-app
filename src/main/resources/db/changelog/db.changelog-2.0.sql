--liquibase formatted sql

--changeset inarkozuev:1
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

--changeset inarkozuev:2
INSERT INTO users (username, birth_date, firstname, lastname, role, company_id)
VALUES ('userA@gmail.com', '1990-01-01', 'Alex', 'Smith', 'USER', 1),
       ('userB@gmail.com', '1991-02-02', 'Bob', 'Johnson', 'ADMIN', 2),
       ('userC@gmail.com', '1992-03-03', 'Charlie', 'Williams', 'MODERATOR', 3);


INSERT INTO product (name, description, color, type, price, image)
VALUES
    ('Smartphone', 'Latest 5G smartphone with 128GB storage', 'Black', 'ELECTRONICS', 599, ''),
    ('Headphones', 'Wireless noise-canceling headphones', 'White', 'ACCESSORIES', 199, ''),
    ('T-shirt', 'Cotton t-shirt with a minimalist design', 'Blue', 'CLOTHING', 25, ''),
    ('Laptop', 'Lightweight laptop with 16GB RAM and 512GB SSD', 'Silver', 'ELECTRONICS', 1200, ''),
    ('Watch', 'Smartwatch with fitness tracking features', 'Black', 'ACCESSORIES', 150, ''),
    ('Sneakers', 'Comfortable running sneakers', 'Red', 'CLOTHING', 75, ''),
    ('Backpack', 'Durable and water-resistant backpack', 'Green', 'ACCESSORIES', 50, ''),
    ('Camera', 'DSLR camera with 24MP resolution', 'Black', 'ELECTRONICS', 800, ''),
    ('Jacket', 'Waterproof jacket with thermal insulation', 'Yellow', 'CLOTHING', 120, ''),
    ('Tablet', '10-inch tablet with 64GB storage and stylus support', 'Gray', 'ELECTRONICS', 350, '');


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
