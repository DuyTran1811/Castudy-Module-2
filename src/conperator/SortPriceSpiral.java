package conperator;

import ManagerSmartPhone.SmartPhone;

import java.util.Comparator;

public class SortPriceSpiral implements Comparator<SmartPhone> {
    @Override
    public int compare(SmartPhone o1, SmartPhone o2) {
        return Float.compare(o2.getPrice(), o1.getPrice());
    }
}
