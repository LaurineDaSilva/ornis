# Security

# CORS: Cross Origin Resource Sharing

=> Cors requests made by browsers.

![image](https://user-images.githubusercontent.com/88188227/217075580-a9a0dcba-b2a1-4ddb-a497-931c1f41151a.png)

BE CAREFUL: it is a security concept **BUT** it does not protect any intrusions in the URL.

1. Create a **Configuration package**
2. Create a **WebConfig** Class (Config: name by convention but you can named WebConfiguration) and implement **WebMvcConfigurer**
3. Create a **addCorsMappings()** method  and add a **@Configuration** annotation
4. Delete @CrossMapping in Controller files

* methods = 5 verbs Rest
* patterns =  /**
* origin(s)

Link: https://www.baeldung.com/spring-cors

However, it is not a good practice to put the URL directly in the code. So the best practice is to inform the URL in the application.properties file.

![image](https://user-images.githubusercontent.com/88188227/217491070-447624b3-fc90-42d4-92de-74c10c6afba2.png)

It can have many properties which will contain a key and a value.

![image](https://user-images.githubusercontent.com/88188227/217493634-bb17f10b-5d4f-47f4-b3af-5c9c6843fd3a.png)


