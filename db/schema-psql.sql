\set username `echo $DB_USERNAME`
\set password `echo $DB_PASSWORD`

CREATE USER :username WITH PASSWORD :'password';
CREATE TABLE IF NOT EXISTS users(id serial PRIMARY KEY, name VARCHAR(255), salary NUMERIC(1000, 2));
GRANT SELECT, INSERT, UPDATE, DELETE ON users TO :username;
