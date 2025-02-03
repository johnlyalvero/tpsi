FROM oraclelinux:9

RUN yum update -y
RUN yum install java-11-openjdk-devel

RUN mkdir helloworld
WORKDIR ./helloworld
COPY HelloWorld.java .

RUN javac HelloWorld.java
CMD ["java","HelloWorld"]