#!/bin/bash
echo "Validating backend deployment..."

# 프로세스 확인
if [ -f /var/www/book-ms-backend/app.pid ]; then
    PID=$(cat /var/www/book-ms-backend/app.pid)
    
    if ps -p $PID > /dev/null; then
        echo "Application process is running (PID: $PID)"
        
        # HTTP 헬스체크 (최대 30초 대기)
        for i in {1..30}; do
            HTTP_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/actuator/health || echo "000")
            
            if [ "$HTTP_CODE" = "200" ]; then
                echo "Backend is healthy (HTTP $HTTP_CODE)"
                exit 0
            fi
            
            echo "Waiting for application to be ready... ($i/30)"
            sleep 1
        done
        
        echo "Application failed to respond after 30 seconds"
        tail -n 50 /var/www/book-ms-backend/logs/application.log
        exit 1
    else
        echo "Application process is not running"
        exit 1
    fi
else
    echo "PID file not found"
    exit 1
fi
