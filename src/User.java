import java.util.ArrayList;
import java.util.Arrays;

public class User {

	protected ArrayList <String> interests = new ArrayList <String> ();

	 protected String name;
	 protected String password;
	 protected int id;

	 User curFriend = null;
	 private ArrayList <String> shared_inter = new ArrayList<String>();

	public User(String userName, String pass, ArrayList <String> inters)
	{
		name = userName;
		password = pass;
		interests = inters;
		friendr.Users.add(this);
		id = friendr.Users.size();
	}


	public void friendSearch()
	{

		int max = 0;
		for (int i = 0 ; i < friendr.Users.size() ; i++)
		{

			int curMax = 0;
			User curUser = friendr.Users.get(i);

			if(curUser.equals(this))
			{
				continue;
			}
			ArrayList <String> tmpShared = new ArrayList<String>();
			for(int j = 0 ; j < this.interests.size() ; j++ )
			{
				if(curUser.interests.contains(this.interests.get(j)))
				{
					
					
					tmpShared.add(this.interests.get(j));
					curMax++;
				}
			}
			if(curMax > max)
			{
				max = curMax;
				this.curFriend = curUser;
				this.shared_inter = tmpShared;
			}
		}
	}

	public String toStringFriend() {
		if (curFriend == null) {
			return "Your your only friend loser";
		}
		String s = this.name +"s friend " + "Name: " + curFriend.name + ", Shared Interests:";
		for (int i = 0 ; i < this.shared_inter.size(); i++) {
			s = s + " " + this.shared_inter.get(i);
		}
		
		System.out.println(s);
		return s;
	}



	private String getUserQuery() {
		StringBuilder query_command = new StringBuilder(100);
		StringBuilder query_values = new StringBuilder(100);


		query_command.append("INSERT INTO Users (ID, Name, Password) ");
		query_values.append("VALUES (" + id + ", '" + name + "', '" + password + "')");

		return query_command.toString() + query_values.toString();

	}


	private String[] getInterestQueries(){
		ArrayList<String> queries = new ArrayList<>();

		for (String interest : interests) {
			String query_command = "INSERT INTO UserInterests (ID, Name, Interests) ";
			String query_values = "VALUES (" + id + ", '" + name + "', '" + interest + "')";

			queries.add(query_command + query_values);
		}

		return queries.toArray(new String[queries.size()]);

	}

	public String[] getQueries() {
		ArrayList<String> queries = new ArrayList<>();
		queries.add(getUserQuery());

		queries.addAll(Arrays.asList(getInterestQueries()));

		return queries.toArray(new String[queries.size()]);
	}





	/*TODO: Get name from front end and enter in for user.
	 *
	 * public void setname() {

	System.out.println("Please enter your name friend");

	System.in.

	}*/




}
