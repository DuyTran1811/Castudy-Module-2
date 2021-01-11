package conperator;

import ManagerSmartPhone.SmartPhone;

import java.util.Comparator;

public class SortYearSpiral implements Comparator<SmartPhone> {
    @Override
    public int compare(SmartPhone o1, SmartPhone o2) {
        return Integer.compare(o2.getYearProduce(), o1.getYearProduce());
    }
}
