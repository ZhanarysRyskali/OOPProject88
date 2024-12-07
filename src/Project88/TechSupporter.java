package Project88;

import java.util.ArrayList;
import java.util.List;

public class TechSupporter extends Employee {
	private List<Order> orders = new ArrayList<>();

	public List<Order> viewOrder(Status status) {
		// Filter orders by status
		return orders;
	}

	public void acceptOrder(Order order) {
		// Logic for accepting an order
	}

	public void rejectOrder(Order order) {
		// Logic for rejecting an order
	}
}
