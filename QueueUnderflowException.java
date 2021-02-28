/**
 * This class defines a customized exception that indicates queue underflow when trying to remove element from an empty queue.
 * @author Nermeen Mohi
 *
 */
public class QueueUnderflowException extends Exception {

	public QueueUnderflowException()
	{
		super("This is an empty queue");
	}
}
