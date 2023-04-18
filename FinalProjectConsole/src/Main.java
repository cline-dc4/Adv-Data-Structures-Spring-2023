import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int choice;
		Board gb = new Board();
		System.out.println(gb);
		while(!gb.getGameEnd())
		{
			System.out.println("Player " + gb.getCurrentPlayer() +
					", please enter which pocket number you would like to move(counting from left to right).");
			choice = input.nextInt();
			try
			{
				gb.moveStones(choice);
				System.out.println(gb);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}

	}
}
