package himedia.practice;

class Chat{
    private boolean flag = false;

    public synchronized void question(String msg){
        while(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Question : " +msg);
        flag = true;
        notify();
    }
    public synchronized void answer(String msg){
        while(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Answer : "+msg);
        flag = false;
        notify();
    }
}
class QuestionThread extends Thread{
    private Chat chat;
    private String[] questions ={"Hi","How are you?","what are you dogin?"};
    public QuestionThread(Chat chat){
        this.chat = chat;
    }

    @Override
    public void run() {
        for (String question : questions) {
            chat.question(question);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class AnswerThread extends Thread{
    private Chat chat;
    private String[] answers ={"Hello","I'fine, thank you!","I'm coding in Java"};
    public AnswerThread(Chat chat){
        this.chat = chat;
    }

    @Override
    public void run() {
        for (String answer : answers) {
            chat.answer(answer);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

public class C_thred_8_2 {
    public static void main(String[] args) {
        Chat chat = new Chat();

        QuestionThread questionThread = new QuestionThread(chat);
        AnswerThread answerThread = new AnswerThread(chat);

        questionThread.start();
        answerThread.start();
    }
}

