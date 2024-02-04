package src.com.kk.furns.service;

import src.com.kk.furns.entity.Furn;

import java.util.List;

/**
 * @author KK
 * @version 1.0
 */
public interface FurnService {
    // 列出所有家居
    List<Furn> list();

    // 添加一个家居
    int add(Furn furn);

    // 根据 id 删除一个家居
    int deleteFurnById(int id);
}
