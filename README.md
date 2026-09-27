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

