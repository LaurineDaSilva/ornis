SET CLIENT_ENCODING TO 'UTF-8';

DROP TABLE IF EXISTS birds;
DROP TABLE IF EXISTS user_accounts;

CREATE TABLE birds (
    id SERIAL PRIMARY KEY,
    species_code VARCHAR(100) UNIQUE NOT NULL,
    scientific_name VARCHAR(100) UNIQUE NOT NULL,
    common_name VARCHAR(200) UNIQUE NOT NULL,
    description VARCHAR(5000) 
);

CREATE TABLE user_accounts (
    id SERIAL PRIMARY KEY, 
    email_address VARCHAR(100) UNIQUE NOT NULL, 
    nickname VARCHAR(20) UNIQUE NOT NULL, 
    password VARCHAR(42), 
    roles VARCHAR(11)
);