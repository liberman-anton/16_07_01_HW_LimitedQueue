package tel_ran.queues.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tel_ran.queues.EmptyQueueException;
import tel_ran.queues.LimittedQueue;
import tel_ran.queues.OutOfLimitException;

public class LimitedQueTest {

	private static final int N_ELEMENTS = 10;
	

	@Before
	public void setUp() throws Exception {
	
	}

	@Test
	public void testAdd() {
		LimittedQueue<Integer> queue = new LimittedQueue<Integer>(N_ELEMENTS);
		boolean fl_exception = false;
		for(int i = 0; i < N_ELEMENTS; i++){
			try {
				queue.add(i);
			} catch (OutOfLimitException e) {
				fl_exception = true;
			}
		}
		assertTrue(!fl_exception);
		
		fl_exception = false;
			try {
				queue.add(111);
			} catch (OutOfLimitException e) {
				fl_exception = true;
			}
		assertTrue(fl_exception);
		
	}
	@Test
	public void testOffer() {
		LimittedQueue<Integer> queue = new LimittedQueue<Integer>(N_ELEMENTS);
		boolean fl_exception = false;
		try {
			queue.offer();
		} catch (EmptyQueueException e) {
			fl_exception = true;
		}
		assertTrue(fl_exception);	
		
		fl_exception = false;
		for(int i = 0; i < N_ELEMENTS; i++){
			try {
				queue.add(i);
			} catch (OutOfLimitException e) {
				fl_exception = true;
			}
		}
		assertTrue(!fl_exception);
		
		fl_exception = false;
		for(int i = 0; i < N_ELEMENTS; i++){
			try {
				queue.offer();
			} catch (EmptyQueueException e) {
				fl_exception = true;
			}
		}
		assertTrue(!fl_exception);
		
		fl_exception = false;
		try {
			queue.offer();
		} catch (EmptyQueueException e) {
			fl_exception = true;
		}
		assertTrue(fl_exception);
		
	}
}
