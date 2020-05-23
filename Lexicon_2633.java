//Ashish Kumar cs610 ak2633 prp
import java.io.*;
import java.io.*;
import java.io.*;
import java.util.*;

public class Lexicon_2633 {
	// global variables needed throughout the program
	static int[] HashTable = {};
	static char[] CharTable = {};
	static int[] tempHashTable = {};
	static char[] tempCharTable = {};
	static char[] reTempCharTable = {};
	static int startIndex = 1;
	static int flag = 0;

	public static void main(String[] args) {
		try {
			if(args.length!=1) {
				System.out.println("Please enter the proper File Name");
				return;
			}
			File file = new File(args[0]);
			Scanner fileCount = new Scanner(file);
			Scanner fileData = new Scanner(file);// Initialized again as pointer was not reseting.
			int totalOp = 0;

			while (fileCount.hasNextLine()) {
				fileCount.nextLine();
				totalOp = totalOp + 1;// counting the total elements.
			}

			String[] operation = new String[totalOp];// array to store the operation name.
			String[] word = new String[totalOp];// array to store the words.
			int operationIncr = 0;
			int wordIncr = 0;
			String[] parts = new String[2];

			System.out.println("----------------");
			while (fileData.hasNext()) {// in this loop we are storing the data into the arrays.
				// System.out.println(fileData.next());
				// System.out.println(fileData.next());
				String data = fileData.nextLine();
				parts = data.split(" ", 2);
				// System.out.println(Arrays.toString(parts) + " , " + parts.length);
				// System.out.println(parts[0] + " , " + parts[1]);

				if (parts[0].equals("14")) {
					boolean val = true;
					int a = 0;
					try {
						a = Integer.parseInt(parts[1]);
					} catch (Exception e) {
						val = false;
					}
					if (val == true) {
						if(a>0) {
							operation[operationIncr] = parts[0];
							word[wordIncr] = parts[1];
							operationIncr = operationIncr + 1;
							wordIncr = wordIncr + 1;
						}else {
							System.out.println("Table size should be more than 0");
						}
						
					} else {
						System.out.println("Please Enter the table size as valid Integer");
					}

				}

				else if (parts[0].equals("11")) {
					operation[operationIncr] = parts[0];
					word[wordIncr] = parts[1];
					operationIncr = operationIncr + 1;
					wordIncr = wordIncr + 1;
				}

				else if (parts[0].equals("12")) {
					operation[operationIncr] = parts[0];
					word[wordIncr] = parts[1];
					operationIncr = operationIncr + 1;
					wordIncr = wordIncr + 1;
				}

				else if (parts[0].equals("10")) {
					operation[operationIncr] = parts[0];
					word[wordIncr] = parts[1];
					operationIncr = operationIncr + 1;
					wordIncr = wordIncr + 1;
				}

				else if (parts[0].equals("15")) {
					operation[operationIncr] = parts[0];
					word[wordIncr] = parts[1];
					operationIncr = operationIncr + 1;
					wordIncr = wordIncr + 1;
				}

				else if (parts[0].equals("13")) {
					operation[operationIncr] = parts[0];
					word[wordIncr] = null;
					operationIncr = operationIncr + 1;
					wordIncr = wordIncr + 1;
				} else {
					System.out.println("File contains invalid command");
				}

			}

//			 System.out.println(Arrays.toString(operation));
//			 System.out.println(Arrays.toString(word));

			// 10 is for Insert,parameter is String
			// 11 is for deletion,parameter is String
			// 12 is for search,parameter is String
			// 13 if for print
			// 14 is for create,parameter is integer
			// 15 is comment,ignore the content of this line.

			// reading the array and deciding the processes.
			for (int i = 0; i < operation.length; i++) {
				if(operation[i] == null) {
					
				}else if (operation[i].equals("14")) {
					for (int j = i; j < operation.length; j++) {
						if (operation[j] == null) {
							// System.out.println(operation[j] +" is not a valid operation");
						} else if (operation[j].equals("10")) {
							insertData(word[j]);
						} else if (operation[j].equals("11")) {
							toDelete(word[j]);
						} else if (operation[j].equals("12")) {
							searchVal(word[j]);
						} else if (operation[j].equals("13")) {
							printArray();
						} else if (operation[j].equals("14") && flag == 0) {// the flag here will ignore the second
																			// creation.
							flag = 1;
							createStructure(word[j]);
						} else if (operation[j].equals("15")) {
							System.out.println("this is a comment,ignore it");
						} else {
							if (flag == 1) {
								System.out.println("Duplicate table creation command entered");
							} else {
								System.out.println("This is not a valid operation");
							}
						}
					}
					break;
				} else {
					System.out.println("Table is still not created,So can't insert the data");
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// This Method will be creating the The arrays.
	public static void createStructure(String limit) {

		HashTable = new int[Integer.parseInt(limit)];
		CharTable = new char[15 * Integer.parseInt(limit)];

		for (int i = 0; i < CharTable.length; i++) {
			CharTable[i] = ' ';
		}

		for (int j = 0; j < HashTable.length; j++) {
			HashTable[j] = -1;
		}

	}

	// This method will insert the records in the arrays.
	public static void insertData(String personName) {
		insertWord(personName);
		insertKey(personName);
		// System.out.println("--------------------------------------------------------------");
	}

	// This method is to print the records.
	public static void printArray() {
		System.out.println("\nReady to print--------------------------------------");

		System.out.print("T:                                A : ");
		for (int i = 0; i < CharTable.length; i++) {
			if ((int) CharTable[i] == 32) {
				break;
			}
			if ((int) CharTable[i] == 0) {
				System.out.print("/");
			} else {
				System.out.print(CharTable[i]);
			}

		}

		System.out.println();

		for (int i = 0; i < HashTable.length; i++) {
			if (HashTable[i] != -1) {
				System.out.println(i + " : " + HashTable[i]);
			} else {
				System.out.println(i + " : ");
			}

		}

		int totalSoltsOccup = 0;
		for (int i = 0; i < HashTable.length; i++) {
			if (HashTable[i] != -1) {
				totalSoltsOccup = totalSoltsOccup + 1;
			}
		}
		System.out.println("");
		System.out.println("Total Slots Occupied : " + totalSoltsOccup);
		System.out.println("Total Slots Unccupied : " + (HashTable.length - totalSoltsOccup));
		int count = 0;
		for (int i = 0; i < CharTable.length; i++) {
			count = count + 1;
			if ((int) CharTable[i] == 32) {
				break;
			}
		}
		System.out.println("Total Slots in charTable : " + count);
		// System.out.println(Arrays.toString(CharTable));
	}

	// This method is to search the record in the arrays.
	public static void searchVal(String toSearch) {

		int srcHashSum = 0;
		int srcFunc = 0;
		int srcHashFunc = 0;
		int numCount = 0;
		int found = -2;

		for (int i = 0; i < toSearch.length(); i++) {
			srcHashSum = srcHashSum + ((int) toSearch.charAt(i));
		}

		//System.out.println("sum is :" + srcHashSum);
		srcFunc = srcHashSum % HashTable.length;

		for (int j = 0; j < HashTable.length; j++) {
			numCount = 0;
			srcHashFunc = (srcFunc + (j * j)) % HashTable.length;
			if(srcHashFunc<0) {//this is to avoid the overflow
				break;
			}
			if (HashTable[srcHashFunc] != -1) {

				for (int k = 0; k < toSearch.length(); k++) {
					if (toSearch.charAt(k) == CharTable[k + HashTable[srcHashFunc]]) {
						numCount = numCount + 1;
					} else {
						break;
					}
				}
				if (numCount == toSearch.length()) {
					found = HashTable[srcHashFunc];
					break;
				}
			}
		}
		//System.out.println("found is :" + found);
		if (found == -2) {
			System.out.println(toSearch + " Not Found");
		} else {
			System.out.println(toSearch + " Found at slot :" + srcHashFunc + " Character array :" + found);
		}

	}

	// This function is to delete the records.
	public static void toDelete(String delete) {

		int delHashSum = 0;
		int delFunc = 0;
		int delHashFunc = 0;
		int delNumCount = 0;
		int traverse = -2;
		for (int i = 0; i < delete.length(); i++) {
			delHashSum = delHashSum + ((int) delete.charAt(i));
		}

		delFunc = delHashSum % HashTable.length;

		for (int j = 0; j < HashTable.length; j++) {
			delNumCount = 0;
			delHashFunc = (delFunc + (j * j)) % HashTable.length;
			if(delHashFunc<0) {//this is to avoid the overflow
				break;
			}
			if (HashTable[delHashFunc] != -1) {// if hash function matches there then it will search each word in loop.

				for (int k = 0; k < delete.length(); k++) {
					if (delete.charAt(k) == CharTable[k + HashTable[delHashFunc]]) {
						delNumCount = delNumCount + 1;
					} else {
						break;
					}
				}

				if (delNumCount == delete.length()) {// if each word matches then both count will be same.
					traverse = HashTable[delHashFunc];
					break;
				}
			}

		}

		if (traverse == -2) {
			System.out.println(delete + " not found,So cant be deleted");
		} else {
			while ((int) CharTable[traverse] != 0) {
				CharTable[traverse] = '*';
				traverse = traverse + 1;
			}
			HashTable[delHashFunc] = -1;
			System.out.println(delete + " deleted from slot :" + delHashFunc);

		}
	}

	// This function is to insert the records to the Character array.
	public static void insertWord(String name) {

		if (ifNoCollision(name) == false) {
			reSize();
		}

		if (ifNoCollision(name) == false) {
			reSize();
		}
		if (ifNoCollision(name) == true) {

			for (int i = 0; i < CharTable.length; i++) {
				if ((int) CharTable[i] == 32) {
					startIndex = i;
					break;
				}
			}

			int strIndex = 0;// this index is for controlling the flow of the word to be inserted

			for (int j = startIndex; j < (startIndex + name.length()); j++) {
				if (j >= CharTable.length) {

					reStructChar(name);
				}
				CharTable[j] = name.charAt(strIndex);
				strIndex = strIndex + 1;
			}
			if ((startIndex + name.length()) >= CharTable.length) {
				reStructChar(name);
			}
			CharTable[startIndex + name.length()] = '\0';// this adds the O after each word
		}

	}

	// This function is to insert the keys into the integer array.
	public static void insertKey(String fulName) {
		int hashSum = 0;
		int Func = 0;
		int hashFunc = 0;

		for (int i = 0; i < fulName.length(); i++) {
			hashSum = hashSum + ((int) fulName.charAt(i));
		}

		Func = hashSum % HashTable.length;

		for (int j = 0; j < HashTable.length; j++) {
			hashFunc = (Func + (j * j)) % HashTable.length;
			if (HashTable[hashFunc] == -1) {
				HashTable[hashFunc] = startIndex;
				break;
			}
		}

	}

	// This function is to build the array.But this reduced the performance of the
	// ceode.
	public static String buildArray() {

		String finalVal = "";
		char add = ' ';
		for (int i = 0; i < CharTable.length; i++) {
			if ((int) CharTable[i] == 32) {
				break;
			}
			add = CharTable[i];
			if ((int) CharTable[i] == 0) {
				add = '/';
			}

			finalVal = finalVal + add;
		}
		return finalVal;
	}

	// This is to check if the collision occurs.
	public static boolean ifNoCollision(String fulName) {

		int hashSum = 0;
		int Func = 0;
		int hashFunc = 0;

		for (int i = 0; i < fulName.length(); i++) {
			hashSum = hashSum + ((int) fulName.charAt(i));
		}
		// System.out.println(hashSum);
		Func = hashSum % HashTable.length;

		for (int j = 0; j < HashTable.length; j++) {
			hashFunc = (Func + (j * j)) % HashTable.length;
			// System.out.println(hashFunc);
			if (HashTable[hashFunc] == -1) {
				return true;
			}
		}
		return false;
	}

	// This will Increase the size of the character array if it becomes full.
	public static void reStructChar(String reName) {
		int reCount = 0;
		reTempCharTable = new char[2 * CharTable.length];
		for (int i = 0; i < reTempCharTable.length; i++) {
			reTempCharTable[i] = ' ';
		}

		for (int i = 0; i < CharTable.length; i++) {
			reTempCharTable[i] = CharTable[i];
		}

		CharTable = reTempCharTable;

	}

	// This will help in resizing both the character array and the integer array.
	public static void reSize() {
		int insertIndex = 0;
		int totalSum = 0;
		tempHashTable = new int[2 * HashTable.length];
		tempCharTable = new char[2 * CharTable.length];
		for (int i = 0; i < tempCharTable.length; i++) {
			tempCharTable[i] = ' ';
		}

		for (int j = 0; j < tempHashTable.length; j++) {
			tempHashTable[j] = -1;
		}

		for (int i = 0; i < CharTable.length; i++) {
			tempCharTable[i] = CharTable[i];
		}

		CharTable = tempCharTable;

		for (int k = 0; k < CharTable.length; k++) {
			// System.out.println(CharTable[k]);
			if ((int) CharTable[k] != 42) {
				if ((int) CharTable[k] == 0) {
					// System.out.println("insert " + insertIndex);
					// System.out.println("Sum is " + totalSum);
					// System.out.println("index " + k);
					if (totalSum != 0) {
						reEnterData(totalSum, tempHashTable.length, insertIndex);
					}
					insertIndex = k + 1;
					totalSum = 0;
					continue;
				}
				totalSum = totalSum + (int) CharTable[k];
			}
			if ((int) CharTable[k] == 32) {
				break;
			}

		}
		HashTable = tempHashTable;

	}

	// this is reentering the data into the integer array
	public static void reEnterData(int totalSum, int totalLength, int insertIndex) {

		int reFunc = 0;
		int rehashFunc = 0;

		reFunc = totalSum % totalLength;

		for (int j = 0; j < tempHashTable.length; j++) {
			rehashFunc = (reFunc + (j * j)) % totalLength;
			if (tempHashTable[rehashFunc] == -1) {
				tempHashTable[rehashFunc] = insertIndex;
				break;
			}
		}

	}

}
