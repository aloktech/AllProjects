@echoff
cls
mvn clean install -DskipTests=true && mvn test -DwithHistory org.pitest:pitest-maven:mutationCoverage