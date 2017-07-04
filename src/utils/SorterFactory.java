package utils;

public final class SorterFactory {

    private SorterFactory() {
        throw new IllegalAccessError();
    }

    public static SorterHelper newInstance(final Class dataType) {
        if(dataType == null) {
            return null;
        }
        if(dataType == String.class) {
            return new StringSorterHelper();
        } else
        if(dataType == Integer.class) {
            return new IntegerSorterHelper();
        }
        else {
            return null;
        }
    }
}
