package utils;

import java.util.ArrayList;
import java.util.List;

public final class IntegerSorterHelper extends SorterHelper {
    @Override
    protected int compare(final Object obj1, final Object obj2) throws NullPointerException {
        return ((Integer)obj1).compareTo((Integer)obj2);
    }

    @Override
    protected List<Object> parse(final List<String> list) throws NumberFormatException {
        if(list == null) {
            return null;
        }
        try {
            final List<Object> outList = new ArrayList<>();
            for (String str : list) {
                outList.add(Integer.parseInt(str));
            }
            return outList;
        }
        catch (Exception ex) {
            return null;
        }
    }
}
