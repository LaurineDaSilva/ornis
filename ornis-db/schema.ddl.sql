SET CLIENT_ENCODING TO 'UTF-8';

DROP TABLE IF EXISTS birds;
DROP TABLE IF EXISTS english_messages;
DROP TABLE IF EXISTS french_messages;

CREATE TABLE english_messages (
    id SERIAL PRIMARY KEY,
    species_code VARCHAR(100) UNIQUE NOT NULL,
    common_name VARCHAR(200) UNIQUE NOT NULL
);

CREATE TABLE french_messages (
    id SERIAL PRIMARY KEY,
    species_code VARCHAR(100) UNIQUE NOT NULL,
    common_name VARCHAR(200) UNIQUE NOT NULL
);

CREATE TABLE birds (
    id SERIAL PRIMARY KEY,
    species_code VARCHAR(100) UNIQUE NOT NULL,
    scientific_name VARCHAR(100) UNIQUE NOT NULL,
    common_name VARCHAR(200)
);