call set MAVEN_OPTS=-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n
call mvn jetty:run <nul
