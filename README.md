# VotingSystem

This is an API for a cooperative voting system. 
The idea of the project is to develop a system that is able to:
- Create a matter/subject;
- Delete a matter/subject;
- List all matters/subjects;
- Pick a specific matter/subject;
- Enable associates to vote (yes/no) on a specific matter. 

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

[image]

Listing all matters

[image]

Voting on a specific matter

[image]

## Frontend rendering

This is the initial idea for a frontend using Angular, but it's still in development

[image]

## Observations
There are a lot of development features that I'm planning to include in the next weeks, such as:
- An algorithm to enable specific voters to vote online once;
- Creating a session to compute and count votes. It should accept votes only during a specified amount of time and announce the result. 
- A fully functioning frontend using Angular;
- Unit testing (JUnit);
- RabbitMQ messaging.




