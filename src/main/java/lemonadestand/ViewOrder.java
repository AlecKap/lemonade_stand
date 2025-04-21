package lemonadestand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lemonadestand.model.Order;

public class ViewOrder {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      File file = new File("./orders");
      System.out.println("Which order would you like to view?");

      int orderNum = 0;
      try {
        orderNum = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Please a number between 1 and 2 billion");
      }

      // try (FileInputStream fileInputStream = new FileInputStream(file + "/order" + orderNum + ".txt");
      //     ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
      //   Order order = (Order) objectInputStream.readObject();
      //   System.out.println(order.getLemonades());
      //   System.out.println("Total: $" + order.getTotal());
      // } catch (FileNotFoundException e) {
      //   System.out.println("Order with number " + orderNum + " does notexist");
      // } catch (IOException e) {
      //   System.out.println("Internal IOException");
      // } catch (ClassNotFoundException e) {
      //   System.out.println("Tried to read an order that isn't formatted correctly.");
      // } catch (ClassCastException e) {
      //   System.out.println("The file read does not contain and Order.");
      // }

      ObjectMapper objectMapper = new ObjectMapper();
      try {
        Order order = objectMapper.readValue(new File(file + "/order" + orderNum + ".json"), Order.class);
        System.out.println(order.getLemonades());
        System.out.println("Total: $" + order.getTotal());
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
