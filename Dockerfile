FROM openjdk:21-slim AS builder
WORKDIR /usr/local/temp
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} application.jar
RUN java -Djarmode=tools -jar application.jar extract --layers --launcher

FROM openjdk:21-slim
ARG VERSION=latest
LABEL version=${VERSION}
LABEL maintainer="Ashutosh Sahoo"
LABEL description="spring-boot-kubernetes-mysql"

WORKDIR /usr/local/app
RUN useradd --user-group --system --create-home --no-log-init app
USER app
COPY --from=builder /usr/local/temp/application/spring-boot-loader/ ./
COPY --from=builder /usr/local/temp/application/snapshot-dependencies/ ./
COPY --from=builder /usr/local/temp/application/dependencies/ ./
COPY --from=builder /usr/local/temp/application/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.launch.JarLauncher"]