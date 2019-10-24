// Version: 2017100201
/**
 * Handin done by:
 *   Freja Oesterboeg, 201809189
 *   Carl Ulsoee, 201906950
 *
 * Contributions:
 *   Freja and Carl discussed this together and Freja wrote the code itself
 */

import java.util.*;

public class Median {
    // Add your private fields here
    private PriorityQueue<Integer> above = new PriorityQueue<>();
    private PriorityQueue<Integer> below = new PriorityQueue<>(Collections.reverseOrder());

    public void add(int x)  {
        if ((above.size() == 0 && below.size() == 0) || above.peek() <= x)   {
            above.add(x);
        }
        else if (x < above.peek())  {
            below.add(x);
        }

        if (below.size() > above.size())  {
            above.add(below.poll());
        }
        else if (above.size() - 1 > below.size())  {
            below.add(above.poll());
        }
    }
    

    public int median() {
        return above.peek();
    }
}
