public class Matrix {

    private double[][] matrix;

    private int rowCount = 0;
    private int colCount = 0;

    public Matrix(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.matrix = new double[rowCount][colCount];
    }

    public void populate(double[][] value) {
        if (value == null){
            throw new IllegalArgumentException("value is required to populate Matrix");
        }
        if (value.length != rowCount) {
            throw new IllegalArgumentException("value is has incorrect number of rows");
        }
        if (value[0].length != colCount) {
            throw new IllegalArgumentException("value is has incorrect number of columns");
        }
        matrix = value;
    }

    public void print() {
        for (int y=0 ; y<matrix.length ; y++) {
            for (int x=0 ; x<matrix[y].length ; x++) {
                System.out.print(matrix[y][x] + "\t");
            }
            System.out.print("\n");
        }
    }

    public void transpose() {
        int transposedRowCount = colCount;
        int transposedColCount = rowCount;
        double[][] transposedMatrix = new double[transposedRowCount][transposedColCount];

        for (int y=0 ; y<transposedRowCount ; y++) {
            for (int x=0 ; x<transposedColCount ; x++) {
                transposedMatrix[y][x] = matrix[x][y];
            }
        }
        rowCount = transposedRowCount;
        colCount = transposedColCount;
        matrix = transposedMatrix;
    }

    public Matrix dot(Matrix value) {
        if (value == null) {
            throw new IllegalArgumentException("value is required for a dot product");
        }
        if (colCount != value.getRowCount()) {
            throw new IllegalArgumentException("value must have equal number of rows to source columns for a dot product");
        }

        Matrix resultMatrix = new Matrix(rowCount, value.getColCount());
        double[][] result = new double[resultMatrix.getRowCount()][resultMatrix.getColCount()];

        for (int y=0 ; y<resultMatrix.getRowCount() ; y++) {
            for (int x=0 ; x<resultMatrix.getColCount() ; x++) {
                double sum = 0.0;
                /*calculate sum*/
                for (int i=0 ; i<colCount ; i++) {
                    sum += matrix[y][i] * value.getMatrix()[i][x];
                }
                result[y][x] = sum;
            }
        }
        resultMatrix.populate(result);
        return resultMatrix;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public double[][] getMatrix() {
        return matrix;
    }
}
