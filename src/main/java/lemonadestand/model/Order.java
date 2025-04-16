package lemonadestand.model;

import java.util.HashSet;
import java.util.Set;

public class Order {
	private Customer customer;
	private Set<Lemonade> lemonades;
	private double total;

	public Order(Customer customer) {
		super();
		this.customer = customer;
		lemonades = new HashSet<>();
		total = 0.0;
	}

	public void addLemonade(Lemonade lemonade) {
//    Lemonade[] temp = new Lemonade[lemonades.length + 1];
//    for (int i = 0; i < lemonades.length; i++) {
//      temp[i] = lemonades[i];
//    }

		// Lemonade[] newLemonadeArray = Arrays.copyOf(lemonades, lemonades.length + 1); // creates a temp array. same as above.
		// newLemonadeArray[newLemonadeArray.length - 1] = lemonade;
		// lemonades = newLemonadeArray;
		if (lemonades.add(lemonade)) {
			total += lemonade.getPrice();
		}
	}

	public void addLemonades(Set<Lemonade> lemonades) {
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
	public Set<Lemonade> getLemonades() {
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
		return "Order [customer=" + customer + ", lemonades=" + lemonades.toString() + ", total=" + total + "]";
	}
}
