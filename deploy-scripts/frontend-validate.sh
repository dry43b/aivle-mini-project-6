#!/bin/bash
echo "Validating frontend deployment..."

# Nginx 상태 확인
if sudo systemctl is-active --quiet nginx; then
    echo "Nginx is running"
    
    # HTTP 응답 확인
    HTTP_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost)
    if [ "$HTTP_CODE" = "200" ]; then
        echo "Frontend is responding correctly (HTTP $HTTP_CODE)"
        exit 0
    else
        echo "Frontend returned unexpected HTTP code: $HTTP_CODE"
        exit 1
    fi
else
    echo "Nginx is not running"
    exit 1
fi
