public class MatrixMaths {

    public void execute(){
        System.out.println("***************");
        System.out.println("LOADING MATRIX");
        System.out.println("***************");

        Matrix matrix1 = new Matrix(1, 3);
        Matrix matrix2 = new Matrix(3, 4);

        double[][] value1 = {
                {3, 4, 2}
        };
        double[][] value2 = {
                {13, 9, 7, 15},
                { 8, 7, 4,  6},
                { 6, 4, 0,  3}
        };

        matrix1.populate(value1);
        matrix2.populate(value2);

        Matrix result = matrix1.dot(matrix2);
        result.print();
    }

}
