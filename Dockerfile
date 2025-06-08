# Usamos imagen oficial de Tomcat
FROM tomcat:9.0-jdk11-openjdk

# Borramos apps por defecto
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiamos el .war corregido
COPY TRABAJOIT_WEB_fixed.war /usr/local/tomcat/webapps/ROOT.war

# Puerto que expone Tomcat
EXPOSE 8080
