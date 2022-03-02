package exceptionstudy;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ExceptionEx1 {
    public void myMethod() {
        try {
            // 에러가 발생할 가능성이 있는 코드
        } catch (IllegalStateException e) {
            // IllegalState Exception 을 처리하기 위한 코드
        } catch (IllegalArgumentException e) {
            // IllegalArgumentException 을 처리하기 위한 코드
        } catch (Exception e) {
            // 최고 조상을 넣음으로써, 반드시 예외처리 catch가 실행되도록 한다.
        }
    }

    public void myMethod2() throws Exception {
        Exception e = new Exception("고의로 발생시켰음");
        throw e;
    }

    public int myMethod3() {
        try {

            return 1;
        } catch (Exception e) {
            System.out.println(" catch ");
            return 2;
        } finally {
            System.out.println(" finally ");
        }
    }

    // 자원 자동 반환 try - with - resources
    public void myMethod4() {

        try (FileInputStream fis = new FileInputStream("score");
             final DataInputStream dis = new DataInputStream(fis)) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
