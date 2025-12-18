#!/bin/bash
echo "Preparing for frontend installation..."

# 기존 파일 백업
if [ -d "/var/www/book-ms-frontend" ]; then
    echo "Backing up existing frontend files..."
    sudo rm -rf /var/www/book-ms-frontend.backup
    sudo cp -r /var/www/book-ms-frontend /var/www/book-ms-frontend.backup
fi

# 디렉토리 생성
sudo mkdir -p /var/www/book-ms-frontend
sudo chown -R ec2-user:ec2-user /var/www/book-ms-frontend
