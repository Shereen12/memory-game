import java.util.Random;
import java.util.Scanner;
public class Game {
 
	private Card[] cards;
	private Card[][] board;
	private boolean[] deck;
	
	private void setCards()
	{
		for ( int i = 0 ; i < 8 ; i++ )
		{
			cards[i] = new Card(i + 1);
		}
		
		for ( int i = 8 ; i < 16 ; i++ )
		{
			cards[i] = new Card((i+2) % 9);
		}
		
		/*for ( int i = 0 ; i < 16 ; i++ )
		{
			System.out.print(cards[i].getValue());
		}*/
	}
	
	private void setBoard()
	{
		board = new Card[4][4];
		
		initialize();
	}
	
	private void initialize()
	{
		Random rand = new Random();
		
		for ( int i = 0 ; i < 4 ; i++ )
		{
			for (int j = 0 ; j < 4 ; j++)
			{
				int randomNumber = rand.nextInt(16);
				
				while ( deck[randomNumber] == true ) {
					
					randomNumber = rand.nextInt(16);
				} 
					
					deck[randomNumber] = true;
				
				board[i][j] = cards[randomNumber];
			}
		}
		
	/*	for ( int i = 0 ; i < 4 ; i++ )
		{
			for ( int j = 0 ; j < 4 ; j++ )
			{
				int value = board[i][j].getValue();
				System.out.print(value + " ");
			}
			System.out.println();
		}*/
	}
	
	private void initializeDeck()
	{
		deck = new boolean[16];
		
		for ( int i = 0 ; i < 16 ; i++ )
			deck[i] = false;
	}
	
	private void userPrompt()
	{
		System.out.println("Enter location for two cards: ");
		Scanner scannerObject = new Scanner(System.in);
		int i1 = scannerObject.nextInt();
		int j1 = scannerObject.nextInt();
		int i2 = scannerObject.nextInt();
		int j2 = scannerObject.nextInt();
		
		checkBoard(i1, j1, i2, j2);
	}
	
	private void checkBoard(int i1, int j1, int i2, int j2)
	{
        i1 -= 1;
        j1 -= 1;
        
        i2 -= 1;
        j2 -= 1;
        
	    board[i1][j1].setFace(true);
	    board[i2][j2].setFace(true); 
	    
	    output();
	    
	    if ( board[i1][j1].getValue() != board[i2][j2].getValue() ) {
	    	board[i1][j1].setFace(false);
	        board[i2][j2].setFace(false);
	        
	        output();
	    }
	    
	    isWon();
	    
	}
	private void isWon()
	{
		if (scanBoard() == true )
			System.out.println("Done!");
		
		else { 
			userPrompt();
		}
			
	}
	private boolean scanBoard()
	{
		for ( int i = 0 ; i < 4 ; i++ )
		{
			for ( int j = 0 ; j < 4 ; j++ )
			{
				if ( board[i][j].getFace() == false)
					return false;
			}
		}
		
		return true;
	}
	private void output()
 	{
		
		for ( int i = 0 ; i < 4 ; i++ )
		{
			for (int j = 0 ; j < 4 ; j++)
			{
				if ( board[i][j].getFace() == true )
					
					System.out.print(board[i][j].getValue() + " ");
				
				else System.out.print("*" + " ");
				
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println();
		
	}
	public Game()
	{
		cards = new Card[16];
		setCards();
		initializeDeck();
		setBoard();
		userPrompt();		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Game g = new Game();
	}

}
