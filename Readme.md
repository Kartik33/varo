pre-requsites 

    Java 11
    PostgresSQL 13.4
    Spring-boot

cd to target folder

To export the environment varibales run the following command in the terminal\
&nbsp;&nbsp;   export $(cat .env | xargs)

Run the app\
&nbsp;&nbsp;    java -jar target/vero-0.0.1-SNAPSHOT.jar


APIs


    /users
        Method : GET
        Success Code : 200
        Response Type : Json (List of all the users and their information)

    /user  
        Method : POST
        Success Code : 201
        -H 'Content-Type: application/json'
        -d {"fName":"","lName":"","email":"", "addresses":[{"linea":"","lineb":"","city":"","state":""}]}

    /user?email=email   
        Method :  GET
        Success code : 200
        Error code: 404


    /user        
        Method  : PATCH
        Success code : 200
        -H 'Content-Type: application/json'
        -d {"userId": "" , "fName":"","lName":"","email":"", "addresses":[{"linea":"","lineb":"","city":"","state":""}]}


    /user/{id}          
        Method : GET
        Success code : 200
        Error Code : 404


    /user/{id}/address   
        Method : POST
        Success code : 201
        -H 'Content-Type: application/json'
        -d {"linea":"","lineb":"","city":"","state":"" }
        
   /user/{id}
        Method : DELETE
        Success code : 200
        
