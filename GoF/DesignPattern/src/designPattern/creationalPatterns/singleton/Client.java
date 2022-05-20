package designPattern.creationalPatterns.singleton;

/**
 * <p>
 * 客户端
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
public class Client {
    protected static HungrySingleton hungrySingleton = HungrySingleton.getInstance();
    protected static LazySingleton lazySingleton = LazySingleton.getInstance();

    public static void main(String[] args) {
        System.out.println("单例模式测试：");
    }
}
