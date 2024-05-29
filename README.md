# Library API Spring Boot App

This is a simple Spring Boot application for managing a library's database. The application provides endpoints to interact with the accounts, borrowers, books, and authors tables in the database. Below are the features and instructions on how to set up and use the application.

## Features

1. **Accounts:**
   - Create a new account
   - Retrieve account information
   - Update account details
   - Delete an account
   
2. **Authors:**
    - Add a new author
    - Retrieve author details
    - Update author information
    - Delete an author

3. **Books: (UNDER DEV)**
   - Add a new book
   - Retrieve book details
   - Update book information
   - Delete a book

4. **Borrowers: (UNDER DEV)**
    - Add a new borrower
    - Get borrower details
    - Update borrower information
    - Remove a borrower

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

---

- **Get All Users:**
  ```http
  GET /accounts
  ```

  Retrieves information about all users.

- **Find Users by Criteria:**
  ```http
  GET /accounts/find?id={id}&name={name}&email={email}
  ```

  Finds users based on the specified criteria:
    - `id`: Optional - User ID
    - `name`: Optional - User name
    - `email`: Optional - User email

- **Add New User:**
  ```http
  POST /accounts/add
  ```

  Adds a new user to the system.
    - `name`: String - User's name
    - `email`: String - User's email
    - `password`: String - User's password
    - `age`: int - User's age

- **Delete User By id:**
  ```http
  DELETE /accounts/delete?id={id}
  ```

  Deletes a user specified by their ID.

- **Update User's Name and/or Password by ID:**
  ```http
  PUT /accounts/updateUser/{id}?name={name}&password={password}
  ```

  Updates the name and/or password of a user specified by their ID.
    - `name`: Optional - New user name
    - `password`: Optional - New user password

    
### Authors

---

- **Get All Authors:**
  ```http
  GET /authors
  ```

    Retrieves information about all authors.


- **Find Authors by Criteria:**
  ```http
  GET /authors/find?id={id}&name={name}
  ```

  Finds authors based on the specified criteria:
    - `id`: Optional - Author ID
    - `name`: Optional - Author name

- **Add New Author:**
  ```http
  POST /authors/add
  ```

  Adds a new author to the system.
    - `name`: String - Author's name
    - `contact`: String - Author's contact information
    - `age`: int - Author's age
    - `bio`: String - Author's biography

- **Delete Author By ID:**
  ```http
  DELETE /authors/delete?id={id}
  ```

  Deletes an author specified by their ID.

- **Update Author's Information By ID:**
  ```http
  PUT /authors/update/{id}?name={name}&contact={contact}&age={age}&bio={bio}
  ```

  Updates the information of an author specified by their ID.
    - `name`: Optional - New author name
    - `contact`: Optional - New author contact information
    - `age`: Optional - New author age
    - `bio`: Optional - New author biography

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
