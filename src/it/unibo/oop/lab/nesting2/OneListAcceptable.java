package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	private final List<T> list;
	
	public OneListAcceptable(List<T> list) {
		this.list = list;
	}

	public Acceptor<T> acceptor() {
		final Iterator<T> iterator = this.list.iterator();
		return new Acceptor<T>() {

			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {	
				if (iterator.hasNext() && newElement.equals(iterator.next())) {
					System.out.println("Item accepted " + newElement);
				} else {
					System.out.println(newElement + " is not accept!");
					throw new ElementNotAcceptedException(newElement);
				}
			}
			
			@Override
			public void end() throws EndNotAcceptedException {
				if (iterator.hasNext()) {
					System.out.println("There are more item in the list.");
					throw new EndNotAcceptedException();
				} 
				System.out.println("List is finish.");

			}
		};
	}

}
