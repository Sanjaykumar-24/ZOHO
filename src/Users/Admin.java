package Users;
import Model.*;
import java.io.*;
import java.util.*;
public class Admin extends User
{
	public Admin(String username,String password)
	{
		this.username = username;
		this.password = password;
	}
	public boolean verifyAdmin() throws IOException
	{
		File file = new File("D:\\Java\\ZohoRound3\\src\\Admin.txt");
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
	public void addQuestion(Scanner sc,Repo repo)
	{
	   System.out.println("Enter Question id:");
	   int id = sc.nextInt();
	   sc.nextLine();
	   System.out.println("Enter Question:");
	   String question = sc.nextLine();
	   String[] options = new String[4];
	   System.out.println("Enter the options:");
	   System.out.println("Enter Option A:");
	   String A = sc.nextLine();
	   options[0] = A;
	   System.out.println("Enter Option B:");
	   String B = sc.nextLine();
	   options[1] = B;
	   System.out.println("Enter Option C:");
	   String C = sc.nextLine();
	   options[2] = C;
	   System.out.println("Enter Option D:");
	   String D = sc.nextLine();
	   options[3] = D;
	   System.out.print("Enter the difficulty:");
	   String difficulty = sc.next();
	   System.out.print("Enter the option(1,2,3,4) for the question");
	   int answer = sc.nextInt();
	   Question ques = new Question(id,question,options,difficulty,answer);
	   repo.add(ques);
	}
	public void deleteQuestion(Scanner sc,Repo repo)
	{
		System.out.println("Enter the Id of Question to be deleted:");
		int id = sc.nextInt();
		boolean result = repo.removeQues(id);
		if(result)
		{
			System.out.println("Successfully deleted..!!");
		}
		else
		{
			System.out.println("Question not found with this Id..!!");
		}
	}
	public void viewAllQuestions(Scanner sc,Repo repo)
	{
	   repo.viewQues();
	}
}