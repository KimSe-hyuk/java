package himedia.practice;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class D_input_output_stream {
    // 1. 바탕화면 경로 가져오기
    private String desktopPath;
    // 2. 폴더 경로 설정
    private String folderPath;
    // 폴더 생성
    private Path myFolder;
    // 오늘 날짜의 파일 경로 설정
    private String today;
    private Path todayFile;



    public D_input_output_stream(){
        this.desktopPath = System.getProperty("user.home")+ File.separator+"Desktop";
        this.folderPath= desktopPath+ File.separator+"테스트";
        this.myFolder= Paths.get(folderPath);
    }
    public  void exam1(){

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

    public void exam2(){
        Scanner sc =new Scanner(System.in);// 복사본 ,입력받아서이름 내용 생성
        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("텍스트 파일 이름 입력 : ");
        String fileName=sc.nextLine();
        todayFile = myFolder.resolve(fileName+"_"+today + ".txt");


        // 오늘 날짜의 파일을 생성하고 "Hello World!"를 넣음
        if( Files.notExists(todayFile)) {
            //방법 1
             /*
            FileOutputStream fos =null;
            try {
                fos = new FileOutputStream(todayFile.toFile());
                String content ="Hello World!";
                fos.write(content.getBytes());
                System.out.println(today +".txt 파일을 생성하고 내요을 썼습니다..");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                if(fos !=null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            */
            //방법 2 -> try - with - resources 알트 엔트 맨밑
            try (FileOutputStream fos = new FileOutputStream(todayFile.toFile())) {
                String content ="Hello World!";
                System.out.println("텍스트 파일에 적을 내용 : ");
                fos.write((content+"\n"+sc.nextLine()).getBytes());
                System.out.println(fileName+"_"+today +".txt 파일을 생성하고 내용을 썼습니다.");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println(today + ".txt 파일이 존재합니다.");
        }
    }
    public void exam3(){
        Scanner sc =new Scanner(System.in);
        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));


        File dir = new File(folderPath);

        String[] filenames = dir.list();
        assert filenames != null;
        for (String filename : filenames) {
            System.out.println("filename : " + filename);
        }
        System.out.println("내용을 볼 txt 날짜제외 파일 명을 쓰시오");
        String name = sc.nextLine();

        todayFile = myFolder.resolve(name+"_"+today + ".txt");
        if( Files.exists(todayFile)) {
            try (FileInputStream fis = new FileInputStream(todayFile.toFile())) {
                int byteData;
                System.out.println("읽어오기 : " + today + ".txt");

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
            System.out.println(todayFile+name + "_" +today + ".txt 파일이 존재하지 않습니다.");
        }
    }
    public void exam4(){
        Scanner sc =new Scanner(System.in);
        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        File dir = new File(folderPath);

        String[] filenames = dir.list();
        for (String filename : filenames) {
            System.out.println("filename : " + filename);
        }
        System.out.println("삭제할 txt 파일에 날짜제외 파일 명을 쓰시오");
        String name = sc.nextLine();
        todayFile = myFolder.resolve(name+"_"+today + ".txt");
        if( Files.exists(todayFile)) {
            try {
                Files.delete(todayFile);
                System.out.println("파일삭제 성공");
            } catch (IOException e) {
                System.out.println("파일삭제 실패");
                throw new RuntimeException(e);
            }
        }else{
            System.out.println(todayFile+name + "_" +today + ".txt 파일이 존재하지 않습니다.");
        }
    }
    private void exam5() {
        File dir = new File(folderPath);

        String[] filenames = dir.list();
        for (String filename : filenames) {
            System.out.println("filename : " + filename);
        }
    }
    public static void main(String[] args) {
        D_input_output_stream d= new D_input_output_stream();
        Scanner sc =new Scanner(System.in);
        while(true){
            System.out.println("번호입력:1. 폴더 생성, 2. 텍스트 파일생성, 3. 텍스트파일 읽기 4. 텍스트파일 삭제 5. 파일 리스트 ");
            int num = sc.nextInt();
            switch(num){
                case 1:
                    d.exam1();
                    break;
                case 2:
                    d.exam2();
                    break;
                case 3:
                    d.exam3();
                    break;
                case 4:
                    d.exam4();
                    break;
                case 5:
                    d.exam5();
                    break;
                default:
                    return;
            }
        }

    }

}
