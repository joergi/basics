# BASICS - REGISTRY / LOGIN

[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=SonarSource_basics&metric=ncloc)](https://sonarcloud.io/dashboard?id=SonarSource_basics) [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=SonarSource_basics&metric=bugs)](https://sonarcloud.io/dashboard?id=SonarSource_basics) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=SonarSource_basics&metric=code_smells)](https://sonarcloud.io/dashboard?id=SonarSource_basics) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=SonarSource_basics&metric=coverage)](https://sonarcloud.io/dashboard?id=SonarSource_basics) [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=SonarSource_basics&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=SonarSource_basics)

this project should work as a general user registration and login handler (Backend)

A registration and login for users is needed in most projects, so this can help fulfilling this task.

## Sentry

Errors are here: https://sentry.io/organizations/joergi/issues/?project=5418174

## Sonar Test

To see the code quality, you can use Sonarqube, but you need Docker installed.  

Run docker locally: ` docker run -d --name sonarqube -p 9000:9000 sonarqube `   

After Sonarqube is started probably, you will reach it under the url: http://localhost:9000/
now, run maven against Sonarqube: ` mvn clean test sonar:sonar -Dsonar.host.url=http://localhost:9000/ `
