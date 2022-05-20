package designPattern.creationalPatterns.singleton.extend;

import designPattern.creationalPatterns.singleton.HungrySingleton;
import designPattern.creationalPatterns.singleton.LazySingleton;

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
    protected static LazyMultition lazySingleton = LazyMultition.getRandomInstance();

    public static void main(String[] args) {
        System.out.println("多例模式测试：");
    }
}
