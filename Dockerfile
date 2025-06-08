# Usamos imagen oficial de Tomcat
FROM tomcat:9.0-jdk11-openjdk

# Borramos apps por defecto (opcional)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiamos nuestro .war
COPY TRABAJOIT_WEB.war /usr/local/tomcat/webapps/ROOT.war

# Puerto que expone Tomcat
EXPOSE 8080
