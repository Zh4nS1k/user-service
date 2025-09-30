Вот улучшенный и аккуратно оформленный README для твоего **User Service**, полностью готовый к копированию:

````markdown
# 👤 User Service

**User Service** — микросервис на **Spring Boot** для управления пользователями.  
Поддерживает **CRUD-операции** (создание, чтение, обновление, удаление) через REST API.

---

## 🛠 Технологии

- ☕ **Java 17**  
- 🌱 **Spring Boot 3.5.5**  
- 🗄 **Spring Data JPA**  
- 🗃 **PostgreSQL**  
- 🔄 **MapStruct**  
- 🧭 **Flyway** (миграции базы данных)  
- 🌐 **OpenFeign** (интеграция с другими микросервисами)  

---

## ⚙️ Конфигурация

Основные настройки находятся в [`src/main/resources/application.properties`](src/main/resources/application.properties):  

| Настройка                | Описание                              |
|------------------------|-------------------------------------|
| `server.port=8080`     | Порт запуска приложения             |
| `spring.datasource.*`  | Параметры подключения к PostgreSQL  |

---

## 🚀 Запуск

1️⃣ Убедитесь, что **PostgreSQL** запущен и доступен по адресу, указанному в `application.properties`.  
2️⃣ Соберите проект:  

```bash
./gradlew build
````

3️⃣ Запустите приложение:

```bash
./gradlew bootRun
```

После запуска сервис будет доступен на:
➡ **[http://localhost:8080/api/users](http://localhost:8080/api/users)**

---

## 📡 API Эндпоинты

| Метод    | Endpoint          | Описание                      |
| -------- | ----------------- | ----------------------------- |
| `GET`    | `/api/users`      | Получить список пользователей |
| `GET`    | `/api/users/{id}` | Получить пользователя по `id` |
| `POST`   | `/api/users`      | Создать нового пользователя   |
| `PUT`    | `/api/users/{id}` | Обновить данные пользователя  |
| `DELETE` | `/api/users/{id}` | Удалить пользователя          |

---

## 🗂 Миграции

Миграции базы данных находятся в:
`src/main/resources/db/migration`
Они применяются автоматически при старте приложения благодаря **Flyway**.

---

## 🐳 Docker

Для запуска в Docker:

```bash
docker build -t user-service .
docker run -p 8080:8080 user-service
```

*(можно дополнительно создать `docker-compose.yml` для PostgreSQL + User Service)*

---

## 🧪 Тестирование

Запуск тестов:

```bash
./gradlew test
```

---

## 👤 Автор

**Zhanserik**

```

Хочешь, я добавлю сюда **пример `docker-compose.yml`** для PostgreSQL + User Service, чтобы можно было всё поднять одной командой?  
Так будет удобно для локальной разработки и тестирования.
```
