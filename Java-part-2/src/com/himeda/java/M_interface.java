package com.himeda.java;

// * 인터페이스(Interface)
// 자바에서 클래스들이 구현해야 하는 메서드의 집합을 정의하는데 사용되는 추상 타입이다.
// 인터페이스는 메서드의 선언만 포함하며, 메서드의 구체적인 구현은 포함하지 않는다.
// 따라서 인터페이스를 구현하는 클래스는 인터페이스에 선언된 모든 메서드를 반드시 구현해야 한다.

// * 인터페이스의 필요성
// 1. 표준화
// 인터페이스를 사용하면 여러 클래스가 동일한 메서드를 구현하도록 강제할 수 있다.
// 이는 일관된 API 설계와 코드 표준화를 가능하게 한다.

// 2. 다중 상속의 대안
// 자바는 클래스의 다중 상속을 지원하지 않지만, 인터페이스는 여러 개를 구현할 수 있다.
// 이를 통해 다중 상속의 이점을 제공하면서 다중 상속에서 발생할 수 있는 복잡성과 충돌을 피할 수 있다.

// 3. 유연한 설계
// 인터페이스를 사용하면 특정 클래스의 구현에 의존하지 않고, 인터페이스를 기반으로 프로그래밍할 수 있다.
// 이는 코드의 유연성과 확장성을 크게 향상시킨다.

// 4. 느슨한 결합
// 인터페이스를 사용하면 구현체와 사용자를 느슨하게 결합할 수 있다.
// 이는 시스템의 각 부분을 독립적으로 개발하고 변경할 수 있게 한다.

// * 인터페이스와 추상 클래스의 차이점
//	•	다중 구현: 클래스는 여러 인터페이스를 구현할 수 있지만, 추상 클래스는 하나만 상속받을 수 있다.
//	•	구현 유무: 인터페이스는 구현을 포함하지 않지만, 추상 클래스는 일부 메서드의 구현을 포함할 수 있다.
//	•	상태 유지: 인터페이스는 상태(필드)를 가질 수 없지만, 추상 클래스는 필드를 가질 수 있다.

public class M_interface {
    public static void main(String[] args) {
        M_animal myDog = new M_dog();// 참조형 변수라서 M_dog라는 주소를 M_animal에넣고 그 객체를 mydog로 생성한다.
        M_animal myCat = new M_cat();

        myDog.makeSound();
        myDog.eat();

        myCat.makeSound();
        myCat.eat();
    }
}