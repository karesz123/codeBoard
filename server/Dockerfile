#### Stage 1: Build the application
FROM adoptopenjdk/openjdk11:latest as app_build
WORKDIR /app
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle gradle
COPY src src
RUN ./gradlew build -x test
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)

#### Stage 2: A minimal docker image with command to run the app 
FROM adoptopenjdk/openjdk11:latest
RUN groupadd -g 999 spring && useradd -r -u 999 -g  spring spring
USER spring:spring
ARG DEPENDENCY=/app/build/dependency
COPY --from=app_build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=app_build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=app_build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.codeBoard.CodeBoardApplication"]
