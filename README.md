# jsonmngr
Just a Java JSON manager


## POST example
curl -X POST http://localhost:8080/persons \
-H "Content-Type: application/json" \
-d '{
      "name":"Fernando",
      "age":44
    }'

## GET example
curl http://localhost:8080/persons