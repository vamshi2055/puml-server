# PlantUML Server

A Spring Boot application that provides a REST API for generating PlantUML diagrams. This server accepts PlantUML code and returns the generated diagram as a PNG image.

## Features

- REST API endpoint for generating PlantUML diagrams
- CORS enabled for frontend integration
- PNG image output
- Spring Boot 3.2.3
- Java 17

## Prerequisites

- Java 17 or higher
- Maven 3.9.x or higher

## Getting Started

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd puml-server
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The server will start on `http://localhost:8080`.

## API Usage

### Generate Diagram

**Endpoint:** `POST /api/puml/generate`

**Content-Type:** `text/plain`

**Request Body:** PlantUML code

**Response:** PNG image

**Example using curl:**
```bash
curl -X POST \
  -H "Content-Type: text/plain" \
  --data-binary "@startuml
Alice -> Bob: Hello
Bob --> Alice: Hi there
@enduml" \
  http://localhost:8080/api/puml/generate \
  --output diagram.png
```

**Example using JavaScript/Fetch:**
```javascript
const plantUmlCode = `@startuml
Alice -> Bob: Hello
Bob --> Alice: Hi there
@enduml`;

fetch('http://localhost:8080/api/puml/generate', {
  method: 'POST',
  headers: {
    'Content-Type': 'text/plain',
  },
  body: plantUmlCode
})
.then(response => response.blob())
.then(blob => {
  const url = window.URL.createObjectURL(blob);
  const img = document.createElement('img');
  img.src = url;
  document.body.appendChild(img);
});
```

## Project Structure

```
src/main/java/com/example/pumlserver/
├── PumlServerApplication.java    # Main application class
├── config/
│   └── WebConfig.java           # CORS configuration
├── controller/
│   └── PlantUmlController.java  # REST API endpoints
└── service/
    └── PlantUmlService.java     # PlantUML diagram generation logic
```

## Dependencies

- Spring Boot Web
- PlantUML (version 1.2024.3)
- Spring Boot Test (for testing)

## Configuration

The application can be configured through `src/main/resources/application.properties`:

```properties
server.port=8080
spring.application.name=puml-server
```

## CORS Configuration

The server is configured to accept requests from any origin with credentials. This can be modified in `WebConfig.java` if you need to restrict access to specific origins.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 