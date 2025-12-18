#!/bin/bash
echo "Starting nginx..."

# Nginx 설정 테스트
sudo nginx -t

# Nginx 시작
sudo systemctl start nginx
sudo systemctl enable nginx

echo "Nginx started successfully"
