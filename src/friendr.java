import java.util.ArrayList;


public class friendr {
	public static ArrayList <User> Users = new ArrayList <User> ();

	public static void main(String [] args)
	{
		ArrayList<String> interests1 = new ArrayList<String>();
		ArrayList<String> interests2 = new ArrayList<String>();
		ArrayList<String> interests3 = new ArrayList<String>();

		interests1.add("Gaming");
		interests2.add("Gaming");
		interests1.add("Poker");
		interests2.add("Poker");
		interests1.add("Gains");
		interests2.add("Test");
		interests3.add("Nothing");

		User amith = new User("Amith", "", interests1);
		User karan = new User("Karan", "", interests2);
		User ankith = new User("Ankith", "", interests3);

		amith.friendSearch(amith);
		System.out.println(amith.toStringFriend());
		karan.friendSearch(karan);
		System.out.println(karan.toStringFriend());
		ankith.friendSearch(ankith);
		System.out.println(ankith.toStringFriend());0




	}

}
