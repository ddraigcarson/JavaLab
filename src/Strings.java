public class Strings {

    public Strings() {
        System.out.println("***************");
        System.out.println("LOADING STRINGS");
        System.out.println("***************");
    }

    public void listFacts(){
        equalsFact();
    }

    private void equalsFact() {
        System.out.println("How equals works");
        String str1 = new String("wow");
        String str2 = new String("wow");
        String str3 = str1;

        System.out.println("str1: " + str1 + ", hashcode: " + System.identityHashCode(str1));
        System.out.println("str2: " + str2 + ", hashcode: " + System.identityHashCode(str2));
        System.out.println("str3: " + str3 + ", hashcode: " + System.identityHashCode(str3));

        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1.equals(str2): " + str1.equals(str2));

        System.out.println("str1 == str3: " + (str1 == str3));
        System.out.println("str1.equals(str3): " + str1.equals(str3));
    }


}
