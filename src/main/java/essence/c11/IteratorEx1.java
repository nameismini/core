package essence.c11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorEx1 {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(30);
        System.out.println("office remote test");

        Iterator it = list.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println("obj = " + obj);
        }
        
    }
}
