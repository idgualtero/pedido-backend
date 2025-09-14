# Informacion para la BD de Postgres

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

# Kubernetes Minikube

## Instalación de Minikube

### Paso 1: Instalar Minikube

```bash
choco install minikube

# O descargar desde: https://minikube.sigs.k8s.io/docs/start/
```

### Paso 2: Instalar kubectl (si no lo tienes)

```bash
choco install kubernetes-cli

# O descargar desde: https://kubernetes.io/docs/tasks/tools/install-kubectl-windows/
```

## Uso de Minikube con la Aplicación

### Paso 1: Iniciar Minikube

```bash

minikube start --driver=docker --memory=2048 --cpus=2
minikube status
```

### Paso 2: Revisar status pods y services

```bash
kubectl get pods
kubectl get services
```

### Paso 3: Acceder a la aplicación

```bash
minikube service pedido-app-backend --url
minikube service pedido-app-backend
```

### Paso 4: Ver logs

```bash
kubectl logs -f deployment/pedido-app-backend
kubectl exec -it <nombre-del-pod> -- /bin/bash
```

### Paso 5: Monitorear el escalado automático

```bash
kubectl get hpa
kubectl describe hpa pedido-app-backend
kubectl top pods
```

## Comandos útiles de Minikube

```bash
minikube stop
minikube start
minikube delete
minikube status
minikube service list
```

## Solución de problemas comunes

### Si la aplicación no responde:

```bash
kubectl get pods
kubectl logs deployment/pedido-app-backend
kubectl describe service pedido-app-backend
```

---

# Comandos usados para compilar y publicar en dockerhub

## Generar jar de la app

```
mvn clean package
```

## Constuir imagen

```
docker build -t idgualtero/pedido-backend:latest .
```

## Subir imagen a Dockerhub

```
docker push idgualtero/pedido-backend:latest
```

### Url del docker hub

https://hub.docker.com/repositories/idgualtero

# Comandos para genera helm

Empaquetar en la carpeta charts

## Acceder a la carpeta carts

```
cd charts
```

## Genera los archivos gtz de postgres que son dependencia

```
helm dependency update pedido-app
```

## genera el tgz de la aplicacion

```
helm package pedido-app
```

## Genera el index.yaml

```
helm repo index . --url https://idgualtero.github.io/helm-charts/charts
```

Los archivos index.yaml y pedido-app-0.1.0.tgz que se generaron se deben llevar al repo https://github.com/idgualtero/helm-charts en la rama gh-pages y dejarlos en la carpeta charts y versionar alla.

## Agregar al cluste de Helm

```
helm repo add pedido-app https://idgualtero.github.io/helm-charts/charts
```

```
helm repo update
```

## Si se quiere borrar algo de helm

```
helm repo remove pedido-app
```
