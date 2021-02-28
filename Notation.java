/**
 * This class has method to convert from infix to postfix and vise versa.
 * It also has methods to calculate both postfix and infix expressions.
 * @author Nermeen Mohi
 *
 */

public class Notation {
	
	
	//public static NotationStack<String> Stack= new NotationStack<String>(40);
	
	//------------------------ The constructor
	public Notation()
	{
	}
	//------------------------------------------------------------------------------------------------------------------------------------------ infix to postfix
	/**
	 * 
	 * @param infix
	 * @return Postfix
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix (String infix) throws InvalidNotationFormatException
	{
		NotationQueue<String> postfix = new NotationQueue<String>(infix.length()); // postfix to be returned
		NotationStack<String> Stack= new NotationStack<String>(infix.length());
		
		
		try
		{
			char current;
			for(int i=0; i< infix.length(); i++)
			{
				current = infix.charAt(i);
				if(current ==' ') //skipping the spaces
				{
					continue;
				}
				else if(Character.isDigit(current))
				{
					postfix.enqueue(String.valueOf(current));
				}
				else if(current == '(')
				{
					Stack.push("(");
				}
				else if(current == '*' || current == '/'|| current =='+'|| current =='-') //check operations
				{
					switch(current)
					{
					
					case '*': 
						if(Stack.isEmpty()) //check if the stack is empty
						{
							Stack.push("*");
						}
						else if(Stack.top()== "/")//only / is equal or higher
						{
							postfix.enqueue(Stack.top());
							Stack.pop();
							Stack.push("*");
						}
						else
						{
							Stack.push("*");
						}
						break;
					
					case '/':  
						if(Stack.isEmpty())//check if the stack is empty
						{
							Stack.push("/");
						}
						else if(Stack.top()== "*")  // only * is equal or higher
						{
							postfix.enqueue(Stack.top());
							Stack.pop();
							Stack.push("/");
						}
						else
						{
							Stack.push("/");
						}
						break;
					
					case '+' : 
						if(Stack.isEmpty())//check if the stack is empty
						{
							Stack.push("+");
						}
						else if(Stack.top()== "-" || Stack.top()== "/" || Stack.top()== "-") //  *,/,-  are equal or higher
						{
							postfix.enqueue(Stack.top());
							Stack.pop();
							Stack.push("+");
						}
						else
						{
							Stack.push("+");
						}
						break;
						
					case '-' : 
						if(Stack.isEmpty())//check if the stack is empty
						{
							Stack.push("-");
						}
						else if(Stack.top()== "+" || Stack.top()== "/" || Stack.top()== "*") //  *,/,+  are equal or higher
						{
							postfix.enqueue(Stack.top());
							Stack.pop();
							Stack.push("-");
						}
						else
						{
							Stack.push("-");
						}
						break;
					}
				}
				else if(current == ')') //check if it is right parenthesis
				{
					if(!(Stack.toString().contains("("))) //check if no left parenthesis
					{
						throw new InvalidNotationFormatException();
					}
					else
					{
						//postfix.enqueue(Stack.top());
						//Stack.pop();
						int temp= Stack.size(); //store the current stack size
						for(int x=0; x <  temp; x++)
						{
							if(Stack.top()== "+" ||Stack.top()== "-" ||Stack.top()== "*" ||Stack.top()== "/")
							{
								postfix.enqueue(Stack.top());
								Stack.pop();
							}
							else if (Stack.top()=="(")
							{
								Stack.pop();
								break;
							}
							else
							{
								break;
							}
						}
					}
				}
			}
			for(int i=0; i< Stack.size(); i++)
			{
				postfix.enqueue(Stack.top());
				Stack.pop();
			}
		}
		catch (QueueOverflowException x) {
			x.getMessage();
		} catch (StackOverflowException x) {
			x.getMessage();
		} catch (StackUnderflowException x) {
			x.getMessage();
		}
		
		return postfix.toString();
	}
	/**
	 * 
	 * @param postfix
	 * @return infix
	 * @throws InvalidNotationFormatException
	 */
	//------------------------------------------------------------------------------------------------------------------------------------------postfix to infix
	public static String convertPostfixToInfix(String postfix)throws InvalidNotationFormatException
	{
		NotationStack<String> Stack= new NotationStack<String>(40);
		String output="";
		char current;
		for(int i=0; i< postfix.length(); i++)
		{
			current = postfix.charAt(i);
			while(current == ' ')  // Ignoring the spaces
			{
				i++;
				current = postfix.charAt(i);
			}
			if(Character.isDigit(current)) //check if the current character is a digit, and put it in the stack
			{
				try {
					Stack.push(Character.toString(current));
				} catch (StackOverflowException x) {
					x.getMessage();
				}
			}
			else // if not then they must be the operations
			{
				try
				{
					String s1= Stack.pop(); // stack : 32
					String s2= Stack.pop();
					output= "(" +s2 + current + s1 + ")"; // we need (2+3)
					Stack.push(output);
				}
				catch(StackUnderflowException x)
				{
					throw new InvalidNotationFormatException();
				} catch (StackOverflowException x) {
					x.getMessage();
				}
			}
		}
		try
		{
			output = Stack.pop();
			//String fail= Stack.pop();
			//throw new InvalidNotationFormatException();
		}
		catch( StackUnderflowException x)
		{	
		}
		return output.toString();
	}
	/**
	 * 
	 * @param postfixExpr
	 * @return value of the the postfix expression
	 * @throws InvalidNotationFormatException
	 */
	//-----------------------------------------------------------------------------------------------------------------Method to Evaluate the postfix
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
	{
		NotationStack<String> Stack= new NotationStack<String>(40);
		char current;
		double d = 0;
		try {
			for(int i=0; i< postfixExpr.length(); i++)
			{
				current = postfixExpr.charAt(i);
				while(current == ' ')  // Ignoring the spaces
				{
					i++;
					current = postfixExpr.charAt(i);
				}
				if(Character.isDigit(current)) //check if the current character is a digit, and put it in the stack
				{
					Stack.push(Character.toString(current));
				}
				if(current== '*')
				{
					double calc= Double.parseDouble(""+ Stack.pop()) * Double.parseDouble(""+ Stack.pop());
					Stack.push(String.valueOf(calc));
				}
				if(current == '/')
				{
					double calc= 1/( Double.parseDouble(""+ Stack.pop()) / Double.parseDouble(""+ Stack.pop()));
					Stack.push(String.valueOf(calc));
				}
				if(current == '+')
				{
					double calc = Double.parseDouble(""+ Stack.pop()) + Double.parseDouble(""+ Stack.pop());
					Stack.push(String.valueOf(calc));
				}
				if(current == '-')
				{
					double calc = (-1) *(Double.parseDouble(""+ Stack.pop()) - Double.parseDouble(""+ Stack.pop()));
					Stack.push(String.valueOf(calc));
				}
			}
		}
		catch(StackUnderflowException x)
		{
				throw new InvalidNotationFormatException();
		} catch (StackOverflowException x) {
			x.getMessage();
		}
		try {
			 d =Double.valueOf(Stack.pop());
		} catch (NumberFormatException x) {
			x.getMessage();
		} catch (StackUnderflowException x) {
			x.getMessage();
		}
		return d;
	}
	/**
	 * 
	 * @param infixExpr
	 * @return value of the infix expression
	 * @throws InvalidNotationFormatException
	 */
	//-------------------------------------------------------------------------------------------------------------------------------Method to Evaluate the infix
	public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException
		{
			String iToP = convertInfixToPostfix(infixExpr);
			double iToP_d = evaluatePostfixExpression(iToP);
			return iToP_d;
		
		}
		
}
