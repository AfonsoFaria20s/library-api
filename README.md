# Library API Spring Boot App

This is a simple Spring Boot application for managing a library's database. The application provides endpoints to interact with the accounts, borrowers, books, and authors tables in the database. Below are the features and instructions on how to set up and use the application.

## Features

1. **Accounts:**
   - Create a new account
   - Retrieve account information
   - Update account details
   - Delete an account

2. **Borrowers:**
   - Add a new borrower
   - Get borrower details
   - Update borrower information
   - Remove a borrower

3. **Books:**
   - Add a new book
   - Retrieve book details
   - Update book information
   - Delete a book

4. **Authors:**
   - Add a new author
   - Retrieve author details
   - Update author information
   - Delete an author

## Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL (or your preferred database)

## Prerequisites

1. Java 8 or higher installed
2. Maven installed
3. MySQL database installed and running

## Setup

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/AfonsoFaria20s/library-api.git
   ```

2. **Configure Database:**
   - Open/Create `src/main/resources/application.properties`.
   - Update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties with your database connection details.

3. **Build and Run:**
   ```bash
   cd library-api
   mvn clean install
   java -jar target/library-api-1.0.0.jar
   ```

4. **Access the Application:**
   Open your web browser and go to [http://localhost:8080](http://localhost:8080)

## API Endpoints

### Accounts

- **Get all Accounts:**
  ```http
  GET /accounts
  ```

- **Create Account:**
  ```http
  POST /accounts/add?name={name}&email={email}&age={age}
  ```

- **Get Account by ID:**
  ```http
  GET /accounts/byId/{accountId}
  ```

- **Get All Accounts by Name:**
  ```http
  GET /accounts/byName/{accountName}
  ```

- **Update Account: (Under Development)**
  ```http
  PUT /accounts/{accountId}
  ```

- **Delete Account: (Under Development)**
  ```http
  DELETE /accounts/{accountId}
  ```

### Borrowers _(UNDER DEVELOPMENT)_

- **Create Borrower:**
  ```http
  POST /borrowers
  ```

- **Get Borrower by ID:**
  ```http
  GET /borrowers/{borrowerId}
  ```

- **Update Borrower:**
  ```http
  PUT /borrowers/{borrowerId}
  ```

- **Delete Borrower:**
  ```http
  DELETE /borrowers/{borrowerId}
  ```

### Books _(UNDER DEVELOPMENT)_

- **Create Book:**
  ```http
  POST /books
  ```

- **Get Book by ID:**
  ```http
  GET /books/{bookId}
  ```

- **Update Book:**
  ```http
  PUT /books/{bookId}
  ```

- **Delete Book:**
  ```http
  DELETE /books/{bookId}
  ```

### Authors

- **Get all Authors:**
  ```http
  GET /authors
  ```

- **Create Author:**
  ```http
  POST /authors/add?name={authorName}
  ```

- **Get Author by ID:**
  ```http
  GET /authors/byId/{authorId}
  ```

- **Get Author by Name:**
  ```http
  GET /authors/byName/{authorName}
  ```

- **Update Author: (Under Development)**
  ```http
  PUT /authors/{authorId}
  ```

- **Delete Author: (Under Development)**
  ```http
  DELETE /authors/{authorId}
  ```

## Sample Requests

### Create Account

```http
POST /accounts/add
Content-Type: application/json

{
  "name": "john_doe",
  "email": "john.doe@example.com"
  "age": 30
}
```

### Get Account by ID

```http
GET /accounts/byId/2
```

### Update Account

```http
PUT /accounts/2
Content-Type: application/json

{
  "email": "john.doe.updated@example.com"
}
```

### Delete Account

```http
DELETE /accounts/1
```

## Notes

- Make sure to replace `{accountId}`, `{borrowerId}`, `{bookId}`, and `{authorId}` with actual IDs in the API endpoints.
- Customize the application as per your specific requirements.
- Ensure proper error handling and validation for production use.

Feel free to reach out if you have any questions or need further assistance. Happy coding!
