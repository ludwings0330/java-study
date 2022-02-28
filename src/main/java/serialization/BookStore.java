package serialization;

import java.io.Serializable;

public class BookStore implements Serializable {
    private String address;
    private Book[] books;
}
