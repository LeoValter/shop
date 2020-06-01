DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS products;
DROP SEQUENCE IF EXISTS global_sequence;

CREATE SEQUENCE global_sequence START WITH 1000;

CREATE TABLE users
(
    id          INTEGER     PRIMARY KEY DEFAULT nextval('global_sequence'),
    name        VARCHAR     NOT NULL,
    password    VARCHAR     NOT NULL,
    email       VARCHAR     NOT NULL,
    enabled     BOOLEAN     DEFAULT TRUE NOT NULL,
    registered  TIMESTAMP   DEFAULT now()
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE products
(
    id          INTEGER     PRIMARY KEY DEFAULT nextval('global_sequence'),
    name        VARCHAR     NOT NULL,
    description VARCHAR     NOT NULL,
    price       DOUBLE PRECISION NOT NULL,
    weight      DOUBLE PRECISION NOT NULL
);