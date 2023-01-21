package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private double totalCartCost;

    public void addToCart(CartItem item) {
        for (CartItem cartItem : items) {
            if (item.getItem().equals(cartItem.getItem())) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                calculateTotalCartCost();
                return;
            }
        }
        items.add(item);
        calculateTotalCartCost();
    }

    public void calculateTotalCartCost() {
        this.totalCartCost = 0;
        for (CartItem cartItem : items) {
            totalCartCost += cartItem.getQuantity() * cartItem.getItem().getPrice();
        }
    }

    public void emptyCart() {
        this.items.clear();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getTotalCartCost() {
        return totalCartCost;
    }

    public void setTotalCartCost(double totalCartCost) {
        this.totalCartCost = totalCartCost;
    }
}
