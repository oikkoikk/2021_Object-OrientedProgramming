package assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MartSimulation {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Mart.setTimeNow(LocalDateTime.of(2021, 5, 27, 15, 0));
        ArrayList<Customer> customerList = new ArrayList<Customer>();

        try {
            BufferedReader customReader = new BufferedReader(new FileReader("./CustomerWallets.txt"));
            BufferedReader martReader = new BufferedReader(new FileReader("./Mart.txt"));

            int customerSize = Integer.parseInt(customReader.readLine());
            int martSize = Integer.parseInt(martReader.readLine());
            for (int i = 0; i < customerSize; i++) {
                // [고객 이름, wallet의 가짓수]
                String[] customerInfo = customReader.readLine().split(", ");
                ArrayList<Payable> customerWallet = new ArrayList<Payable>();

                for (int j = 0; j < Integer.parseInt(customerInfo[1]); j++) {
                    String[] walletInfo = customReader.readLine().split(", ");
                    if (walletInfo[0].equals("Credit")) {
                        customerWallet.add(new Credit(walletInfo[1], Integer.parseInt(walletInfo[2]),
                                Integer.parseInt(walletInfo[3])));
                    } else {
                        customerWallet.add(new Cash(walletInfo[1], Integer.parseInt(walletInfo[2])));
                    }
                }
                customerList.add(new Customer(customerInfo[0], customerWallet));
            }
            for (int i = 0; i < martSize; i++) {
                String[] martInfo = martReader.readLine().split(", ");

                if (martInfo[0].equals("Food")) {
                    Mart.getInstance()
                            .addProduct(new Food(martInfo[1], Integer.parseInt(martInfo[2]),
                                    LocalDateTime.of(Integer.parseInt(martInfo[3]), Integer.parseInt(martInfo[4]),
                                            Integer.parseInt(martInfo[5]), Integer.parseInt(martInfo[6]),
                                            Integer.parseInt(martInfo[7])),
                                    Integer.parseInt(martInfo[8])));
                } else {
                    Mart.getInstance().addProduct(new Manufactured(martInfo[1], Integer.parseInt(martInfo[2]),
                            martInfo[3], Integer.parseInt(martInfo[4])));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0); // 파일 입출력에서 예외 생기면 그냥 프로그램 종료!
        }
        while (true) {
            int firstMenu = 0;

            while (true) {
                try {
                    firstMenu = printMainMenu();
                    break;
                } catch (InputMismatchException e) {
                    // int가 아닌 입력이 들어올 경우
                    System.out.println("Input mismatch");
                } catch (InvalidAccessException e) {
                    // 1,2,3이 아닌 숫자가 들어올 경우
                    System.out.println(e.getMessage());
                }
            }
            switch (firstMenu) {
                case 1:
                    managerMode();
                    break;
                case 2:
                    customerMode(customerList);
                    break;
                case 3:
                    return;
            }
        }
    }

    public static int printMainMenu() throws InputMismatchException, InvalidAccessException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("1) Manager Mode");
        System.out.println("2) Customer Mode");
        System.out.println("3) End Program");

        System.out.print("Select Menu: ");

        int firstMenu = keyboard.nextInt();
        if (1 > firstMenu || firstMenu > 3) {
            throw new InvalidAccessException();
        }

        return firstMenu;
    }

    public static int printProductList() {
        int pos = 0;

        for (Product product : Mart.getInstance().getSalesList()) {
            System.out.println(++pos + ". " + product);
        }
        // 총 product 개수 return!
        return pos;
    }

    public static int printCustomerList(ArrayList<Customer> customerList) {
        int pos = 0;

        for (Customer customer : customerList) {
            System.out.println(++pos + ". " + customer);
        }
        // 총 customer 인원 수 return!
        return pos;
    }

    public static void managerMode() {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            int menu = 0;

            while (true) {
                try {
                    System.out.println("1) Add Inventory");
                    System.out.println("2) Replace Expired");

                    System.out.print("Select Menu: ");
                    menu = keyboard.nextInt();
                    if (menu == 0)
                        return;
                    if (1 > menu || menu > 2)
                        throw new InvalidAccessException();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Input mismatch");
                    keyboard.nextLine();
                } catch (InvalidAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
            switch (menu) {
                case 1:
                    addInventory();
                    break;
                case 2:
                    replaceExpired();
                    break;
            }
        }
    }

    public static void customerMode(ArrayList<Customer> customerList) {
        Scanner keyboard = new Scanner(System.in);
        int totalCustomers = printCustomerList(customerList);
        int selectedCustomer = 0;
        // customer 선택
        while (true) {
            try {
                System.out.print("Select Customer: ");
                selectedCustomer = keyboard.nextInt();
                if (selectedCustomer == 0)
                    return;
                if (1 > selectedCustomer || selectedCustomer > totalCustomers)
                    throw new InvalidAccessException();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch");
                keyboard.nextLine();
            } catch (InvalidAccessException e) {
                System.out.println(e.getMessage());
            }
        }
        // customer mode 진입
        while (true) {
            int menu = 0;
            while (true) {
                System.out.println("1) Shopping");
                System.out.println("2) Print Shopping Cart");
                System.out.println("3) Paying");
                System.out.println("4) Print Wallet");
                System.out.print("Select Menu: ");
                try {
                    menu = keyboard.nextInt();
                    if (menu == 0)
                        return;
                    if (1 > menu || menu > 4)
                        throw new InvalidAccessException();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Input mismatch");
                    keyboard.nextLine();
                } catch (InvalidAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
            switch (menu) {
                case 1:
                    shopping(customerList.get(selectedCustomer - 1));
                    break;
                case 2:
                    printShoppingCart(customerList.get(selectedCustomer - 1));
                    break;
                case 3:
                    paying(customerList.get(selectedCustomer - 1));
                    break;
                case 4:
                    printWallet(customerList.get(selectedCustomer - 1));
                    break;
            }
        }

    }

    public static void addInventory() {
        Scanner keyboard = new Scanner(System.in);
        int totalProducts = printProductList();

        while (true) {
            int selectedProduct = 0;
            int productQuantity = 0;
            try {
                System.out.print("Select Product: ");
                selectedProduct = keyboard.nextInt();
                if (selectedProduct == 0) {
                    return;
                }
                if (1 > selectedProduct || selectedProduct > totalProducts)
                    throw new InvalidAccessException();
                System.out.print("Enter quantity: ");
                productQuantity = keyboard.nextInt();
                Mart.getInstance().addInventory(selectedProduct, productQuantity);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch");
                keyboard.nextLine();
            } catch (InvalidAccessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void replaceExpired() {
        Scanner keyboard = new Scanner(System.in);
        int pos = 0; // 목록 출력을 위한 indexing
        int idx = 0; // 유통기한을 변경해야할 상품을 체크하기 위한 indexing
        ArrayList<Integer> replacableProduct = new ArrayList<Integer>();

        for (Product product : Mart.getInstance().getSalesList()) {
            if (product.getClass() == Food.class) {
                Food temp = (Food) product;
                if (temp.isExpired(Mart.getTimeNow())) {
                    // 만약 식품 중에서 유통기한이 지난 상품이 있다면 출력
                    System.out.println(++pos + ". " + product);
                    replacableProduct.add(idx);
                }
            }
            ++idx;
        }

        if (replacableProduct.size() == 0) {
            System.out.println("There are no expired products.");
            return;
        }

        String[] additionalEXP;
        while (true) {
            try {
                System.out.println("Enter additional EXP");
                System.out.println("format: years, months, days");
                System.out.println("ex) 0, 2, 4  =>  extending 0 year 2 months 4 days");
                System.out.print(": ");
                additionalEXP = keyboard.nextLine().split(", ");
                if (additionalEXP.length != 3)
                    throw new Exception("Wrong format");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch");
                keyboard.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            for (int i : replacableProduct) {
                Food temp = (Food) Mart.getInstance().getSalesList().get(i);
                temp.setExpirationDateTime(
                        temp.getExpirationDateTime().plus(Period.of(Integer.parseInt(additionalEXP[0]),
                                Integer.parseInt(additionalEXP[1]), Integer.parseInt(additionalEXP[2]))));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void shopping(Customer customer) {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            int totalProducts = printProductList();
            int selectedProduct = 0;
            int selectedQuantity = 0;

            try {
                System.out.print("Select Product: ");
                selectedProduct = keyboard.nextInt();
                if (selectedProduct == 0)
                    return;
                if (1 > selectedProduct || selectedProduct > totalProducts)
                    throw new InvalidAccessException();
                System.out.print("Select Quantity: ");
                selectedQuantity = keyboard.nextInt();
                customer.addToCart(selectedProduct, selectedQuantity);
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch");
                keyboard.nextLine();
            } catch (InvalidAccessException e) {
                System.out.println(e.getMessage());
            } catch (ExpiredException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int printShoppingCart(Customer customer) {
        System.out.println(Mart.getTimeNow());
        System.out.printf("%-12s %11s %9s %11s\n","Product name", "Unit price", "Quantity", "Amount");
        System.out.println("-".repeat(46));

        int totalPrice = 0;

        for (Product product : customer.getShoppingCart()) {

            System.out.printf("%-12s %11s %9s %11s\n", product.getName(), product.getPrice(), product.getQuantity(),
                    product.getPrice() * product.getQuantity());
            totalPrice += product.getPrice() * product.getQuantity();
        }
        System.out.println("-".repeat(46));

        return totalPrice;
    }

    public static void paying(Customer customer) {
        Scanner keyboard = new Scanner(System.in);
        int selectedPayment = 0;

        int totalPrice = printShoppingCart(customer);
        System.out.printf("%s %34s\n", "Total price", totalPrice);
        System.out.println("-".repeat(46));
        int totalPayments = printWallet(customer);
        while (true) {
            try {
                System.out.print("Select payment method: ");
                selectedPayment = keyboard.nextInt();
                // 0 누르면 결제 취소
                if (selectedPayment == 0)
                    return;
                if (1 > selectedPayment || selectedPayment > totalPayments)
                    throw new InvalidAccessException();
                customer.requestPay(selectedPayment, totalPrice);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch");
                keyboard.nextLine();
            } catch (InvalidAccessException e) {
                System.out.println(e.getMessage());
            } catch (NotEnoughBalanceException e) {
                System.out.println(e.getMessage());
            }
        }
        printReceipt(customer, selectedPayment);
        // 주문번호 증가
        Mart.transactionNum++;
        customer.clearCart();
    }

    public static int printWallet(Customer customer) {
        int pos = 0;

        for (Payable payable : customer.getWallet()) {
            System.out.println(++pos + ". " + payable);
        }

        return pos;
    }

    public static void printReceipt(Customer customer, int paymentIdx) {
        Payable payment = customer.getWallet().get(paymentIdx - 1);

        try {
            PrintWriter receiptWriter = new PrintWriter("Receipt" + Mart.transactionNum + ".txt");
            int totalPrice = 0;

            receiptWriter.println(Mart.getTimeNow().toString());
            receiptWriter.printf("%-12s %11s %9s %11s\n","Product name", "Unit price", "Quantity", "Amount");
            receiptWriter.println("-".repeat(46));

            for (Product product : customer.getShoppingCart()) {

                receiptWriter.printf("%-12s %11s %9s %11s\n", product.getName(), product.getPrice(),
                        product.getQuantity(), product.getPrice() * product.getQuantity());
                totalPrice += product.getPrice() * product.getQuantity();
            }
            receiptWriter.println("-".repeat(46));
            receiptWriter.printf("%s %34s\n", "Total price", totalPrice);
            receiptWriter.println("-".repeat(46));
            if (payment.getClass() == Credit.class) {
                Credit temp = (Credit) payment;
                receiptWriter.println("Credit, " + temp.getBank());
            } else {
                Cash temp = (Cash) payment;
                receiptWriter.println("Cash, " + temp.getCurrency());
            }
            receiptWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0); // 파일 입출력에서 예외 생기면 그냥 프로그램 종료!
        }

    }
}
