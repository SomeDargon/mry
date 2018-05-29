#! /bin/bash

server_host=121.42.142.228
username=root
password=uyi2July18

http_port=8080

sed -i "" "s/localhost:8080/$server_host:$http_port/g" web/src/main/resources/config.properties

echo "======= Maven Package ======="
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home
mvn clean install

echo "======= Maven Package End ======="

sed -i "" "s/$server_host:$http_port/localhost:8080/g" web/src/main/resources/config.properties

echo "======= Start Copying WAR to Server ======="

sshpass -p $password scp web/target/ROOT.war $username@$server_host:/root/

echo "======= Finish Copying WAR to Server ======="
echo "======= Start Deploying WAR to Server ======="

sshpass -p $password ssh  -t -t $username@$server_host<< EOF
    pkill -f tomcat
    rm -rf /opt/tomcat/webapps/ROOT*
    mv /root/ROOT.war /opt/tomcat/webapps/
    export JAVA_HOME=/opt/jdk
    export JAVA_OPTS='-Xms1026M -Xmx1026M'
    /opt/tomcat/bin/startup.sh
    sleep 5
    exit
EOF

echo "======= Server Starts Running ======="
