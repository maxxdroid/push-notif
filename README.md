This is a barebone implementation of how a push notification can be sent with the STOMP protocol.

1. Run the spring boot application
2. visit `localhost:8080`
3. Click on the send button to send a push notification to all users
4. Click on the send private to send the notification to a specific user


### Note
Spring Security is used for the authentication of the user. Credentials are in the security config. Notifications sent to that user will be received by only the user. You can disable spring security if you do not need it.