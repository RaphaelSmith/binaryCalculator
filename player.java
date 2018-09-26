import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class player {
	
	
	int row, column;
	private String name, age, email = "";
	public void playerFire() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String tempRow ="";
		String tempCol ="";

		do {
			try {
		System.out.println("Choose a row: ");
		
		tempRow = input.readLine();
			} catch (Exception e) { System.out.println("Invalid Input " +  e );}
		}while(!tempRow.matches("[0-9]+"));
		row = Integer.parseInt(tempRow);
		
		do {
			try {
		System.out.println("Choose a column: ");
		//Scanner columnFire = new Scanner(System.in);
		 
		tempCol = input.readLine();
			} catch (Exception e) { System.out.println("Invalid Input " +  e );}
		}while(!tempCol.matches("[0-9]+"));
		column = Integer.parseInt(tempCol);
	}
	
	public void newPlayer() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
		do {
			try {
		System.out.println("Please enter Player's name and surname: ");
		setName(input.readLine());
		} catch (Exception e) { System.out.println("Invalid Input " +  e );}
		}while(name =="" || !name.contains(" "));
		do {
		try {
	System.out.println("Please enter Player's age (numbers only): ");
		setAge(input.readLine());
	} catch (Exception e) { System.out.println("Invalid Input " +  e );}
	}while(age ==""|| !age.matches("[0-9]+"));
		
	do {
		try{
		System.out.println("Please enter Player's email (no spaces allowed): ");
		setEmail(input.readLine());
} catch (Exception e) { System.out.println("Invalid Input " +  e );}
	}while(email ==""|| !email.contains("@")|| email.contains(" "));
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
}
