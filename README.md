## Getting started
```
git submodules init
```
```
pushd users && mvn clean verify
```
```
pushd recommendations && mvn clean verify
```
```
pushd zipkin && bin/sbt update
```
```
pushd zipkin && bin/collector
```
```
pushd zipkin && bin/query
```
```
pushd zipkin && bin/web
```

## Running
Delete `zipkin/zipkin.db` to clear out existing data
```
mysql.server start
```
```
java -jar users/target/users-service-0.0.1-SNAPSHOT.jar -Dserver.port=8081
```
```
java -jar recommendations/target/recommendations-service-0.0.1-SNAPSHOT.jar -Dserver.port=8082
```
```
bin/collector
```
```
bin/query
```
```
bin/web
```
```
curl http://localhost:8081/api/users/1
```
Go to http://localhost:8080 to view the traces
