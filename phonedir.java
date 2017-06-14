package hw4;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Phuc Dang
 * Purpose: The purpose of this program is to create a LinkedList data structure 
 * that maintains a list of records containing names and phone numbers. 
 * Solution: Create a userlist class to manage the records. Use linkedlist to 
 * add userlist objects to display commands, take user-input, allow user to edit and retrieve data.
 * Data Structure Used: LinkedList
 * Program Use: The program will prompt the user for a command, execute the command,
 * then prompt the user for another command. The commands must be chosen from 
 * the following possibilities:
          a     Show all records
          d     Delete the current record
          f     Change the first name in the current record
          l     Change the last name in the current record
          n    Add a new record
          p    Change the phone number in the current record
          q     Quit
          s     Select a record from the record list to become the current record.
 **/


public class phonedir {
	//Displaying commands and editing userlist based on user input
public static void main(String [] args) {
	LinkedList <userlist> userlist = new LinkedList<userlist>();
	int current=0;
	//precondition: linked list records is empty
	while(true){
	//postcondition:  display no current record 
	if (userlist.isEmpty()==true){
		System.out.println("No matching record found.");
	}
	//If linked list is greater than 1 then list is sorted based on first and last name. 
	else if(userlist.size()>1){
		System.out.println("Current record is: "+ (userlist.get(current)).tostring());
			for (int i = 1; i < userlist.size(); i++) {
				if(userlist.get(i).getlast().compareTo((userlist.get(i-1)).getlast()) < 0){
				userlist temp=userlist.get(i);
				userlist.remove(i);
				userlist.addLast(temp);
			}
		}
	}
	else{
		System.out.println("Current record is: "+ (userlist.get(current)).tostring());
	}
	System.out.println("a \t Show all records");
    System.out.println("d \t Delete the current record");
    System.out.println("f \t Change the first name of the current record");
    System.out.println("l \t Change the last name of the current record");
    System.out.println("n \t Add a new record");
    System.out.println("p \t Change the phone number of the current record");
    System.out.println("q \t Quit");
    System.out.println("s \t Select a record from the directory to be the current record\n");
    System.out.print("Enter a command from the list above (q to quit): ");
	Scanner inputt = new Scanner(System.in); 
	String input = inputt.nextLine();
	//record object at position i is retrieved and printed if input is equal to "a"
	if(input.equalsIgnoreCase("a")){
		 System.out.print("First Name\t");
         System.out.print("Last Name\t");
         System.out.print("Phone Number\n");
         System.out.print("--------\t");
         System.out.print("--------\t");
         System.out.print("--------\t\n");
		for (int i = 0; i < userlist.size(); i++) {
			System.out.print((userlist.get(i)).getname()+ "\t\t");
			System.out.print(( userlist.get(i)).getlast()+ "\t\t");
			System.out.println(( userlist.get(i)).getnum()+ "\t");
		}
	}
	//Record object at current position is removed from linked list if input equals to "d"
	else if(input.equalsIgnoreCase("d")){
		userlist.remove(current);
	}
	//If input equals to "f", then record object at current position will have 
	//its fist name changed to what was given
	else if(input.equalsIgnoreCase("f")){
		System.out.println("Enter new first name: ");
		String newFirstName=inputt.nextLine();
		userlist.get(current).changefirst(newFirstName);
	}
	//Rrecord object at current position will have its last name changed to what was given
	// if input equals "l"
	else if(input.equalsIgnoreCase("l")){
		System.out.println("Enter new last name: ");
		String newLastName=inputt.nextLine();
		userlist.get(current).changelast(newLastName);
	}
	//Adding new record to linked list and make it current 
	else if(input.equalsIgnoreCase("n")){
		System.out.println("\nEnter first name: ");
		String firstName=inputt.nextLine();
		System.out.println("Enter last name: ");
		String lastName=inputt.nextLine();
		System.out.println("Enter Phone number: "); 
		String number=inputt.nextLine();
		if(number.contains("-")){
		userlist user = new userlist(firstName, lastName, number);
		current=(userlist.size()-1);
		}
		else if(number.length()<10){
			userlist user = new userlist(firstName, lastName, number);
			userlist.add(user);
			current=(userlist.size()-1);
		}
		else {
		String dash1 = number.substring(0,3);
		String dash2=number.substring(3, 6);
		String dash3=number.substring(6,10);
		String PhoneFormat = dash1 +"-"+dash2+"-"+dash3;
		userlist user = new userlist(firstName, lastName, PhoneFormat);
		userlist.add(user);
		current=(userlist.size()-1);
		}
		
		System.out.println("Record added");
	}
	//precondition: input equals character 'p', then gives phone number
	//postcondition: record object at current position has its phone number changed to what is given
	else if(input.equalsIgnoreCase("p")){
		System.out.println("Enter new phone number: ");
		String newnumberber=inputt.nextLine();
		if (newnumberber.contains("-")){
			userlist.get(current).changeNumber(newnumberber);
			}
		else{
			String dash1 = newnumberber.substring(0,3);
			String dash2=newnumberber.substring(3, 6);
			String dash3=newnumberber.substring(6,10);
			String PhoneFormat = dash1 +"-"+dash2+"-"+dash3;
			userlist.get(current).changeNumber(PhoneFormat);
		}
		}
	//Program terminate if input equals "q"
	else if(input.equalsIgnoreCase("q")){
		System.exit(-1);
	}
	//if input equals to "S" then searches for a record by first and last
	//through list and select that record to become the current record
	else if(input.equalsIgnoreCase("s")){
		System.out.println("Enter first name: ");
		String firstName=inputt.nextLine();
		System.out.println("Enter last name: ");
		String lastName = inputt.nextLine();
		for (int i = 0; i < userlist.size(); i++) {
			if (firstName.equalsIgnoreCase((userlist.get(i)).getname())){
			current = i;
		}
		}
	}
	else{
		System.out.println("Illegal command.");
	}
	}
	
}

}
