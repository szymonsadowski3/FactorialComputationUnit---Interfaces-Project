package pl.edu.agh.kis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;

import Interfaces.ComputationsQueue;

/**
 * The Class ProgramRunner, which controls a flow of the program
 * 
 * @author szymon sadowski
 */
public class ProgramRunner {
	/**
	 * this field is used so to control prioritizations of computations
	 */
	ComputationsQueue queue;

	/**
	 * this field is used so to perform factorial computations
	 */
	FactorialComputer computer;

	/**
	 * Parametrized constructor
	 * 
	 * @param queue_
	 *            Object of class that represents ComputationsQueue interface
	 * @param cacheCapacity
	 *            Cache Capacity
	 */
	ProgramRunner(ComputationsQueue queue_, int cacheCapacity) {
		queue = queue_;
		computer = new FactorialComputer(cacheCapacity);
	}

	/**
	 * @param message
	 *            String attached to result
	 * @param result
	 *            Result
	 */
	void printResult(String message, BigInteger result) {
		System.out.println(message + result);
	}

	/**
	 * Method called when there is no program arguments
	 */
	void runWithNoArgs() {
		System.out.println("---Type 1 if you do NOT want to prioritize your computations---");
		System.out.println("---Type 2 if you DO want to prioritize your computations---");

		int choice = Utility.getUserInteger("");

		if (choice == 1) {
			runWithoutPrioritization();
		} else if (choice == 2) {
			runWithPrioritization();
		} else {
			System.out.println("Incorrect choice, try again!");
			runWithNoArgs();
		}
	}

	/**
	 * Method called when there is at least one program argument
	 * 
	 * @param args
	 *            program arguments
	 */
	void runWithArgs(String[] args) {
		System.out.println("Processing given arguments...");

		for (int i = 0; i < args.length; ++i) {
			int n = Utility.parseString(args[i]);
			BigInteger result = computer.calculateFactorialReusingResult(n);
			printResult((n + "! = "), result);
		}
	}

	/**
	 * Method called when there is desire to read arguments from file (prints
	 * results)
	 * 
	 * @param path
	 *            path to file with arguments
	 * @throws IOException
	 */
	void runWithArgsInFile(String path) throws IOException {
		InputStream is = new FileInputStream(path);
		Reader r = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(r);

		String line;

		while ((line = br.readLine()) != null) {
			int arg = Utility.parseString(line);
			BigInteger result = computer.calculateFactorialReusingResult(arg);
			printResult((arg + "! = "), result);
		}
		is.close();
	}

	/**
	 * Method called when User did NOT choose Prioritization mode
	 */
	void runWithoutPrioritization() {
		System.out.println("You run NO-Prioritize option. Type in positive numbers to calculate their factorials.");
		System.out.println("If you type in anything else, you will exit the program.");

		for (;;) {
			int n = Utility.getUserInteger("Type: ");

			if (n < 0) {
				System.out.println("Thanks for using this program...");
				System.exit(0);
			} else {
				BigInteger result = computer.calculateFactorialReusingResult(n);
				printResult((n + "! = "), result);
			}
		}
	}

	/**
	 * Method called when User DID choose Prioritization
	 */
	void runWithPrioritization() {
		System.out.println(
				"You run DO-Prioritize option. Type in correct syntax, that is: [POSITIVE_PRIORITY_NUMBER] [POSITIVE_ARGUMENT]");
		System.out.println(
				"If you type anything else, it will mean that inputting is finished, and the computations will begin.");
		System.out.println("The lower the PRIORITY_NUMBER is, the higher priority certain task has.");
		System.out.println("For example if 0 150 is typed in, 150! will always be computed as the first.");

		for (;;) {
			Pair toAdd = Utility.getPair("");

			if ((toAdd.getFirst() < 0) && (toAdd.getFirst() < 0))
				break;

			queue.add(toAdd);
		}

		performQueueTasks();
	}

	/**
	 * Method "unwraps" <code>TaskQueque</code> and computes factorials in
	 * correct order
	 */
	void performQueueTasks() {
		while (!queue.isEmpty()) {
			Pair acquiredPair = queue.remove();
			BigInteger result = computer.calculateFactorialReusingResult(acquiredPair.getSecond());
			printResult((acquiredPair.getSecond() + "! = "), result);
		}
	}
}