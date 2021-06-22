import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Decoded {

	static ArrayList<String> al = new ArrayList<String>();
	static String[] findedStart;

	public static void readFile() throws IOException {

		try {
			//Read and write to the buffer and add every link to ArrayList
			Scanner in = new Scanner(System.in);
			System.out.print("Please write the path text document: ");
			String pathName =  in.nextLine();

			System.out.print("Pleas write three start letters: ");
			String startLetter =  in.nextLine();
			
			in.close();
			
			BufferedReader fin = new BufferedReader(new FileReader(pathName));

			String line = fin.readLine();
			for (int i = 0; line != null; i = i + 1) {
				al.add(i, line);
				line = fin.readLine();
			}
			
			fin.close();
			findStart(startLetter);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't open file, or wrong path " + e);
		}

	}

	//Take a start of the first three letters. Find in the list and split it.
	public static String findStart(String s) {
			try {
				for (String string : al) 
				{
					if (string.contains(s)) {
						findedStart = string.split("#", 3);
						System.out.print(findedStart[1]);
						reverseUsingStringBuilder(findedStart[2], string);
					}
				}
				System.out.println("");
				System.out.println("Can't find next reverse symbols probable end of the message, or wrong start symbol, try again");
			}
			
			catch (Exception e) {
				// TODO: handle exception
			}
			return s;
		}

	//Reverse last three charts. And remove from the list used line (Word) for the next step.
	public static String reverseUsingStringBuilder(String input, String remuvUsedSymbol) {
		if (input == null) {
			return null;
		}

		StringBuilder output = new StringBuilder(input).reverse();
		String a = output.toString();
		al.remove(remuvUsedSymbol);
		return findStart(a);
	}

	public static void main(String args[]) {
		try {
			readFile(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}