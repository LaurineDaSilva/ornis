# Front-end Structure

As Ornis is a [SPA](https://github.com/LaurineDaSilva/ornis/blob/documentation/documentation/architecture/architecture.md#a-single-page-application), it will have only one HTML file, named index.html.
The app will have several components written in JavaScript and styled in CSS, as well as a routing system which will allow the rendering of the desired components.

Strings will be externalized, which means that they will not be hard coded in the HTML file, but will be rendered through JavaScript files and/or accessed from a JSON file. It will allow the app to be dynamic and it will improve the maintainability of the service.

Indeed, we will have a specific JSON file in which we will find all our labels. This will help us because when one label needs to be changed, we'll be able to look for it in a single file instead of many.

This approach will also make i18n easier if needed. For instance we will have one JSON file per supported language, which would help for the traduction of the app depending on the user's browser if we publish the app in several languages.
