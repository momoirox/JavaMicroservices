#!/bin/bash

docker start my_postgres_container

#Create for the first time
#POSTGRES_USER="postgres"
#POSTGRES_PASSWORD="postgres"
#POSTGRES_PORT="5432"
#docker run --name my_postgres_container \
#-e POSTGRES_USER=$POSTGRES_USER \
#-e POSTGRES_PASSWORD=$POSTGRES_PASSWORD \
#-p $POSTGRES_PORT:$POSTGRES_PORT \
#-d postgres

echo "Waiting for postgres to start..."
sleep 10
echo "Postgres started"
