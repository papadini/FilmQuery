### Film Query App

Intro: this project was to get myself use to and strengthen my skills with connecting Java with a database using SQL, with any new technology
and my style of learning, i find the best way to really learn something is to dive right in and learn the ins and outs first hand.
using maven and connecting the driver all took some reviewing to perform the same task on this project but after some trial and error
i was able to get it connected prior to beginning the search of the data base. My first task after the properly connecting the the data base to
my Java class, i went into SQL and figured out what my select statement needs to be to get the proper data out of the database, after the select
statement is properly formed, i am able to put that into Java using JDBC to encapsulate the SQL code needed to pull data out of database.

Technologies: Java, SQL, JDBC, Interfaces, while-loop, switch

lessons learned:
-Select statement needs to be tested in SQL, it is a waste of time to test in Java code
-Prepared statements are the safest way to avoid SQL injection
-My SQL select string needs to match order of film fields
-Using full names instead of placeholder when writing select statement makes code much more readable
-Same with using full name of what your selecting and not the number or spot its in
