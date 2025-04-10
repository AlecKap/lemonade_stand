package lemonadestand.model;

import java.util.Arrays;

public class Order {
  private Customer customer;
  private Lemonade[] lemonades;
  private double total;

  public Order(Customer customer) {
    super();
    this.customer = customer;
    lemonades = new Lemonade[0];
    total = 0.0;
  }

  private void updateTotal() {
    total = 0.0; // confused on this part here?
    for (Lemonade l : lemonades) {
      total += l.getPrice();
    }
  }

  public void addLemonade(Lemonade lemonade) {
//    Lemonade[] temp = new Lemonade[lemonades.length + 1];
//    for (int i = 0; i < lemonades.length; i++) {
//      temp[i] = lemonades[i];
//    }
    Lemonade[] newLemonadeArray = Arrays.copyOf(lemonades, lemonades.length + 1); // creates a temp array. same as above.
    newLemonadeArray[newLemonadeArray.length - 1] = lemonade;
    lemonades = newLemonadeArray;
    updateTotal();
  }

  public Customer getCustomer() {
    return customer;
  }

  public Lemonade[] getLemonades() {
    return lemonades;
  }

  public double getTotal() {
    return total;
  }
}
