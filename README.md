
# Альфа Банк
## Тестовое задание


![Currency project](https://github.com/BadmaevDanzan/currency/blob/main/currency.gif?raw=false=700x250)
## Задача

- Создать сервис, который обращается к сервису курсов валют, и отображает gif.
    - Если курс по отношению к USD за сегодня стал:
        - Выше, отдаем https://giphy.com/search/rich
        - Ниже, отдаем https://giphy.com/search/broke

## Требования

### Must have
- [x]   Сервис на Spring Boot 2 + Java / Kotlin
- [x]   Запросы приходят на HTTP endpoint (должен быть написан в соответствии с rest conventions), туда передается код валюты по отношению с которой сравнивается USD
- [x]   Для взаимодействия с внешними сервисами используется Feign
- [x]   Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки
- [x]   На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)
- [x]   Для сборки должен использоваться Gradle
- [x]   Результатом выполнения должен быть репо на GitHub с инструкцией по запуску

### Nice to Have
  
- [x]   Сборка и запуск Docker контейнера с этим сервисом
- [x]   Срок выполнения задания - 1 неделя

## Инструкция по запуску

- Запуск через Docker (Команды)

        docker build . -t currency
        docker run -p 8080:8080 -t currency

- Запуск через Gradle (Команда)

        gradlew bootRun

## API

### Frontend

    http://localhost:8080/
    
Выдает страницу index.html

### Backend

    http://localhost:8080/api

По стандарту добавляет к параметру currency = RUB (?currency=RUB)

    http://localhost:8080/api?currency=YourRate
Вместо YourRate указываем значение из [списка валют](https://openexchangerates.org/api/currencies.json) в ответ приходит json:
- currency = Валюта которую Вы указали
- profit = Текста дохода, rich или broke (Это необходимо для фронтенда)
- imgUrl = Ссылка на gif с сервиса Giphy.com
- yesterdayRate = Курс за вчерашний день
- todayRate = Курс за сегодняшний день 




