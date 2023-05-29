package essence.c11;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {

    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr);  // String의 Comparable구현에 의한 정렬
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); //대소문자 구분안함
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending()); //역순 정렬
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));
    }
}

    class Descending implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Comparator && o2 instanceof Comparator) {
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;

                return c1.compareTo(o2) * -1; // -1을 곱해서 기본 정렬방식의 역으로 변경
                                              // 또는 c2.compareTo(o1) 같이 순서를 바꿔도 된다.
            }
            return -1;
        }
    }
