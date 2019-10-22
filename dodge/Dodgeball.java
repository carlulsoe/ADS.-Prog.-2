/**
 * Handin done by:
 *   Freja Østerbøg, 201809189
 *   Carl Ulsøe, 201906950
 * 
 * Contributions:
 *   This exersice was discussed together and written by Carl
 */
import java.io.*;
import java.util.*;
public class Dodgeball {
    private TreeSet<Integer> search = new TreeSet<Integer>();
    public void addPlayer(int x) {
        search.add(x);
    }

    public int throwBall(int x) {
        Integer floor = search.floor(x);
        Integer ceiling = search.ceiling(x);
        if (floor == null && ceiling != null) {
            search.remove(ceiling);
            addPlayer(x);
            return ceiling - x;
        }
        if (floor != null && ceiling == null) {
            search.remove(floor);
            addPlayer(x);
            return x - floor;
        }
        floor = x - floor;
        ceiling = ceiling - x;
        int distance = Math.min(floor, ceiling);
        if (floor == distance) {
            search.remove(x - distance);
        }
        else {
            search.remove(x + distance);
        }
        if (distance != 0) {
            addPlayer(x);
        }
        return distance;
    }
}
