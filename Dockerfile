FROM maven:3.8.3-openjdk-16@sha256:abbf9c557da32c644762a29798bad90ea7d8a7adfe82241f927d253e2d6ab49e AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests

FROM adoptopenjdk/openjdk16:x86_64-alpine-jre-16.0.1_9@sha256:ae1c696bb92844e72f5dae6954478b96b5701820e4bc93551e292b3de77e47de
RUN apk add dumb-init
RUN mkdir /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
COPY --from=build /project/target/erp-0.0.1-SNAPSHOT.jar /app/erp.jar
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
CMD "dumb-init" "java" "-jar" "erp.jar"