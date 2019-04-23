# rss_clean

The RSS Clean Architecture is a demo that shows a process to collect information of many posts from Netflix tech blog.

The project imports, normalizes and stores this information following an implementation of Clean Architecture.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- [Java8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Maven 3.5.0](https://maven.apache.org/download.cgi)

You have to install Docker and Docker Compose:

- [Docker](https://docs.docker.com/installation/#installation)
- [Docker Compose](https://docs.docker.com/compose/install)

### Installing

* Clone source code from git

```
$ git clone git@github.com:ivangrod/rss_clean_architecture.git
```

* Build project with Maven

```
$ mvn clean install
```

* Run the application from the command line using:

```
$ ./mvnw spring-boot:run
```

## Built With

* [Spring Framework](https://spring.io/) - The framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds
* [Elasticsearch](https://www.elastic.co/products/elasticsearch) - Search engine based on [Lucene](https://lucene.apache.org/core/)

## Authors

* **Iván Gutiérrez** - [ivangrod](https://github.com/ivangrod)

## Contributors

* **David Romero** - *Development* - [david-romero](https://github.com/david-romero)

## License

This project is licensed under the GNU GENERAL PUBLIC LICENSE License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* [Engineering-blogs](https://github.com/kilimchoi/engineering-blogs)
