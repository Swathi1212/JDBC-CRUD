# JDBC-CRUD
CRUD operations using JDBC (Java Database Connectivity) allow Java applications to interact with relational databases for data management. CRUD stands for Create, Read, Update, and Delete, and these operations can be implemented using SQL queries within a JDBC setup.
Create: Inserting data into the database with an INSERT SQL statement. The PreparedStatement object is typically used for inserting records to prevent SQL injection attacks and improve performance.

Read: Retrieving data using a SELECT SQL statement. A ResultSet object fetches the data, which is then processed row by row.

Update: Modifying existing data with an UPDATE SQL statement. Similar to Create, PreparedStatement can be used to execute the update, allowing dynamic value setting.

Delete: Removing data using a DELETE SQL statement. This is also executed with PreparedStatement to ensure safe deletion and prevent SQL injection.

To establish a connection, JDBC requires a database URL, username, password, and the appropriate JDBC driver for the database in use. Using these components, CRUD operations can be performed in Java applications to interact with relational databases efficiently.
In MySQL command line client window:

> Create table student(
rno integer primary key,
sname varchar(15),
avgmarks numeric(5,2));

Now create a new Java project using Eclipse.
In JDBC, both Statement and PreparedStatement are used to execute SQL queries, but they have some key differences in terms of performance, security, and usage:
Statement: Used for simple SQL queries without parameters. SQL queries are hardcoded as strings and executed directly.
java
Copy code
Statement stmt = connection.createStatement();
String sql = "SELECT * FROM users WHERE age > 25";
ResultSet rs = stmt.executeQuery(sql);
PreparedStatement: Used for parameterized SQL queries, allowing you to set values at runtime. The SQL query is precompiled, which provides efficiency and prevents SQL injection.
java
Copy code
String sql = "SELECT * FROM users WHERE age > ?";
PreparedStatement pstmt = connection.prepareStatement(sql);
pstmt.setInt(1, 25);
ResultSet rs = pstmt.executeQuery();

PreparedStatement is generally preferred due to its advantages in performance, security, and flexibility, especially for queries that require user input or are executed repeatedly with varying parameters.
