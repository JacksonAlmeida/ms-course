INSERT INTO TB_ROLE(ROLE_NAME) VALUES ('ADMIN');
INSERT INTO TB_ROLE(ROLE_NAME) VALUES ('OPERATOR');
INSERT INTO TB_USER(EMAIL, NAME, PASSWORD) VALUES ('jackson.rodrigues@gmail.com', 'Jackson Almeida Rodrigues', 'qwertyuiolkjhg$kxyv\baaaa,poefij');
INSERT INTO TB_USER(EMAIL, NAME, PASSWORD) VALUES ('elisama.melo@gmail.com', 'Elisama Marques Melo', 'dftsgyhuejifk,srofjtgihtgihtdio,gud,');
INSERT INTO TB_USER_ROLE(USER_ID, ROLE_ID) VALUES (1,1);
INSERT INTO TB_USER_ROLE(USER_ID, ROLE_ID) VALUES (1,2);
INSERT INTO TB_USER_ROLE(USER_ID, ROLE_ID) VALUES (2,2);