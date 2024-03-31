# play-googleauth-example

Example of [play-googleauth](https://github.com/guardian/play-googleauth) module usage

Considered a much more 

- First go to [developers-console](https://console.cloud.google.com/apis/credentials) and  create Google OAuth 2.0 Client
- Then set values in application.conf or create environment variables

### Run application for development
```
sbt run
```
The web server will start on port [9000](http://localhost:9000)

### Usage

Initially when you open [home page](http://localhost:9000) in browser, you will be redirected to google login form. When you successfully login with credentials you will be redirected again to home page but then you will get your identity information  

### Docker
You can build docker image with command
```
sbt docker:publishLocal
```
It will create docker image and publish it in local repository. To publish it on remote repository you must first configure it in build.sbt
