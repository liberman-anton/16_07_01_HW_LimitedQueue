package tel_ran.queues;

public class LimittedQueueTestAppl {

	public static void main(String[] args) {
		LimittedQueue<Integer> queue = new LimittedQueue<Integer>(10);
		for(int i = 0; i < 10; i++){
			try {
				queue.add(i);
			} catch (OutOfLimitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Queue:");
		for (int j = 0; j < queue.getSize(); j++) {
			System.out.print(queue.queue[j]);
		}
		System.out.println("\nQueue after offers:");
		for(int i = 0; i < 9; i++){
			try {
				queue.offer();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 0; j < queue.getSize(); j++) {
			System.out.print(queue.queue[j]);
		}
	}

}
