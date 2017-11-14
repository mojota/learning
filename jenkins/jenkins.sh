#!/bin/sh
# chkconfig: - 80 20
# description: auto_start_jenkins_sevcie

JENKINS_ROOT=/home/jenkins/programs
JENKINSFILENAME=jenkins.war

start(){
    echo "Starting $JENKINSFILENAME "
	su - jenkins -c "java -jar $JENKINS_ROOT/$JENKINSFILENAME & "
}

stop(){
    su - jenkins -c "ps -ef|grep $JENKINSFILENAME |awk '{print $2}'| xargs kill -9"
}

status(){
    ps -ef|grep $JENKINSFILENAME
}

case "$1" in
start)
  start
  ;;
stop)
  stop
  ;;
restart)
  stop
  start
  ;;
status)
  status
  ;;
*)
  printf 'Usage: %s {start|stop|restart|status}\n' "$prog"
  exit 1
  ;;
esac
