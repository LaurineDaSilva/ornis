DROP TABLE IF EXISTS birds;

CREATE TABLE birds(
    id SERIAL PRIMARY KEY,
    species_code VARCHAR(100) UNIQUE NOT NULL,
    scientific_name VARCHAR(100) UNIQUE NOT NULL,
    english_name VARCHAR(200) UNIQUE NOT NULL,
    french_name VARCHAR(200) UNIQUE NOT NULL
);