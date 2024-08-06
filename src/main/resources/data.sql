



/* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');

-- /* Users */
-- INSERT INTO users (id_user, username, password) VALUES (default, 'admin', '');


-- /* Profiles */
-- -- INSERT INTO profiles (id_profile, email, address, user_id, country_id) VALUES (default, 'pepe@mail.com', 'portal 1', 1, 2);
-- -- INSERT INTO profiles (id_profile,email, address, user_id) VALUES (default,'pepe@mail.com', 'portal 1', 1);
-- INSERT INTO profiles (id_profile,email, address, user_id) VALUES (default,'pepe@mail.com', 'portal 1',1,2);


INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
