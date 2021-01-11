package conperator;

import ManagerSmartPhone.SmartPhone;

import java.util.Comparator;

public class SortPriceAscending implements Comparator<SmartPhone> {

    @Override
    public int compare(SmartPhone o1, SmartPhone o2) {
        return Float.compare(o1.getPrice(), o2.getPrice());
    }
}
