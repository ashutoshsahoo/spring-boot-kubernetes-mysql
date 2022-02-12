# Spring Boot Kubernetes and MySQL

Sample project to test and deploy spring boot application with mysql database in kubernetes using JKube maven plugin.

## Prerequisite

- Docker with kubernetes enabled
- Kubernetes command-line tool(kubectl)
- JDK 17 LTS
- Maven

## Start application

- Create secrets and start mysql database

```sh
kubectl create -f deployment/secrets.yaml
kubectl create -f deployment/mysql-deployment.yaml
```

- Build application and deploy in kubernetes

```sh
mvn clean package
mvn k8s:build k8s:resource k8s:apply
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
mvn k8s:undeploy
kubectl delete -f deployment/mysql-deployment.yaml
kubectl delete -f deployment/secrets.yaml
```
### Reference

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Eclipse JKube](https://github.com/eclipse/jkube)
- [OpenJDK Docker](https://hub.docker.com/_/openjdk)
- [MySQL Docker](https://hub.docker.com/_/mysql)