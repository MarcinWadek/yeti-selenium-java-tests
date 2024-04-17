# Selenium Web Testing
Automated functional testing of [https://yeti.org.pl/](https://yeti.org.pl/) as a part of collaboration with the follow.studio.

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [My approach](#my-approach)
* [Screenshots](#screenshots)
* [Setup](#setup)
* [Usage](#usage)
* [Project Status](#project-status)
* [Room for Improvement](#room-for-improvement)
* [Contact](#contact)
<!-- * [License](#license) -->


## General Information
- The goal of this project was to show how I approach testing webpages
- It is a standard Maven Java project with regular java folder structure and POM.xml
- I aimed at creating robust framework, without flacky tests, with reduced time of test performance.

## Technologies Used
- Java 17
- Selenium 4.17
- JUnit 5.91


## My approach
- I have used Page Object Model design pattern so the webpage is divided into smaller parts - pages and parts of pages - footer and header.
- I also implemented Page Factory to simplify the usage of locators and reduce the amount of code.
- BasePage class in pages package contains the most important methods which are inhertied by other classes.
- BaseTest class in tests package contatins common setup and teardown annotations which are inherited by other classes.
- BaseTest also initialize chromeOptions settings in order to reduce the time of test performance.
- Assertionsa are written as a methods in page classes to make them reusable.
- Allure annotations are included to increase readability for non technical users, better clarity and in order to generate the report.
- The project is also configured as a Jenkins job.
  

## Screenshots

## Setup
Setup Instructions
To set up your local environment and get started with the project, follow these steps:

Clone the Repository:
git clone <repository_url>
cd <project_directory>

Build the Project:
mvn clean install

Run Tests:
mvn test

Example:
$ git clone https://github.com/MarcinWadek/yeti-selenium-java-tests.git
$ cd Yeti
$ mvn clean install
$ mvn test

After following these steps, you'll have the project set up and ready for development or testing. You can modify the source code, add new tests, and run the project locally on your machine.

## Usage

## Project Status
Project is in progress.


## Room for Improvement

Room for improvement:
- Add more tests to increase test coverage.

To do:
- Add usage description and screenshots to the readme.md
