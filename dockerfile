FROM tomcat:8.0.43-jre8-alpine
MAINTAINER khannanitin106@gmail.com
ADD  movie-0.0.2-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8080 80 443
CMD chmod +x /usr/local/tomcat/bin/catalina.sh
CMD ["catalina.sh", "run"]
