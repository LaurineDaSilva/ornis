# Axios

Axios allows us to do HTTP requests. It has shortened functions for GET, PUT etc compared to Fetch.

Axios's base url is set with only one environment variable for the whole application. It means we don't need to duplicate this piece of code, we can stay DRY.

Another benefit is that we write much less code.

Axios is not framework-dependant, it can be used with VueJS, Angular, React...

## Setting up environment variables for Axios

We export the Axios instance so that it can be used throughout the app, with globalProperties:

`app.config.globalProperties.$axios = _instance_`

We also need to set the base URL for the HTTP requests made with Axios.

`import axios from 'axios'`

`const instance = axios.create({`
`baseURL : "http://localhost:8080"`
`})`

`app.config.globalProperties.$axios = instance;`

Here, the base URL is hard coded in the code. We need to extract it for there with Vite and environment variables.
