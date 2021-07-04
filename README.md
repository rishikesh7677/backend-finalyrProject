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

./feeds
{
	[Post]
}



./feed/postid
Post Model
{
	Post Id : Number,
	Title : String,
	Content : String,
	Image :  String64,
	Comments : [Comment],
	LikeCount : Number,
Is_approved: boolean,
	Creator Id : Number,
	Created at :  timestamp
}

Comment Model:
{
	Comment Id : Number,
	Content :String,
	Creator Id : Number,
	Created at : Timestamp
}


./feedback

Feedback model
{
	Query Id: Number,
	Content : String,
	Created at : Timestamp,
	Response : String,
	Response at :Timestamp,
	Creator Id : Number
}




./Suggestion
Opportunity Suggestion model
{
	Suggestion Id: Number,)
	Title: String, (Mandatory)
Description: String,
	Link : String, (Mandatory)
	Image : String64,
	Created at : Timestamp,
	Response : String,
Is_approved: boolean,
	Response at :Timestamp,
	Creator Id : Number
}
/opportunities
{
	[Opportunity Suggestion Model] 
}

./Create_Event
Create  Event model
{
	Event Id: Number,
	Title: String, (Mandatory)
Description: String,
	Link : String, (Mandatory)
	Image : String64,
	Event Date : TimeStamp,
Is_approved: boolean,
	Created at : Timestamp,
	Creator Id : Number,
	LikeCount : Number,
	Comments : [Comment]
}


/events
{
	[create event model] 
}


./auth/register

{
	User name : String,
	Roll Number : Number,
	Email : String,
	Stream : String,
	Batch : Number,
	Phone : Number,
	Password : String
}

./auth/login
{
	Email : String
	Password : String
}



/notice
{
	Title : String,
	Description : String,
	Source : String,
	Date : Timestamp,
	Publish date: Timestamp,
	Notice id : Number
}


./create_project_Expo

CreateProjectExpo  model
{
	Project Id: Number,)
	Title: String, (Mandatory)
Description: String,
	Link : String, (Mandatory)
	Image : String64,
Is_approved: boolean,
	Created at : Timestamp,
	Like count : number,
	Comment : [Comment]
	Creator Id : Number
}



./myaccounts
{
	[register]
}

./ProjectExpo
{
	[Create Project Expo]
}


Java 11 Installation on Windows
Installation
1.  	Go to https://www.oracle.com/in/java/technologies/javase-jdk11-downloads.html[TM1] 
2.  	Download Windows x64 Installer and install it.
3.  	You will need to create an oracle account to download.
Setting Java path in windows environment variable
1.      Search for “Edit the System Environment Variables” in windows search and open it.
 
 
 
2.      Go to environment Variables
 
 
3.      In “Environment variables” dialog, System variables, Click on the New... button and add a JAVA_HOME variable and point it to your java installation directory (C:\Program Files\Java\jdk-11.0.10)
4.      Under System Variables find PATH click on Edit…. Find any older Java path (probably java 1.8 path) there and delete it.
5.      Add the Java 11 installation bin folder path (C:\Program Files\Java\jdk-11.0.10\bin) by clicking on New.
6.      Open command prompt and verify the Java installation by typing java -version. It should be 11.0.10
 
Maven Setup
1.      Download maven zip from https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip
2.  	Search for “Edit the System Environment Variables” in windows search, open it and got to Environment Variables just like in Java Installation.
3.  	In “Environment variables” dialog, System variables, Click on the New... button and add a MAVEN_HOME variable and point it to your unzipped folder directory for maven (C:\maven\apache-maven-3.6.3)
 





4.In system variables, find PATH, clicks on the Edit... button. In “Edit environment variable” dialog, clicks on the New button and add this %MAVEN_HOME%\bin
 
5.  	Verify this by running mvn -version command in cmd.
Note : You don’t need separate maven setup , IntelliJ already comes with built in maven and you can run all the maven commands inside IntelliJ. This is useful only for building the java project using cmd or if there is an issue with IntelliJ’s maven.
 
 
IntelliJ Installation
 
