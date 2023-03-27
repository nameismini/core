package essence.c11;

import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author 작성자를 명시한다
 * @see    함께 참조할 다른 메소드나 클래스 등
 * @version 버전 정보를 명시한다
 * @param    생성자 혹은 메소드가 받는 파라메타를 설명한다
 * @return 반환값에 대해 설명한다
 */
public class StackEx1 {

    public static Stack back = new Stack();
    public static Stack forward = new Stack();

    private static void goURL(String url) {
        back.push(url);
        if (!forward.empty()) {
            forward.clear();
        }
    }

    private static void goForward() {
        if (!forward.empty()) {
            back.push(forward.pop());
        }
    }

    private static void goBack() {
        if (!back.empty()) {
            forward.push(back.pop());
        }
    }

    private static void printStatus() {
        System.out.println("back : "+ back);
        System.out.println("forward : "+ forward);

    }

    public static void main(String[] args) {
        goURL("1. 네이트");
        goURL("2. 야후");
        goURL("3. 네이버");
        goURL("4. 다음");

        printStatus();

        goBack();
        System.out.println("= 뒤로가기 버튼을 누른후 =");
        printStatus();

        goBack();
        System.out.println("= 뒤로가기 버튼을 누른후 =");
        printStatus();

        goForward();
        System.out.println("= 앞으로가기 버튼을 누른후 =");
        printStatus();

        goURL("codechobo.com");
        System.out.println("= 새로운 주소로 이동 =");
        printStatus();
    }


}
