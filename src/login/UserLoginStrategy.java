package login;

import java.util.Scanner;

public final class UserLoginStrategy implements LoginStrategy {

    @Override
    public User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("사용자 이름을 입력하세요: ");
        String username = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();

        if (("이서윤".equals(username) && "1025".equals(password)) ||
                ("김찬호".equals(username) && "2400".equals(password))) {
            return new User(username, password);
        } else {
            System.out.println("로그인 실패");
            return null;
        }
    }
}
