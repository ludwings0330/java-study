package enumstudy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class EnumExample {

    @Getter
    @RequiredArgsConstructor
    enum Transportation {
        BUS(10) {
            int getFare(int distance) { return distance * BASIC_FARE; }
        },
        TRAIN(20) {
            int getFare(int distance) { return distance * BASIC_FARE; }
        },
        SHIP(100) {
            int getFare(int distance) { return distance * BASIC_FARE; }
        };

        protected final int BASIC_FARE;

        abstract int getFare(int distance);

        public int getBasicFare() {
            return BASIC_FARE;
        }
    }

    enum Direction {
        EAST(10, "동"), SOUTH(100,"남"), WEST(200, "서"), NORTH(1000, "북");

        private final int value;
        private final String description;

        Direction(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() { return value; }
        public String getDescription() { return description; }
    }

    enum Grade {
        VERY_GOOD, GOOD, BAD, VERY_BAD
    }

//    @Getter
//    @RequiredArgsConstructor
//    class Grade {
//        static final Grade VERY_GOOD = new Grade("VERY_GOOD");
//        static final Grade GOOD = new Grade("GOOD");
//        static final Grade BAD = new Grade("BAD");
//        static final Grade VERY_BAD = new Grade("VERY_BAD");
//
//        private final String description;
//    }

    class Unit {
        int x, y;
        Direction d;

        void init() {
            this.d = Direction.EAST;
        }
    }

    public static void main(String[] args) {
        Direction[] dArr = Direction.values();
        for (Direction d :
                dArr) {
            System.out.printf("%s = %d\n", d.name(), d.ordinal());
        }
    }
}
