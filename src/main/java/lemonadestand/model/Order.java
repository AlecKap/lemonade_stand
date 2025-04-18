package lemonadestand.model;

import java.util.List;
import java.util.ArrayList;

public class Order {
	private Customer customer;
	private List<Lemonade> lemonades;
	private double total;

	public Order(Customer customer) {
		super();
		this.customer = customer;
		lemonades = new ArrayList<>();
		total = 0.0;
	}

	public void addLemonade(Lemonade lemonade) {
		lemonades.add(lemonade);
		total += lemonade.getPrice();
	}

	public void addLemonades(List<Lemonade> lemonades) {
		this.lemonades.addAll(lemonades);
		for (Lemonade l : lemonades) {
			total += l.getPrice();
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	// public Lemonade[] getLemonades() {
	// 	return lemonades.toArray(new Lemonade[lemonades.size()])
	// } same as below
	public List<Lemonade> getLemonades() {
		return lemonades;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + lemonades.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (lemonades.equals(other.getLemonades()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order {customer=" + customer + ", lemonades=" + lemonades.toString() + ", total=" + total + "}";
	}
}
