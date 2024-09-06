package himedia.practice.account2_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class AccountBooklmpl implements AccountBook {
    // 1. 바탕화면 경로 가져오기
    private String desktopPath;
    // 2. 폴더 경로 설정
    private String folderPath;
    // 폴더 생성
    private Path myFolder;
    private String today;
    private Path todayFile;


    AccountBooklmpl() {
            this.desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
            this.folderPath = desktopPath + File.separator + "가계부";
            this.myFolder = Paths.get(folderPath);

    }

    public  void makeForder(){

        try{
            if (Files.notExists(myFolder)) {
                // 폴더가 존재하지 않는 경우 생성
                Files.createDirectories(myFolder);
                System.out.println("폴더가 성공적으로 생성되었습니다.");
            } else {
                System.out.println("폴더가 이미 존재합니다.");
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void AccountBookPlus() {
        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int sum =0;
        todayFile = myFolder.resolve(today+".txt");
        if ( Files.notExists(todayFile) ) {
            System.out.println("파일 시작");
            writeTxt(false);
        }else{
            System.out.println("파일 수정");
            writeTxt(true);
        }
    }
    void writeTxt(boolean replace){
        StringBuilder sb=new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int sum =0;
        todayFile = myFolder.resolve(today + ".txt");

        try ( FileOutputStream fos = new FileOutputStream(todayFile.toFile() )) {
            if(replace) {

                todayFile = myFolder.resolve(today+".txt");
                BufferedReader br = new BufferedReader(new FileReader(String.valueOf(todayFile)));
                String[] str = br.readLine().split(":");
                for (int i = 0; i < str.length-2; i=i+2) {
                    sb.append(str[i]).append(" : ").append(str[i+1]).append("\n");
                    sum+=Integer.parseInt(str[i+1]);
                }
                sb.append("합계").append(" : ").append(sum);
                fos.write(sb.toString().getBytes());
                System.out.println(today+".txt 파일을 수정하고 내용을 썼습니다.");

            }

                while (true){
                    System.out.println("종료를 원할시 stop 입력");
                    System.out.println("이름 입력 : ");
                    String name = sc.nextLine();
                    if(name.equals("stop"))break;
                    System.out.println("가격 입력 : ");
                    int price = sc.nextInt();
                    sc.nextLine();
                    sum+=price;
                    sb.append(name).append(" : ").append(price).append("\n");
                }

            sb.append("합계").append(" : ").append(sum);
            fos.write(sb.toString().getBytes());
            System.out.println(today+".txt 파일을 생성하고 내용을 썼습니다.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void AccountBookAllDel() {
        Scanner sc =new Scanner(System.in);
        File dir = new File(folderPath);

        String[] filenames = dir.list();
        for (String filename : filenames) {
            System.out.println("filename : " + filename);
        }
        System.out.println("삭제할 txt 파일 명을 쓰시오");
        String name = sc.nextLine();
        todayFile = myFolder.resolve(name+ ".txt");
        if( Files.exists(todayFile)) {
            try {
                Files.delete(todayFile);
                System.out.println("파일삭제 성공");
            } catch (IOException e) {
                System.out.println("파일삭제 실패");
                throw new RuntimeException(e);
            }
        }else{
            System.out.println(name + ".txt 파일이 존재하지 않습니다.");
        }
    }

    @Override
    public void AccountBookList() {
        Scanner sc =new Scanner(System.in);
        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        File dir = new File(folderPath);
        String[] filenames = dir.list();
        assert filenames != null;
        for (String filename : filenames) {
            System.out.println("filename : " + filename);
        }
        System.out.println("내용을 볼 txt명을 쓰시오");
        if(filenames.length == 0){
            System.out.println("파일이 없습니다.");
            return;
        }
        String name = sc.nextLine();
        todayFile = myFolder.resolve(name+".txt");
        if( Files.exists(todayFile)) {
            try (FileInputStream fis = new FileInputStream(todayFile.toFile())) {
                int byteData;
                System.out.println("읽어오기 : " + name + ".txt");

                while ((byteData = fis.read()) != -1) {
                    System.out.print((char)byteData);
                }
                System.out.println(); //줄바꿈
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println(name  + ".txt 파일이 존재하지 않습니다.");
        }
    }



    @Override
    public int menuPrint() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 가계부 추가, 2. 내역조회, 3. 삭제, 4. 프로그램 종료");
        return sc.nextInt();
    }
}
