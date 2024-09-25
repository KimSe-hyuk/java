package com.example.tobi.springtobi.hometest;


public class SRP {
    // 1. 사용자 정보를 담당하는 클래스
    static class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    // 2. 이메일 발송을 담당하는 클래스
    static class EmailService {
        public void sendEmail(String email, String message) {
            // 이메일 발송 로직
            System.out.println("Send email to " + email + ": " + message);
        }
    }

    // 3. 데이터베이스 저장을 담당하는 클래스
    static class UserRepository {
        public void saveUser(User user) {
            // DB에 사용자 정보 저장 로직
            System.out.println("Save user to the database: " + user.getName());
        }
    }

    public static void main(String[] args) {
        // User 생성
        User user = new User("John Doe", "john@example.com");

        // 이메일 서비스 사용
        EmailService emailService = new EmailService();
        emailService.sendEmail(user.getEmail(), "Welcome to our service!");

        // 사용자 정보 저장
        UserRepository userRepository = new UserRepository();
        userRepository.saveUser(user);
    }
}

