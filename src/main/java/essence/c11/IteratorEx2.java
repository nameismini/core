package essence.c11;

//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

public class IteratorEx2 {

    public static void main(String[] args) {
        List original = new ArrayList();
        List copy1 = new ArrayList();
        List copy2 = new ArrayList();

        for (int i = 0; i < 10; i++) {
            original.add(i);
        }

        ListIterator it = original.listIterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

/*        for (Object o : original) {
            System.out.println("o = " + o);
        }*/

        System.out.println(original.toString());

    }
}
