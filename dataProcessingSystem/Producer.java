package dataProcessingSystem;

public class Producer extends Thread 
{
	private final TransactionProcessor processor;
	public Producer(TransactionProcessor processor) 
	{
		this.processor = processor;
	}
	@Override
	public void run() 
	{
		try 
		{
			Transaction transaction = new Transaction(
					createTransactionId(), 
					System.currentTimeMillis(),
					"BUY", 
					Math.random() * 1000
					);
			while (!processor.queue.offer(transaction, 2, java.util.concurrent.TimeUnit.SECONDS)) 
			{
				System.out.println("Queue is full: " + transaction);
			}
			System.out.println("Produced: " + transaction);
			processor.logPerformance();
			Thread.sleep(100);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Error: Producer interrupted");
			Thread.currentThread().interrupt();
		}
	}
	private String createTransactionId() 
	{
		return "TransactionId: " + processor.transactionIdCounter.incrementAndGet();
	}
}
