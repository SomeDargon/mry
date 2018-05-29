@echo off

set server_host=121.42.142.228
set username=root
set password=uyi2July18

set http_port=8080

sed -i "s/pic.server.host=http:\/\/localhost:8080/pic.server.host=http:\/\/%server_host%:%http_port%/g" web\src\main\resources\config.properties
sed -i "s/pic.server.host=http:\/\/localhost:80/pic.server.host=http:\/\/%server_host%:%http_port%/g" web\src\main\resources\config.properties

echo.&echo ======= Maven Package =================
call mvn clean install -DskipTests
echo.&echo ======= Maven Package End =============
sed -i "s/pic.server.host=http:\/\/%server_host%:%http_port%/pic.server.host=http:\/\/localhost:8080/g" web\src\main\resources\config.properties
rm -f sed*

REM echo.&echo ======= Copy WAR to Server ============
REM pscp -pw %password% web\target\ROOT.war %username%@%server_host%:/root/

REM echo.&echo ======= Server Deploy WAR to Tomcat ===
REM plink -ssh -pw %password% %username%@%server_host% pkill -f tomcat;
REM plink -ssh -pw %password% %username%@%server_host% rm -rf /opt/tomcat/webapps/ROOT*
REM plink -ssh -pw %password% %username%@%server_host% mv /root/ROOT.war /opt/tomcat/webapps/
REM plink -ssh -pw %password% %username%@%server_host% export JAVA_HOME=/opt/jdk; export JAVA_OPTS='-Xms1025M -Xmx1025M'; /opt/tomcat/bin/startup.sh
REM echo.&echo ======= Server Runing =================

