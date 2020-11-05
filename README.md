# Bepy Task

Service created for the study of micronaut and kotlin, also has a GRPC part

## How to run this project

JDK 11

1 - ```gradle clean```

2 - ```gradle build -Dorg.gradle.java.home=<JDK_HOME>```

3 - ```gradle run -Dorg.gradle.java.home=<JDK_HOME>```

## Http Request

To use Http, you can use [Insomnia](https://insomnia.rest/download/core/?&ref=https%3A%2F%2Fwww.google.com.br%2F). The collection is in the docs folder, only imports

## GRPC 

To use GRPC, you can use [Bloom RPC](https://github.com/uw-labs/bloomrpc). Only import the proto file, which is located in the ```src/main/proto``` folder

----
##### Warn: Before starts the service run the postgres through docker-compose

```docker-compose up -d```

## Refs
* [Micronaut About](https://medium.com/@jvoliveiran/micronaut-uma-vis%C3%A3o-geral-1f640c5a7ad4#:~:text=Lan%C3%A7ado%20oficialmente%20em%2023%20de%20outubro%20de%202018%2C%20o%20Micronaut,forma%20modular%20e%20facilmente%20test%C3%A1vel.)
* [Micronaut Postgres](https://dzone.com/articles/micronaut-cloud-jpa)
* [Micronaut JPA](https://guides.micronaut.io/micronaut-data-access-jpa-hibernate/guide/index.html)
* [Micronaut GRPC](https://micronaut-projects.github.io/micronaut-grpc/snapshot/guide/index.html)
* [GRPC About](https://grpc.io/docs/languages/kotlin/)