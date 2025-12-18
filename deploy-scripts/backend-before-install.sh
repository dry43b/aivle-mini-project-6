#!/bin/bash
echo "Preparing for backend installation..."

# 디렉토리 생성
sudo mkdir -p /var/www/book-ms-backend
sudo mkdir -p /var/www/book-ms-backend/logs

# 기존 JAR 파일 백업
if [ -f "/var/www/book-ms-backend/bookms.jar" ]; then
    echo "Backing up existing JAR file..."
    sudo mv /var/www/book-ms-backend/bookms.jar /var/www/book-ms-backend/bookms.jar.backup
fi

# 권한 설정
sudo chown -R ec2-user:ec2-user /var/www/book-ms-backend
sudo chmod -R 755 /var/www/book-ms-backend
