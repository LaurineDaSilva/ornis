# Error Handling

## Error 401 - Unauthorized

This error means the client's request cannot be completed because the client lacks valid authentication credentials for the requested resource.

We'll handle this error with an error message and a link redirecting to the Authentication service and a link redirecting to the homepage.

## Error 403 - Forbidden

This error means that the server understands the request but refuses to authorize it. Re-authenticating doesn't solve the issue.

We'll handle this error with an error message and a link redirecting to the homepage.

## Error 404 - Not Found

This error means the server cannot find the requested resource.

We'll handle this error with an error message and a link redirecting to the homepage.

## Error 500 - Internal Server Error

This error means that the server encountered an unexpected issue and cannot fulfill the request.

We'll handle this error with an error message and a link redirecting to the homepage.
