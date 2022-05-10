package ie.gmit.dip;

import java.util.concurrent.BlockingQueue;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

  /**
  * 
  * @author Aron Nutley
  * @version 1.0
  * @since 2020-09
  * @references See README.txt
  * 
  * Reads the files in the queryFolder that will be compared against the subject file
  * Implements <b>Runnable</b>
  */

public class FolderManager implements Runnable {
	private BlockingQueue<Word> blockingQueue;
	private File file;
	private int counter;

	public FolderManager(BlockingQueue<Word> blockingQueue, File file, int counter) {
		this.blockingQueue = blockingQueue;
		this.file = file;
		this.counter = counter;
	}

	/**
	 * @param words reads in the subject files line by line and stores them in the String array 'words'
	 * Then iterates over the array and adds each word to the blocking queue using the .put() method
	 */
	
	@Override
	public void run() {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));  //Possible error here if not resolved by submission see Outstanding Issues in README.txt
			
			String nextLine;
			
			while ((nextLine = bufferedReader.readLine()) != null) {
				String[] words = nextLine.toLowerCase().replaceAll("[^A-Za-z0-9 ]", " ").split(" ");
				
				for (String wordLoop : words) {
					blockingQueue.put(new Word(file.getName(), wordLoop, counter));
				}
			}
			
			blockingQueue.put(new WordInstance());
			
			bufferedReader.close();
			
		} catch (IOException ioException) {
			ioException.printStackTrace();
			
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}
}


