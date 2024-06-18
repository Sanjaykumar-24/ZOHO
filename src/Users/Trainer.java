package Users;
import java.util.*;
import Model.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Trainer extends User
{
	public Trainer(String username,String password)
	{
		this.username = username;
		this.password = password;
	}
	public boolean verifyTrainer() throws IOException
	{
		File file = new File("D:\\Java\\ZohoRound3\\src\\Trainer.txt");
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
	public void addTest(Scanner sc,Repo repo)
	{
		System.out.println("Enter Test Details");
		System.out.println("Enter Test Id:");
		int id = sc.nextInt();
		System.out.print("Enter number of Questions:");
		int count = sc.nextInt();
		System.out.print("Enter easy count:");
		int easy = sc.nextInt();
		System.out.print("Enter medium count:");
		int medium= sc.nextInt();
		System.out.print("Enter hard count:");
		int hard = sc.nextInt();
		System.out.println("Enter number of tests to be excluded:");
		int exclude = sc.nextInt();
		List<Question> list = new ArrayList<>();
		boolean isTest = repo.makeQuestions(count,easy,medium,hard,exclude,list);
		if(isTest)
		{
			Test test = new Test(id,count,easy,medium,hard,exclude,list);
			repo.addTesttoList(test);
		}
		else
		{
			System.out.println("Cant able to create a test with avalible data..!!");
		}
	}
	public void viewResult(Repo repo)
	{
		repo.view();
	}
}