DROP TABLE IF EXISTS birds;

CREATE TABLE birds(
    id SERIAL PRIMARY KEY,
    vernacular_name VARCHAR(100) UNIQUE NOT NULL,
    scientific_name VARCHAR(100) UNIQUE NOT NULL,
    image_url VARCHAR(300)
);