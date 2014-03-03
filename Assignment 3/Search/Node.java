package search;

import java.util.ArrayList;

public class Node<Action, State>  {
	private Action _action;
	private State _state;
	private Node<Action, State> _prevNode;
	
	public Node(State _state) {
		this(null, _state, null);
	}

	public Node(Action _action, State _state, Node<Action, State> _prevNode) {
		this._action = _action;
		this._state = _state;
		this._prevNode = _prevNode;
	}

	public Action getAction() {
		return _action;
	}

	public State getState() {
		return _state;
	}

	public Node<Action, State> getPrevious() {
		return _prevNode;
	}
	
	public ArrayList<Action> getRoute() {
		if(_prevNode != null) {
			ArrayList<Action> route = _prevNode.getRoute();
			route.add(getAction());
			return route;
		}
		return new ArrayList<Action>();
	}

	public String routeToString() {
		StringBuffer nodeStr = new StringBuffer();
		if(_prevNode != null) {
			nodeStr.append("Action: " + _action + ", State: " + _state + ", Previous Node: " + _prevNode.routeToString());
		} else {
			nodeStr.append("State: " + _state);
		}
		return nodeStr.toString();
	}
	
	public String toString() {
		return "Action: " + _action + ", State: " + _state; 
	}
	
}
