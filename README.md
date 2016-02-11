# ComApi ( Companies Api ) - ![Builds](https://travis-ci.org/albulescu/compapi.svg?branch=master)
Small api example using Spark library.

## Requirements
---
- Java 1.8 
- Maven
- Eclipse

## Instalation
---

### - Clone repo
```
mkdir compapi && cd compapi
git init .
git remote add origin git@github.com:albulescu/compapi.git
```

## - Install dependinces
```
mvn install
```

## Endpoints
---
### - Create Company
```
curl -X "POST" "http://localhost:4567/v1/companies" \
	-d $'{
	"name":"test2",
	"address":"some address",
	"city":"some city",
	"country":"some country"
}'
```

### - List companies
```
curl -X "GET" "http://localhost:4567/v1/companies"
```

### - Update companies
Other fields can also be updated
```
curl -X "PUT" "http://localhost:4567/v1/companies/1" \
	-d $'{
	"name":"test2 new"
}'
```

### - Create user
```
curl -X "POST" "http://localhost:4567/v1/users" \
	-d $'{
	"name":"Cosmin Albulescu",
	"email":"cosmin@albulescu.ro"
}'
```

### - List users
```
curl -X "GET" "http://localhost:4567/v1/users"
```

### - Create employee
```
curl -X "POST" "http://localhost:4567/v1/employees" \
	-d $'{
	"company":"1",
	"user":"1",
	"role":"GENERIC"
}'
```

## Testing
---
```
make test
```
