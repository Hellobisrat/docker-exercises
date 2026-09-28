#### This project is for the Devops bootcamp exercise for 
#### "Containers - Docker" 


# SQL image added
docker run --name my-mysql \
  -e MYSQL_ROOT_PASSWORD=pass \
  -e MYSQL_DATABASE=mydb \
  -e MYSQL_USER=myuser \
  -e MYSQL_PASSWORD=mypass \
  -p 3306:3306 \
  -d mysql:8


# php image 
docker run --name my-phpmyadmin \
  --link my-mysql:db \
  -p 8081:80 \
  -e PMA_HOST=my-mysql \
  -e PMA_PORT=3306 \
  -d phpmyadmin/phpmyadmin


  # copy the images / project to server
  scp -i ~/.ssh/id_rsa -r docker-exercises root@157.245.140.57:/root/

# build inside the server
cd /root/docker-exercises
./gradlew build
docker compose up -d --build


# tag image for nexus
docker tag docker-exercises-app 167.99.238.79:8083/docker-exercises-app


# after tag log in nexus docker
docker login 167.99.238.79:8083

# push
docker push 167.99.238.79:8083/docker-exercises-app
# pull
docker pull 167.99.238.79:8083/docker-exercises-app



