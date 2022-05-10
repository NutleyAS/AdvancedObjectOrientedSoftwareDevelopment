# Threaded Cosine Distance Calculator for Text Documents

## Introduction 

This program was made for the Advanced Object Oriented Software Development modual of H.Dip in Software Development. For the project I was required to develop a Java API that can rapidly compare a query file against a subject file by computing the cosine distance between them. The API should uphold the principles of loose-coupling and high cohesion throughout its design by correctly applying abstraction, encapsulation, composition and inheritance.

## Minimum Requirements

  * Use the package name ie.gmit.dip. The application myst be deployed and runnable using the specification in Section 3.
  * Create a console-based menu-driven UI to input the path of a subject file to index a query file to compare. Any other input parameters should be input through the menu-driven UI.
  * Each file should be parsed, processed and added to a rapidly searchable data structure.
  * The application should be fully threaded and use Runnable types where appropriate.
  * The output of the system should be the percentage similarity of the input query file against the subject file.
  * Provide a UML diagram of your design and fully JavaDoc your code.

## Operation

The operation of this program is broken down into 3 steps.

1. Define the size of the blocking queue. For this enter a positive integer.
2. Enter the address of the query folder. For this the full address of the folder must be entered. For example for checking the files in File1 enter the following 'TestFiles/File1'. If using command prompt the full directory must be entered.
3. Enter the address of the subject file. For this the full address of the file must be entered. For example for comparing the file 'file1.txt' to the subject folder in Step 02 the folloing would be entered 'TestFiles/File1/file1.txt' Like in Step 02 if using command prompt the full directory must be entered.
4. The application will act on the inputted information and will give the Similarity of the file to the folder in percentage. 

### Information

This application uses eight main classes. The Classes are: Runner, DisplayMenu, Calculator, Word, SubjectManager, FolderManager, QueueGenerator and WordInstance.

### Runner

This Class runs the program.

### DisplayMenu

This class creates a primitave User Interfaces that allows the User to do the following:
1. Define Size of Blocking Queue
2. Input the subject folder and subject file.
3. View the similarity between the subject file and the files in the query folder.

### Calculator

This class recieves the words contained inside the files in the query folder and subject file, it stores them into sepearte maps. It then uses this information, by passing these maps into a function and calculates the cosine distance between files. This figure is then converted into a percentage which shows similarity between the files/folders.

### Word

This class is used to get the file, words contained in the file and the file count.

### SubjectManager

This class takes in the query file and passes it to the 'Calculator' class.

### FolderManager

This class is similar to the 'SubjectManager' class. It takes in the subject files and puts them onto the blocking queue.

### QueueGenerator

This takes a word from the blocking queue and passes it to the 'Word' class. This offers O(1) notation allowing the program to operate concurrently and compare multiple files instead of just one.

### WordInstance

Receives words from the class 'QueueGenerator'

## Optional Extras

The information below discusses optional extras that were added to the project.

### Subject Folder

Instead of comparing a query file and subject file this program compares a file to a folder. This alows the user to compare multiple files and saves time.

### Blocking Que

Instead of  processing the shingles with treads and building maps with these the application places them onto a blocking queue before this. The blocking queue offers O(1) notation meaning that the program will operate efficiently when comparing multiple files.

### Outstanding Issues

The application works when comparing .txt files that only have one line of text. This is not ideal as the purpose of the project is to compare large txt files. Unfortunately I did not get to rectify these issues but I suspect that it is something to do with either the 'Calculator' Class or the 'FolderManager' class. Issues are commented on in the program.

