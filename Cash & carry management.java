import java.util.*;
import java.io.*;

public class L {
    static String id = "Nouman";
    static String password = "khalid";

    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~ Programing Fundamental ~~~~~~~~~~~~~~~~~~~~~~~~");
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Cash and Carry Managment System ~~~~~~~~~~~~~~~~~~~~");
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Main Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\t1- Customer");
                System.out.println("\t\t2- Administration");
                System.out.println("\t\t3- TO display Menu");
                System.out.println("\t\t4- To Exit");
                System.out.print("\t\tEnter your choice between 1 and 4: ");
                int choice = input.nextInt();
                System.out.println();
                if (choice == 1) {
                    customer();
                    System.out.println("\t\t\t                                      /. / \t\t");
                    System.out.println("\t\t\t    Thanks For Shopping!!            /. / \t\t");
                    System.out.println("\t\t\t \\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/._/ \t\t");
                    System.out.println("\t\t\t  \\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/   \t\t");
                    System.out.println("\t\t\t   \\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/   \t\t");
                    System.out.println("\t\t\t    \\~~~~~~~~~~~~~~~~~~~~~~~~~~~/   \t\t");
                    System.out.println("\t\t\t     \\~~~~~~~~~~~~~~~~~~~~~~~~~/   \t\t");
                    System.out.println("\t\t\t      \\_______________________/   \t\t");
                    System.out.println("\t\t\t                          | | \t\t");
                    System.out.println("\t\t\t      |~~~~~~~~~~~~~~~~~~~~~~|   \t\t");
                    System.out.println("\t\t\t       |______________________|   \t\t");
                    System.out.println("\t\t\t         /``\\          /``\\       \t\t");
                    System.out.println("\t\t\t         \\__/          \\__/       \t\t");
                } else if (choice == 2) {
                    security();
                } else if (choice == 3) {
                    displayMenu();
                } else if (choice == 4) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ Program Ended ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                } else
                    System.out.println("\t\tWrong input. Try again.");
            } catch (Exception ex) {
                System.out.println("\t\tWrong input. Enter Again.");
            }
        }
    }

    public static void security() {
        try {
            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.print("\t\tEnter ID: ");
                String x = input.nextLine();
                System.out.print("\t\tEnter Password: ");
                String y = input.nextLine();

                if (x.matches(id) && y.matches(password)) {
                    administration();
                    break;
                } else if (x.matches(id) && !y.matches(password)) {
                    System.out.println("\t\tWrong Password. Enter Again.");
                } else if (!x.matches(id) && y.matches(password)) {
                    System.out.println("\t\tWrong ID. Enter Again.");
                } else {
                    System.out.println("\t\tWrong Id and Password. Enter Again.");
                }
            }
        } catch (Exception ex) {
            security();
        }

    }

    public static void administration() {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~ Administration ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\tEnter 1- To Modify Products.");
                System.out.println("\t\tEnter 2- To Check Sale.");
                System.out.println("\t\tEnter 3- To change ID or Password.");
                System.out.println("\t\tEnter 4- To Display Stoke.");
                System.out.println("\t\tEnter 5- To Go to Main Menu.");
                System.out.printf("\t\tEnter what you want to do: ");
                int choice = input.nextInt();
                if (choice == 1) {
                    modify();
                } else if (choice == 2) {
                    sales();
                } else if (choice == 3) {
                    input = new Scanner(System.in);
                    System.out.print("\t\tEnter New ID: ");
                    String newID = input.nextLine();
                    String newPass;
                    while (true) {
                        input = new Scanner(System.in);
                        System.out.print("\t\tEnter New Password: ");
                        newPass = input.nextLine();
                        if (newPass.matches(password))
                            System.out.println("\t\tNew password cannot be same as previous one.");
                        else {
                            System.out.println("\t\tPassword updated. Successfully.");
                            break;
                        }
                    }
                    id = newID;
                    password = newPass;
                } else if (choice == 4) {
                    displayMenu();
                } else if (choice == 5) {
                    break;
                } else
                    System.out.println("\t\tWrong input. Enter Again.");

            } catch (Exception ex) {
                System.out.println("\t\tWrong input. Enter Again.");
            }
        }

    }

    public static void sales() {
        while (true) {
            try {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Sale ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                Scanner input = new Scanner(System.in);
                System.out.println("\t\tEnter 1- to check Daily sale: ");
                System.out.println("\t\tEnter 2- to check monthly sale: ");
                System.out.println("\t\tEnter 0- to go back: ");
                System.out.print("\t\tWhat you want to do: ");
                int choice = input.nextInt();
                if (choice == 1) {
                    daily();
                } else if (choice == 2) {
                    monthly();
                } else if (choice == 0) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println("\t\tInvalid input. Try Again.");
            }
        }
    }

    public static void daily() {
        try {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Daily Sale ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            File path = new File("C:\\Users\\Nouman\\Downloads\\Data (3).csv");
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int rows = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                rows++;
            }
            reader.close();

            reader = new BufferedReader(new FileReader(path));

            int i = 0;
            String[][] content = new String[rows][6];
            while ((line = reader.readLine()) != null) {
                content[i] = line.split(",");
                i++;
            }
            reader.close();

            int date, month, year;
            while (true) {
                try {
                    Scanner input = new Scanner(System.in);
                    input = new Scanner(System.in);
                    System.out.print("\t\tEnter date: ");
                    date = input.nextInt();
                    System.out.print("\t\tEnter Month: ");
                    month = input.nextInt();
                    System.out.print("\t\tEnter year: ");
                    year = input.nextInt();
                    if (checkDate(date, month, year)) {
                        break;
                    } else
                        System.out.println("\t\tWrong Date format. Enter Again");
                } catch (Exception ex) {
                    System.out.println("\t\tWrong date fomat. Integer type only.");
                }
            }
            long totalSale = 0;
            for (i = 0; i < rows; i++) {
                if (content[i][4].matches(String.valueOf(year))) {
                    if (content[i][3].matches(String.valueOf(month))) {
                        if (content[i][2].matches(String.valueOf(date))) {
                            totalSale = totalSale + Integer.parseInt(content[i][5]);
                        }
                    }
                }
            }
            System.out
                    .println("\t\tTotal Daily sale on " + date + "-" + month + "-" + year + " is " + totalSale + "Rs");
            System.out.println();
        } catch (Exception ex) {
            System.out.println("\t\tInvalid input. Try Again." + ex.getMessage());
        }
    }

    public static void monthly() {
        try {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~ Monthly Sale ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            File path = new File("C:\\Users\\Nouman\\Downloads\\Project.csv");
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int rows = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                rows++;
            }
            reader.close();

            reader = new BufferedReader(new FileReader(path));

            int i = 0;
            String[][] content = new String[rows][6];
            while ((line = reader.readLine()) != null) {
                content[i] = line.split(",");
                i++;
            }
            reader.close();
            int date = 1;
            int month, year;
            while (true) {
                try {
                    Scanner input = new Scanner(System.in);
                    input = new Scanner(System.in);
                    System.out.print("\t\tEnter Month: ");
                    month = input.nextInt();
                    System.out.print("\t\tEnter year: ");
                    year = input.nextInt();
                    if (checkDate(date, month, year)) {
                        break;
                    } else
                        System.out.println("\t\tWrong Date format. Enter Again");
                } catch (Exception ex) {
                    System.out.println("\t\tWrong date fomat. Integer type only.");
                }
            }
            long totalSale = 0;
            for (i = 0; i < rows; i++) {
                if (content[i][4].matches(String.valueOf(year))) {
                    if (content[i][3].matches(String.valueOf(month))) {
                        totalSale = totalSale + Integer.parseInt(content[i][5]);
                    }
                }
            }
            System.out.println("\t\tTotal monthly sale on " + month + "-" + year + " is " + totalSale + "Rs");
            System.out.println();
        } catch (Exception ex) {
            System.out.println("\t\tInvalid input. Try Again." + ex.getMessage());
        }
    }

    public static void customer() {
        Scanner input = new Scanner(System.in);
        String cnic;

        try {
            System.out.print("\t\tEnter your name: ");
            String name = input.nextLine();

            String phone;
            while (true) {
                System.out.print("\t\tEnter your phone number (without dash): +92");
                phone = input.nextLine();
                if (phone.matches("\\d{10}")) {
                    if (phone.charAt(0) == '3') {
                        break;
                    } else {
                        System.out.println("\t\tInvalid phone number.");
                    }
                } else {
                    System.out.println("\t\tInvalid phone number.");
                }
            }

            while (true) {
                System.out.print("\t\tEnter your CNIC (xxxxx-xxxxxxx-x): ");
                cnic = input.nextLine();
                if (cnic.matches("\\d{5}-\\d{7}-\\d{1}")) {
                    break;
                } else {
                    System.out.println("\t\tInvalid CNIC. Try again");
                }
            }
            int date, month, year;
            while (true) {
                try {
                    input = new Scanner(System.in);
                    System.out.print("\t\tEnter date: ");
                    date = input.nextInt();
                    System.out.print("\t\tEnter Month: ");
                    month = input.nextInt();
                    System.out.print("\t\tEnter year: ");
                    year = input.nextInt();
                    if (checkDate(date, month, year)) {
                        break;
                    } else
                        System.out.println("\t\tWrong Date format. Enter Again");
                } catch (Exception ex) {
                    System.out.println("\t\tWrong date fomat. Integer type only.");
                }
            }
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~ Welcome To Our Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~");

            File path = new File("C:\\Users\\Nouman\\Downloads\\Project.csv");
            Scanner read = new Scanner(path);
            int row = 0;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                row++;
            }
            String[] content = new String[row];

            int menuSize = 0;

            read = new Scanner(path);

            int productNumber = 0;

            while (read.hasNextLine()) {
                String line = read.nextLine();
                content[menuSize] = line;
                menuSize++;

                String[] itemData = line.split(",");

                for (int i = 0; i < itemData.length; i++) {
                    System.out.printf("\t%-16s", itemData[i]);
                }
                System.out.println();

                productNumber++;
            }

            long bill = 0;

            String[][] purchasedProducts = new String[row][3];
            int purchasedProductsCount = 0;

            while (true) {
                try {
                    System.out.print("\t\tEnter product number and 0 to exit: ");
                    int x = input.nextInt();
                    if (x == 0) {
                        break;
                    } else {
                        if (x < 1 || x >= productNumber) {
                            System.out.println("\t\tInvalid product number.");
                            continue;
                        }
                        String[] selectedProduct = content[x].split(",");
                        System.out.println("\t\tProduct Name is: " + selectedProduct[1]);
                        if (isOutOfStock(selectedProduct)) {
                            System.out.println("\t\tOut of Stock");
                            continue;
                        }
                        while (true) {
                            System.out.print("\t\tEnter total number of quantities you want: ");
                            int y = input.nextInt();
                            if (y > Integer.parseInt(selectedProduct[3]))

                            {
                                System.out.println("\t\tWe don't have that much in stock.");
                            } else if (y < 1) {
                                System.out.println("\t\tInvalid quantity.");
                            } else {
                                int price = Integer.parseInt(selectedProduct[2]);
                                bill = bill + (price * y);

                                String[] purchasedProduct = new String[3];
                                purchasedProduct[0] = selectedProduct[1];
                                purchasedProduct[1] = String.valueOf(y);
                                purchasedProduct[2] = selectedProduct[2];

                                purchasedProducts[purchasedProductsCount] = purchasedProduct;
                                purchasedProductsCount++;

                                int availableQuantity = Integer.parseInt(selectedProduct[3]);
                                int updatedQuantity = availableQuantity - y;
                                selectedProduct[3] = String.valueOf(updatedQuantity);

                                content[x] = String.join(",", selectedProduct);

                                break;
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("\t\tInvalid choice. Try again.");
                    input.next();
                }
            }

            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Order Details ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\tName: " + name);
            System.out.println("\t\tPhone: +92" + phone);
            System.out.println("\t\tCNIC: " + cnic);

            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~ Purchased Products ~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (int i = 0; i < purchasedProductsCount; i++) {
                String[] productData = purchasedProducts[i];
                System.out.println("\t\tProduct Name: " + productData[0]);
                System.out.println("\t\tQuantity: " + productData[1]);
                System.out.println("\t\tPrice per unit: " + productData[2]);
            }

            // Calculate GST
            double gstAmount = bill * 0.17;
            double totalBillWithGST = bill + gstAmount;

            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Total Bill ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Total bill: " + bill);
            System.out.println("GST (17%): " + gstAmount);
            System.out.println("Total bill (including GST): " + totalBillWithGST);
            // Payment logic
            boolean paymentCompleted = false;
            while (!paymentCompleted) {
                try {
                    System.out.print("\t\tPress 1 for Visa card or 2 for cash payment: ");
                    int payment = input.nextInt();
                    if (payment == 1) {

                        boolean validCardEntered = false;

                        while (!validCardEntered) {
                            Scanner in = new Scanner(System.in);
                            System.out.print("\t\tEnter your 16-digit visa card number (xxxx-xxxx-xxxx-xxxx): ");
                            String card = in.nextLine();

                            if (card.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")) {
                                while (true) {
                                    System.out.print("\t\tEnter your 4-digit PIN: ");
                                    String pass = in.nextLine();

                                    if (pass.matches("\\d{4}")) {
                                        System.out.println("\t\tPayment completed.");
                                        transfer(name, cnic, date, month, year, bill);
                                        validCardEntered = true;
                                        paymentCompleted = true;
                                        break;
                                    } else {
                                        System.out.println("\t\tWrong password. Enter again.");
                                    }
                                }
                            } else {
                                System.out.println("\t\tWrong visa card format.");

                            }
                        }
                    } else if (payment == 2) {
                        System.out.print("\t\tEnter total cash given: ");
                        if (input.hasNextDouble()) {
                            double cashGiven = input.nextDouble();
                            System.out.println("\t\tCash Deposit is: " + cashGiven);
                            System.out.println("\t\tTotal bill is: " + bill);
                            System.out.println("\t\tRemaining Amount: " + (totalBillWithGST - cashGiven));
                            System.out.println("\t\tPayment completed");
                            transfer(name, cnic, date, month, year, bill);
                            break;
                        } else {
                            System.out.println("\t\tInvalid input. Please enter a valid cash amount.");
                            input.next();
                        }
                    } else {
                        System.out.println("\t\tInvalid choice. Try again.");
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("\t\tInvalid choice. Try again.");
                    input.next();
                }
            }

            try {
                FileWriter writer = new FileWriter(path);
                for (int i = 0; i < content.length; i++) {
                    writer.write(content[i] + "\n");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("\t\tAn error occurred while updating the file: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("\t\tAn error occurred: " + e.getMessage());
        }

    }

    public static void displayMenu() {
        try {
            File path = new File("C:\\Users\\Nouman\\Downloads\\Project.csv");
            Scanner read = new Scanner(path);

            while (read.hasNextLine()) {
                String[] line = read.nextLine().split(",");
                for (String k : line)
                    System.out.printf("\t%-16s", k);
                System.out.println();
            }
            read.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void modify() {
        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~ Modify Products ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\tEnter 1- To Add New Products.");
                System.out.println("\t\tEnter 2- To Delete Products.");
                System.out.println("\t\tEnter 3- To Change in Existing Products.");
                System.out.println("\t\tEnter 4- To Go back to Administration.");
                System.out.printf("\t\tWhat do you want to do: ");
                int choice = in.nextInt();
                if (choice == 1) {
                    addProduct();
                } else if (choice == 2) {
                    deleteProduct();
                } else if (choice == 3) {
                    changeProduct();
                } else if (choice == 4) {
                    administration();
                    break;
                } else {
                    System.out.println("\t\tinvalid Input.");
                }
            } catch (Exception ex) {
                System.out.println("\t\tWrong input. Enter Again");
                modify();
            }
        }
    }

    public static void addProduct() {
        try {
            Scanner in = new Scanner(System.in);
            File path = new File("C:\\Users\\Nouman\\Downloads\\Project.csv");
            Scanner read = new Scanner(path);
            String[] line = read.nextLine().split(",");
            System.out.println("\t\tEnter new values according to the given column seperated by a comma:");
            for (String k : line)
                System.out.printf("\t\t%-15s", k);
            System.out.println();
            System.out.print("\t\t");
            String addition = in.nextLine();
            String[] value = addition.split(",");
            boolean productExist = false;
            while (read.hasNextLine()) {
                String[] rowData = read.nextLine().split(",");
                if (rowData[0].equals(value[0])) {
                    productExist = true;
                    break;
                }
            }
            if (productExist) {
                System.out.println("\t\tProduct Number already exist. Enter another.");
                addProduct();
            } else {
                BufferedWriter write = new BufferedWriter(new FileWriter(path, true));
                write.write(addition);
                write.newLine();
                write.close();
                System.out.println("\t\tProduct Added Successfully.");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            addProduct();
        }
    }

    public static void deleteProduct() {
        try {
            File path = new File("C:\\Users\\Nouman\\Downloads\\Project.csv");
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int rows = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                rows++;
            }
            reader.close();

            reader = new BufferedReader(new FileReader(path));

            int i = 0;
            String[][] content = new String[rows][4];
            while ((line = reader.readLine()) != null) {
                content[i] = line.split(",");
                i++;
            }
            reader.close();

            for (i = 0; i < content.length; i++) {
                for (int j = 0; j < content[i].length; j++) {
                    System.out.printf("\t%-16s", content[i][j]);
                }
                System.out.println();
            }
            while (true) {
                try {
                    System.out.print("\t\tEnter product number you want to delete: ");
                    Scanner in = new Scanner(System.in);
                    int delNum = in.nextInt();
                    BufferedWriter writer = new BufferedWriter(new FileWriter(path));
                    for (i = 0; i < content.length; i++) {
                        if (content[i][0].equals(String.valueOf(delNum))) {
                            continue;
                        }
                        for (int j = 0; j < content[i].length; j++) {
                            writer.write(content[i][j] + ",");
                        }
                        writer.newLine();
                    }
                    System.out.println("\t\tProduct deleted successfully.");
                    writer.close();
                    break;
                } catch (Exception ex) {
                    System.out.println("\t\tWrong Product Number. Try Again.");

                }
            }
        } catch (Exception ex) {
            System.out.println("\t\tWrong input. Try Again.");
            deleteProduct();
        }
    }

    public static void changeProduct() {
        try {
            String path = "C:\\Users\\Nouman\\Downloads\\Data (3).csv";
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int rows = 0, columns = 0;
            String line;
            while ((line = reader.readLine()) != null)
                rows++;
            reader.close();
            reader = new BufferedReader(new FileReader(path));
            String firstLine;
            if ((firstLine = reader.readLine()) != null)
                columns = firstLine.split(",").length;
            reader.close();

            reader = new BufferedReader(new FileReader(path));
            String[][] content = new String[rows][columns];
            int i = 0;
            while ((line = reader.readLine()) != null) {
                content[i] = line.split(",");
                i++;
            }

            for (int j = 0; j < content.length; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.printf("\t\t%-15s", content[j][k]);
                }
                System.out.println();
            }
            Scanner input = new Scanner(System.in);
            System.out.print("\t\tEnter product number you want to change: ");
            int editRow = input.nextInt();
            int x = 0;

            while ((line = reader.readLine()) != null) {
                content[x] = line.split(",");
                x++;
            }
            reader.close();

            for (i = 0; i < content.length; i++) {
                if (content[i][0].equals(String.valueOf(editRow))) {
                    break;
                }
            }
            int rowNum = i;

            for (int j = 0; j < content[0].length; j++)
                System.out.println("\t\t" + (j + 1) + ": " + content[0][j] + "  ");

            System.out.println();

            System.out.print("\t\tWhich column do you want to edit: ");
            int editCol = input.nextInt() - 1;

            System.out.println("\t\tOld " + content[0][editCol] + " is: " + content[rowNum][editCol]);
            System.out.print("\t\tEnter new " + content[0][editCol] + ": ");
            input = new Scanner(System.in);
            String newValue = input.nextLine();
            content[rowNum][editCol] = newValue;

            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            for (int j = 0; j < content.length; j++) {
                for (int k = 0; k < content[0].length; k++) {
                    writer.write(content[j][k] + ",");
                }
                writer.newLine();
            }
            writer.close();
            System.out.println(
                    "\t\tSuccessfully Changed.\n\t\tEnter 0 to edit again.\n\t\tEnter any other key to go back. ");
            System.out.print("\t\t");
            String choice = input.next();
            if (choice.equals("0"))
                changeProduct();
            else
                modify();

        } catch (Exception ex) {
            System.out.println("\t\tInvalid input. Enter again.");
            System.out.println("\t\t" + ex.getMessage());
        }
    }

    private static boolean isOutOfStock(String[] productData) {
        int quantity = Integer.parseInt(productData[3]);
        return quantity == 0;
    }

    public static boolean checkDate(int day, int month, int year) {
        int maxdays;
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                maxdays = 29;
            else
                maxdays = 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11)
            maxdays = 30;
        else
            maxdays = 31;

        if ((day >= 1 && day <= maxdays) && (month >= 1 && month <= 12) && (year > 1))
            return true;
        else
            return false;
    }

    public static void transfer(String name, String cnic, int date, int month, int year, long bill) {
        try {
            String path = ("C:\\Users\\Nouman\\Downloads\\Project.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write(name + "," + cnic + "," + date + "," + month + "," + year + "," + bill);
            writer.newLine();
            writer.close();
        } catch (Exception ex) {
            System.out.println("\t\t Error occured.");
        }

    }

}
