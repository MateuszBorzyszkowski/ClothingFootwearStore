package com.mateusz;

import com.mateusz.api.ProductFacade;
import com.mateusz.api.ProductService;
import com.mateusz.api.UserRegisterLoginFacade;
import com.mateusz.enums.Color;
import com.mateusz.enums.Material;
import com.mateusz.enums.SkinType;
import com.mateusz.facade.ProductFacadeImpl;
import com.mateusz.facade.UserRegisterLoginFacadeImpl;
import com.mateusz.model.Boots;
import com.mateusz.model.Cloth;
import com.mateusz.model.Product;
import com.mateusz.model.User;
import com.mateusz.model.parser.ColorParser;
import com.mateusz.model.parser.MaterialParser;
import com.mateusz.model.parser.SkinParser;
import com.mateusz.service.ProductServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void startMenu() {
        System.out.println("App Menu");
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.println("0. Exit");
    }

    public static void loggedMenu() {
        System.out.println("App Menu");
        System.out.println("1. Add new product");
        System.out.println("2. Remove product");
        System.out.println("3. Show all products");
        System.out.println("0. Log out");
    }

    public static void productTypeMenu() {
        System.out.println("1. Add boots");
        System.out.println("2. Add cloths");
        System.out.println("3. Other");
    }

    public static Product createOtherProduct() {
        String productName;
        Color color;
        float price, weight;
        int count;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Choose color: RED, BLUE, GREEN, BLACK, WHITE, YELLOW ");
        color = ColorParser.parserStringToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        return new Product(1, productName, price, weight, color, count);
    }

    public static Product createBootsProduct() {
        String productName;
        Color color;
        float price, weight;
        int count, size;
        SkinType skinType;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Choose color: RED, BLUE, GREEN, BLACK, WHITE, YELLOW ");
        color = ColorParser.parserStringToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.nextInt();

        System.out.println("Choose skin type: NATURAL, ARTIFICIAL ");
        skinType = SkinParser.parserStringToSkin(scanner.next());


        return new Boots(1, productName, price, weight, color, count, size, skinType);
    }

    public static Product createClothProduct() {
        String productName, size;
        Color color;
        Material material;
        float price, weight;
        int count;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Choose color: RED, BLUE, GREEN, BLACK, WHITE, YELLOW ");
        color = ColorParser.parserStringToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.next();

        System.out.println("Choose material: LEATHER, FUR, COTTON, WOOL, POLYESTERS.");
        material = MaterialParser.parserStringToMaterial(scanner.next());


        return new Cloth(1, productName, price, weight, color, count, size, material);
    }

    public static void main(String[] args) {
        UserRegisterLoginFacade userFacade = UserRegisterLoginFacadeImpl.getInstance();
        ProductFacade productFacade = ProductFacadeImpl.getInstance();
        ProductService productService = ProductServiceImpl.getInstance();
        boolean appOn = true;
        boolean loggedOn = false;
        int optionRead;

        while (appOn) {
            startMenu();
            optionRead = scanner.nextInt();

            switch (optionRead) {
                case 1:
                    System.out.print("Type login: ");
                    String loginLog = scanner.next();
                    System.out.print("Type password: ");
                    String passwordLog = scanner.next();
                    if (userFacade.loginUser(loginLog, passwordLog)) {
                        loggedOn = true;
                        System.out.println("Success! You login!");
                    } else {
                        System.out.println("Invalid login!");
                    }
                    break;
                case 2:
                    System.out.print("Type login: ");
                    String loginReg = scanner.next();
                    System.out.print("Type password: ");
                    String passwordReg = scanner.next();
                    User user = new User(1, loginReg, passwordReg);
                    userFacade.registerUser(user);
                    break;
                case 0:
                    appOn = false;
                    break;
            }

            while (loggedOn) {
                loggedMenu();
                optionRead = scanner.nextInt();

                switch (optionRead) {
                    case 1:
                        productTypeMenu();
                        optionRead = scanner.nextInt();
                        Product product = null;
                        switch (optionRead) {
                            case 1:
                                product = createBootsProduct();
                                break;
                            case 2:
                                product = createClothProduct();
                                break;
                            case 3:
                                product = createOtherProduct();
                                break;
                        }
                        System.out.println(productFacade.createProduct(product));
                        break;
                    case 2:
                        System.out.println("Available products: " + productFacade.getAllProducts());
                        System.out.println("Type name of product to delete: ");
                        String productToDelete = scanner.next();
                        System.out.println(productFacade.removeProduct(productToDelete));
                        break;
                    case 3:
                        System.out.println("Available products: " + productFacade.getAllProducts());
                        break;
                    case 0:
                        loggedOn = false;
                        break;
                }
            }
        }
    }
}
