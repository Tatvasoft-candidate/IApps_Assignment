FROM eclipse-temurin:11.0.18_10-jre-alpine@sha256:4edcb9a82ae75460ff836a63d7bf2d601635233130952083f5bc79bf888ea8ad
WORKDIR /home/user/Desktop
RUN addgroup --system javauser && adduser -S -s /home/user/Desktop/iapps -G javauser javauser
COPY target/iapps.jar /iapps.jar
RUN chown -R javauser:javauser .
USER javauser
ENTRYPOINT ["java", "-jar", "/iapps.jar"]

