import java.util.Scanner;


public class TicTacToe
{

	//Variables for the Fields of the game
	String[][] field = new String[3][3];

	//Method to determine who wins the game
	public boolean win(String [][] field)
	{

		if ("XXX".equals(field[0][0] + field[1][0] + field[2][0]) || "XXX".equals(
				field[0][1] + field[1][1] + field[2][1]) || "XXX".equals(
				field[0][2] + field[1][2] + field[2][2]) || "XXX".equals(
				field[0][0] + field[0][1] + field[0][2]) || "XXX".equals(
				field[1][0] + field[1][1] + field[1][2]) || "XXX".equals(
				field[2][0] + field[2][1] + field[2][2]) || "XXX".equals(
				field[0][0] + field[1][1] + field[2][2]) || "XXX".equals(
				field[0][2] + field[1][1] + field[2][0]))
		{
			return true;
		}
		else if ("OOO".equals(field[0][0] + field[1][0] + field[2][0]) || "OOO".equals(
				field[0][1] + field[1][1] + field[2][1]) || "OOO".equals(
				field[0][2] + field[1][2] + field[2][2]) || "OOO".equals(
				field[0][0] + field[0][1] + field[0][2]) || "OOO".equals(
				field[1][0] + field[1][1] + field[1][2]) || "OOO".equals(
				field[2][0] + field[2][1] + field[2][2]) || "OOO".equals(
				field[0][0] + field[1][1] + field[2][2]) || "OOO".equals(
				field[0][2] + field[1][1] + field[2][0]))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	Scanner sc = new Scanner(System.in);
	String input = null;
	//Method for playing the game
	public void play()
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				field[i][j] = "";
			}
		}
		System.out.println("Welcome to Tic Tac Toe!\nYou can choose between the Fields A-C 1-3\nHave fun playing!");

		//for loop that starts the game
		for (int i = 0; i < 10; i++)
		{
			if(i == 9)
			{
				System.out.println("Draw!");
				break;
			}
			if (i % 2 == 0)
			{
				System.out.println("Player one please choose a field:");
				try
				{
					input = sc.next();
				}
				catch (Exception e)
				{
					System.err.println("Please enter correct values");
					i--;
				}

					try
					{
						if (input.length() == 2)
						{
							try
							{
								checkCoords(input, field, "X");
								if(win(field))
								{
									showCurrentScore();
									System.out.println("Player X has won the game!");
									break;
								}
							}
							catch (FieldAlreadyUsedException d)
							{
								System.err.println("This field has already been used");
								i--;
							}

						}
						else
						{
							System.err.println("Please enter a valid input");
							i--;
						}

					}
					catch (Exception f)
					{
						i--;
						System.err.println("Please enter a valid input");
					}

			}
			else
			{
				System.out.println("Player two please choose a field:");
				try
				{
					input = sc.next();
				}
				catch (Exception e)
				{
					System.err.println("Please enter correct values");
					i--;
				}

					try
					{
						if (input.length() == 2)
						{
							try
							{
								checkCoords(input, field, "O");
								if(win(field))
								{
									showCurrentScore();
									System.out.println("Player O has won the game!");
									break;
								}
							}
							catch (FieldAlreadyUsedException d)
							{
								System.err.println("This field has already been used");
								i--;
							}

						}
						else
						{
							System.err.println("Please enter a valid input");
							i--;
						}

					}
					catch (Exception f)
					{
						i--;
						System.err.println("Please enter a valid input");
					}

			}

			showCurrentScore();
		}


	}

	private void showCurrentScore()
	{
		System.out.println(field[0][0] + " | " + field[0][1] + " | " + field[0][2]);
		System.out.println(field[1][0] + " | " + field[1][1] + " | " + field[1][2]);
		System.out.println(field[2][0] + " | " + field[2][1] + " | " + field[2][2]);
	}

	public void checkCoords(String input, String field[][], String XO) throws FieldAlreadyUsedException
	{
		String beschreibung = String.valueOf(input.charAt(0));
		int zeile = Integer.parseInt(input.substring(input.length() - 1, input.length())) - 1;
		int spalte = 0;
		if (beschreibung.equalsIgnoreCase("A"))
		{
			spalte = 0;
		}
		if (beschreibung.equalsIgnoreCase("B"))
		{
			spalte = 1;
		}
		if (beschreibung.equalsIgnoreCase("C"))
		{
			spalte = 2;
		}

		if (field[spalte][zeile].isBlank())
		{
			field[spalte][zeile] = XO;
		}
		else if ("O".equals(field[spalte][zeile]) || "X".equals(field[spalte][zeile]))
		{
			throw new FieldAlreadyUsedException("This field is already in use, please take another one");
		}
	}

	public String[][] getField()
	{
		return field;
	}

	public void setField(String[][] field)
	{
		this.field = field;
	}
}
