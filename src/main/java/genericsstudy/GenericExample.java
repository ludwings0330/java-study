package genericsstudy;

public class GenericExample {
    static class Box<T> {
        T item;
        void setItem(T item) {
            this.item = item;
        }
        
        T getItem() {
            return this.item;
        }
    }


    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<Apple>();


        Box<String> box = new Box<String>();
        box.setItem("ABC");
        String item = box.getItem(); // (String)으로 형변환이 필요없음 컴파일시에 타입 체크
        System.out.println("item = " + item);
    }

    private static class Apple extends Fruit {
    }

    private static class FruitBox<T extends Fruit> { // Fruit의 자손만 타입으로 지정가능
    }

    private static class Fruit {
    }
}
