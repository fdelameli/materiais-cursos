public class EmptyQueueException extends RuntimeException {

	public EmptyQueueException(String reason) {
        super(reason);
    }
}