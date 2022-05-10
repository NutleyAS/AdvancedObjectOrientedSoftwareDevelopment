package ie.gmit.dip;

import java.util.Scanner;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 
 * @author Aron Nutley
 * @version 1.0
 * @since 2020-09
 * @references See README.txt
 * 
 * Generates a User Interface that allows user to input query folder and subject file
 * This shows the Similarity as a percentage
 *
 */

public class DisplayMenu {
	private Scanner scanner = new Scanner(System.in);
	private Calculator calculator = new Calculator();
	private int size = 0, fileCounter = 1, i;
	private String queryFolder, subjectFile;

	/**
	 * @throws InterruptedException
	 * @param run() calls the menu function
	 */
	
	public void run() throws InterruptedException {
		menu();
	}

	/**
	 * 
	 * @throws InterruptedException
	 * @param menu() generates User Interface
	 */
	
	public void menu() throws InterruptedException {
		System.out.println("####################################################");
		System.out.println("#          Cosine Distance Calculator              #");
		System.out.println("#                   Main Menu                      #");
		System.out.println("####################################################");
		System.out.println("Step 01 - Input Blocking Queue");
		System.out.println("Step 02 - Input Full Address For Query Folder");
		System.out.println("Step 03 - Input Full Address For Subject File");
		System.out.println("####################################################");
		System.out.println("Please Input Blocking Queue Size: ");
		
		size = scanner.nextInt();

		BlockingQueue<Word> blockingQueue = new ArrayBlockingQueue<Word>(size);

		System.out.print("Enter Address Of Query Folder: ");
		queryFolder = scanner.next();

		File files = new File(queryFolder);
		File[] fileArray = files.listFiles();

		for (File file : fileArray) {
			if (file.isFile()) {
				new Thread(new FolderManager(blockingQueue, file, fileCounter)).start();
			}

			fileCounter++;
		}

		Thread fileThread = new Thread(new QueueGenerator(blockingQueue, calculator, fileCounter));

		fileThread.start();

		System.out.print("Enter Full Address Of Subject File To Compare Against Files In Query Folder: ");
		subjectFile = scanner.next();

		File qFile = new File(subjectFile);
		Thread queryThread = new Thread(new SubjectManager(calculator, qFile));

		queryThread.start();

		fileThread.join();
		queryThread.join();

		System.out.println("\nSimilarity:");

		for (File fileLoop : fileArray) {
			if (fileLoop.isFile()) {
				i++;

				System.out.println(i + ": " + fileLoop.getName() + ", " + qFile.getName() + " = "
						+ calculator.getCosine(fileLoop.getName())+ "%");
			}
		}

	}
}
