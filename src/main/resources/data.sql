INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO users (id_user, username, password) VALUES (default, 'admin', '$2a$12$BJ3/svgLxyn7cLcsPXYSteK4wSVYRncL9V7dYLpKSAIE40A6rs1a6');
INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
