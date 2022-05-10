package ie.gmit.dip;

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
 *Reads the subject file that will be compared against the files in the query folder.
 *Implements <b>Runnable</b>
 *
 */

public class SubjectManager implements Runnable { //Sets the instance variables
	private Calculator calculator;
	private File file;

	public SubjectManager(Calculator calculator, File file) {
		this.calculator = calculator;
		this.file = file;
	}

	/**
	 * @param words reads in the subject file and stores them in String array 'words'.
	 * The iterates over the array and adds each word to the query map using the function 'addQuery'
	 * 
	 */
	
	
	public void run() {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
			
			String nextLine;
			
			while ((nextLine = bufferedReader.readLine()) != null) {
				String[] words = nextLine.toLowerCase().replaceAll("[^A-Za-z0-9 ]", " ").split(" ");
				
				for (String wordLoop : words) {
					calculator.addQuery(new Word(file.getName(), wordLoop, 0));
				}
			}
			
			bufferedReader.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
