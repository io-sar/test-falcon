# test-falcon

### Notes ###
* Build with gradle
* Check the postgresql usr and psw in case of change

### How To Start an Endpoint ###
* Run the application in local host : http://localhost:8080
* In the main form either press the link or type http://localhost:8080/add to chat with people
* In the main form either press the link or type http://localhost:8080/show to check the db with
* In the main form either press the link or type http://localhost:8080/jsonlist to check the json files returned from the db

### How To Chat ###
* Set up a name
* Connect to the server
* Write a message
* Press Send (Note. The server has 1 sec delay to make the message appear)

### Docker ###
* Build the app
* Move to the build/docker directory
* Run "docker-compose up -d"
##### note #####
I wasn't able to check the connection between the postgresql container and the app container because I was running the docker into a VM from my windows machine. The app currently does't work as intended from the docker machine since the "localhost" wont be mapped correctly.

### Future ###
* Missing tests
