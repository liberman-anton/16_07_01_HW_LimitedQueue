package tel_ran.queues;

public class LimittedQueue<T> {
	Object[] queue;
	int size;
	public LimittedQueue(int limit){
		queue = new Object[limit];
		size = 0;
	}
	public void add(T obj) throws OutOfLimitException {
		//check except if limit 
		//O(1)
		try {
			queue[size++] = obj;
		} catch (Exception e) {
			throw new OutOfLimitException();
		}
		
	}
	@SuppressWarnings("unchecked")
	public T offer() throws EmptyQueueException {
		// return first element and delete 
		// if null then throw exception
		// O(1)
		T res = null;
		try {
			res = (T) queue[0];
			if(res == null) throw new Exception();
			System.arraycopy(queue, 1, queue, 0, --size);
			queue[size] = null;
		} catch (Exception e) {
			throw new EmptyQueueException();
		}
		
		return res;
	}
	public int getLimit(){
		return queue.length;
	}
	/*
	 * @return maximal possible number of objects in the queue
	 */
	public int getSize(){
		
		return size;
	}
}
