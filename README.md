SpringBatch Multi-Threaded
==========================

This is a basic implementation of a multi-threaded Spring Batch Job. Many people find difficulty in implementing the multi-threaded model as the reader is not synchronized and results in "Cursor mismatch error" when two threads access the cursor simultaneously. This is a basic job consisting of an ItemReader that reads from a local mysql db (Table: CIRCLE (ID,NAME) ) and processes using an interface of ItemProcessor and writes to a database table using a prepared statement in the ItemWriter provided by Spring Framework. All those facing difficulty setting up their basic multi-threaded spring batch Job can refer this.

All suggestions to make this a better example are welcome.
email - riteshmahato2012@gmail.com
