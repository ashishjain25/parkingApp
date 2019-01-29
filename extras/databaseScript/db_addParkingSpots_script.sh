#!/bin/bash

DIR=$(dirname $0)
DIR=$(cd $DIR & pwd)

. $DIR/dbConnectionDetails.env

psql -h $IP -p $Port -U $Default_Username -W $Default_Db <<EOF
\i addParkingSpots.sql 
EOF
