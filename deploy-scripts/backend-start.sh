#!/bin/bash
echo "Starting Spring Boot application..."

cd /var/www/book-ms-backend

# 환경변수 설정 (필요한 경우)
export SPRING_PROFILES_ACTIVE=prod

# 애플리케이션 시작
nohup java -jar \
    -Dserver.port=8080 \
    -Dspring.profiles.active=prod \
    bookms.jar \
    > logs/application.log 2>&1 &

# PID 저장
echo $! > app.pid

echo "Application started with PID: $(cat app.pid)"
sleep 10

# 로그 확인
echo "Recent application logs:"
tail -n 20 logs/application.log
