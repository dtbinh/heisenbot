package search;

import java.util.Iterator;
import java.util.Stack;

import rp13.search.interfaces.Agenda;

public class stackAgenda<ItemT> implements Agenda<ItemT> {

	private Stack<ItemT> stack = new Stack<ItemT>();
	
	@Override
	public Iterator iterator() {
		return stack.iterator();
	}

	@Override
	public void push(ItemT _item) {
		stack.push(_item);
	}

	@Override
	public ItemT pop() {
		return stack.pop();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public boolean contains(Object _item) {
		return stack.contains(_item);
	}


}
