#!/bin/bash
jar_file=$2
pid_file="${jar_file%.*}.pid"
case $1 in
start)
	java -server -Duser.timezone=UTC -Dfile.encoding=UTF-8 -jar $jar_file --spring.profiles.active=production >out.log 2>err.log &
    echo $! > $pid_file
	;;
stop)
    kill `cat $pid_file`
	rm $pid_file
	;;
*) echo  "USAGE: ./microserv.bash <start|stop> <jar file>";;
esac

