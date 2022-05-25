package designPattern.creationalPatterns.singleton;

/**
 * <p>
 * 懒汉式单例
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
public class LazySingleton {
    private static volatile LazySingleton instance = null;    //保证 instance 在所有线程中同步

    private LazySingleton() {
        System.out.println("懒汉式单例");
    }    //private 避免类在外部被实例化

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
