package dataProcessingSystem;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class TransactionProcessor
{
	final BlockingQueue<Transaction> queue;
	final TransactionHistory history;
	private final int producerCount;
	private final int consumerCount;
	final AtomicLong transactionIdCounter = new AtomicLong();

	public TransactionProcessor(int queueCapacity, int producerCount, int consumerCount)
	{
		this.queue = new ArrayBlockingQueue<>(queueCapacity);
		this.history = new TransactionHistory();
		this.producerCount = producerCount;
		this.consumerCount = consumerCount;
	}
	public void start()
	{
		for (int i = 0; i < producerCount; i++) 
		{
			new Producer(this).start();
		}
		for (int i = 0; i < consumerCount; i++) 
		{
			new Consumer(this).start();
		}
	}
	public void logPerformance()
	{
		System.out.println("Queue length: " + queue.size());
	}
}

