# Log-Ingestor-and-Query-Interface
log ingestor system that can efficiently handle vast volumes of log data, and offer a simple interface for querying this data using full-text search or specific field filters.

# Getting Started
### Prerequisites
java 21
docker desktop
Intellij (Recommended) 
maven

### Steps to Run
* In the parent directory, run the below commands
* docker-compose up setup  (Take several minutes)
* docker-compose up -d (wait till both kibana and elastic search will start)
* ./mvnw spring-boot:run


Go to http://localhost:5601 and enter user credentials.
* username=elastic
* password=pass1234

Create index pattern in kibana by navigating to http://localhost:5601/app/management/kibana/dataViews
to create the view for the index by passing parameters.
name=ingest-log
pattern=ingest-logs*

The service will run on 3000 port. Call the post API by sending log data in request body.

Example request:

curl --location 'http://localhost:3000' \
--header 'Content-Type: application/json' \
--data '{
"level": "error",
"message": "Failed to connect to DB",
"resourceId": "server-1234",
"timestamp": "2023-02-18T12:00:00Z",
"traceId": "abc123",
"spanId": "span-xyz123",
"commit": "342ff",
"metadata": {
"parentResourceId": "server-5678"
}
}'


Go to kibana to discover http://localhost:5601/app/discover#
and change the index patterns or data view to ingest-log

You can query the data using filters in the discover page. 
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web)
* [Spring Data Elasticsearch (Access+Driver)](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#data.nosql.elasticsearch)
* [Kibana Discover](https://www.elastic.co/guide/en/kibana/current/document-explorer.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

