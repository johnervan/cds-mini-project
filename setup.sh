#!/bin/sh

source .env
psql -d postgres -f  ./db/create-db.sql
psql -d "$DB_NAME" -f ./db/schema-psql.sql
