/**
 * This class defines a customized exception that indicates queue overflow when trying to add element to a full queue
 * @author Nermeen Mohi
 *
 */
public class QueueOverflowException extends Exception{

	public QueueOverflowException()
	{
		super("This is a full queue");
	}
}
