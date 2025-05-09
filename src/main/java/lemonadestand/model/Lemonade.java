package lemonadestand.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Lemonade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -525484956057928472L;

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

	public Lemonade() {
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setLemonJuice(double lemonJuice) {
		this.lemonJuice = lemonJuice;
	}

	public void setWater(double water) {
		this.water = water;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setIceCube(int iceCube) {
		this.iceCube = iceCube;
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

	@JsonIgnore
	public int getCUP() {
		return CUP;
	}

	public double getPrice() {
		return price;
	}

	public int getIceCube() {
		return iceCube;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lemonJuice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(water);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sugar);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + CUP;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + iceCube;
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
		Lemonade other = (Lemonade) obj;
		if (Double.doubleToLongBits(lemonJuice) != Double.doubleToLongBits(other.lemonJuice))
			return false;
		if (Double.doubleToLongBits(water) != Double.doubleToLongBits(other.water))
			return false;
		if (Double.doubleToLongBits(sugar) != Double.doubleToLongBits(other.sugar))
			return false;
		if (CUP != other.CUP)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (iceCube != other.iceCube)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lemonade {lemonJuice=" + lemonJuice + ", water=" + water + ", sugar=" + sugar + ", CUP=" + CUP
				+ ", price=" + price + ", iceCube=" + iceCube + "}";
	}

}
