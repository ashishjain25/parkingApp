\set dbName parking
\set dbAdmin parking_db_adm

-- Connect to database
\c :dbName :dbAdmin;

INSERT INTO parking_db_schema.parkingspot VALUES(1,0.100000,0.100000);
INSERT INTO parking_db_schema.parkingspot VALUES(2,0.110000,0.110000);
