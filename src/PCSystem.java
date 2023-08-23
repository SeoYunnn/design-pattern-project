import login.LoginManager;
import login.LoginStrategy;
import login.User;
import login.UserLoginStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;


public final class PCSystem {
    public static void main(String[] args) throws IOException {
        // BufferReader 를 사용해 사용자의 입력을 받음
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 로그인 전략과 매니저를 생성
        // LoginStrategy 인터페이스를 구현한 UserLoginStrategy 객체를 생성함, 사용자 로그인의 전략을 나타냄
        LoginStrategy loginStrategy = new UserLoginStrategy();

        // 위에서 생성한 UserLoginStrategy 객체를 사용해 LoginManger 객체를 생성함, 로그인을 관리하는 클래스
        LoginManager loginManager = new LoginManager(loginStrategy);

        // 로그인 여부를 판단하는 변수들을 초기화
        // 사용자 로그인 여부를 isLoggedIn 을 false 로 초기화, 초기에는 로그인 되지 않은 상태로 설정
        boolean isLoggedIn = false;
        int maxLoginAttempts = 3;
        int loginAttempts = 0;

        while (!isLoggedIn && loginAttempts < maxLoginAttempts) {
            // 사용자에게 로그인 옵션을 제공
            System.out.println("==========================");
            System.out.println("춘식PC에 오신것을 환영합니다");
            System.out.println("1. 회원 로그인");
            System.out.println("2. 비회원 로그인");
            System.out.println("0. 종료");
            System.out.println("==========================");
            int loginChoice = Integer.parseInt(reader.readLine());

            // 사용자 선택에 따라 동작을 수행
            switch (loginChoice) {
                case 1 -> {
                    // 회원 로그인을 시도함
                    // loginManager 를 통해 회원 로그인을 시도함
                    // 이때 performLogin() 메서드는 사용자의 이름과 비밀번호를 입력받고, 유효한 사용자인지 확인하는 작업 수행
                    User user = loginManager.performLogin();
                    if (user == null) {
                        // 로그인 실패 시 처리
                        System.out.println("이름이나 비밀번호가 틀립니다. 다시 시도해주세요 ! \n");
                        loginAttempts++;
                    } else {
                        // 로그인 성공 시 처리
                        isLoggedIn = true;
                    }
                }
                case 0 -> {
                    // 시스템 종료
                    System.out.println("시스템을 종료합니다, 다음에 또 오세요 !");
                    return;
                }
                default -> {
                    // 잘못된 선택 처리
                    System.out.println("잘못된 선택입니다. 다시 선택하세요 !");
                    loginAttempts++;
                }
            }
        }

        // 로그인 실패하면 종료함
        if (!isLoggedIn) {
            return;
        }

        // 주문 내역 저장을 위한 ArrayList 생성
        ArrayList<OrderItem> orderHistory = new ArrayList<>();
        runMenu(reader, orderHistory); // 메뉴 선택 및 주문 프로세스 실행

        System.out.println("주문 내역:");
        for (OrderItem orderItem : orderHistory) {
            System.out.println("이름: " + orderItem.getName() + " - " + orderItem.getDescription() +
                    " (개수: " + orderItem.getQuantity() + "개) - $" + orderItem.getTotalCost());
        }

        System.out.println("주문이 완료되었습니다.\n");
    }

    public static void runMenu(BufferedReader reader, ArrayList<OrderItem> orderHistory) throws IOException {
        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 라면");
            System.out.println("2. 볶음밥");
            // 버퍼리더를 사용해서 사용자의 입력을 받는 부분
            int menuChoice = Integer.parseInt(reader.readLine());

            switch (menuChoice) {
                case 1 -> {
                    System.out.println("라면을 선택하세요:");
                    System.out.println("1. 기본 라면");
                    System.out.println("2. 치즈 라면");
                    System.out.println("3. 계란 라면");
                    // 사용자롤부터 라면 종류를 입력받음
                    // 버퍼리더로 사용자가 입력한 값을 읽어와 ramenChoice 변수에 저장
                    int ramenChoice = Integer.parseInt(reader.readLine());
                    // RamenFactory 클래스를 인스턴스화, 이 클래스는 라면 객체를 생성하는 역할
                    FoodFactory RamenFactory = new RamenFactory();

                    Food food = switch (ramenChoice) {
                        case 1 -> RamenFactory.createFood();  // 기본 라면 선택
                        case 2 -> new CheeseTopping(RamenFactory.createFood());  // 치즈 라면 선택
                        case 3 -> new EggTopping(RamenFactory.createFood());  // 계란 라면 선택
                        default -> throw new InputMismatchException("잘못된 선택입니다. 다시 선택하세요 !");
                    };

                    System.out.print("주문할 개수를 입력하세요: ");
                    int quantity = Integer.parseInt(reader.readLine());

                    orderHistory.add(new OrderItem(food, quantity));
                }
                case 2 -> {
                    System.out.println("볶음밥을 선택하세요:");
                    System.out.println("1. 계란 볶음밥");
                    System.out.println("2. 김치 볶음밥");
                    System.out.println("3. 새우 볶음밥");
                    int friedRiceChoice = Integer.parseInt(reader.readLine());
                    FoodFactory FriedRiceFactory = new FriedRiceFactory();

                    Food food = switch (friedRiceChoice) {
                        case 1 -> FriedRiceFactory.createFood();  // 계란 볶음밥 선택
                        case 2 -> new KimchiTopping(FriedRiceFactory.createFood());  // 김치 볶음밥 선택
                        case 3 -> new ShrimpTopping(FriedRiceFactory.createFood()); // 새우 볶음밥 선택
                        default -> throw new InputMismatchException("잘못된 선택입니다. 다시 선택하세요 !");
                    };

                    System.out.print("주문할 개수를 입력하세요: ");
                    int quantity = Integer.parseInt(reader.readLine());

                    orderHistory.add(new OrderItem(food, quantity));
                }
                default -> {
                    System.out.println("잘못된 선택입니다. 다시 선택하세요 !");
                    continue;
                }
            }

            System.out.print("추가 주문하시겠습니까? (y/n): ");
            String additionalOrder = reader.readLine();
            if (!additionalOrder.equalsIgnoreCase("y")) {
                continueOrdering = false;
            }
        }
    }
}
