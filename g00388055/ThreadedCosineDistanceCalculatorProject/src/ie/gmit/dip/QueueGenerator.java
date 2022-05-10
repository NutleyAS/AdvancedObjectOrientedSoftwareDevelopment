package ie.gmit.dip;

import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author Aron Nutley
 * Version 1.0
 * Since 2020-09
 * @references See README.txt
 * 
 *Takes a word from blocking queue and passes it to the 'Word' Class.
 *
 */

public class QueueGenerator implements Runnable {
	private BlockingQueue<Word> blockingQueue;
	private Calculator calculator;
	private int fileCount;
	private int counter = 0;
	private boolean keepRunning = true; 

	public QueueGenerator(BlockingQueue<Word> blockingQueue, Calculator calculator, int fileCount) {
		this.blockingQueue = blockingQueue;
		this.calculator = calculator;
		this.fileCount = fileCount;
	}

	/**
	 * @param run() takes a word from the block queue and passes it to the instance of 'Word'
	 * If the current word is not an instance of 'WordInstance', it will put the word into the file map using the 'addWord; function
	 * keepRunning boolean keeps the application running
	 * 
	 */
	
	@Override
	public void run() {
		try {
			while (keepRunning) {
				Word word = blockingQueue.take();
				
				if (word instanceof WordInstance) {
					counter++;
				} else {
					calculator.addWord(word);
				}
				
				if (counter == fileCount - 1) {
					keepRunning = false;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
