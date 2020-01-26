import java.util.ArrayList;

public class User {

	protected ArrayList <String> interests = new ArrayList <String> ();

	 protected String name;
	 
	 
	 User curFriend = null;
	 
	public User()
	{
		
	}
	
	
	public void FriendSearch(User newfren)
	{
		
		int max = 0;
		for (int i = 0 ; i < friendr.Users.size() ; i++)
		{
			int curMax = 0;
			User curUser = friendr.Users.get(i);
			for(int j = 0 ; j < newfren.interests.size() ; j++ )
			{
				if(curUser.interests.contains (newfren.interests.get(j)))
				{
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


	/*TODO: Get name from front end and enter in for user.
	 * 
	 * public void setname() {
	
	System.out.println("Please enter your name friend");
	
	System.in.
	
	}*/
	
	
	

}
