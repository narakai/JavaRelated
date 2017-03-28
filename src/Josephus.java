import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by laileon on 2017/3/26.
 */
public class Josephus {
    public static void main(String[] args) {
        int m = 71;
        int n = 5;

        // initialize the queue
        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {

            for (int i = 1; i < m; i++) {
                //不断dequeue enqueue 直到达到上限
                queue.enqueue(queue.dequeue());
            }
            //m出列
            StdOut.print(queue.dequeue() + " ");

        }
        StdOut.println();
    }
}
