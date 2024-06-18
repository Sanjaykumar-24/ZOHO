package Controller;
import Users.*;
import java.util.*;

import Model.Repo;

import java.io.*;
public class OnlineQuizApp
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		Repo repo = new Repo();
		while(true)
		{
			printDetails();
			int choice = sc.nextInt();
			if(choice == 4)
			{
				System.out.println("Thank you..!!");
				System.out.println("-----------------------------------------------------------");
				break;
			}
			else if(choice == 1)
			{
				getAdminDetails(sc,repo);
			}
			else if(choice == 2)
			{
				getTrainerDetails(sc,repo);
			}
			else if(choice == 3)
			{
				getStudentDetails(sc,repo);
			}
			else
			{
				System.out.println("Enter a Valid Choice..!!");
				System.out.println("-----------------------------------------------------------");
			}
		}
	}
	static void printDetails()
	{
		System.out.println("Enter you role as below:");
		System.out.println("1.Admin");
		System.out.println("2.Trainer");
		System.out.println("3.Student");
		System.out.println("4.Exit");
		System.out.println("-----------------------------------------------------------");
		System.out.print("Enter your choice:");
	}
	static void getAdminDetails(Scanner sc,Repo repo) throws IOException
	{
	   System.out.print("Enter your username:");
	   String username = sc.next();
	   System.out.print("Enter your password:");
	   String password = sc.next();
	   Admin admin = new Admin(username,password);
	   boolean isAdmin = admin.verifyAdmin();
	   if(isAdmin)
	   {
		   while(true)
		   {
		   System.out.println("1.Add a question");
		   System.out.println("2.Delete a question");
		   System.out.println("3.View All question");
		   System.out.println("4.Exit");
		   System.out.println("-----------------------------------------------------------");
		   System.out.println("Enter your choice:");
		   int choice = sc.nextInt();
		   if(choice == 4)
		   {
			   System.out.println("Thanl You..!!");
			   break;
		   }
		   else if(choice == 1)
		   {
			   admin.addQuestion(sc,repo);
		   }
		   else if(choice == 2)
		   {
			   admin.deleteQuestion(sc,repo);
		   }
		   else if(choice == 3)
		   {
			   admin.viewAllQuestions(sc, repo);
		   }
		   else
		   {
			   System.out.println("Enter a Valid Choice");
			   System.out.println("-----------------------------------------------------------");
		   }
		   }
	   }
	   else
	   {
		   System.out.println("You are not a Admin, Try Again..!!");
		   System.out.println("-----------------------------------------------------------");
		   return;
	   }
	}
	static void getTrainerDetails(Scanner sc,Repo repo) throws IOException
	{
	   System.out.print("Enter your username:");
	   String username = sc.next();
	   System.out.print("Enter your password:");
	   String password = sc.next();
	   Trainer trainer = new Trainer(username,password);
	   boolean isTrainer = trainer.verifyTrainer();
	   if(isTrainer)
	   {
		   while(true)
		   {
			   System.out.println("1.Add a Test");
			   System.out.println("2.View Results");
			   System.out.println("3.Exit");
			   int choice = sc.nextInt();
			   if(choice == 3)
			   {
				   System.out.println("Thank You..!!");
				   break;
			   }
			   else if(choice == 1)
			   {
				   trainer.addTest(sc, repo);
			   }
			   else if(choice == 2)
			   {
				   trainer.viewResult(repo);
			   }
			   else
			   {
				   System.out.println("Enter a valid choice..!!");
			   }
		   }
	   }
	   else
	   {
		   System.out.println("You are not a Trainer, Try Again..!!");
		   System.out.println("-----------------------------------------------------------");
		   return;
	   }
	}
	static void getStudentDetails(Scanner sc,Repo repo) throws IOException
	{
	   System.out.print("Enter your username:");
	   String username = sc.next();
	   System.out.print("Enter your password:");
	   String password = sc.next();
	   Student student = new Student(username,password);
	   boolean isStudent = student.verifyStudent();
	   if(isStudent)
	   {
		   while(true)
		   {
			   System.out.println("1.Take test");
			   System.out.println("2.View Result");
			   System.out.println("3.Exit");
			   int choice = sc.nextInt();
			   if(choice == 3)
			   {
				   System.out.println("Thank You..!!");
				   break;
			   }
			   else if(choice == 1)
			   {
				   student.takeTest(sc,repo);
			   }
			   else if(choice == 2)
			   {
				   student.viewResult(repo);
			   }
		   }
	   }
	   else
	   {
		   System.out.println("You are not a Student, Try Again..!!");
		   System.out.println("-----------------------------------------------------------");
		   return;
	   }
	}
}