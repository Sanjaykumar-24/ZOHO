package Model;
public class Question
{
	int id;
	String question;
	String[] options;
	String difficulty;
	int answer;
    public Question(int id,String question,String[] options,String difficulty,int answer)
    {
    	this.id = id;
    	this.question = question;
    	this.options = options;
    	this.difficulty = difficulty;
    	this.answer = answer;
    }
}