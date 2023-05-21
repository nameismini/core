package essence.c11;

import java.util.Arrays;

public class ComparatorEx {

    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr);  // String의 Comparable구현에 의한 정렬
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); //대소문자 구분안함
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

//        Arrays.sort(strArr, new Descending()); //대소문자 구분안함
//        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));
    }
}
