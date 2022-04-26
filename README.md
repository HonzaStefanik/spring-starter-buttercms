TODO - change GitHub URLs to official ButterCMS' repos once they get created

![Java version](https://img.shields.io/badge/Java-8-red)

# Spring Boot +  ButterCMS Starter Project

This Spring Boot starter project fully integrates with dynamic sample content from your ButterCMS account, 
including main menu, pages, blog posts, categories, and tags, all with a beautiful, custom theme with already-implemented search functionality.
All of the included sample content is automatically created in your account dashboard when you sign up for a free trial of ButterCMS.

[View our live demo hosted at Heroku](https://spring-starter-buttercms.herokuapp.com/), or you can click a button below
to deploy your own copy of our starter project to the provider of your  choice.

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/HonzaStefanik/spring-starter-buttercms.git)


## 1. Installation

### Prerequisites

This project requires two dependencies in order to get  up and running. They are

* Java 8
* Maven

The few other dependencies (Spring Boot, Java SDK for ButterCMS) are automatically managed by Maven.

To get started, first, clone the repo

```
git clone https://github.com/HonzaStefanik/spring-starter-buttercms.git
cd spring-starter-buttercms
```

### 2. Set API Token

To fetch your ButterCMS content, add your API token as an environment variable.

`$ echo 'BUTTER_CMS_TOKEN=<Your API Token>' >> .env`

### 3. Build the project

Build the project with the following command

`mvn install -DskipTests`

### 4. Run the project

To run the project, use the following command

`mvn spring-boot:run`

Your starter project is now live at http://localhost:8080

## 5. Deploy on Heroku

Deploy your Spring Boot app using Heroku. With a single click, you'll create a copy of our starter project in your Git provider account,
instantly deploy it, and institute a full content workflow connected to your ButterCMS account. Smooth.

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/HonzaStefanik/spring-starter-buttercms.git)


### 6. Webhooks

The ButterCMS webhook settings are located at https://buttercms.com/webhooks/

### 7. Previewing Draft Changes

By default, your starter project is set up to allow previewing of draft changes saved in your ButterCMS.com account.
To disable this functionality, set the following value in your .env file: BUTTER_CMS_PREVIEW=false
