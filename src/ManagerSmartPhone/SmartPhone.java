package ManagerSmartPhone;

import Exception.*;

import java.util.regex.Pattern;

public class SmartPhone {
    private static int nextId = 101;
    private String id;
    private String brand;
    private String name;
    private float price;
    private int yearProduce;
    private String screenSize;

    public SmartPhone() {
    }

    public SmartPhone(String id, String brand,
                      String name, float price,
                      int yearProduce, String screenSize) {
        this.setId(id);
        try {
            this.setBrand(brand);
        } catch (InvalidBrandNameException e) {
            System.out.println(e.getInvalidBrandName());
        }
        this.name = name;
        this.price = price;
        this.yearProduce = yearProduce;
        this.screenSize = screenSize;
    }

    public static void setNextId(int nextId) {
        SmartPhone.nextId = nextId;
    }

    public void setId(String id) {
        if (id == null) {
            this.id = "MSP" + nextId;
            nextId++;
        } else {
            this.id = id;
        }
    }

    public void setBrand(String brand) throws InvalidBrandNameException {
        if (checkBrand(brand)) {
            this.brand = brand;
        } else {
            this.brand = null;
            throw new InvalidBrandNameException("Hang Khong Co Danh Sach Trong Kho");
        }
    }

    private boolean checkBrand(String inputBrand) {
        String regex = "^apple|samsung|huawei|xiaomi|oppo|vsmart$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(inputBrand).matches();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setYearProduce(int yearProduce) {
        this.yearProduce = yearProduce;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getYearProduce() {
        return yearProduce;
    }

    public String getScreenSize() {
        return screenSize;
    }
}
