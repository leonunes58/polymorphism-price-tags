import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        List <Product> listProuct = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Product " + (i + 1) + " data: ");
            System.out.print("Common, used or imported (c/u/i): ");
            char typeProduct = sc.next().charAt(0);
            if(typeProduct == 'c') {
                Product product = createProductCommon(sc);
                listProuct.add(product);
            }
            else if(typeProduct == 'i') {
                Product product = createProductImported(sc);
                listProuct.add(product);
            }
            else {
                Product product = createProductUsed(sc);
                listProuct.add(product);
            }
        }
        writeProductList(listProuct);

        sc.close();

    }

    public static Product createProductCommon(Scanner sc) {
        System.out.print("Name: ");
        String nameProduct = sc.next();
        System.out.print("Price: ");
        double priceProduct = sc.nextDouble();
        return new Product(nameProduct, priceProduct);
    }
    public static Product createProductImported(Scanner sc) {
        System.out.print("Name: ");
        String nameProductImported = sc.next();
        System.out.print("Price: ");
        double priceProductImported = sc.nextDouble();
        System.out.print("Customs fee: ");
        double customsFee = sc.nextDouble();
        return new ImportedProduct(nameProductImported, priceProductImported, customsFee);
    }
    public static Product createProductUsed(Scanner sc) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Name: ");
        String nameProduct = sc.next();
        System.out.print("Price: ");
        double priceProduct = sc.nextDouble();
        System.out.print("Manufature date: ");
        Date manufactureDate = sdf.parse(sc.next());
        return new UsedProduct(nameProduct, priceProduct, manufactureDate);
    }

    public static void writeProductList(List<Product> listProduct) {
        System.out.print("\n");
        for (Product product : listProduct) {
            System.out.println(product.priceTag());
        }
    }
}