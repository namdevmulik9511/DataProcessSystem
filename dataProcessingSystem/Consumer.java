package dataProcessingSystem;

import java.util.concurrent.TimeUnit;

public class Consumer extends Thread
{
	private final TransactionProcessor processor;

	public Consumer(TransactionProcessor processor)
	{
		this.processor = processor;
	}
	@Override
	public void run() 
	{
		try 
		{
			if (processor.queue.isEmpty()) 
			{
				System.out.println("Queue is empty");
				Thread.sleep(500);
			}
			Transaction transaction = processor.queue.poll(2,TimeUnit.SECONDS);
			if (transaction != null) 
			{
				long startTime = System.nanoTime();
				processTransaction(transaction);
				long endTime = System.nanoTime();
				System.out.println("Consumer: " + transaction + " in " + (endTime - startTime) / 1_000_000 + " ms");
				processor.logPerformance();
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Error: Consumer interrupted");
			Thread.currentThread().interrupt();
		}
	}
	private void processTransaction(Transaction transaction) 
	{
		System.out.println("Processing: " + transaction);
		processor.history.add(transaction);
	}
}
