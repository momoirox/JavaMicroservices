#!/bin/bash
POSTGRES_USER="postgres"
DB1="evaluationsDb"
DB2="managementDb"


docker exec -it my_postgres_container psql -U $POSTGRES_USER -c "CREATE DATABASE $DB1;"
docker exec -it my_postgres_container psql -U $POSTGRES_USER -c "CREATE DATABASE $DB2;"


echo "Datebases created: $DB1 i $DB2"

docker exec -it my_postgres_container psql -U $POSTGRES_USER -c "\l"