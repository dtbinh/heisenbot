package search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import rp13.search.interfaces.Agenda;

public class queueAgenda<ItemT> implements Agenda<ItemT>{

	private Queue<ItemT> queue = new LinkedList<ItemT>();
	
	@Override
	public Iterator iterator() {
		return queue.iterator();
	}

	@Override
	public void push(ItemT _item) {
		queue.add(_item);		
	}

	@Override
	public ItemT pop() {
		return queue.remove();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public boolean contains(ItemT _item) {
		return queue.contains(_item);
	}

}
