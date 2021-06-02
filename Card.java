
public class Card {

	private int value;
	private boolean face;
	
	public Card(int v)
	{
		value = v;
		face = false;
	}
	
	public void setFace(boolean value)
	{
		face = value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setValue( int v )
	{
		value = v;
	}
	
	public boolean getFace()
	{
		return face;
	}
}
