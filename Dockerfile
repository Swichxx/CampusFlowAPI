# Use a imagem oficial do Java
FROM openjdk:17-jdk-slim

# Copia o jar da aplicação para dentro do container
COPY target/seu-app.jar app.jar

# Expõe a porta que a aplicação vai rodar
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","/app.jar"]
