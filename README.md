To run:
* git submodules init
* build zipkin
    * bin/sbt update
* run zipkin
    * bin/collector
    * bin/query
    * bin/web
* build and run applications
* `curl http://localhost:8081/api/users/1`
* Go to http://localhost:8080 to view the traces
