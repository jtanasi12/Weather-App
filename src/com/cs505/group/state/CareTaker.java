package com.cs505.group.state;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.cs505.group.Encrypt.src.Encrypt;
import com.cs505.group.main.iterator.*;
import com.cs505.group.state.StateOriginator.Memento;

/**
 * This class handles the Memento Objects and stores all the Mementos into a
 * customized ArrayList.
 * We have a counter that keeps track of the number of objects that we create,
 * and when we go beyond
 * the limit of objects we are allowed to add, we remove from the front of the
 * list and add the new
 * object to the end.
 * 
 * The objects are then saved to a .txt file and loaded back from the .txt file.
 * 
 * @author Joseph Tanasi
 *
 */
public class CareTaker {

	// Keeps track of the Memento objects that we create
	private static int counter;

	/**
	 * We can only keep track of 10 Memento objects
	 * When we reach our limit of 10 we will delete from the front of the ArrayList
	 * Before adding to the end of the ArrayList much like a queue. We didn't use a
	 * queue
	 * because it has limited features for accessing items in the queue with an
	 * index.
	 * Essentially our ArrayList will act like a queue.
	 */

	// Dummy number to display that when we exceed the limit of 5, we delete from
	// the front
	// and add to the back of the list.
	private final int LIMIT = 5;

	public CareTaker() {
		counter = 0;
	}

	// Container of Memento Objects that we want to store
	private LinkList<StateOriginator.Memento> savedWeatherStates = new LinkList<>();

	/**
	 * Allows us to add a Memento object to the list and if we go over the LIMIT
	 * we delete the first object in the list and add the new object to the end
	 * (Like a queue).
	 * 
	 * @param newMemento - is the new Memento object that we are adding to the list.
	 */
	public void addMemento(StateOriginator.Memento newMemento) {
		counter++;

		if (newMemento != null) {

			// If we have less then 5 Mementos created then add to the ArrayList as normal
			if (counter <= LIMIT) {
				savedWeatherStates.addNode(newMemento);
			} else {
				// We are removing the front object so we can add to the list and keep it at 10
				// Memento objects or less
				removeState();
				--counter;

				savedWeatherStates.addNode(newMemento);
			}

			saveToFile(); // Save the list to the file
		}

	}

	/**
	 * Allows us to specify what index we want to remove from the list.
	 * 
	 * @param index - is the number in the list that represents the object that we
	 *              want to delete.
	 * @throws OutOfBoundsIndexException - if the index is below 0 or above the
	 *                                   counter the object doesn't exist
	 */
	public void removeStateIndex(int index) {

		try {

			if (index > counter || index < 0) {
				throw new OutOfBoundsIndexException("The index is out of range.");
			} else {
				savedWeatherStates.remove(index);
			}
		} catch (OutOfBoundsIndexException e) {
			e.printStackTrace();
		}
	}

	/**
	 * We use this to remove the object from the front of the list, only if the list
	 * is not empty
	 */
	public void removeState() {
		if (!savedWeatherStates.isEmpty()) {

			if (counter > LIMIT) {
				savedWeatherStates.remove(0);

			}
		}
	}

	/*
	 * Removes all the states. Clears the list setting it to 0
	 * 
	 */
	public void dumpStates() {

		while (counter > 0) {
			savedWeatherStates.remove(counter - 1);
			--counter;
		}

	}

