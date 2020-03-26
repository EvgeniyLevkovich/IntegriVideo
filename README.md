1. Обновление версии всех библиотек в проекте до последних релизных:
mvn versions:use-latest-releases

2. Запуск всех тестов:
mvn clean test

3. Запуск тестов из одного тестового класса:
mvn clean test -Dtest=LoginTest 

4. Запуск одного теста:
mvn clean test -Dtest=LoginTest#logout 

5. Запуск нескольких тестов:
mvn clean test -Dtest=LoginTest#logout+invalidPassword 

6. Запуск билда через альтернативный POM.xml
mvn clean test -f src/test/resources/pom.xml

7. Запуск теста registration() с параметром "password" :
mvn clean test -Dtest=LoginTest#registration  -Dpassword=test12345678