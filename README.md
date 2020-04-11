## Event Tracker Project

#### Week 12 Homework for Skill Distillery

### Overview
This project tracks a persons emotion throughout the day allowing them to log how they are feeling. This project is focused on creating RESTFUL Services and to demonstrate knowledge on the REST.

#### How to Use




### **Table of REST endpoints**
**HTTP Verb**| **URI**| **Request Body**|**Response Body**|**Purpose**|
--------|--------|--------|--------|--------|
**GET** | /api/trackers|       |Collection of all *tracker event entries* | **List** or **Collection** endpoint
**GET** | /api/trackers/{trackerId}| | Representation of entry at id number-- {trackerId}| **Retrieve** endpoint
**POST** | /api/trackers/{emotionId}| Representation of new *tracker event* entry| Description of the result of the operation| **Create** endpoint
**PUT** | api/trackers/{trackerId}| Representation of a *new version* of entry at id number--{trackerId}| | **Replace** endpoint
**DELETE** | api/trackers/{trackerId}| | | **Delete** route

### Technologies Used
- Gradle
- MySQL
- JPA
- JSON
- Java
- Spring Boot
- Spring REST
- RESTful API
- Postman

### Lessons Learned
- How to create a REST Project
- How to use Postman to test Endpoints
- REST Controller mapping
- JPA Repositories
- REST Service implementation
