package database;

import entity.Item;
import entity.User;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<User> users = new ArrayList<>();
    public static List<Item> items = new ArrayList<Item>();

    public void addUser(User user) {
        users.add(user);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item findItemById(int id) throws ItemNotFoundException {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new ItemNotFoundException("Such a product is not available in our stocks");
    }

    public List<Item> getAllItems() {
        return items;
    }


}
