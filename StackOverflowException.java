/**
 * This class defines a customized exception that indicates stack overflow when trying to add element to a full stack
 * @author Nermeen Mohi
 *
 */
public class StackOverflowException extends Exception{

	public StackOverflowException()
	{
		super("The stack is full");
	}
}