1.  	Go to https://www.jetbrains.com/idea/download/#section=windows, download the community edition of IntelliJ and install it.
2.  	Download this sample springboot project https://git.hashedin.com/husain.topiwala/sample-springboot-project
3.  	Open the downloaded project from IntelliJ.[TM2] 
4.  	Select maven [TM3] as build tool (IntelliJ comes preinstalled with maven).
5.  	Please wait for IntelliJ to index Java 11 and download all the dependencies in pom.xml file.
6.  	Open Class containing main function (src/main/java/com/example/springboot/Application.java)
7.  	You can manually set configuration to run specific class when you click on run button or you can go to main class and click on run button to left of main function which will setup the run configuration automatically.
 


8.  	You can click on run button on top right from next time onwards.
9.  	If the build is successful, the output should be as shown in following image. The output in terminal is list of all beans. Also, you can verify the controller by visiting http://localhost:8080
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
Postman installation
1.  	Download postman from https://www.postman.com/downloads/
2.  	Install it and create a new account in the app if you don’t already have one.
3.  	Click on + icon and you should be read to start testing your APIs, attaching image for reference
Docker Setup
1.  	Please ignore if you already have docker installed.
2.  	Download docker here https://desktop.docker.com/win/stable/Docker%20Desktop%20Installer.exe
3.  	 When prompted, ensure the Enable Hyper-V Windows Features option is selected on the Configuration page.
4.  	Follow the instructions on the installation wizard to authorize the installer and proceed with the install.
5.  	When the installation is successful, click Close to complete the installation process.
6.  	 If your admin account is different to your user account, you must add the user to the docker-users group.
 
 
7.     Add C:\Program Files\Docker\Docker\resources\bin and C:\ProgramData\DockerDesktop\version-bin to Path in system variables in Environment Variables.
8.  	How to add user to the group ->
·   	Open "Computer Management" by pressing the start orb and typing "Computer Management" and open as administrator. Enter password when prompted
 
·   	Locate the "docker-users" group under the "groups" folder and double-click
·   	Double-Click "Add", then "Advanced" and finally "Find Now" to display a list of allusers on the computer
·   	Double-click on your account and you will be added to the group. You will need to close all windows and restart your computer for the changes to take effect.
 
9.  	Start the docker ->
a.      Docker Desktop does not start automatically after installation. To start Docker Desktop, search for Docker, and select Docker Desktop in the search results.
b.      When the whale icon in the status bar stays steady, Docker Desktop is up-and-running, and is accessible from any terminal window.
c.       If the whale icon is hidden in the Notifications area, click the up arrow on the taskbar to show it. To learn more, see Docker Settings.
d.      When the initialization is complete, Docker Desktop launches the onboarding tutorial. The tutorial includes a simple exercise to build an example Docker image, run it as a container, push and save the image to Docker Hub.
e.      Congratulations! You are now successfully running Docker Desktop on Windows.
f.        If you would like to rerun the tutorial, go to the Docker Desktop menu and select Learn.
10.  Verify installation by typing docker ps in cmd and if it shows list of all containers.
 
 
 
Docker Postgres Setup
1.  	Open cmd and pull the docker postgres image using command :
 docker pull postgres
2.  	Wait for it download
3.  	Run the container using command :
 docker run --name postgresContainer -e POSTGRES_PASSWORD=123 -d -p 5432:5432 postgres
4.  	Verify if the container is running using command :
 docker ps
5.  	You can execute psql commands using command :
docker exec -it ContainerID psql -U postgres 	
Where ContainerID is the ID you obtain from docker ps command 
6.  	Once psql opens, use this command to create a test database :
 create DATABASE test_db;
7.  	More docker resources :
https://hub.docker.com/_/postgres/
 
 
DBeaver Installation
1.  	DBeaver is used to connect to any database and view data in tabular form. You can create db , delete db and run native sql queries.
2.  	Go to this link and download Dbeaver https://dbeaver.io/files/dbeaver-ce-latest-x86_64-setup.exe
3.  	Install it and open it.
4.  	Click on new connection on top left and enter database details as shown below.
 
 
5.  	To view tables click on db -> schemas -> public -> tables, you should see your tables listed here
 
 

Do you need to login to download it? Can you mention that as well?  [TM1]
Need to use a sample spring boot project. I would recommend using this project here https://git.hashedin.com/husain.topiwala/sample-springboot-project [TM2]
Need to install maven before that [TM3]


