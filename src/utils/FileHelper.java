package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

final class FileHelper {

    static List<String> readFile(final String fname) throws IllegalArgumentException,
                                                                    IOException {
        if(fname == null) {
            throw new IllegalArgumentException();
        }
        final File file = new File(fname);
        if(!file.exists()) {
            throw new FileNotFoundException();
        }
        final BufferedReader reader = new BufferedReader(
                new FileReader(file.getAbsoluteFile()));
        final List<String> stringList = new ArrayList<>();

        String buffer = null;
        while ((buffer = reader.readLine()) != null) {
            stringList.add(buffer);
        }
        reader.close();
        return stringList;
    }

    static void writeFile(final String fname, final List<Object> dataList) throws IllegalArgumentException,
                                                                                            IOException {
        if(fname == null || dataList == null) {
            throw new IllegalArgumentException();
        }
        final File file = new File(fname);
        if(!file.exists() && !file.createNewFile()) {
            throw new FileNotFoundException();
        }
        final PrintWriter writer = new PrintWriter(file.getAbsoluteFile());
        for(Object buffer : dataList) {
            writer.println(buffer);
        }
        writer.close();
    }
}
