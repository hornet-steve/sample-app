## Build and Deploy
#### Build and Run Locally (Development)
Use the following to run the application on your host. This might be useful for development purposes:

`./gradlew clean test assemble && java -jar build/libs/sample-app-1.0-SNAPSHOT.jar`

#### Build Docker Image
Use the following to build a local Docker image with this application:

`./gradlew buildDockerImage`

Once completed, you should be able to see that your image was built by using:

`docker images`

It should produce something like the following:

`com.hornetdevelopment.sample/sample-app latest 56400fe3e2db 2 seconds ago 673 MB`

To start a container running the sample-app application:

`docker run -p 8080:8080 -t com.hornetdevelopment.sample/sample-app`

## REST API Request Examples

- Check Application Status
    - ```
        curl --request GET --url http://localhost:8080/
      ```
    
- Create Greeting
    - ```
        curl --request POST \
           --url http://localhost:8080/greetings \
           --header 'content-type: application/json' \
           --data '{
            "name": "Jon Doe",
            "greeting": "This is a greeting"
         }'
      ```
      
- List Greetings
    - ```
        curl --request GET \
           --url http://localhost:8080/greetings
      ```
      
- Get Greeting By Id
    - ```
        curl --request GET \
           --url http://localhost:8080/greetings/<GREETING_ID_GUID>
      ```
      
- Update Greeting
    - ```
        curl --request PUT \
           --url http://localhost:8080/greetings/<GREETING_ID_GUID> \
           --header 'content-type: application/json' \
           --data '{
        	 "name": "Jane Swanson",
        	 "greeting": "This is an updated greeting"
         }'
      ```
      
- Delete Greeting
    - ```
        curl --request DELETE \
           --url http://localhost:8080/greetings/<GREETING_ID_GUID>
      ```