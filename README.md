```
podman run --name test --rm -p 3306:3306 -e MYSQL_USER=test -e MYSQL_PASSWORD=test -e MYSQL_DATABASE=test -e MYSQL_ROOT_PASSWORD=root -dit registry.redhat.io/rhel8/mysql-80:latest

podman run --name foo --rm -p 8161:8161 -p 61616:61616 -dit -e AMQ_USER=user -e AMQ_PASSWORD=password registry.redhat.io/amq7/amq-broker:latest

podman exec -it foo /bin/bash
mysql
create table foo (id serial primary key, value varchar(1000));
quit

mvn clean package

java -jar target/spring-boot-jms-sql-xsl-test-0.1.0-SNAPSHOT.jar
```