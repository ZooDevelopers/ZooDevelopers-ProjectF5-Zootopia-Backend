
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO users (id_user, username, password) VALUES (default, 'admin', '$2a$12$BJ3/svgLxyn7cLcsPXYSteK4wSVYRncL9V7dYLpKSAIE40A6rs1a6');
INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);

INSERT INTO species (id, date_of_entry, family, gender, image_url, name, type)
VALUES 
-- Félidos (León, Tigre, Leopardo, etc...)
(default, '2021-03-15', 'FELIDOS', 'Masculino', 'https://example.com/images/lion.jpg', 'Lion', 'León'),
(default, '2021-03-16', 'FELIDOS', 'Femenino', 'https://example.com/images/tiger.jpg', 'Tiger', 'Tigre'),
(default, '2021-03-17', 'FELIDOS', 'Masculino', 'https://example.com/images/leopard.jpg', 'Leopard', 'Leopardo'),
(default, '2021-03-18', 'FELIDOS', 'Femenino', 'https://example.com/images/cheetah.jpg', 'Cheetah', 'Guepardo'),
(default, '2021-03-19', 'FELIDOS', 'Masculino', 'https://example.com/images/jaguar.jpg', 'Jaguar', 'Jaguar'),

-- Cánidos (Zorro, Lobos, Chacales, etc...)
(default, '2021-04-10', 'CANIDOS', 'Masculino', 'https://example.com/images/fox.jpg', 'Fox', 'Zorro'),
(default, '2021-04-11', 'CANIDOS', 'Femenino', 'https://example.com/images/wolf.jpg', 'Wolf', 'Lobo'),
(default, '2021-04-12', 'CANIDOS', 'Masculino', 'https://example.com/images/jackal.jpg', 'Jackal', 'Chacal'),
(default, '2021-04-13', 'CANIDOS', 'Femenino', 'https://example.com/images/coyote.jpg', 'Coyote', 'Coyote'),
(default, '2021-04-14', 'CANIDOS', 'Masculino', 'https://example.com/images/dog.jpg', 'Dog', 'Perro'),

-- Reptiles (Cocodrilos, Serpientes, Iguanas, etc...)
(default, '2021-05-05', 'REPTILES', 'Masculino', 'https://example.com/images/crocodile.jpg', 'Crocodile', 'Cocodrilo'),
(default, '2021-05-06', 'REPTILES', 'Femenino', 'https://example.com/images/snake.jpg', 'Snake', 'Serpiente'),
(default, '2021-05-07', 'REPTILES', 'Masculino', 'https://example.com/images/iguana.jpg', 'Iguana', 'Iguana'),
(default, '2021-05-08', 'REPTILES', 'Femenino', 'https://example.com/images/turtle.jpg', 'Turtle', 'Tortuga'),
(default, '2021-05-09', 'REPTILES', 'Masculino', 'https://example.com/images/lizard.jpg', 'Lizard', 'Lagarto'),

-- Mustélidos (Nutria, Comadrejas, Tejones, etc...)
(default, '2021-06-01', 'MUSTELIDS', 'Masculino', 'https://example.com/images/otter.jpg', 'Otter', 'Nutria'),
(default, '2021-06-02', 'MUSTELIDS', 'Femenino', 'https://example.com/images/weasel.jpg', 'Weasel', 'Comadreja'),
(default, '2021-06-03', 'MUSTELIDS', 'Masculino', 'https://example.com/images/badger.jpg', 'Badger', 'Tejón'),
(default, '2021-06-04', 'MUSTELIDS', 'Femenino', 'https://example.com/images/mink.jpg', 'Mink', 'Visón'),
(default, '2021-06-05', 'MUSTELIDS', 'Masculino', 'https://example.com/images/ferret.jpg', 'Ferret', 'Hurón'),

-- Lepóridos (Conejos y Liebres)
(default, '2021-07-10', 'LEPORIDAE', 'Femenino', 'https://example.com/images/bunny.jpg', 'Bunny', 'Conejo'),
(default, '2021-07-11', 'LEPORIDAE', 'Masculino', 'https://example.com/images/hare.jpg', 'Hare', 'Liebre'),
(default, '2021-07-12', 'LEPORIDAE', 'Femenino', 'https://example.com/images/rabbit.jpg', 'Rabbit', 'Conejo'),
(default, '2021-07-13', 'LEPORIDAE', 'Masculino', 'https://example.com/images/snowhare.jpg', 'Snow Hare', 'Liebre de la Nieve'),
(default, '2021-07-14', 'LEPORIDAE', 'Femenino', 'https://example.com/images/blackrabbit.jpg', 'Black Rabbit', 'Conejo Negro');
