package shembull_seminar;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private List<String> items = new ArrayList<>();

    public void addItem(String item){
        if(item != null && !item.isEmpty()){
            items.add(item);
        }
    }

    public List<String> getItems(){
        return items;
    }
}
