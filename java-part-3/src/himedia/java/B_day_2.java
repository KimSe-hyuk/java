package himedia.java;

public enum B_day_2 {
    //각 열거 상수는 B_day_2의 인스턴스를 나타냅니다.
    SUNDAY("Holiday"),
    MONDAY("Work day"),
    TUESDAY("Work day"),
    WEDNESDAY("Work day"),
    THURSDAY("Work day"),
    FRIDAY("Work day"),
    SATURDAY("Half day"),;

    // 필드
    private String description;

    //열거형의 생성자는 private으로 선언되며, 각 열거 상수를 생성할 때 호출됩니다. 이 생성자는 description 값을 설정합니다.
    B_day_2(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

