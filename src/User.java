import java.util.ArrayList;

public class User {

	protected ArrayList <String> interests = new ArrayList <String> ();

	 protected String name;
	 protected String password;
	 protected int id;

	 User curFriend = null;
	 protected ArrayList <String> shared_inter = new ArrayList<String>();

	public User(String userName, String pass, ArrayList <String> inters)
	{
		name = userName;
		password = pass;
		interests = inters;
		friendr.Users.add(this);
		id = friendr.Users.size();
	}


	public void friendSearch(User newfren)
	{

		int max = 0;
		for (int i = 0 ; i < friendr.Users.size() ; i++)
		{

			int curMax = 0;
			User curUser = friendr.Users.get(i);

			if(curUser.equals(newfren))
			{
				continue;
			}

			for(int j = 0 ; j < newfren.interests.size() ; j++ )
			{
				if(curUser.interests.contains (newfren.interests.get(j)))
				{
					newfren.shared_inter.add(newfren.interests.get(j));
					curMax++;
				}
			}
			if(curMax > max)
			{
				max = curMax;
				newfren.curFriend = curUser;
			}
		}


	}

	public String toStringFriend() {
		if (curFriend == null) {
			return "No friend found, sorry!";
		}
		String s = "Name: " + curFriend.name + ", Shared Interests:";
		for (int i = 0 ; i < shared_inter.size(); i++) {
			s = s + " " + shared_inter.get(i);
		}
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
			query_command.append("INSERT INTO UserInterests (ID, Name, Interests) ");
			query_values.append("VALUES (" + id + ", '" + name + "', '" + interest + "')");

			queries.add(query_command.toString() + query_values.toString());
		}

		return queries.toArray(new String[queries.size()]);

	}

	public String[] getQueries(Users) {
		ArrayList<String> queries = new ArrayList<>();
		queries.add(getUserQuery(id));

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
