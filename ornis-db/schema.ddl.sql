SET CLIENT_ENCODING TO 'UTF8';

DROP TABLE IF EXISTS t_birds_colors;
DROP TABLE IF EXISTS t_birds;
DROP TABLE IF EXISTS t_colors;
DROP TABLE IF EXISTS t_beak_shapes;
DROP TABLE IF EXISTS t_feet_shapes;
DROP TABLE IF EXISTS t_sizes;

DROP TABLE IF EXISTS t_user_accounts;

CREATE TABLE t_colors (
    id SERIAL PRIMARY KEY, 
    rgb_code CHAR(6) UNIQUE NOT NULL,
    name VARCHAR(100) UNIQUE NOT NULL
);

create TABLE t_beak_shapes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL,
    image VARCHAR(41) UNIQUE 
);

create TABLE t_feet_shapes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE,
    image VARCHAR(41) UNIQUE 
);

create TABLE t_sizes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE
);

CREATE TABLE t_birds (
    id SERIAL PRIMARY KEY,
    scientific_name VARCHAR(100) UNIQUE NOT NULL,
    common_name VARCHAR(200) UNIQUE NOT NULL,
    image VARCHAR(41) UNIQUE NOT NULL,
    beak_shape_id INTEGER,
    feet_shape_id INTEGER,
    size_id INTEGER,
    xeno_id NUMERIC(6) UNIQUE,
    description VARCHAR(5000),
    FOREIGN KEY (beak_shape_id) REFERENCES t_beak_shapes(id),
    FOREIGN KEY (feet_shape_id) REFERENCES t_feet_shapes(id),
    FOREIGN KEY (size_id) REFERENCES t_sizes(id)
);

CREATE TABLE t_birds_colors (
    id SERIAL NOT NULL PRIMARY KEY,
    bird_id INTEGER,
    color_id INTEGER,
    UNIQUE (bird_id, color_id),
    FOREIGN KEY (bird_id) REFERENCES t_birds(id),
    FOREIGN KEY (color_id) REFERENCES t_colors(id)
);

CREATE TABLE t_user_accounts (
    id SERIAL PRIMARY KEY, 
    email_address VARCHAR(100) UNIQUE NOT NULL, 
    username VARCHAR(20) UNIQUE NOT NULL, 
    password CHAR(60), 
    role VARCHAR(11)
);



