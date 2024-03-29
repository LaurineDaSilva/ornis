SET CLIENT_ENCODING TO 'UTF-8';

DROP TABLE IF EXISTS birds_colors;
DROP TABLE IF EXISTS birds;
DROP TABLE IF EXISTS colors;

DROP TABLE IF EXISTS user_accounts;

CREATE TABLE colors (
    id SERIAL PRIMARY KEY, 
    rgb_code VARCHAR(6) UNIQUE NOT NULL,
    color_name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE birds (
    id SERIAL PRIMARY KEY,
    scientific_name VARCHAR(100) UNIQUE NOT NULL,
    common_name VARCHAR(200) UNIQUE NOT NULL,
    image_name VARCHAR(41) UNIQUE NOT NULL,
    xeno_id NUMERIC(6) UNIQUE,
    description VARCHAR(5000)
);

CREATE TABLE birds_colors (
    bird_id INTEGER,
    color_id INTEGER,
    PRIMARY KEY (bird_id, color_id),
    FOREIGN KEY (bird_id) REFERENCES birds(id),
    FOREIGN KEY (color_id) REFERENCES colors(id)
);

CREATE TABLE user_accounts (
    id SERIAL PRIMARY KEY, 
    email_address VARCHAR(100) UNIQUE NOT NULL, 
    nickname VARCHAR(20) UNIQUE NOT NULL, 
    password VARCHAR(60), 
    role VARCHAR(11)
);



