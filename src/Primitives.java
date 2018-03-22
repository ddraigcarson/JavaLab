public class Primitives {

    /* INNER CLASS */
    class Primitive {
        private String name;
        private String type;
        private int bytes;

        public Primitive(String name, String type, int bytes) {
            this.name = name;
            this.type = type;
            this.bytes = bytes;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public int getBytes() {
            return bytes;
        }
    }

    private Primitive[] primitives;

    public Primitives() {

        System.out.println("***************");
        System.out.println("LOADING PRIMITIVES");
        System.out.println("***************");

        primitives = createAll();
    }

    /* COULD BE ENUMS */
    private Primitive[] createAll() {
        Primitive[] primitives = {
                new Primitive("byte", "number", 1),
                new Primitive("short", "number", 2),
                new Primitive("int", "number", 4),
                new Primitive("long", "number", 8),
                new Primitive("float", "float number", 4),
                new Primitive("double", "float number", 8),
                new Primitive("char", "a character", 2),
                new Primitive("boolean", "true/false", 1)
        };
        return primitives;
    }

    public void listAll() {
        for (Primitive primitive : primitives) {
            System.out.println(printDetails(primitive.name, primitive.type, primitive.bytes));
        }
    }

    private String printDetails(String name, String type, int bytes) {
        return "primitive: " + name + ", type: " + type + ", no of bytes: " + bytes;
    }

}
