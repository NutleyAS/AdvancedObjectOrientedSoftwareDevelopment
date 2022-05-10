package ie.gmit.dip;

/**
 * 
 * @author Aron Nutley
 * @version 1.0
 * @since 2020-09
 * @references See README.txt
 *
 *        This Class runs the application. Creates a new instance of the
 *        DisplayMenu and calls the run() function from the Menu Class.
 * 
 *        See DisplayMenu()
 * 
 */

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		DisplayMenu menu = new DisplayMenu();
		menu.run();
	}
}