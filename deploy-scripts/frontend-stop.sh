#!/bin/bash
echo "Stopping nginx for frontend deployment..."
sudo systemctl stop nginx || true
