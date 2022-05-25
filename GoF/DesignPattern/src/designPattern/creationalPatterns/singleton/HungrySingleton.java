package designPattern.creationalPatterns.singleton;

/**
 * <p>
 * 饿汉式单例
 * </p>
 * <p>
 * Copyright:2022.All rights reserved.
 * </p>
 * <p>
 * Company:Zsoft
 * </p>
 * <p>
 * CreateDate:2022/5/19
 * </p>
 *
 * @author shipleyleo
 * @history Mender:shipleyleo；Date:2022/5/19
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
        System.out.println("饿汉式单例");
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}