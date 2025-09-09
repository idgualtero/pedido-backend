
Informacion para la BD de Postgres

CREATE DATABASE pedidos;
CREATE USER admin WITH PASSWORD 'supersecret';
GRANT ALL PRIVILEGES ON DATABASE pedidos TO admin
GRANT ALL PRIVILEGES ON TABLE pedido TO admin
GRANT USAGE, SELECT ON SEQUENCE pedido_id_seq TO admin;

CREATE TABLE pedido (
    id SERIAL PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    monto NUMERIC(10, 2) NOT NULL
);
