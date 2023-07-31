DROP TABLE IF EXISTS birds;
DROP TABLE IF EXISTS english_messages;
DROP TABLE IF EXISTS french_messages;

CREATE TABLE english_messages (
    id SERIAL PRIMARY KEY,
    species_code VARCHAR(100) UNIQUE NOT NULL,
    english_name VARCHAR(200) UNIQUE NOT NULL
);

CREATE TABLE french_messages (
    id SERIAL PRIMARY KEY,
    species_code VARCHAR(100) UNIQUE NOT NULL,
    french_name VARCHAR(200) UNIQUE NOT NULL
);

CREATE TABLE birds (
    id SERIAL PRIMARY KEY,
    species_code VARCHAR(100) UNIQUE NOT NULL,
    scientific_name VARCHAR(100) UNIQUE NOT NULL
);