import java.io.IOException;
import java.lang.RuntimeException;

public class Eagle {
    static String today;

    /**
     * works fine with unchecked exception
     */
    public static void gulgate1() {
        if(today == "Thursday") {
            throw new RuntimeException("file1 not found");
        }
    }

    /**
     * we must either catch checked exception
     */
    public static void gulgate2() {
        try {
            System.out.println("hello");
            if(today == "Thursday") {
                throw new IOException("file2 not found");
            }
        } catch(Exception e) {
            System.out.println("xixi" + e);
        }
    }

    /**
     * Or specify the method using throws
     * we need to modiefy the method that calls gulgate3
     * in this example it is main and we change the definition
     * we could also use catch block
     * @param args
     */
    public static void gulgate3() throws IOException {
        if(today == "Thursday") {
            throw new IOException("file3 not found");
        }
    }


    public static void main(String[] args) throws IOException {
        Eagle.gulgate1();
        Eagle.today = "Thursday";
        Eagle.gulgate2();
//        Eagle.today = "Thursday";
        Eagle.gulgate3();
    }
}
