#!/bin/bash
echo "Stopping Spring Boot application..."

# PID 파일 확인 및 프로세스 종료
if [ -f /var/www/book-ms-backend/app.pid ]; then
    PID=$(cat /var/www/book-ms-backend/app.pid)
    if ps -p $PID > /dev/null; then
        echo "Killing process $PID"
        kill -15 $PID
        sleep 5
        
        # 강제 종료가 필요한 경우
        if ps -p $PID > /dev/null; then
            echo "Force killing process $PID"
            kill -9 $PID
        fi
    fi
    rm -f /var/www/book-ms-backend/app.pid
fi

# Java 프로세스 확인 및 종료
JAVA_PID=$(pgrep -f "bookms.jar")
if [ ! -z "$JAVA_PID" ]; then
    echo "Found running Java process: $JAVA_PID"
    kill -15 $JAVA_PID
    sleep 5
fi

echo "Application stopped"
