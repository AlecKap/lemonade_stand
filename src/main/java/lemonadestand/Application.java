package lemonadestand;

import lemonadestand.model.Customer;
import lemonadestand.model.Lemonade;
import lemonadestand.model.Order;

public class Application {
	public static void main(String[] args) {
		Customer customer1 = new Customer("Alec", "(123)4567890");
		Customer customer2 = new Customer("Halie", "(123)4567899");

		Order order1 = new Order(customer1);
		Order order2 = new Order(customer2);

		order1.addLemonade(new Lemonade(1, .5, 1, 5));
		order1.addLemonade(new Lemonade(1, .5, 1, 5));
		order1.addLemonade(new Lemonade(1, .5, 1, 5));
		order1.addLemonade(new Lemonade(1, .5, 1, 5));

		// for (Lemonade l : order1.getLemonades()) {
		// 	System.out.println(l.getPrice());
		// }
		// System.out.println(order1.getCustomer().getName() + ", your total price is: $" + order1.getTotal() + "!");

		order2.addLemonade(new Lemonade(1, .5, 1, 5));
		order2.addLemonade(new Lemonade(2, .5, 1, 5));
		order2.addLemonade(new Lemonade(1, .5, 2, 5));
		order2.addLemonade(new Lemonade(.5, .5, 2, 5));

		// for (Lemonade l : order2.getLemonades()) {
		// 	System.out.println(l.getPrice());
		// }
		// System.out.println(order2.getCustomer().getName() + ", your total price is: $" + order2.getTotal() + "!");

		// System.out.println(order1.toString());
		// System.out.println(order1);
		// System.out.println(order1.equals(order1));

		Box<Order> b1 = new Box<Order>(order1);
		Box<Customer> b2 = new Box<>(customer2);

		b1.setObj(order2);
		
		// ((Order) b1.getObj()).addLemonade(new Lemonade(2,1.5,1.75,5));
		b1.getObj().addLemonade(new Lemonade(2,1.5,1.75,5));
		b2.setObj(customer1);

		// System.out.println(b1.getObj());
		// System.out.println(b2.getObj());
		// System.out.println(b2.getObj().getName());

		b2.<Customer, Order>printValue(customer1, order2);
		b2.printValue(customer1, order2);

		Box<Integer> b3 = new Box<Integer>(1);
	}
}
