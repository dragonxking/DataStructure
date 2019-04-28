package mydemo.linkedlist;

public class Test {

    public static void testSlowFastRepeatStep(){
        int n = 1;
        int circleLength = 6;
        while (!samePosition(n, circleLength)) {
            n++;
        }
        System.out.println("n=" + n);
    }

    public static boolean samePosition(int x, int circle) {
        int slow = x % circle;
        int fast = (2 * x) % circle;
        System.out.println("slow = " + slow);
        System.out.println("fast = " + fast);
        if(slow == 0){
            System.out.println("slow  circled " );
        }

        System.out.println("==================================");
        return slow == fast;
    }

    public static void main(String[] args) {
        testSlowFastRepeatStep();
    }
}
