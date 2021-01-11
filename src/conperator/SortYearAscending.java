package conperator;

import ManagerSmartPhone.SmartPhone;
import sun.util.resources.LocaleData;

import java.util.Comparator;

public class SortYearAscending implements Comparator<SmartPhone> {
    @Override
    public int compare(SmartPhone o1, SmartPhone o2) {
        return Integer.compare(o1.getYearProduce(), o2.getYearProduce());
    }
}
