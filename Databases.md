# Relational Database
A relational database (RDB) is a way of structuring information in tables, rows, and columns. An RDB has the ability to establish links—or relationships–between information by joining tables, which makes it easy to understand and gain insights about the relationship between various data points.

# What is SQL ?
Structured Query Language - using which we can query the database tables and get the relevant information from the database table.

Example:
MYSQL
Oracle
Postgres

# What is SQLite?
SQLite is the database designed to run on lower end devices. it is light weight as suggested in the name itself. Typically the data is stored in a file.

# What Database is used in Android ?
SQLite

# Basic Commands of SQLite
#### Create - This Query helps us to create a database table
`create TABLE person(person_id integer PRIMARY KEY AUTOINCREMENT, 
     	 person_name TEXT, person_age INTEGER);`

#### Insert - This query helps us store data into table
`INSERT into person(person_name,person_age) VALUES("Pavan", 20);`

#### Read
`SELECT * from person;`

`SELECT * from person ORDER BY person_age ASC;`

`SELECT * from person where person_age>20;`

`SELECT * from person where person_age>20 ORDER by person_age DESC;`

#### Update
`UPDATE person set person_name = "pavan kumar" where person_id = 1;`

`UPDATE person set person_name = "pavan kumar", person_age= 30 where person_id = 1;

#### Delete - helps to delete individual rows
`DELETE from person where person_id = 1;`

#### Entire table can be deleted
`DROP table person;`



