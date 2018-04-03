package task1.model;

import java.util.Comparator;
import task1.entity.Book;

public class BookPublisherComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return ((Book)o1).getPublisher().compareTo(
               ((Book)o2).getPublisher()
        );
    }
}
