Student name: Aron Nutley
Student number: G00388055

This program was made for the Advanced Object Oriented Software Development modual of H.Dip in Software Development.

========================================================================
Operation

The operation of this program is broken down into 3 steps.

Step 01: Define the size of the blocking queue. For this enter a positive integer.

Step 02: Enter the address of the query folder. For this the full address of the folder must be entered. For example for checking the files in File1 enter the following 'TestFiles/File1'. If using command prompt the full directory must be entered.

Step 03: Enter the address of the subject file. For this the full address of the file must be entered. For example for comparing the file 'file1.txt' to the subject folder in Step 02 the folloing would be entered 'TestFiles/File1/file1.txt' Like in Step 02 if using command prompt the full directory must be entered.

Step 04: The application will act on the inputted information and will give the Similarity of the file to the folder in percentage. 

========================================================================
Information
========
This application uses eight main classes. The Classes are: Runner, DisplayMenu, Calculator, Word, SubjectManager, FolderManager, QueueGenerator and WordInstance.

Runner
======
This Class runs the program.

DisplayMenu
==========
This class creates a primitave User Interfaces that allows the User to do the following:
1. Define Size of Blocking Queue
2. Input the subject folder and subject file.
3. View the similarity between the subject file and the files in the query folder.

Calculator
========
This class recieves the words contained inside the files in the query folder and subject file, it stores them into sepearte maps. It then uses this information, by passing these maps into a function and calculates the cosine distance between files. This figure is then converted into a percentage which shows similarity between the files/folders.

Word
====
This class is used to get the file, words contained in the file and the file count

SubjectManager
===========
This class takes in the query file and passes it to the 'Calculator' class.

FolderManager
=========
This class is similar to the 'SubjectManager' class. It takes in the subject files and puts them onto the blocking queue.

QueueGenerator
============
This takes a word from the blocking queue and passes it to the 'Word' class. This offers O(1) notation allowing the program to operate concurrently and compare multiple files instead of just one.

WordInstance
==========
Receives words from the class 'QueueGenerator'

========================================================================
Optional Extras
===========
The information below discusses optional extras that were added to the project.

Subject Folder
==========
Instead of comparing a query file and subject file this program compares a file to a folder. This alows the user to compare multiple files and saves time.

Blocking Que
==========
Instead of  processing the shingles with treads and building maps with these the application places them onto a blocking queue before this. The blocking queue offers O(1) notation meaning that the program will operate efficiently when comparing multiple files.

========================================================================
Outstanding Issues
==============
The application works when comparing .txt files that only have one line of text. This is not ideal as the purpose of the project is to compare large txt files. Unfortunately I did not get to rectify these issues but I suspect that it is something to do with either the 'Calculator' Class or the 'FolderManager' class. Issues are commented on in the program.

========================================================================
References
=========
1. https://www.sciencedirect.com/topics/computer-science/cosine-similarity 
2. https://learnonline.gmit.ie/mod/forum/view.php?id=63501 
3. https://www.javatpoint.com/super-keyword 
4. https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html 
5. https://github.com/kevinniland/Multi-threaded-Cosine-Distance-Computer 
6. https://stackoverflow.com/questions/520241/how-do-i-calculate-the-cosine-similarity-of-two-vectors
7. https://www.oracle.com/ie/technical-resources/articles/java/javadoc-tool.html
8. https://www.draw.io 
9. https://blog.nishtahir.com/fuzzy-string-matching-using-cosine-similarity/ 
10. https://github.com/JoseIgnacioRetamalThomsen/Multithreaded-Cosine-Distance-Computer-
11. https://www.faqforge.com/windows/windows-10/find-and-open-files-using-windows-command-prompt/ 
12. https://neo4j.com/docs/graph-algorithms/current/labs-algorithms/cosine/

========================================================================
