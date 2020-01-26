import java.util.ArrayList;
public class FriendSearch {

	public ArrayList <User> Users = new ArrayList <User> ();
	
	public FriendSearch(User newfren)
	{
		for (int i = 0 ; i < Users.size() ; i++)
		{
			int max = 0;
			int curMax = 0;
			User curUser = Users.get(i);
			for(int j = 0 ; j < newfren.interests.size() ; j++ )
			{
				if(curUser.interests.contains (newfren.interests.get(j)))
				{
					curMax++;
				}
			}
		}
	}







}
