package exceptionstudy;

public class ExceptionEx2 {
    static int method1() throws Exception {
        try {
            System.out.println("ExceptionEx2.method1 try");
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
//            return 1; // catch 블럭내부에도 return이 필요하다.
            throw new Exception(); // 예외 되던지기로 return 을 생략할 수 있다.
        } finally {
            System.out.println("ExceptionEx2.method1 finally");
        }
    }
}
