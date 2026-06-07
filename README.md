# Jenkins-Nexus CI/CD Pipeline Project

A complete, production-ready CI/CD pipeline demonstrating automated building, testing, quality analysis, and artifact management.

## 📋 Project Overview

This project implements a full CI/CD workflow:
```
Git Repository 
    ↓ (commit/push)
Jenkins (automated build trigger)
    ↓ 
Maven (build & compile)
    ↓
Unit Tests (JUnit 5)
    ↓
SonarQube (code quality analysis)
    ↓
Nexus (artifact repository storage)
    ↓
✅ Artifact Available for Deployment
```

## 🛠️ Technology Stack

| Component | Version | Purpose |
|-----------|---------|---------|
| **Java** | 21 LTS | Application runtime |
| **Spring Boot** | 3.2.0 | REST API framework |
| **Maven** | 3.9.11 | Build tool |
| **Jenkins** | 2.x | CI/CD automation |
| **Nexus** | 3.x | Artifact repository |
| **SonarQube** | 9.x+ | Code quality analysis |
| **Git** | 2.51.0 | Version control |

## 📁 Project Structure

```
jenkins-nexus-cicd/
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   ├── Application.java          (Main entry point)
│   │   │   └── controller/
│   │   │       └── HelloController.java  (REST endpoints)
│   │   └── resources/
│   │       └── application.properties    (Configuration)
│   └── test/
│       └── java/com/example/controller/
│           └── HelloControllerTest.java  (Unit tests)
├── pom.xml                                (Maven configuration)
├── Jenkinsfile                            (Pipeline definition)
├── sonar-project.properties               (SonarQube config)
├── .gitignore                             (Git ignore rules)
└── README.md                              (This file)
```

## 🚀 Quick Start

### Prerequisites
- Java 21 LTS
- Maven 3.9.11
- Git 2.51+

### Local Build & Test

```bash
# Clone the repository
git clone <your-repo-url>
cd jenkins-nexus-cicd

# Build the application
mvn clean install

# Run tests
mvn test

# Run the application locally
mvn spring-boot:run
```

### Test the API Locally

Once running on `http://localhost:8080/api`:

```bash
# Health check
curl http://localhost:8080/api/health

# Hello endpoint
curl http://localhost:8080/api/hello/YourName

# Version info
curl http://localhost:8080/api/version
```

## 🔄 CI/CD Pipeline Stages

### 1. **Checkout** (Git Stage)
- Clones repository from GitHub
- Checks out the specific branch

### 2. **Build** (Maven Stage)
- `mvn clean compile`
- Compiles all Java source code
- Downloads dependencies

### 3. **Test** (Maven Test Stage)
- `mvn test`
- Runs all JUnit 5 tests
- Generates test reports

### 4. **Code Quality** (SonarQube Stage)
- `mvn sonar:sonar`
- Analyzes code quality
- Applies quality gates
- Fails build if threshold not met

### 5. **Build Artifact** (Maven Package Stage)
- `mvn package`
- Creates executable JAR file
- Prepares for deployment

### 6. **Deploy to Nexus** (Maven Deploy Stage)
- `mvn deploy`
- Pushes artifact to Nexus repository
- Stores for future deployments

## 📊 REST API Endpoints

### Health Check
```
GET /api/health
Response: {"status": "UP", "message": "Application is healthy"}
```

### Hello Endpoint
```
GET /api/hello/{name}
Response: {"message": "Hello, {name}! Welcome to Jenkins-Nexus CI/CD Pipeline"}
```

### Version Information
```
GET /api/version
Response: {"version": "1.0.0", "buildTime": 1234567890}
```

## 🔐 Configuration Files

### `pom.xml`
- Maven configuration
- Dependencies (Spring Boot, JUnit 5)
- Build plugins
- Nexus repository URLs & credentials

### `application.properties`
- Server port: 8080
- Context path: /api
- Logging configuration
- Application metadata

### `.gitignore`
- Excludes Maven `target/` directory
- Excludes IDE files (.idea/, .vscode/)
- Excludes OS-specific files

## 📝 Jenkins Jenkinsfile (To be added)

Complete pipeline definition with all stages, error handling, and notifications.

## 🧪 Testing

All tests are located in `src/test/java/`:

Run tests:
```bash
mvn test
```

View test reports:
```
target/surefire-reports/
```

## 📦 Artifact Management

Artifacts are stored in Nexus at:
```
Release Repository: http://localhost:8081/nexus/content/repositories/releases/
Snapshot Repository: http://localhost:8081/nexus/content/repositories/snapshots/
```

Artifact coordinates:
```
groupId: com.example
artifactId: jenkins-nexus-app
version: 1.0.0
```

## 🎓 Learning Outcomes

By completing this project, you'll understand:
- ✅ Git workflow & GitHub collaboration
- ✅ Maven build lifecycle (clean, compile, test, package, deploy)
- ✅ Jenkins pipeline automation (stages, triggers, artifacts)
- ✅ Nexus repository management (snapshots, releases)
- ✅ SonarQube code quality analysis
- ✅ Spring Boot REST API development
- ✅ Unit testing with JUnit 5 & Mockito
- ✅ CI/CD best practices

## 🤝 Contributing

1. Create a feature branch: `git checkout -b feature/your-feature`
2. Commit changes: `git commit -m "Add feature description"`
3. Push to branch: `git push origin feature/your-feature`
4. Create Pull Request

## 📚 Next Steps

1. Set up GitHub repository
2. Configure Jenkins with this repo
3. Install & configure Nexus
4. Set up SonarQube
5. Create Jenkinsfile for pipeline
6. Test end-to-end flow

## 📞 Support

For issues or questions, refer to:
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Maven Documentation](https://maven.apache.org/)
- [Jenkins Pipeline](https://www.jenkins.io/doc/book/pipeline/)
- [Nexus Documentation](https://help.sonatype.com/)

---

**Project Version**: 1.0.0  
**Last Updated**: April 2026  
**Author**: Your Name  
**Status**: Learning Project
