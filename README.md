# Сборка и запуск
---
Импортировать базу данных postgresql из файла _customer_products.sql_
В папке с проектом в файле src/main/java/resources/hibernate.cfg.xml скорректировать имя пользователя, пароль, имя базы данных и схемы.
![Рисунок](/src/main/resources/properties.png)
Запусть консоль из корневой папки проекта.
Выполнить команды:
```
mvn clean
mvn package
```
Перейти в директорию target:
```
cd target
```
Запустить проект со своими параметрами по шаболу:
```
java -jar db-operations-jar-with-dependencies.jar command input.json output.json
```
Входные параметры:
- command - тип запроса (search или stat)
- input. json - ссылка на входной файл
- output.json - ссылка на выходной файл
Пример запуска:
```
java -jar db-operations-jar-with-dependencies.jar search c:\temp\input.json c:\temp\output.json
```
Примеры входных запросов расположены в папке src/main/java/resources/input