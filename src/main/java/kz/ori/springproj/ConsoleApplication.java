package kz.ori.springproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command (add, remove, show, exit):");
            command = scanner.nextLine();

            if ("exit".equalsIgnoreCase(command)) {
                break;
            }

            Cart cart = context.getBean(Cart.class);

            switch (command.toLowerCase()) {
                case "add":
                    System.out.println("Enter product id to add:");
                    Long addId = scanner.nextLong();
                    cart.addProduct(addId);
                    scanner.nextLine();
                    break;
                case "remove":
                    System.out.println("Enter product id to remove:");
                    Long removeId = scanner.nextLong();
                    cart.removeProduct(removeId);
                    scanner.nextLine();
                    break;
                case "show":
                    System.out.println(cart);
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }

        scanner.close();
    }
}

