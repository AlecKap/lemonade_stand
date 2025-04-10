package lemonadestand.model;

public class Lemonade {

  private double lemonJuice;
  private double water;
  private double sugar;
  private final int CUP = 1;
  private double price;
  private int iceCube;

  public Lemonade(double lemonJuice, double water, double sugar, int iceCube) {
    super();
    this.lemonJuice = lemonJuice;
    this.water = water;
    this.sugar = sugar;
    this.iceCube = iceCube;
    calculatePrice();
  }

  private void calculatePrice() {
    price = (lemonJuice * .3) + (sugar * .15) + (CUP * .5);
  }

  public double getLemonJuice() {
    return lemonJuice;
  }

  public double getWater() {
    return water;
  }

  public double getSugar() {
    return sugar;
  }

  public int getCUP() {
    return CUP;
  }

  public double getPrice() {
    return price;
  }

  public int getIceCube() {
    return iceCube;
  }
}
