package service;

import Exception.*;
import conperator.SortPriceAscending;
import conperator.SortPriceSpiral;
import conperator.SortYearAscending;
import conperator.SortYearSpiral;
import model.SmartPhone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageSmartPhone {
    public List<SmartPhone> listSmartPhone = new ArrayList<>(reardToFile());
    public static final String fileName = "FileSmartPhone.csv";

    public void ceartSmartPhone(Scanner input) {
        System.out.println("Nhập Tên Hãng");
        String brand = input.nextLine();
        System.out.println("Nhap Ten");
        String name = input.nextLine();
        System.out.println("Nhap Gia");
        float price = Float.parseFloat(input.nextLine());
        System.out.println("Nhap nam San Xuat");
        int date = Integer.parseInt(input.nextLine());
        System.out.println("Nhap Kich Thuoc Man Hinh");
        String screen = input.nextLine();
        SmartPhone smartPhone = new SmartPhone(null, brand, name, price, date, screen);
        listSmartPhone.add(smartPhone);
    }

    public void showSmartPhone(List<SmartPhone> listSmartPhone) {
        System.out.printf("%-13s%-13s%-13s%-13s%-20s%-13s\n",
                "Mã SP", "Tên Hãng", "Nhập Tên", "Giá SP", "Năm Sản Xuất", "Kích Thước Màn Hình");
        for (SmartPhone smp : listSmartPhone) {
            System.out.printf("%-13s%-13s%-13s%-13s%-20s%-13s\n",
                    smp.getId(), smp.getBrand(), smp.getName(), smp.getPrice(), smp.getYearProduce(), smp.getScreenSize());
        }
    }

    public void edit(Scanner input) {
        System.out.println("Nhập Mã Sản Phẩm");
        String id = input.nextLine();
        for (SmartPhone smp : listSmartPhone) {
            if (smp.getId().compareTo(id) == 0) {
                System.out.println("Nhập Hãng");
                try {
                    smp.setBrand(input.nextLine());
                } catch (InvalidBrandNameException e) {
                    e.printStackTrace();
                }
                System.out.println("Nhập Tên");
                smp.setName(input.nextLine());
                System.out.println("Nhập Giá");
                smp.setPrice(Float.parseFloat(input.nextLine()));
                System.out.println("Nhập Năm Sản Xuất");
                smp.setYearProduce(Integer.parseInt(input.nextLine()));
                System.out.println("Nhập Kích Thước Màn Hình");
                smp.setScreenSize(input.nextLine());
            }
        }
    }

    public void Sort(Scanner input) {
        System.out.println("1.Giá Tăng Dần");
        System.out.println("2.Giá Thấp Dần");
        System.out.println("3.Năm Sản Xuất Cũ => Mới");
        System.out.println("4.Năm Sản Xuất Mới => Cũ");
        int option = input.nextInt();
        switch (option) {
            case 1:
                listSmartPhone.sort(new SortPriceAscending());
                break;
            case 2:
                listSmartPhone.sort(new SortPriceSpiral());
                break;
            case 3:
                listSmartPhone.sort(new SortYearAscending());
                break;
            case 4:
                listSmartPhone.sort(new SortYearSpiral());
                break;
            default:
                System.out.println("Xin Vui Lòng Nhập Lại");
        }
    }

    public void totalMoney() {
        float total = 0;
        for (SmartPhone smp : listSmartPhone) {
            total += smp.getPrice();
        }
        System.out.println("Tổng Giá Trị Trong Kho " + total);
    }

    public void WirterFile() {
        if (listSmartPhone.size() > 0) {
            File file = new File(fileName);
            try (FileWriter fileWriter = new FileWriter(file)) {
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for (SmartPhone smp : listSmartPhone) {
                    if (file.exists()) {
                        printWriter.println(smp.getId());
                        printWriter.println(smp.getBrand());
                        printWriter.println(smp.getName());
                        printWriter.println(smp.getPrice());
                        printWriter.println(smp.getYearProduce());
                        printWriter.println(smp.getScreenSize());
                    }
                }
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Danh Sách Rỗng");
        }
    }

    private List<SmartPhone> reardToFile() {
        List<SmartPhone> list = new ArrayList<>();
        File file = new File(fileName);
        try {
            file.createNewFile();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String id = scanner.nextLine();
                String brand = scanner.nextLine();
                String name = scanner.nextLine();
                float price = Float.parseFloat(scanner.nextLine());
                int year = Integer.parseInt(scanner.nextLine());
                String screenSize = scanner.nextLine();
                SmartPhone smartPhone = new SmartPhone(id, brand, name, price, year, screenSize);
                list.add(smartPhone);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleProduct(Scanner input) {
        System.out.println("Nhap Ma SP");
        String id = input.nextLine();
        listSmartPhone.removeIf(smp -> smp.getId().compareTo(id) == 0);
    }

    public void search(Scanner input) {
        List<SmartPhone> list = new ArrayList<>();
        System.out.println("Nhập Mã Sản Phẩm");
        String id = input.nextLine();
        for (SmartPhone smp : listSmartPhone) {
            if (smp.getId().compareTo(id) == 0) {
                list.add(smp);
            }
        }
        showSmartPhone(list);
    }
    public void upDateSmartPhone(List<SmartPhone> listSmartPhone) {
        int max = 100;
        for (SmartPhone smp : listSmartPhone) {
            int curd = Integer.parseInt(smp.getId().substring(3));
            if (curd > max) {
                max = curd;
            }
        }
        SmartPhone.setNextId(max + 1);
    }
}
