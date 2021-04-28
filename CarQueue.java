import java.util.PriorityQueue;
import java.util.Random;

public class CarQueue 
{

	 PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	 Random r = new Random();
	 int returned;
	public CarQueue()
	{
		queue.add(r.nextInt(4)); //add any number less than four
		queue.add(r.nextInt(4));
		queue.add(r.nextInt(4));
		queue.add(r.nextInt(4));
		queue.add(r.nextInt(4));
		queue.add(r.nextInt(4));
	}
	
	public void addToQueue()
	{
		class c implements Runnable
		{
			@Override
			public void run()
			{
				queue.add(r.nextInt(4));
				queue.add(r.nextInt(4));
				queue.add(r.nextInt(4));
				queue.add(r.nextInt(4));
				queue.add(r.nextInt(4));
			}
		}
		
		Runnable r= new c();
		Thread t = new Thread(r);
		t.start();
		
	}
	
	public int deleteQueue()
	{
		 class c2 implements Runnable
         {
		    @Override
            public void run()
            {

              try
              {
                 Thread.sleep(2000);
              }
              catch (InterruptedException e)
              {}
                
              try
              {
                  if(queue.size() < 20)
                  {
                      queue.add(r.nextInt(4));
                      queue.add(r.nextInt(4));
                      queue.add(r.nextInt(4));
                      queue.add(r.nextInt(4));
                      queue.add(r.nextInt(4));
                      queue.add(r.nextInt(4));
                      queue.add(r.nextInt(4));
                      queue.add(r.nextInt(4));
                 
                  }
                 
                  else if (!queue.isEmpty())
                  {
                	  returned = queue.remove();
                  }
                 
                 
               }
              finally {}
              
            }
          
         }
		 Runnable r = new c2();
		 Thread t = new Thread(r);
         t.start();
         
         return returned;
     
		
	}
}
