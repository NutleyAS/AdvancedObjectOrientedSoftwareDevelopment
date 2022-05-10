package ie.gmit.dip;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Aron Nutley
 * @version 1.0
 * @since 2020-09
 * @references See README.txt
 *
 *Processes the data from the queryFolder and subjectFile to calculate
 *the cosine difference.
 *
 */

public class Calculator {
	private Map<String, Integer> queryMap = new HashMap<String, Integer>();
	private Map<String, Integer> fileMap = new HashMap<String, Integer>();
	private Map<String, Integer> cosineMap = new HashMap<String, Integer>();

	public Calculator() {

	}

	/**
	 * Adds words from queryFolder to the fileMap
	 * @param word
	 */

	public synchronized void addWord(Word word) {
		String file = word.getFile(); // Step 01

		String words = word.getWord(); // Step 02

		String wordString = file + " " + words; // Step 03

		if (fileMap.containsKey(wordString)) {
			int fileVal = fileMap.get(wordString);
			fileMap.put(wordString, fileVal + 1);
		} else {
			fileMap.put(wordString, +1);
		}
	}

	/**
	 * Adds words from query file to queryMap
	 * @param qWord
	 */

	public void addQuery(Word qWord) {

		String query = qWord.getWord(); //Step 01

		if (queryMap.containsKey(query)) {
			int queryVal = queryMap.get(query);
			queryMap.put(query, queryVal + 1);

		} else {
			queryMap.put(query, +1);
		}
	}

	/**
	 * Gets cosine for values
	 * @param cosVal
	 * @return
	 */
	
	
	public double getCosine(String cosVal) {
		double cosAnswer;

		for (String wordLoop : fileMap.keySet()) {
			if (wordLoop.contains(cosVal)) {
				String wordString = wordLoop.substring(cosVal.length() + 1, wordLoop.length());

				int cosineVal = fileMap.get(wordLoop);

				cosineMap.put(wordString, cosineVal);
			}
		}

		cosAnswer = calculateCosine(queryMap, cosineMap);

		cosineMap.clear();

		return cosAnswer;
	}

	/**
	 * Compares the cosine values and calculates the % similarity
	 * @param queryMap
	 * @param cosineMap
	 * @return cosine
	 */
	
	
	public double calculateCosine(Map<String, Integer> queryMap, Map<String, Integer> cosineMap) {
		int fileOneFreq = 0, fileTwoFreq = 0, counter;
		float dotProductFreq = 0;
		double cosine = 0, cosDist;

		for (String i : queryMap.keySet()) {
			counter = 0;

			for (String j : cosineMap.keySet()) {
				if (i.equalsIgnoreCase(j)) {
					int fileOne = queryMap.get(i);
					int fileTwo = cosineMap.get(j);
					int dotProduct = fileOne * fileTwo;

					fileOneFreq += fileOne;
					fileTwoFreq += fileTwo;
					dotProductFreq += dotProduct;

					counter++;
				}
			}

			if (counter == 0) {
				int fileOne = queryMap.get(i);
				//fileOneFreq -= fileOne;
				fileOneFreq += fileOne; 
			}
		}

		for (String i : cosineMap.keySet()) {
			counter = 0;

			for (String j : queryMap.keySet()) {
				if (i.equalsIgnoreCase(j)) {
					counter++;
				}
			}

			if (counter == 0) {
				int fileTwo = cosineMap.get(i);
				//fileTwoFreq -= fileTwo;
				fileTwoFreq += fileTwo;
			}
		}

		double fOneCalc = Math.sqrt(fileOneFreq);
		double fTwoCalc = Math.sqrt(fileTwoFreq);

		cosDist = (fOneCalc * fTwoCalc);


		if (dotProductFreq == 0) {   //Possible error here if not resolved by submission see Outstanding Issues in README.txt
			cosine = 0.0;
		} else {
			if (cosDist < dotProductFreq) {
				//cosine = ((dotProductFreq / cosDist) * 100.0);
				cosine = ((cosDist / dotProductFreq) * 100.0); // Multiply by 100 to give percentage
			} else {
				//cosine = ((cosDist / dotProductFreq) * 100.0);
				cosine = ((dotProductFreq / cosDist) * 100.0); 
			}
		}

		return cosine;
	}
}