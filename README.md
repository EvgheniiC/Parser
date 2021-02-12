# Parser
test task for the company *** 

Task 1
What does the Parser class do?

Answer
  - takes as input a date (string parameter), which consists of 4 elements separated by /
  - the first parameter is the clock
  - the second parameter is minutes
  - the third parameter is seconds
- the fourth parameter is milliseund
  - using the convert method, incoming data will be parsed into Integer
  - the display shows the current date + the entered time in the format "dd.MM.yyyy HH: mm: ss"
- This method can be used to show, for example, the time until the end of a promotion. 


Task 2
What problems do you see in the Parser class?

Answer
- StringTokenizer class is deprecated see link https://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html
  It is recommended that anyone looking for this functionality use the split method for String or the java.util.regex package.

- Using the Calendar class is not always the best solution,
  that is, data can be changed in streams. While the classes of the Java.theme package always get a new object. 
  
Task 3
Refactor the Parser class so that the problems
from Exercise 2 have been resolved.

Answer
 - see repository 

Task 4
Please write a JUnit test for the newly created class 

Answer
see repository 

