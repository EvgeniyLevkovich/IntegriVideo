Обновить версии всех библиотек в проекте:
mvn versions:display-dependency-updates

Запустить тесты используя mvn clean test команду:
mvn -Dtest=IntegriChatTest test

Запустить конкретный метод:
mvn -Dtest=IntegriChatTest#sendMessageByClick test

Запустить два теста:
mvn -Dtest=IntegriChatTest#sendMessageByClick+sendMessageByEnter test

Альтернативный pom.xml
mvn -f src/test/resources/pom.xml