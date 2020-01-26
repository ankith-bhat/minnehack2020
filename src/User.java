import java.util.ArrayList;

public class User {

	protected ArrayList <String> interests = new ArrayList <String> ();

	 protected String name;
	 protected String password;
	 
	 User curFriend = null;
	 protected ArrayList <String> shared_inter = new ArrayList<String>(); 
	 
	public User(String userName, String pass, ArrayList <String> inters)
	{
		name = userName;
		password = pass;
		interests = inters;
		friendr.Users.add(this);
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


		
	
	
	/*TODO: Get name from front end and enter in for user.
	 * 
	 * public void setname() {
	
	System.out.println("Please enter your name friend");
	
	System.in.
	
	}*/
	
	
	

}
