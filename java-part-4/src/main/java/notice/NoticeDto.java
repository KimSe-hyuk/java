package notice;

public class NoticeDto {
    private int userID;
    private String email;
    private boolean status;

    public NoticeDto() {}
    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public boolean getStatus() {
        return status;
    }

    public NoticeDto(int userID, String email, boolean status) {
        this.userID = userID;
        this.email = email;
        this.status = status;
    }

}
