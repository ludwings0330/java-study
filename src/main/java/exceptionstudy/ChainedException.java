package exceptionstudy;

public class ChainedException {

    public void myMethod() {
        try {
            throw new SpaceException("공간 부족해요");
        } catch (SpaceException e) {
            final InstallException ie = new InstallException("설치중 예외 발생");
            ie.initCause(e);
            final Throwable cause = ie.getCause();
        }
    }

    static void startInstall() throws SpaceException {
        if (!enoughSpace()) {
            throw new SpaceException("설치 공간이 부족합니다");
        }

        if (!enoughMemory()) {
            throw new RuntimeException(new MemoryException("메모리가 부족합니다"));
        }
    }

    private static boolean enoughMemory() {
        return false;
    }


    private static boolean enoughSpace() {

        return true;
    }
}
