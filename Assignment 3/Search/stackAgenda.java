package search;

import java.util.Iterator;

import rp13.search.interfaces.Agenda;
import search.State;


public class stackAgenda<State> implements Agenda<State> {  //DFS
	
	private State[] stackAgenda;

	public stackAgenda() {
		
	}
	
	@Override
	public Iterator<State> iterator() {
		return this.iterator();
	}

	@Override
	public void push(State _item) {
		stackAgenda[stackAgenda.length + 1] = _item;
		
	}

	@Override
	public State pop() {
		// Returns the next state from the agenda and deletes it
		
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(State _item) {
		// TODO Auto-generated method stub
		return false;
	}



}
