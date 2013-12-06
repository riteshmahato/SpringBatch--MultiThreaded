SpringBatch Multi-Threaded
==========================

This is a basic implementation of a multi-threaded Spring Batch Job. Many people find difficulty in implementing the multi-threaded model as the reader is not synchronized and results in "Cursor mismatch error" when two threads access the cursor simultaneously. This is a basic job consisting of an ItemReader that reads from a local mysql db (table : circle) and processes using an interface of ItemProcessor and writes to a database table using a prepared statement in the ItemWriter provided by Spring Framework. All those facing difficulty setting up their basic multi-threaded spring batch Job can refer this.

All suggestions to make this a better example are welcome.


##How to Run

1. Import the files in Eclipse as an "Existing Maven project".
2. Let Maven download all the dependencies and Jars from "pom.xml" in the project.
3. Open src/main/java/SpringBatchJob.xml and set the url for JobRepository and dataSource as per your requirement.
4. Set the no of threads in the task executor bean and set the throttle limit (default : i've set it to 6).
5. Either modify the sql statements as per need or use the sqldum file "db_dum.sql" in the repository and restore it to get the database and tables I used.
	```
		restore:# mysql -u root -p[root_password] db < db_dump.sql
	```
6. Change the sql statements as needed (it has been set to read from a local mysql db, table:'circle'(ID number,NAME varchar).
7. Change the PSSetter to set your required prepared statement as per your writer sql query.
8. Build project and run "App.java"

###NOTE
In "SpringBatchJob.xml", uncomment the lines 
```html
<jdbc:initialize-database data-source="repoDataSource"> 
		<jdbc:script location="org/springframework/batch/core/schema-drop-mysql.sql" /> 
		<jdbc:script location="org/springframework/batch/core/schema-mysql.sql" /> 
  	</jdbc:initialize-database>   
```

for the "first run only". Then comment the lines for all subsequent runs. It is for initializing the job repository.
