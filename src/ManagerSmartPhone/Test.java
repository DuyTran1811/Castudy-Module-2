package ManagerSmartPhone;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManageSmartPhone manager = new ManageSmartPhone();
        manager.upDateSmartPhone(manager.listSmartPhone);
        int choice;
        do {
            System.out.println("1. Thêm Sản Phẩm");
            System.out.println("2. Hiển Thị Sản Phẩm");
            System.out.println("3. Sửa Thông Tin");
            System.out.println("4. Xoá 1 Sản Phẩm");
            System.out.println("5. Tìm Kiếm Sản Phẩm");
            System.out.println("6. Sắp Xếp Thông Tin");
            System.out.println("7. Tính Tống Giá Tiền Trong Kho");
            System.out.println("8. Ghi Thông Tin File CSV");
            System.out.println("0. Thoát Trương Trình");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    manager.ceartSmartPhone(input);
                    System.out.println("Thêm Thành Công");
                    break;
                case 2:
                    if (manager.listSmartPhone.size() > 0) {
                        manager.showSmartPhone(manager.listSmartPhone);
                    } else {
                        System.out.println("Danh Sách Rỗng1");
                    }
                    break;
                case 3:
                    manager.edit(input);
                    break;
                case 4:
                    manager.deleProduct(input);
                    break;
                case 5:
                    manager.search(input);
                    break;
                case 6:
                    manager.Sort(input);
                    manager.showSmartPhone(manager.listSmartPhone);
                    break;
                case 7:
                    manager.totalMoney();
                    break;
                case 8:
                    manager.WirterFile();
                    break;
            }
        } while (true);
    }
}
