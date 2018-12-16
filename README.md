# SOngService
Service for everithing song related.

[![Build Status](https://travis-ci.org/Kolebnica/SongService.svg?branch=master)](https://travis-ci.org/Kolebnica/SongService)

## REST API

Default port: 8082

Accessing OpenAPI: [localhost:8082/api-specs/ui/?url=http://localhost:8082/api-specs/api/openapi.json](localhost:8082/api-specs/ui/?url=http://localhost:8082/api-specs/api/openapi.json)

## Making & running a Docker image

1. Build Docker image with `docker build -t skiprope/songservice . `
2. Run Docker image `docker run --name skiprope-songservice --publish 8082:8082 --detach skiprope/songservice`
3. Stop & remove docker container `docker stop skiprope-songservice && docker rm skiprope-songservice`
4. Remove docker image `docker rmi skiprope/songservice`