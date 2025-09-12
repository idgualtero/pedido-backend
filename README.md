
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


Comandos usados para compilar y publicar en dockerhub
mvn clean package
docker build -t idgualtero/pedido-backend:latest .
docker push idgualtero/pedido-backend:latest

Comandos para genera helm

Empaquetar en la carpeta charts
cd charts
helm package pedido-app
Se generar archivos index.yaml y pedido-app-0.1.0.tgz que se deben llevar al repo https://github.com/idgualtero/helm-charts rama gh-pages y versionar alla.


Indexar
helm repo index . --url https://idgualtero.github.io/helm-charts/charts

Agregar al cluste de Helm

helm repo add pedido-app https://idgualtero.github.io/helm-charts/charts
helm repo update