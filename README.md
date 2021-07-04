# sample-springboot-project
Hitk-Communtity
https://meet.google.com/kue-txca-btw

Docker Postgress Setup:- 
1.	Open cmd and pull the docker postgres image using command :

```
 docker pull postgres
```

2.	Run the container using command :

```
 docker run --name postgresContainer -e POSTGRES_PASSWORD=123 -d -p 5432:5432 postgres
```

3.	Verify if the container is running using command :

```
 docker ps
```

4.	You can execute psql commands using command : 

```
docker exec -it <ContainerID> psql -U postgres     
```

5.	Once psql opens, use this command to create a test database :

```
 create DATABASE hitk_db;
```

## Integration 
1.Open every Java file in the cntroller and change the local host link in the Cross origin Annotation


## Dependencies list 
1. Java [v-11]
2. Dbeaver
3. intelliJ
