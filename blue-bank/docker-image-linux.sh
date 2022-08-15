#!/bin/bash

export IMAGE_NAME=wallacyrezende/api-blue-bank:1.0-dev

mvnw clean package -DskipTests
docker image rm $IMAGE_NAME
docker build -t $IMAGE_NAME .
docker push $IMAGE_NAME
