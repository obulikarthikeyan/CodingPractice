package arrays;

public class FillRowsColumnsZeros {

    public static void main(String ...args) {
        int[][] matrix = {{0, 2, 9}, {4, 44, 8}, {7, 9, 0}};
        System.out.println("Before:");
        printMatrix(matrix);
        matrix = fillWithZeros(matrix);
        System.out.println("\n\nAfter:");
        printMatrix(matrix);
        int[][] a = {{1, 0, 2, 4}, {3, 2, 1, 8}, {4, 1, 0, 1}};
        System.out.println("\n\nBefore:");
        printMatrix(a);
        a = fillWithZerosInPlace(a);
        System.out.println("\n\nAfter:");
        printMatrix(a);
    }

    public static int[][] fillWithZeros(int[][] matrix) {
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        boolean[] rows = new boolean[rowSize];
        boolean[] columns = new boolean[columnSize];

        for(int i=0; i<rowSize; i++) {
            for (int j=0; j<columnSize; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for(int i=0; i<rowSize; i++) {
            for(int j=0; j<columnSize; j++) {
                if(rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    public static int[][] fillWithZerosInPlace(int[][] a) {
        boolean firstRowZeros = false;
        boolean firstColumnZeros = false;

        for(int i=0; i<a.length; i++) {
            if(a[i][0] == 0) {
                firstColumnZeros = true;
                break;
            }
        }

        for(int i=0; i<a[0].length; i++) {
            if(a[0][i] == 0) {
                firstRowZeros = true;
                break;
            }
        }

        for(int i=1; i<a.length; i++) {
            for(int j=1; j<a[0].length; j++) {
                if(a[i][j] == 0) {
                    a[0][j] = 0;
                    a[i][0] = 0;
                }
            }
        }

        for(int i=1; i<a.length; i++) {
            for(int j=1; j<a[0].length; j++) {
                if(a[i][0] == 0 || a[0][j] == 0) {
                    a[i][j] = 0;
                }
            }
        }

        if(firstColumnZeros) {
            for (int i = 0; i < a.length; i++) {
                a[i][0] = 0;
            }
        }

        if(firstRowZeros) {
            for(int i=0; i<a[0].length; i++) {
                a[0][i] = 0;
            }
        }
        return a;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            String row = "";
            for (int j=0; j<matrix[0].length; j++) {
                row += matrix[i][j] + " ";
            }
            System.out.println(row);
        }
    }
}
