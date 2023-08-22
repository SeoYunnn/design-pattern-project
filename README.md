# ChoonsikPC-Program
PC방 로그인, 음식 주문 시스템 프로그램

## 💻 프로젝트 목적
- wisoft 에서 진행하는 디자인 패턴 세미나를 적극 활용해보기 위해 시작했습니다.
- 프로젝트 내에 디자인 패턴 3가지를 적용시켰습니다.

## ⚙️ 개발환경
- `Java`

## 🎨 프로젝트 내에 쓰인 디자인 패턴
### 1) 전략 패턴
- 객체 간에 알고리즘을 정의하고, 이들 알고리즘을 동적으로 교체해 사용할 수 있도록 하는 디자인 패턴
- `UserLoginStrategy` : 로그인 방식을 정의하는 `LoginStrategy` 인터페이스를 구현
- `LoginManager` : 로그인 방식을 정의하는 (`LoginStrategy`) 을 인자로 받아 생성됨
- `LoginManager` : 전략 패턴의 "컨텍스트" 에 해당, `LoginStrategy` 인터페이스를 이용해 다양한 로그인 전략 실행 

  👉🏻 `LoginManger` 클래스는 생성자를 통해 `LoginStrategy` 를 받아온 후, `performLogin` 메서드에서 해당 전략을 실행
- `User` : 로그인 전략에서 생성된 사용자 정보를 저장하는 데이터 객체 역할


- [패턴 설명 링크](https://leeseoyun.notion.site/Chapter-01-f521be5dbff445eba730499e3ab17a1d?pvs=4)

### 2) 데코레이터 패턴
- 객체 지향 프로그래밍에서 사용되는 디자인 패턴 중 하나로, 기존 객체의 구조를 변경하지 않고 새로운 기능을 동적으로 추가하거나 확장할 수 있게 해주는 패턴
- 데코레이터 패턴을 사용해 음식 객체에 토핑을 추가하고 주문을 처리하는 방식
- 사용자 인터페이스를 통해 사용자가 원하는 메뉴와 토핑을 선택해 주문할 수 있도록 구성


- [패턴 설명 링크](https://leeseoyun.notion.site/Chapter-03-98b38aa1528c431ca71c70d32d7018e8?pvs=4)

### 3) 팩토리 패턴
- [패턴 설명 링크](https://leeseoyun.notion.site/Chapter-04-718e6784b5054a7ebeb52f2e0a4650ad?pvs=4)


## 📋 프로젝트 세부 내용
- [Notion 링크](https://leeseoyun.notion.site/Design-Pattern-Project-77411aa0a64346be9769cf37c7bd8e2b?pvs=4)