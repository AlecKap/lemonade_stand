package lemonadestand;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import lemonadestand.model.Customer;
import lemonadestand.model.Lemonade;
import lemonadestand.model.Order;

public class Application {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the LemonadeStand Application!");
		System.out.println("Provide your name and phone number to create an order");
		System.out.println("Let's start with your name:");

		String name = scanner.nextLine();
		
		System.out.println("Hi " + name + ", nice to meet you!");
		System.out.println("Next we need your number so we will be able to call you when your order is ready:");
		
		
		String phoneNumber = scanner.nextLine();

		System.out.println("Awesome, thank you! We recoreded your phone number as: " + phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3" ));
		System.out.println("Is that correct?");

		String validation = "".toUpperCase();

		do {
			if (validation.equals("N")) {
				System.out.println("Ok, no problem. Please re-enter your phone number:");
				phoneNumber = scanner.nextLine();
				System.out.println("Awesome, thank you! We recoreded your phone number as: " + phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3" ));
				System.out.println("Is that correct? (Y/N)");
			}
			System.out.println("Please enter Y or N.");
			validation = scanner.nextLine().toUpperCase();
		} while (!validation.equals("Y"));
		
		System.out.println("Great! Let's get started with your order.");

		Customer customer = new Customer(name, phoneNumber);
		Order order = new Order(customer);

		System.out.println("How many lemondaes do you want to order");

		for (int numOfLemonades = scanner.nextInt(), currentLemonade = 1; numOfLemonades > 0; numOfLemonades--, currentLemonade++) {
			System.out.println("How much lemon juice do you want for lemonade " + currentLemonade + "? (in cups)");			
			double lemonJuice = scanner.nextDouble();
			System.out.println("How much water do you want for lemonade " + currentLemonade + "? (in cups)");
			double water = scanner.nextDouble();
			System.out.println("How much sugar do you want for lemonade " + currentLemonade + "?? (in cups)");
			double sugar = scanner.nextDouble();
			System.out.println("How many ice cubes do you want for lemonade " + currentLemonade + "?? (in cups)");
			int iceCubes = scanner.nextInt();
			order.addLemonade(new Lemonade(lemonJuice, water, sugar, iceCubes));
		}

		File file = new File("./orders");
		
		File[] files = file.listFiles();

		FileOutputStream fileOutputStream = new FileOutputStream(file + "/order" + (files.length + 1) + ".txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		objectOutputStream.writeObject(order);

		System.out.println("Thank you, we have confirmed your order!");
		System.out.println("Your order total is $" + order.getTotal());
		System.out.println("Please be ready to pick up your order!");
	}
}
