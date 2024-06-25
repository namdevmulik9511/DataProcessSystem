package dataProcessingSystem;

public class Transaction 
{
	//variable its immutable once they are initialized 
	private String transactionId ;
	private  long timestamp;
	private  String transactionType;
	private  double amount;

	public Transaction(String transactionId, long timestamp, String transactionType, double amount)
	{
		super();
		this.transactionId = transactionId;
		this.timestamp = timestamp;
		this.transactionType = transactionType;
		this.amount = amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public long getTimestamp() {
		return timestamp;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", timestamp=" + timestamp + ", transactionType="
				+ transactionType + ", amount=" + amount + "]";
	}
}
