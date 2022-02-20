# Course-Registration-System

## Setting up Database
1. Log into MySQL through command line:  mysql -u '<username>' -p '<password>'
2. Enter password
3. Create a database named REGIE: mysql> CREATE DATABASE regie;
4. use the database: mysql> USE regie;
5. confirm using regie: mysql> select database() from dual;
6. run the sql script to create and populate tables: mysql> source /......./src/main/db/createTables.sql
7. In .../src/main/db/DatabaseConnection.java, line 13, change user and password strings to whatever your MySQL username and password are