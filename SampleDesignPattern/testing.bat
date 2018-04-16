@echo off
cls
rem mvn clean package surefire:test -Dtest=**/DBTest
rem mvn clean package surefire:test -Dtest=**/DBEntityTest surefire-report:report
rem mvn clean package surefire:test -Dtest=**/DBEntityTest#notUniqueEntity surefire-report:report
mvn clean package surefire:test -Dtest=**/*Test jacoco:report surefire-report:report
