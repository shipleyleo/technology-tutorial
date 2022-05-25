package designPattern.creationalPatterns.singleton.extend;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 多例模式
 * </p>
 * <p>
 * Copyright:2022.All rights reserved.
 * </p>
 * <p>
 * Company:
 * </p>
 * <p>
 * CreateDate:2022/5/19
 * </p>
 *
 * @author shipleyleo
 * @history Mender:shipleyleo；Date:2022/5/19
 */
public class LazyMultition {
    private static final List<LazyMultition> list = new ArrayList<>();
    static final int n = 10;
    static {
        for (int i=0; i<n; i++) {
            list.add(new LazyMultition(i));
        }
    }

    private LazyMultition(int index) {
        System.out.println("懒汉式多例-" + index);
    }

    public static LazyMultition getRandomInstance() {
        int value = (int) (Math.random() * n);
        return list.get(value);
    }
}
