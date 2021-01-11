package ManagerSmartPhone;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManageSmartPhone manager = new ManageSmartPhone();
        int choice;
        do {
            System.out.println("1. Thêm Sản Phẩm");
            System.out.println("2. Hiển Thị Sản Phẩm");
            System.out.println("3. Sửa Thông Tin");
            System.out.println("4. Xoá 1 Sản Phẩm");
            System.out.println("5. Sắp Xếp Thông Tin");
            System.out.println("6. Tính Tống Giá Tiền Trong Kho");
            System.out.println("7. Ghi Thông Tin File CSV");
            System.out.println("0. Thoát Trương Trình");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    manager.ceartSmartPhone(input);
                    break;
                case 2:
                    manager.showSmartPhone();
                    break;
                case 3:
                    manager.edit(input);
                    break;
                case 4:
                    manager.deleProduct(input);
                    break;
                case 5:
                    manager.Sort(input);
                    manager.showSmartPhone();
                    break;
                case 6:
                    manager.totalMoney();
                    break;
                case 7:
                    manager.WirterFile();
            }
        } while (true);
    }

}
