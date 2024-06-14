# Spring Boot Kubernetes and MySQL

Sample project to test and deploy spring boot application with mysql database in kubernetes.

## Prerequisite

- Docker with kubernetes enabled
- Kubernetes command-line tool(kubectl)
- JDK 21 LTS
- Gradle 8

## Start application

- Create secrets and start mysql database

```sh
kubectl apply -f deployment/secrets.yaml
kubectl apply -f deployment/mysql-deployment.yaml

```

- Build application and deploy in kubernetes

```sh
gradle clean dockerTag
kubectl apply -f deployment/app-k8s.yaml

```

- Test application :

```curl
curl -X GET \
  http://localhost:31371/api/v1/pets \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json'
  
```

Response should be :

```json
[
  {
    "name": "Puffball",
    "owner": "Diane",
    "species": "hamster",
    "sex": "f",
    "birth": "1999-03-30",
    "death": null
  }
]
```

### Delete deployment, service, secret and pvc

```sh
kubectl delete -f deployment/app-k8s.yaml
kubectl delete -f deployment/mysql-deployment.yaml
kubectl delete -f deployment/secrets.yaml

```
### Reference

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Gradle Docker image build plugin](https://plugins.gradle.org/plugin/com.palantir.docker)
- [OpenJDK Docker](https://hub.docker.com/_/openjdk)
- [MySQL Docker](https://hub.docker.com/_/mysql)