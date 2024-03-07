SET CLIENT_ENCODING TO 'UTF-8';

DROP TABLE IF EXISTS birds;
DROP TABLE IF EXISTS user_accounts;

CREATE TABLE birds (
    id SERIAL PRIMARY KEY,
    scientific_name VARCHAR(100) UNIQUE NOT NULL,
    common_name VARCHAR(200) UNIQUE NOT NULL,
    image_name VARCHAR(41) UNIQUE NOT NULL,
    description VARCHAR(5000)
);

CREATE TABLE user_accounts (
    id SERIAL PRIMARY KEY, 
    email_address VARCHAR(100) UNIQUE NOT NULL, 
    nickname VARCHAR(20) UNIQUE NOT NULL, 
    password VARCHAR(60), 
    role VARCHAR(11)
);

