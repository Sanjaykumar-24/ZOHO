package Model;
import java.util.*;
import Model.*;
public class Repo
{
   List<Question> questionBank = new ArrayList<>();
   List<Test> testList = new ArrayList<>();
   List<Result> resultList = new ArrayList<>();
   public Repo()
   {
	   
   }
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void add(Question ques)
   {
	   this.questionBank.add(ques);
	   System.out.println("Question Successfully added..!!");
   }
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public boolean removeQues(int id)
   {
	   boolean flag = true;
	   for(int i=0;i<questionBank.size();i++)
	   {
		   int currId = questionBank.get(i).id;
		   if(currId == id)
		   {
			   questionBank.remove(i);
			   flag = false;
			   break;
		   }
	   }
	   return flag;
   }
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void viewQues()
   {
	   if(questionBank.size()==0)
	   System.out.println("No questions found..!!");
	   for(int i=0;i<questionBank.size();i++)
	   {
		   Question quiz = questionBank.get(i);
		   System.out.print(quiz.id+" ");
		   System.out.println(quiz.question+" ");
		   for(int j=0;j<4;j++)
		   {
			   System.out.println((char)(97+j)+":"+quiz.options[j]);
		   }
		   System.out.println("Difficulty:"+quiz.difficulty);
		   System.out.println("-----------------------------------------------------------");
	   }
   }
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public boolean makeQuestions(int count,int easy,int medium,int hard,int exclude,List<Question> list)
   {
	   boolean result = true;
	   for(int i=0;i<questionBank.size();i++)
	   {
		   Question quiz = questionBank.get(i);
		   if(quiz.difficulty.equals("easy") && easy>0)
		   {
			   boolean flag = true;
			   for(int j=testList.size()-1;j>=testList.size()-exclude && j>=0;j--)
			   {
				   List<Question> prev = testList.get(j).test;
				   for(int k=0;k<prev.size();k++)
				   {
					   Question curr = prev.get(k);
					   if(curr.id == quiz.id && curr.difficulty.equals(quiz.difficulty))
					   {
						   flag = false;
					   }
				   }
			   }
			   if(flag)
			   {
				   easy--;
				   list.add(quiz);
			   }
		   }
	   }
		   if(easy>0)
			 result = false;
		   if(result)
		   {
			   for(int i=0;i<questionBank.size();i++)
			   {
				   Question quiz = questionBank.get(i);
				   if(quiz.difficulty == "medium" && medium>0)
				   {
					   boolean flag = true;
					   for(int j=testList.size()-1;j>=testList.size()-exclude && j>=0;j--)
					   {
						   List<Question> prev = testList.get(j).test;
						   for(int k=0;k<prev.size();k++)
						   {
							   Question curr = prev.get(k);
							   if(curr.id == quiz.id && curr.difficulty.equals(quiz.difficulty));
							   {
								   flag = false;
							   }
						   }
					   }
					   if(flag)
					   {
						   medium--;
						   list.add(quiz);
					   }
				   }
		      }
			   if(medium>0)
			   result = false;
   }
		   if(result)
		   {
			   for(int i=0;i<questionBank.size();i++)
			   {
				   Question quiz = questionBank.get(i);
				   if(quiz.difficulty == "hard" && hard>0)
				   {
					   boolean flag = true;
					   for(int j=testList.size()-1;j>=testList.size()-exclude && j>=0;j--)
					   {
						   List<Question> prev = testList.get(j).test;
						   for(int k=0;k<prev.size();k++)
						   {
							   Question curr = prev.get(k);
							   if(curr.id == quiz.id && curr.difficulty.equals(quiz.difficulty));
							   {
								   flag = false;
							   }
						   }
					   }
					   if(flag)
					   {
						   hard--;
						   list.add(quiz);
					   }
				   }
		      }
			   if(hard>0)
			   result = false;
		   }
		   return result;
		   }
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void addTesttoList(Test test)
   {
	   testList.add(test);
	   System.out.println("Test successfully added");
   }
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void view()
   {
	   if(resultList.size()==0)
	      System.out.println("No results..!!");
	   for(int i=0;i<resultList.size();i++)
	   {
		   Result rslt = resultList.get(i);
		   System.out.println(rslt.studentName+" "+rslt.TestId+" "+rslt.mark);
	   }
   }
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public boolean verifyTest(int testId)
   {
	   boolean flag = false;
	   for(int i=0;i<testList.size();i++)
	   {
		   Test tst = testList.get(i);
		   if(tst.id == testId)
		   {
			   flag = true;
		   }
	   }
       return flag;
   }
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void takeTestNow(Scanner sc,int testId,String name)
   {
	  Test currtest = null;
	  for(int i=0;i<testList.size();i++)
	  {
		  if(testList.get(i).id == testId)
		  {
			  currtest = testList.get(i);
		  }
	  }
	  System.out.println("Ready to take the test");
	  int mark = 0;
	  for(int i=0;i<currtest.test.size();i++)
	  {
		  Question quiz = currtest.test.get(i);
		  System.out.println(quiz.question);
		  System.out.print("Enter the option(1,2,3,4):");
		  int choice = sc.nextInt();
		  if(choice == quiz.answer)
		  mark++;
	  }
	  Result rst = new Result(name,testId,mark);
	  resultList.add(rst);
	  System.out.println("you have completed the test you can view the result in resut section..!!");
   }
}