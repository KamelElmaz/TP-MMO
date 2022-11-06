import java.util.ArrayList;
import java.util.List;

public class SaveVie {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento getLast(){
        return mementoList.get(mementoList.size() - 1);
    }
}
