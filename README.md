SMS Sender Service

SMS Sender Service is a Spring Boot microservice responsible for receiving SMS requests, validating blocked users through Redis, simulating communication with a third-party SMS vendor, and publishing SMS events to Kafka for downstream processing.

This service serves as the entry point for the SMS platform and communicates asynchronously with the SMS Store Service through Kafka.




Basic Setup to run the project
1. Start the redis server
2. Go the project directory and start the docker desktop
3. (make sure kafka is running ) result of operation 2
4. run the springboot application


Author

Niku Raj

Spring Boot | Distributed Systems | Backend Development | Kafka | Redis | Go | MongoDB
