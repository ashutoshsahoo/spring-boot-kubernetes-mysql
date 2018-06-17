## Spring-Boot-Kubernetes-MySQL

Sample project to use spring boot application with mysql database in kubernetes with fabric8 maven plugin.


- Start mysql database

```sh

$ kubectl create -f deployment/mysql-deployment.yaml

```

- Connect to mysql database

```sh
$ kubectl run -it --rm --image=mysql:5.7 --restart=Never mysql-client -- mysql -h mysql -ppassword
```
- Create table and insert some records
 
```sql
mysql> GRANT ALL PRIVILEGES ON test.* To 'testuser'@'%' IDENTIFIED BY 'test123'; 
mysql> FLUSH PRIVILEGES;

mysql> use test;
mysql> CREATE TABLE pet (name VARCHAR(20), owner VARCHAR(20), species VARCHAR(20), sex CHAR(1), birth DATE, death DATE);
mysql> INSERT INTO pet VALUES ('Puffball','Diane','hamster','f','1999-03-30',NULL);

```

- Build application and deploy in kubernetes

```sh
$ mvn clean package

$ mvn fabric8:build fabric8:resource fabric8:deploy

```

- Test application :

```curl
curl -X GET \
  http://127.0.0.1:8080/api/pets \
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