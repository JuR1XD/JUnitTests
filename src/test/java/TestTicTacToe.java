import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class TestTicTacToe
{

	TicTacToe t;

	//Arrange
	String[][] field;
	@BeforeEach
	void setUp()
	{
		field = new String[3][3];
		t = new TicTacToe();
	}

	@Test
	@DisplayName("Check with a example if the winning System for X works")
	void CheckIfWinnerSystemWorksX()
	{

		//Arrange
		field [1][0] = "X";
		field [1][1] = "X";
		field [1][2] = "X";

		//Act
		//Assert
		assertTrue(t.win(field));
	}
	@Test
	@DisplayName("Check with a example if the winning System for O works")
	void CheckIfWinnerSystemWorksO()
	{
		//Arrange
		field [1][0] = "O";
		field [1][1] = "O";
		field [1][2] = "O";

		//Act
		//t.setField(field);

		//Assert
		assertTrue(t.win(field));
	}

	@Test
	@DisplayName("Test the correct output if there is a draw")
	void TestCorrectDrawOutput()
	{
		//Arrange
		field [0][0] = "O";
		field [0][1] = "O";
		field [0][2] = "X";
		field [1][0] = "X";
		field [1][1] = "X";
		field [1][2] = "O";
		field [2][0] = "O";
		field [2][1] = "X";
		field [2][2] = "O";
		//Act
		//t.setField(field);
		//Assert
		assertFalse(t.win(field));
	}

	@Test
	@DisplayName("Test that all fields are null at the beginning")
	void TestIfFieldsAreNull()
	{
		//Arrange
		String [][] field = t.getField();
		//Act
		// Assert
		for(int i = 0; i <= t.getField().length-1; i++)
		{

				for (int j = 0; j <= t.getField().length-1; j++)
				{
					assertNull(field[i][j]);
				}
		}

	}

	@Test
	@DisplayName("Check that there is no current winner if the conditions are not met")
	void CheckIfConditionsWork()
	{

		//Arrange
		field [1][0] = "X";
		field [1][1] = "O";
		field [1][2] = "X";

		//Act
		//t.setField(field);

		//Assert
		assertFalse(t.win(field));
	}

	@Test
	@DisplayName("Check that there is no current winner if the conditions are not met")
	void CheckIfNull()
	{

		//Arrange

		//Act
		//t.setField(field);

		//Assert
		assertFalse(t.win(field));
	}

	@Test
	@DisplayName("Check if player turn is X")
	void checkIfPlayerX()
	{
		//Arrange
		String input = "A2";
		field[0][1] = input;
		//Act
		t.setField(field);
		//Assert

	}

	/*@Test
	@DisplayName("Check if input is correct")
	void CheckIfInputIsCorrect()
	{
		//Arrange

		//Act

		//Assert

	}*/

}
