public class Loops {

    public Loops() {
        System.out.println("***************");
        System.out.println("LOADING LOOPS");
        System.out.println("***************");
    }

    public void listFacts(){
        whileFact();
        System.out.println("---");
        doWhileFact();
        System.out.println("---");
        breakFact();
    }

    private void whileFact() {
        String[] facts = {
                "while(condition) { stuff }",
                "executes the condition",
                "at least once",
                "and everytime the loop is done"
        };
        int index = 0;
        while(index < facts.length) {
            System.out.println(facts[index]);
            index++;
        }
    }

    private void doWhileFact() {
        String[] facts = {
                "do { stuff } while (condition)",
                "runs the stuff bit at least once",
                "and the condition everytime the loop is done"
        };
        int index = 0;
        do {
            System.out.println(facts[index]);
            index++;
        } while(index < facts.length);
    }

    private void breakFact() {
        System.out.println("Break stops the current loop statement");
        System.out.println("Continue stops the current loop interation but continues the loop");
    }

}
