package com.aaron.mymvp.base.model;

/**
 * 数据请求标识类，定义了项目中所有的数据请求。
 */

/**
 * 由于DataModel使用反射机制获取对应Model的引用，所以Token中存的就应该是对应Model的包名+类名
 */

/**
 * token其实就是描述某个model类“包名+类名”的字符串，
 * 有了它我们就可以得到这个类对应的class对象，从而实例化出对象：
 * model = (BaseModel)Class.forName(token).newInstance(); // 使用token实例化对象
 */
public class Token {
    // 包名
    private static final String PACKAGE_NAME = "com.aaron.mymvp.model.";

    // 具体Model
    public static final String API_MVP_DATA = PACKAGE_NAME + "MainModel";
}
