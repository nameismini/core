package essence.c11;

//import java.util.ArrayList;
//import java.util.List;

import java.nio.charset.Charset;
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

        while (it.hasNext()) {
            copy1.add(it.next());
        }
        System.out.println("copy1 : " + copy1);
        System.out.println("original에서 copy1로 복사");
        System.out.println("original : " + original);


        it = original.listIterator();

        while (it.hasNext()) {
            copy2.add(it.next());
            it.remove();
        }

        System.out.println("original에서 copy2로 복사");
        System.out.println("original : " + original);
        System.out.println("copy2 : " + copy2);

        System.out.println(Charset.defaultCharset().displayName());

    }
}
