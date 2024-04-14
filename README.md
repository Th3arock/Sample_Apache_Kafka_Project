# Sample Apache Kafka Project
•  This is a modular Spring Boot application that utilizes Apache Kafka as a message broker to implement an SmsCenter application.

•  Please note that you must start ZooKeeper and Kafka before using this app. You can start Kafka and ZooKeeper using 
    the following command-line interface (CLI) commands:

•  For Kafka in Linux:

`./bin/kafka-server-start.sh ./config/server.properties`

•  For ZooKeeper in Linux:

`./bin/zookeeper-server-start.sh ./config/zookeeper.properties`

• For monitoring the application, it is essential to use the Kafdrop tool, 
    which can be found at the following GitHub repository:
[Kafdrop](https://github.com/obsidiandynamics/kafdrop)
