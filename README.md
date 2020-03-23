1. Обновление версии всех библиотек в проекте до последних релизных:
mvn versions:use-latest-releases

2. Запуск всех тестов:
mvn clean test

3. Запуск тестов из одного тестового класса:
mvn -Dtest=LoginTest test

4. Запуск одного теста:
mvn -Dtest=LoginTest#logout test

5. Запуск нескольких тестов:
mvn -Dtest=LoginTest#logout+invalidPassword test

6. Запуск билда через альренативный POM.xml
mvn -f src/test/resources/pom.xml

7. Запуск теста registration() с параметром "password" :
mvn -Dtest=LoginTest#registration test -Dpassword=test12345678