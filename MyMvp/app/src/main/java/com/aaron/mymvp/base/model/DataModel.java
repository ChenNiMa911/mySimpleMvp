package com.aaron.mymvp.base.model;

/**
 * 数据层顶级入口，
 * 项目中所有数据都由该类流入和流出，负责分发所有的请求数据。
 */

/**
 * 由于DataModel负责数据请求的分发，
 * 所以最初打算作成一个简单工厂模式的样子，通过switch(token)语句判断要调用的Model。
 *
 * 但如果这样设计的话，在实际开发中我们每次添加一个数据请求接口，
 * 不光需要新建对应的Model和Token，还需要在DataModel类的switch(token)语句中新增加对应的判断，贼麻烦~
 *
 * 思来想去，我觉得利用反射机制会是一个比较理想的办法，
 * 请求数据时以具体Model的包名+类型作为Token，利用反射机制直接找到对应的Model。
 */

/**
 * token由于存在限制
 * 例如当我们给一个已经登记在Token中的Model类改了名字，必须同时去Token中更新手动一下对应的字符串。
 * 直接跳过token解析这一步，直接传递class对象
 */
public class DataModel {
    public static BaseModel request(Class clazz) {
        // 声明一个空的BaseModel
        BaseModel model = null;

        try {
            //利用反射机制获得对应Model对象的引用
            model = (BaseModel) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}
