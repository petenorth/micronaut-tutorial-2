# micronaut-tutorial-2
A record of working through https://www.infoq.com/articles/micronaut-tracing-security-serverless?utm_source=infoq&utm_campaign=user_page&utm_medium=link

## But to get it working it should just be

Start Consul in the background

    docker run -d -p 8500:8500 consul

Start zipkin in the background 

    docker run -d -p 9411:9411 openzipkin/zipkin
    
Run the different microservices via gradle in parallel

    ./gradlew -parallel run
    
And then to test in a separate shell

    OUTPUT="$(curl -v -X "POST" "http://localhost:8080/login" -H 'Content-Type: application/json; charset=utf-8' -d $'{ "username": "sherlock", "password": "elementary" }' | python -c "import sys, json; print json.load(sys.stdin)['access_token']")"
    curl -v "http://localhost:8080/api/books" -H "Authorization: Bearer ${OUTPUT}"
