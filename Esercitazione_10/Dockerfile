# Usa l'immagine base di OpenJDK
FROM openjdk:17

# Imposta la directory di lavoro
WORKDIR /app

# Copia i file sorgente nel container
COPY . /app

# Compila il codice
RUN javac HttpServer.java

# Esponi la porta 8080
EXPOSE 8080

# Avvia il server
CMD ["java", "HttpServer"]