package himedia.practice.member;

public enum Rateplan {
    LITE("LITE플랜",10),
    BASIC("BASIC플랜",20),
    PREMIUM("PREMIUM플랜",30),
    FREEPASS("PREEPASS플랜",-1);

    // 필드
    private final String description;
    private final int count;


    Rateplan(String description,int count) {
        this.description = description;
        this.count = count;
    }

    public String getDescription() {
        return description;
    }
    public int getCount() {
        return count;
    }
}
