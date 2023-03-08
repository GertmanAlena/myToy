package GroupIterator;

import java.util.Iterator;
import java.util.List;

public class GroupIterator<Toy> implements Iterator<Toy> {

    private List<Toy> toysList;
    private int index = 0;
    public GroupIterator(List<Toy> toysList) {
    }

    @Override
    public boolean hasNext() {
        return index < toysList.size();
    }

    @Override
    public Toy next() {
        return toysList.get(index++);
    }
}
