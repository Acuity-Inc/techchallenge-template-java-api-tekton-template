# techchallenge-template-java-api

## Getting Started
### Prerequisites
- Java 17 or higher
- Maven
- IDE
  - Developed using IntelliJ Community Edition
### How to contribute to Acuity Repos
- Please follow branch naming conventions described in [Development Best Practices](https://acuity-inc.atlassian.net/wiki/spaces/TCS1/pages/1993113601/Development+Best+Practices)
- Commit conventions as described in [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/#summary)

## Running the Application
In IntelliJ:
- Under File > Project Structure, select the Project Settings > Project section
  - Set the SDK to Amazon Corretto 17 (IntelliJ may help download it.)
- Right-click SpringbootTemplateApplication and click 'Run' (the green play button.)

## Testing the Application
#### Command
```
mvn test
```
### Running Checkstyle
#### Command
```
mvn checkstyle:checkstyle
```

## Application Features
### CRUD Endpoints
| URL                                | Request Type |                               Description |
|:-----------------------------------|:------------:|------------------------------------------:|
| http://localhost:8080/parents      |     GET      |          retrieve list of Parent entities |
| http://localhost:8080/parents/{id} |     GET      |       retrieve Parent entity by ID (UUID) |
| http://localhost:8080/parents      |     PUT      |       update Parent entity with new input |
| http://localhost:8080/parents/{id} |    DELETE    |                delete Parent entity by ID |
| http://localhost:8080/parents      |     POST     | create Parent entity JSON payload in Body |

A Postman collection is included under /src/test/ that will call each of the above endpoints. Endpoints are secured with
JWT tokens from the template projects Okta provider. In the requests, replace the Bearer token (dummy text 
***YOUR_JWT_HERE***) with your own.

### Actuator Endpoints
| URL                                   | Request Type |                           Description |
|:--------------------------------------|:------------:|--------------------------------------:|
| http://localhost:8080/actuator        |     GET      | discovery page for actuator endpoints |
| http://localhost:8080/actuator/health |     GET      |         health status for running app |

The endpoints set above are turned on by default, based on the documentation for 
[Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html). In the
application.yaml the health endpoint is set to show all available autoconfigured health indicators, with the
`management.endpoint.health.show-components` setting.
Calls to the above endpoints are also in the Postman collection included in the repo.

### Mock Data
On start-up, the application creates two Parent entities (using the MockData.java Component,) which can be retrieved 
from the list endpoint, or retrieved
or changed by ID in the other endpoints.

### Security
The Okta TechChallengeTemplate application token issuer URL is set in the application.yaml under okta.issuer_url. This
should be replaced with your own Okta app URL when implementing this template.

### Swagger UI
When the application is running, Swagger UI is available at the 
[default URL](http://localhost:8080/swagger-ui/index.html). The OpenAPI documentation is also available at the 
[default URL](http://localhost:8080/v3/api-docs).

## Development Design Practices
Leveraging spring-boot-starter-data-rest we are able to provide full CRUD without writing out controllers & services.
Okta Oath2.0 is integrated to provide security across all endpoints of the API.