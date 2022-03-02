package reflectionstudy;

import javax.lang.model.SourceVersion;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public static void main(String[] args) throws Exception {
        Object obj = new Car("foo", 0);
//        foo.move(); // error 인 것은 당연하다.
        final Class<Car> carClass = Car.class;
        final Method move = carClass.getMethod("move");

        move.invoke(obj, null);

        final Method getPosition = carClass.getMethod("getPosition");
        final int position = (int) getPosition.invoke(obj, null);

        System.out.println("position = " + position);

        final Field postion = carClass.getField("position");
        System.out.println("postion = " + postion);

    }
}
