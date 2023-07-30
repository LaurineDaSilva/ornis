# Security

# CORS: Cross Origin Resource Sharing

=> Cors requests made by browsers.

![image](../images/security/security_01.jpg)

BE CAREFUL: it is a security concept **BUT** it does not protect any intrusions in the URL.

1. Create a **Configuration package**
2. Create a **WebConfig** Class (Config: name by convention but you can named WebConfiguration) and implement **WebMvcConfigurer**
3. Create a **addCorsMappings()** method and add a **@Configuration** annotation
4. Delete @CrossMapping in Controller files

- methods = 5 verbs Rest
- patterns = /\*\*
- origin(s)

Link: https://www.baeldung.com/spring-cors

However, it is not a good practice to put the URL directly in the code. So the best practice is to inform the URL in the application.properties file.

![image](../images/security/security_02.jpg)

It can have many properties which will contain a key and a value.

![image](../images/security/security_03.jpg)
