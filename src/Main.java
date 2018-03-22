public class Main {

    public static void main(String[] args) {

        System.out.println("args: " + String.join(", ", args));

        RunMode runMode = null;

        if (args != null && args.length > 0) {
            try {
                runMode = RunMode.valueOf(args[0]);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid or empty run mode, displaying primitives");
                runMode = RunMode.PRIMITIVES;
            }
        }

        System.out.println("---------------------");
        System.out.println("START");
        System.out.println("---------------------");

        switch (runMode) {
            case PRIMITIVES:
                Primitives primitives = new Primitives();
                primitives.listAll();
                break;
            case STRINGS:
                Strings strings = new Strings();
                strings.listFacts();
                break;
            case LOOPS:
                Loops loops = new Loops();
                loops.listFacts();
                break;
            case MATRIX:
                MatrixMaths matrixMaths = new MatrixMaths();
                matrixMaths.execute();
                break;
            default:
                // do nothing
                break;
        }






        System.out.println("---------------------");
        System.out.println("FINISH");
        System.out.println("---------------------");
    }
}
