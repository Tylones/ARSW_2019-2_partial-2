# Partial T2

# ARSW_2019-2_Lab_7_Websockets

## Name :

```
Etienne Maxence Eugene REITZ
GitHub username : Tylones
```

## Build and test instructions : 

Go in the project directory :

* To build the project , run the command : ```mvn package```
* To test the project, run the command : ```mvn test```
* To compile the project, run the command : ```mvn compile```
* To run the project, run the command : ```mvn spring-boot:run```

The application is accessible at *https://localhost:8080/*

The production of the application is accessible at : *https://etienne-reitz-arsw-t2.herokuapp.com*

## Design of the application 

The application has one controller named *AirportFinderController* which manages the GET request from the Frontend of the application.
This controller use one service which is autowired called *AirportFinderServices* which has one function that takes as a parameter the name of the requested location.
This service has one class *AirportsFinderCache* which is autowired aswell. The function of the service will check if the requested location has already been cached, and if 
so returns it. Otherwise, it'll make a request to the rapidapi and store the response in the cache.

## Javadoc

The javadoc is accessible in the directory javadoc 