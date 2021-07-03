# sample-springboot-project
Hitk-Communtity
https://meet.google.com/kue-txca-btw

Docker Postgress Setup:- 
1.	Open cmd and pull the docker postgres image using command :
 docker pull postgres
2.	Wait for it download 
3.	Run the container using command :
 docker run --name postgresContainer -e POSTGRES_PASSWORD=123 -d -p 5432:5432 postgres
4.	Verify if the container is running using command :
 docker ps
5.	You can execute psql commands using command : 
docker exec -it ContainerID psql -U postgres     
Where ContainerID is the ID you obtain from docker ps command  
6.	Once psql opens, use this command to create a test database :
 create DATABASE hitk_db;


##Integration 
1.Open every Java file in the cntroller and change the local host link in the Cross origin Annotation
