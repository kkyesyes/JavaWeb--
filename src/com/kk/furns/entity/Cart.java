package src.com.kk.furns.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * 购物车，包含多个 CartItem
 * @author KK
 * @version 1.0
 */
public class Cart {
    private HashMap<Integer, CartItem> items = new HashMap<>();

    public Integer getTotalCount() {
        int totalCount = 0;
        for (Integer i : items.keySet()) {
            totalCount += items.get(i).getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalCount = new BigDecimal("0");
        for (Integer i : items.keySet()) {
            totalCount.add(items.get(i).getTotalPrice());
        }
        return totalCount;
    }

//    public List<Furn> getItems() {
//
//    }

    /**
     * 购物车中添加一项 CartItem
     * @param cartItem
     */
    public void add(CartItem cartItem) {
        if (!items.containsKey(cartItem.getId())) {
            items.put(cartItem.getId(), cartItem);
            return;
        }
        CartItem item = items.get(cartItem.getId());
        item.setCount(item.getCount() + 1);
        item.setTotalPrice(item.getTotalPrice().add(item.getPrice()));
    }

    /**
     * 购物车中删除一项 CartItem
     * @param id 将要删除的家居的 id
     */
    public void deleteOne(Integer id) {
        if (!items.containsKey(id)) {
            return;
        }
        if (items.get(id).getCount() == 1) {
            items.remove(id);
            return;
        }
        items.replace(id, new CartItem(items.get(id).getId(), items.get(id).getName(), items.get(id).getPrice(), items.get(id).getCount() - 1, items.get(id).getTotalPrice().subtract(items.get(id).getPrice())));

    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
