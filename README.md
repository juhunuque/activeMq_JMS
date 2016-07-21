# ActiveMQ - JMS - Java Lab Config

## Intro
If you don't know about JMS, check (this)[http://www.coderpanda.com/jms-tutorial/]


## Install
### Setting up ActiveMq

You can simply get a docker container with everything install it, (refer to this guide)[https://hub.docker.com/r/cloudesire/activemq/],
or in the docker bash run this:
```sh
$ docker run -p 61616:61616 -p 8161:8161 cloudesire/activemq
```

Then you have the container installed you can access the admin console following this link: http://192.168.99.100:8161/admin
Username: admin
Password: admin

The port 8161 is for the admin console, the other one is the listener

Also, you can manually install it by following the instructions in the (Apache website)[http://activemq.apache.org/download.html]

### Setting our Pom.xml

You will need some libraries, here you have the dependencies:
```xml
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-api</artifactId>
            <version>6.0</version>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>org.apache.activemq</groupId>
            <artifactId>activemq-broker</artifactId>
            <version>5.13.3</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.5</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.5</version>
        </dependency>
```

## Use it!
- First up, you need to create a Sender class in order to act as "Sending Client", check out the class "Sender.java" to see how it works
- After publish your message, you will need a class to act as "Receiving Client", check out the class "Receiver.java" to see how it works
- Also, for both I've created a static method in order to create the connection with the ACTIVEMQ, check out the class "utils.java"

## References

- (Tutorial JMS - ACTIVEMQ)[http://www.coderpanda.com/jms-example-using-apache-activemq/]