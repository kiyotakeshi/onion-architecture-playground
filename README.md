# dddsample

## このリポジトリで試したこと

- [x] [onion architecture](https://medium.com/expedia-group-tech/onion-architecture-deed8a554423), inversion of control principle を試してみる

- [x] [MyBatis 3](https://mybatis.org/mybatis-3/index.html) を試してみる

- [ ] [jOOQ](https://www.jooq.org/) を試してみる

## requirement

- java17
  - use [asdf](https://asdf-vm.com/guide/getting-started.html) and [asdf-java](https://github.com/halcyon/asdf-java) plugin

```shell
asdf install java liberica-17.0.3.1+2

$ java -version
openjdk version "17.0.3.1" 2022-04-22 LTS
OpenJDK Runtime Environment (build 17.0.3.1+2-LTS)
OpenJDK 64-Bit Server VM (build 17.0.3.1+2-LTS, mixed mode, sharing)
```

## run

```shell
docker compose up -d
```

```shell
# ./gradlew task

# run
./gradlew bootRun

# or build executable jar
# ./gradlew bootJar                            
# ls -l build/libs/dddsample-0.0.1-SNAPSHOT.jar
# java -jar build/libs/dddsample-0.0.1-SNAPSHOT.jar
```

## format

```shell
./gradlew format

./gradlew check
```

## test

```shell
./gradlew test
```
