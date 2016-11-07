package pl.edu.agh.kis;

import java.io.*;
import java.util.Scanner;

/**
 * The Class Utility, which is performs some useful tasks
 * 
 * @author szymon sadowski
 */
public class Utility {

	/**
	 * This method parses string to integer
	 * 
	 * @param input
	 *            String to be parsed to int
	 * @return parsed integer
	 */
	public static int parseString(String input) {
		int n = 0;
		try {
			n = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Error while parsing!");
			System.exit(-1);
		}
		return n;
	}

	/**
	 * This method gets User input and Parses it to integer
	 * 
	 * @param message
	 *            Message displayed before acquiring User's input
	 * @return integer typed in by user
	 */
	public static int getUserInteger(String message) {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(message);

		int n = 0;
		String input = "";

		try {
			input = console.readLine();
		} catch (IOException e) {
			System.out.println("Incorrect input, exiting...");
			System.exit(-1);
		}

		try {
			n = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			n = -1;
		}

		return n;
	}

	/**
	 * This method gets User's input
	 * 
	 * @param message
	 *            Message displayed before acquiring User's input
	 * @return Acquired String typed in by User
	 */
	public static String getUserString(String message) {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(message);

		String input = new String("");

		try {
			input = console.readLine();
		} catch (IOException e) {
			System.out.println("Incorrect input, exiting...");
			System.exit(-1);
		}

		return new String(input.toString());
	}

	/**
	 * This method gets two integers typed in one line, divided by SPACE
	 * 
	 * @param message
	 *            Message displayed before acquiring User's inputs
	 * @return Pair object, which contains two integers typed my user
	 */
	public static Pair getPair(String message) {

		int f = 0;
		int s = 0;

		String input = getUserString("");

		String[] strs = input.trim().split("\\s+");

		try {
			f = Integer.parseInt(strs[0]);
		} catch (NumberFormatException e) {
			return new Pair(-100, -100);
			// This Pair is valued like that, because it will break the loop in
			// runWithPrioritization() function
		}

		try {
			s = Integer.parseInt(strs[1]);
		} catch (NumberFormatException e) {
			return new Pair(-100, -100);
			// This Pair is valued like that, because it will break the loop in
			// runWithPrioritization() function
		} catch (ArrayIndexOutOfBoundsException a) {
			return new Pair(-100, -100);
			// When 2nd value is not provided
		}

		return (new Pair(f, s));
	}
}