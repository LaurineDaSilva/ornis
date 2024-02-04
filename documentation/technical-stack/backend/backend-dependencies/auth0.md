# Auth0

## Useful links

[Official documentation for Auth0 with Spring Boot](https://auth0.com/docs/quickstart/backend/java-spring-security5/interactive)

## What is Auth0?

Auth0 allows you to quickly add authorization to your application. This guide demonstrates how to integrate Auth0 with any new or existing Spring Boot application.

It handles login, logout, and user profile information.

## Key features

- Define permissions. Permissions (scopes) let you define how resources can be accessed on behalf of the user with a given access token. For example, you might choose to grant read access to the messages resource if users have the manager access level, and a write access to that resource if they have the administrator access level.

- [Configure an application as a Resource Server and validate the JWTs](https://auth0.com/docs/quickstart/backend/java-spring-security5/interactive#configure-the-resource-server) (``SecurityFilterChain`, `@Configuration` annotation)

- Protect API endpoints:

  - `GET /api/public`: available for non-authenticated requests
  - `GET /api/private`: available for authenticated requests containing an access token with no additional scopes
  - `GET /api/private-scoped`: available for authenticated requests containing an access token with the `read:messages` scope granted

  - Create the API Controller: Create a new class named ``APIController` to handle requests to the endpoints. The `APIController` has three routes as defined in the Protect API Endpoints section. For this example, allow all origins through `@CrossOrigin` annotation. Real applications should configure CORS for their use case.

  ## [java-jwt](https://mvnrepository.com/artifact/com.auth0/java-jwt)

  Java implementation of JSON Web Token (JWT)
