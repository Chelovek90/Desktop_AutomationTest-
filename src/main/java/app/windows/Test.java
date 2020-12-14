package app.windows;

public class Test {
    public static void main(String[] args) {
        boolean b = true;
        int count = 0;
        System.out.println("start cycle - " + count);
        while (b) {
            count += 1;
            if (count == 5) {
                b = false;
            }
        }
        System.out.println("end cycle - " + count);

    }
}
