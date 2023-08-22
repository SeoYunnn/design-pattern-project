import login.LoginManager;
import login.LoginStrategy;
import login.User;
import login.UserLoginStrategy;

import java.util.ArrayList;
import java.util.Scanner;

public class PcSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LoginStrategy loginStrategy = new UserLoginStrategy();
        LoginManager loginManager = new LoginManager(loginStrategy);
        User user = null;

        boolean loggedIn = false;
        int maxLoginAttempts = 3;
        int loginAttempts = 0;

        while (!loggedIn && loginAttempts < maxLoginAttempts) {
            System.out.println("==========================");
            System.out.println("춘식PC에 오신것을 환영합니다");
            System.out.println("1. 회원 로그인");
            System.out.println("2. 비회원 로그인");
            System.out.println("0. 종료");
            System.out.println("==========================");
            int loginChoice = scanner.nextInt();
            scanner.nextLine();

            switch (loginChoice) {
                case 1:
                    user = loginManager.performLogin();
                    if (user == null) {
                        System.out.println("이름이나 비밀번호가 틀립니다. 다시 시도해주세요 ! \n");
                        loginAttempts++;
                    } else {
                        loggedIn = true;
                    }
                    break;
                case 0:
                    System.out.println("시스템을 종료합니다, 다음에 또 오세요 !");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요 !");
                    loginAttempts++;
                    break;
            }
        }

        if (!loggedIn) {
            return;
        }

        ArrayList<OrderItem> orderHistory = new ArrayList<>();
        runMenu(scanner, orderHistory);

        System.out.println("주문 내역:");
        for (OrderItem orderItem : orderHistory) {
            System.out.println("이름: " + orderItem.getName() + " - " + orderItem.getDescription() +
                    " (개수: " + orderItem.getQuantity() + "개) - $" + orderItem.getTotalCost());
        }

        System.out.println("주문이 완료되었습니다.\n");
    }

    public static void runMenu(Scanner scanner, ArrayList<OrderItem> orderHistory) {
        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 라면");
            System.out.println("2. 볶음밥");
            int menuChoice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            Food food = null;
            int quantity;

            switch (menuChoice) {
                case 1:
                    System.out.println("라면을 선택하세요:");
                    System.out.println("1. 기본 라면");
                    System.out.println("2. 치즈 라면");
                    System.out.println("3. 계란 라면");
                    int ramenChoice = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 처리
                    FoodFactory RamenFactory = new RamenFactory();


                    switch (ramenChoice) {
                        case 1:
                            food = RamenFactory.createFood();  // 기본 라면 선택
                            break;
                        case 2:
                            food = new CheeseTopping(RamenFactory.createFood());  // 치즈 라면 선택
                            break;
                        case 3:
                            food = new EggTopping(RamenFactory.createFood());  // 계란 라면 선택
                            break;
                        default:
                            System.out.println("잘못된 선택입니다. 다시 선택하세요 !");
                            continue;
                    }
                    break;


                case 2:
                    System.out.println("볶음밥을 선택하세요:");
                    System.out.println("1. 계란 볶음밥");
                    System.out.println("2. 김치 볶음밥");
                    System.out.println("3. 새우 볶음밥");
                    int friedRiceChoice = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 처리
                    FoodFactory FriedRiceFactory = new FriedRiceFactory();

                    switch (friedRiceChoice) {
                        case 1:
                            food = FriedRiceFactory.createFood();  // 계란 볶음밥 선택
                            break;
                        case 2:
                            food = new KimchiTopping(FriedRiceFactory.createFood());  // 김치 볶음밥 선택
                            break;
                        case 3:
                            food = new ShrimpTopping(FriedRiceFactory.createFood()); // 새우 볶음밥 선택
                            break;
                        default:
                            System.out.println("잘못된 선택입니다. 다시 선택하세요 !");
                            continue;
                    }
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요 !");
                    continue;
            }

            System.out.print("주문할 개수를 입력하세요: ");
            quantity = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            orderHistory.add(new OrderItem(food, quantity));

            System.out.print("추가 주문하시겠습니까? (y/n): ");
            String additionalOrder = scanner.nextLine();
            if (!additionalOrder.equalsIgnoreCase("y")) {
                continueOrdering = false;
            }
        }
    }
}