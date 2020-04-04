## Spring Boot Kubernetes and MySQL

Sample project to test and deploy spring boot application with mysql database in kubernetes using fabric8 maven plugin.

### Prerequisite :
- Docker with kubernetes enabled
- Kubernetes command-line tool(kubectl)
- Java
- Maven

### Start application:

- Start mysql database

```sh

$ kubectl create -f deployment/mysql-deployment.yaml

```

- Build application and deploy in kubernetes

```sh
$ mvn clean package

$ mvn -DskipTests fabric8:build fabric8:resource fabric8:deploy

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

#### Delete deployment, service, secret and pvc.

```sh

$ mvn fabric8:undeploy

$ kubectl delete -f deployment/mysql-deployment.yaml

```