# VotingSystem

This is an API for a cooperative voting system deployed into AWS Elastic Beanstalk. 
The idea of the project is to develop a system that is able to:
- Create a matter/subject;
- Delete a matter/subject;
- List all matters/subjects;
- Pick a specific matter/subject;
- Enable associates to vote (yes/no) on a specific matter. 

## Backend functioning AWS deploy

![desafio técnico v1 backend](https://user-images.githubusercontent.com/108681887/218222062-c112ba2b-23f3-4643-8642-3b9ab1c76833.gif)


## Database scheme

![image](https://user-images.githubusercontent.com/108681887/217982504-93ee7c2e-a55c-4809-b665-23b8b2722377.png)

## Swagger

Application overview

[image]

Matter controller: used for creating matters, listing all of them, picking or deleting a specific one.

[image] 

Vote controller: used for voting on a specific matter/subject.

[image]

## Use examples

Creating a matter/subject

![image](https://user-images.githubusercontent.com/108681887/218221613-4ed5c766-c4fc-4e5b-901a-580810b89c72.png)

Listing all matters

![image](https://user-images.githubusercontent.com/108681887/218221773-8f083a4c-752a-4348-ae3f-10e73cac7d08.png)

Voting on a specific matter

![image](https://user-images.githubusercontent.com/108681887/218221815-1e3d8260-4976-49b9-8811-0a7b62cfe6db.png)

## Frontend rendering

This is the initial idea for a frontend using Angular, but it's still in development

![desafio técnico v1 frontend](https://user-images.githubusercontent.com/108681887/218221229-12daf12f-034b-4466-8a44-1bdd814efd00.gif)

## Observations
There are a lot of development features that I'm planning to include in the next weeks, such as:
- An algorithm to enable specific voters to vote online once;
- Creating a session to compute and count votes. It should accept votes only during a specified amount of time and announce the result.
- Document the API using swagger;
- A fully functioning frontend using Angular;
- Unit testing (JUnit);
- RabbitMQ messaging.




