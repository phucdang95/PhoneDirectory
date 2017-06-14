package hw4;
//This class is used to create the userlist object and
//methods to be used in the phonedir class
public class userlist {
	String firstname;
	String lastname;
	String number;
	public userlist() {
	}

	public userlist(String firstname, String lastname, String number) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.number = number;
	}

	public void changefirst(String firstname) {
		this.firstname = firstname;
	}

	public void changelast(String lastname) {
		this.lastname = lastname;
	}

	public void changeNumber(String number) {
		this.number = number;
	}

	public String getname() {
		return firstname;
	}

	public String getlast() {
		return lastname;
	}

	public String getnum() {
		return number;
	}

	public String tostring() {
		return firstname + "  " + lastname + "  " + number;
	}
}
