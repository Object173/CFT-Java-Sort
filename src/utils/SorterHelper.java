package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public abstract class SorterHelper {

    public enum Result {
        SUCCESS,
        FAIL,
        INVALID_ARGS,
        FILE_NOT_FOUND,
        ERROR_IO_SYSTEM,
        INVALID_FORMAT
    }

    private void insertionSort(final List<Object> data, final boolean isAsc) {
        if(data == null || data.size() <= 1) {
            return;
        }
        for(int i = 1; i < data.size(); i++) {
            for (int j = i; j > 0 && compare(data.get(j - 1), data.get(j), isAsc); j--) {
                Collections.swap(data, j - 1, j);
            }
        }
    }

    public final Result sortFile(final String inFile, final String outFile, final boolean isAsc) {
        if(inFile == null || outFile == null) {
            return Result.INVALID_ARGS;
        }

        try {
            final List<Object> data = parse(FileHelper.readFile(inFile));
            if(data == null) {
                return Result.INVALID_FORMAT;
            }
            insertionSort(data, isAsc);
            FileHelper.writeFile(outFile, data);
            return Result.SUCCESS;
        }
        catch (IllegalArgumentException ex) {
            return Result.INVALID_ARGS;
        }
        catch (FileNotFoundException ex) {
            return Result.FILE_NOT_FOUND;
        }
        catch (IOException ex) {
            return Result.ERROR_IO_SYSTEM;
        }
        catch (Exception ex) {
            return Result.FAIL;
        }
    }

    private boolean compare(final Object obj1, final Object obj2, final boolean isAsc) {
        return (isAsc && compare(obj1, obj2) > 0) || (!isAsc && compare(obj1, obj2) < 0);
    }

    protected abstract int compare(final Object obj1, final Object obj2);
    protected abstract List<Object> parse(final List<String> list);
}
