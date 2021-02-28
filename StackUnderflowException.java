/**
 * This class defines a customized exception that indicates stack underflow when trying to remove element to a empty stack
 * @author Nermeen Mohi
 *
 */
public class StackUnderflowException extends Exception{

	public StackUnderflowException()
	{
		super("The stack is empty");
	}
}
