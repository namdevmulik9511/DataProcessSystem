package dataProcessingSystem;

public class DataProcessing {
	public static void main(String[] args)
	{
		TransactionProcessor transactionProcessor=new TransactionProcessor(100, 3, 2);
		transactionProcessor.start();
	}

}
