-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- This file contains the SupplierCatalog schema. Import this schema into PostgreSQL using the command
--  psql -U postgres [-h <PGserver>] [-p <PGport>] -f capability_as_db_create.sql
-- psql -U postgres -h localhost -p 5432 -f supplierCatalog_as_db_create.sql

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------

--time the command arrives at the server from the client
SET statement_timeout = 0;

-- client encoding
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
--When it is false, it disables validation of the function body string during CREATE FUNCTION.
SET check_function_bodies = false;

--Controls which message levels are sent to the client
SET client_min_messages = warning;

--When on, a warning is issued if a backslash (\) appears in an ordinary string literal and standard_conforming_strings is off. The default is on.
SET escape_string_warning = off;

--specifies the order in which schemas are searched
SET search_path = public, pg_catalog;

--name of the tablespace in which tables will create
SET default_tablespace = '';

SET default_with_oids = false;


\set dbName parking
\echo DBName :dbName

\set schemaName parking_db_schema
\echo SchemaName :schemaName

\set dbUser parking_db_user
\echo DBUser :dbUser

\set dbPass '\'parking123\''
\echo DBPass :dbPass

\set dbAdmin parking_db_adm
\echo DBAdmin :dbAdmin

\set dbAdminPass '\'parkingadm123\''
\echo DBAdminPass :dbAdminPass

DROP USER IF EXISTS :dbUser;
DROP DATABASE IF EXISTS :dbName;
DROP USER IF EXISTS :dbAdmin;

CREATE USER :dbAdmin WITH password :dbAdminPass;
CREATE USER :dbUser WITH password :dbPass;

CREATE DATABASE :dbName WITH OWNER = :dbAdmin;

-- Connect to database
\c :dbName :dbAdmin;


-- create the schema and tables
DROP SCHEMA IF EXISTS parking_db_schema CASCADE;

CREATE SCHEMA parking_db_schema;


-- -----------------------------------------------------
-- Table `parking_db_schema`.`parkingspot`
-- -----------------------------------------------------
DROP TABLE IF EXISTS parking_db_schema.parkingspot ;

CREATE  TABLE parking_db_schema.parkingspot (
  parkingspot_id SERIAL,
  latitude NUMERIC(9,7) NULL ,	
  longitude NUMERIC(10,7) NOT NULL ,
  PRIMARY KEY (parkingspot_id));


-- -----------------------------------------------------
-- Table `parking_db_schema`.`reservation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS parking_db_schema.reservation ;

CREATE  TABLE parking_db_schema.reservation (
  reservation_id SERIAL,
  reservationDate DATE NOT NULL ,
  reservationTime DATE NOT NULL ,
  parkingSpotId INTEGER NOT NULL,
  PRIMARY KEY (reservation_id),
  CONSTRAINT fk_parkingSpot_key
    FOREIGN KEY (parkingSpotId)
    REFERENCES parking_db_schema.parkingspot (parkingspot_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

-- rights
REVOKE CONNECT ON DATABASE :dbName FROM public;
GRANT CONNECT ON DATABASE :dbName TO :dbUser;
GRANT USAGE ON SCHEMA :schemaName TO :dbUser;
GRANT SELECT,INSERT,UPDATE,DELETE ON ALL TABLES IN SCHEMA :schemaName TO :dbUser;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA :schemaName to parking_db_user;

