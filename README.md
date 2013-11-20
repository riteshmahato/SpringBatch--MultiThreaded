SpringBatch Multi-Threaded
==========================

This is a basic implementation of a multi-threaded Spring Batch Job. Many people find difficulty in implementing the multi-threaded model as the reader is not synchronized and results in "Cursor mismatch error" when two threads access the cursor simultaneously. This is a basic job consisting of an ItemReader that reads from a local mysql db (table : circle) and processes using an interface of ItemProcessor and writes to a database table using a prepared statement in the ItemWriter provided by Spring Framework. All those facing difficulty setting up their basic multi-threaded spring batch Job can refer this.

All suggestions to make this a better example are welcome.


##How to Run

1. Import the files in Eclipse as an "Existing Maven project".
2. Let Maven download all the dependencies and Jars from "pom.xml" in the project.
3. Open src/main/java/SpringBatchJob.xml and set the url for Job repository and data source to your requirement.
4. Set the no of threads in the task executor bean and set the throttle limit (default : i've set it to 6).
5. Change the sql statements to your requirement (it has been set to read from a local mysql db table 'circle' (ID,NAME).
6. Change the PSSetter to set your required prepared statement as per your writer sql query.
7. Build project and run App.java
