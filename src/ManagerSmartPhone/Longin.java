package ManagerSmartPhone;

import java.util.Scanner;

public class Longin {
    public static void main(String[] args) {
        Program program = new Program();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1: Đăng Nhập");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Nhap Ten Dang Nhap");
                    String id = input.nextLine();
                    System.out.println("Nhap Mat Khau");
                    String password = input.nextLine();
                    if (id.equals("admin") && password.equals("admin")) {
                        program.mains();
                    } else {
                        System.out.println("Sai Mat Khau Vui Long Nhap Lai");
                    }
                    break;
            }
        } while (true);
    }
}
