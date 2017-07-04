package utils;

import java.util.List;

public final class StringSorterHelper extends SorterHelper {

    @Override
    protected int compare(final Object obj1, final Object obj2) throws NullPointerException {
        return ((String)obj1).compareTo((String)obj2);
    }

    @Override
    protected List<Object> parse(final List<String> list) {
        if(list == null) {
            return null;
        }
        return (List)list;
    }
}
