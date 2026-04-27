package TDAs;

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E> {

    @Override
    public int compare(E a, E b) {
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        return ((Comparable<E>) a).compareTo(b);
    }
}
