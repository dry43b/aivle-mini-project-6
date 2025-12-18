#!/bin/bash
echo "Backend JAR file deployed successfully"

# JAR 파일 확인
if [ -f "/var/www/book-ms-backend/bookms.jar" ]; then
    echo "JAR file found:"
    ls -lh /var/www/book-ms-backend/bookms.jar
else
    echo "ERROR: JAR file not found!"
    exit 1
fi

# 실행 권한 부여
chmod +x /var/www/book-ms-backend/bookms.jar
