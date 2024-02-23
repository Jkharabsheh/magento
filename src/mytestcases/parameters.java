package mytestcases;

import java.util.Random;

public class parameters {

	Random rand = new Random();
	String[] Firstnames = { "John", "Emma", "Michael", "Olivia", "William", "Sophia", "James", "Ava", "Benjamin",
			"Isabella", "Alexander", "Mia", "Daniel", "Charlotte", "Matthew", "Amelia", "Joseph", "Harper", "David",
			"Evelyn" };
	String[] lastnames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez",
			"Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson",
			"Martin" };
	String CommonPassword = "Asd123!@#$";
	int randomindex = rand.nextInt(10);
	int randomemaild = rand.nextInt(9999);
	String Emailid = Firstnames[randomindex] + lastnames[randomindex] + randomemaild + "@" + "gmail.com";
}
