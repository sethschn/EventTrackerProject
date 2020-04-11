## Event Tracker Project

#### Week 12 Homework for Skill Distillery

### Overview
This project tracks a persons emotion throughout the day allowing them to log how they are feeling.

#### How to Use
#### Table of REST Endpoints
| Return Type     | Route                           | Functionality                            |
|-----------------|---------------------------------|------------------------------------------|
| `List<Tracker>` |`GET api/trackers`               | Gets all logged Tracker events           |
| `Tracker`       |`GET api/tracker/{trackerId}`    | Gets one event from tracker by id        |
| `Tracker`       |`POST api/trackers/{emotionId}`  | Creates a new entry in the tracker table |
| `Tracker`       |`PUT api/trackers/{trackerId}`   | Replaces an existing tracker event by id |
| `Boolean`       |`DELETE api/trackers/{trackerId}`| Deletes an existing tracker event by id  |

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
