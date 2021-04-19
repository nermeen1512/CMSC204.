import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter 
{
	 private static MorseCodeTree tree = new MorseCodeTree();
	  
	   public MorseCodeConverter()
	   {
	   }
	 
	   public static String convertToEnglish(String code)
	   {
	       String returned = "";
	       String[] words; // store the splited words
	       String[] chars; //store the splited characters

	       words = code.split(" / ");
	       for(int i = 0; i < words.length; i++)
	       {   
	    	   chars = words[i].split(" ");
	          
	           for(int j = 0; j < chars.length; j++)
	           {
	               returned += tree.fetch(chars[j]);  
	           }
	           returned += " ";
	       }  
	       returned = returned.trim();
	       return returned;
	   }
	   
	   
	   public static String convertToEnglish(File codeFile) throws FileNotFoundException
	   {
	       String returned = "";
	       ArrayList<String> line = new ArrayList<String>();
	       String[] words; // store the splited words
	       String[] chars;  //store the splited characters
	      
	       Scanner inputFile = new Scanner(codeFile);
	       while (inputFile.hasNext())
	       {  
	           line.add(inputFile.nextLine());
	       }
	          
	       inputFile.close();
	    
	       for(int i = 0; i < line.size(); i++)
	       {
	    	   words = line.get(i).split(" / ");
	           for(int j = 0; j < words.length; j++)
	           {
	        	   chars = words[j].split(" ");
	              
	               for(int k = 0; k < chars.length; k++)
	               {
	            	   returned += tree.fetch(chars[k]);  
	               }
	               returned += " ";
	           }
	       }
	       returned = returned.trim();
	      
	       return returned;
	   }

	   
	   public static String printTree()
	   {
	       ArrayList<String> list = new ArrayList<String>();
	       list = tree.toArrayList();
	      
	       String returned = "";
	      
	       for(int i = 0; i < list.size(); i ++)
	       {
	           returned += list.get(i) + " ";  
	       }
	      
	       return returned;
	   }
	
}
