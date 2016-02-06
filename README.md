# Wellesley Hackathon

This is the code for the Wellesley Hackathon with Twitter Boston.

## Dependencies

* Node.js and NPM (https://nodejs.org/en/)
* Maven (https://maven.apache.org/)
* Java 7 (https://www.java.com/en/download/)

## Instructions

### Clone the Repository

    git clone https://github.com/mhrheaume/wellesley.git

### Generating API Keys

1. Log into twitter.com and go to https://apps.twitter.com developer page.
2. Click on "Create New App".
3. Give you application a unique name and description. For the website you can just enter https://www.twitter.com.
4. Accept the developer agreement and click on the "Create your Twitter application".
5. Once the app is created, click "Keys and Access Tokens", and then click "Create Access Token" under "Your Access Token".

### Configure the App

Open `src/main/java/com/twitter/mtv/hackathon/services/TwitterService.java` and replace the following variables with the tokens you generated above.

    private final String consumerKey = ";
    private final String consumerSecret = ";
    private final String accessToken = ";
    private final String accessTokenSecret = ";

### Compile and Run the App

From the root of the repository, build and run the Java app with Maven:

    mvn package
    mvn exec:java -Dexec.mainClass="com.twitter.mtv.hackathon.App"

Now build and run the React front end:

    cd src/main/resources/js
    npm install
    npm start

You can then see the app by opening it in a browser:

    open http://localhost:8000

## Resources

* React.js: https://facebook.github.io/react/
* Twitter4J: http://twitter4j.org/en/index.html
* Twitter API: https://dev.twitter.com/overview/documentation
