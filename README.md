# Тестовое задание по SpringBoot

## Постановка задачи
REST-сервис, выполняющий CRUD-операции над таблицей products и один метод, 
возвращающий сумму полей `amount` по полю `name` оторое передается в метод.

## Пререквизиты
Должен быть запущен postgres на порту 25432 и создана база products_db. 
DDL и тестовые данные находятся в файле `test_data.sql`.
Параметры подключения к БД (и прочие параметры) можно поменять в `src/main/resources/application.properties`.

## Запуск

`./mvnw spring-boot:run`

## Описание методов API

* `GET /products` - получить все продукты
* `POST /products` - создать продукт (необходимо передать поля name и amount в теле запроса)
* `GET /products/{id}` - получить продукт по id
* `DELETE /products/{id}` - удалить продукт по id
* `PUT /products/{id}` - обновить продукт по id (необходимо передать поля name и amount в теле запроса)
* `GET /products/amount_sum/{name}` - получить сумму поля amount по имени