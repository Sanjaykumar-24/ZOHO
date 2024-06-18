package Users;
import Model.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Student extends User
{
	public Student(String username,String password)
	{
		this.username = username;
		this.password = password;
	}
	public boolean verifyStudent() throws IOException
	{
		File file = new File("D:\\Java\\ZohoRound3\\src\\Student.txt");
		FileReader myreader = new FileReader(file);
		BufferedReader Reader = new BufferedReader(myreader);
		String line;
		while((line = Reader.readLine())!=null)
		{
			String[] data = line.split(",");
			if(data[0].equals(this.username) && data[1].equals(this.password))
			return true;
		}
		return false;
	}
	public void viewResult(Repo repo)
	{
		repo.view();
	}
	public void takeTest(Scanner sc,Repo repo)
	{
		System.out.println("Enter testId:");
		int testId = sc.nextInt();
		boolean verify = repo.verifyTest(testId);
		if(verify)
		{
		repo.takeTestNow(sc,testId,this.username);
		}
		else
		{
		   System.out.println("No test fount with this particular testId..!!");
		}
	}
}