	/**
	 * We specify with an index the object that we want to return.
	 * 
	 * @param index - the object that we want to return.
	 * @return - returns the Memento object that is requested.
	 */
	public StateOriginator.Memento getMemento(int index) {

		try {

			if (index > counter || index < 0) {
				throw new OutOfBoundsIndexException("The index is out of range.");
			} else {
				return savedWeatherStates.get(index);
			}
		} catch (OutOfBoundsIndexException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @return - Gives us the number of memento objects that we saved.
	 */
	public static int getStateNumber() {
		System.out.print("Number of states: ");
		return counter;
	}

	/**
	 * Displays the Memento objects
	 * 
	 * @return - a string that tells us the weather states
	 */
	public void display() {

		System.out.println("Weather States: \n[\n" + savedWeatherStates.toString() + "]");

	}

	public void previousListDisplay() {

		System.out.println("Previous Saved Weather States: \n[\n" + savedWeatherStates.toString() + "]");

	}

	/**
	 * Saves the ArrayList to a text file.
	 */
	private void saveToFile() {

		int internalCounter = (counter - 1);// Minus 1 because the counter isn't 0-based

		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter("saveWeather.txt"));
			// buffer.write("Weather States: [");

			// We only iterate to the element before the last element - (N-1)
			// So that we can add the last element without a comma after it
			for (int index = 0; index <= internalCounter; index++) {
				buffer.write(savedWeatherStates.get(index).toString());
				buffer.newLine();

			}

			buffer.flush();
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads the ArrayList that is saved to a text file.
	 * 
	 * @return - if we return true then the file contains data, if false the file is
	 *         empty
	 */

	/**
	 * Checks if the file we are loading is empty
	 * 
	 * @return return true if the file is empty and false if the file is not empty
	 */
	public static boolean fileIsEmpty() {

		try {
			BufferedReader buffer = new BufferedReader(new FileReader("saveWeather.txt"));

			String line = buffer.readLine();

			if (line == null) {
				buffer.close();
				return true;
			} else {
				buffer.close();
				return false;
			}

		} catch (IOException e) {
			e.printStackTrace();
			return true;
		}

	}

	/**
	 * This Method will be called first thing in the Client program.
	 * The purpose of this method is to load data from the text file
	 * that was previously saved in another session.
	 * 
	 * We then create a temporary weather list that will be returned at the end of
	 * the method.
	 * We create a Memento reference holder.
	 * 
	 * As we iterate through the .txt file which stores weather States line by line
	 * we create new Memento objects and pass over a weather State
	 * and then we have the tempWeatherList add the memento to the list.
	 * 
	 * 
	 * 
	 * @return The temporary weatherList is returned and contains all the memento
	 *         objects
	 *         that were created from the .txt file.
	 */
	public static void readMementoFile() {
		CareTaker tempWeatherList = new CareTaker();

		StateOriginator.Memento copyPreviousMemento;

		try {
			BufferedReader buffer = new BufferedReader(new FileReader("saveWeather.txt"));

			String line = buffer.readLine();

			// If the file contains no first Line then it is empty and we return out
			if (line == null) {

				buffer.close();
			}

			System.out.println("Previous Saved Weather States: \n[");
			while (line != null) {

				// copyPreviousMemento = new StateOriginator.Memento(line);
				// tempWeatherList.addMemento(copyPreviousMemento);

				System.out.println(line);
				line = buffer.readLine();

			}

			System.out.println("]");
			buffer.close();

		} catch (IOException e) {
			copyPreviousMemento = null;
			e.printStackTrace();
		}

	}

	public static void encryptMomentoFile() {

		Encrypt enc = Encrypt.getInstance();

		String source, encryptString;

		try {
			BufferedReader buffer = new BufferedReader(new FileReader("saveWeather.txt"));

			String line = buffer.readLine();

			// If the file contains no first Line then it is empty and we return out
			if (line == null) {
				buffer.close();
			}

			while (line != null) {

				// copyPreviousMemento = new StateOriginator.Memento(line);
				// tempWeatherList.addMemento(copyPreviousMemento);

				line = line + buffer.readLine();

			}

			encryptString = enc.encrypt(line);
			buffer.close();

			BufferedWriter bufferWrite = new BufferedWriter(new FileWriter("saveWeather.txt"));
			bufferWrite.write(line);

			bufferWrite.flush();
			bufferWrite.close();

		} catch (

		IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
