package Lesson5;

import java.io.Serializable;
import java.util.Arrays;

public class AppData implements Serializable {

    private final String[] headerInfo;
    private final int[][] dataInfo;

    public AppData(String[] headerInfo, int[][] dataInfo) {
        this.headerInfo = headerInfo;
        this.dataInfo = dataInfo;
    }
        @Override
        public String toString() {
        return Arrays.toString(headerInfo) + Arrays.toString(dataInfo);
    }
}


