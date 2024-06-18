package Model;
import java.util.*;
public class Test
{
	int id;
	int Qcount;
	int eC;
	int mC;
	int hC;
	int exclude;
	List<Question> test = new ArrayList<>();
	public Test(int id,int count,int easy,int medium,int hard,int exclude,List<Question> list)
	{
		this.id = id;
		this.Qcount = count;
		this.eC = easy;
		this.mC = medium;
		this.hC = hard;
		this.exclude = exclude;
		this.test = list;
	}
}