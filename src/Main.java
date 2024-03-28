import java.util.Arrays;
import java.util.List;

public class Main implements Runnable {

    Integer[] num = {1,2,3,4,5};
    public List<Integer> nums = Arrays.asList(num);

    public static void main(String[] args) {
        Main obj = new Main();
        Thread thread = new Thread(obj);
        thread.start();
        System.out.println(obj.nums.subList(0, 2).stream().mapToInt(x -> x * 2).sum());
    }
    public void run() {
       int sum =  nums.subList(2, 5).stream().mapToInt(x -> x * 2).sum();
        System.out.println("This code is running in a thread: " + sum);
    }
}
