# points
java web service using spring boot

Points is a simple web service that handles HTTP requests for a user and returns responses based on the account.

In order to run points, you will need to install Java SE 16 (https://www.oracle.com/java/technologies/javase-jdk16-downloads.html). 

Sending HTTP messages can be done through Postman (https://www.postman.com/downloads/). The request URL must be set to localhost:8080/api/v1/transaction .

HTTP POST requests can be sent to add transactions to a user's account. A transaction takes three parameters: a payer, points, and a timestamp.
e.g. { "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }

A POST request can also be sent for a user to redeem points. 
e.g. { "points": 200 }

Finally, a PUT request can be made to view the user's remaining points. 
