package org.example.base;

/**
 *  @author: paladin
 *  @date: created in 2020/6/28 22:13
 */
public class TestEnum {
    public static void main(String[] args) {
        System.out.println(AccountType.FIXED);
    }
}

enum AccountType{
    // 保存
    SAVING,
    // 修复
    FIXED,
    // 当前
    CURRENT;

    /**
     * 枚举类型的构造器会在每一个枚举值初始化的时候执行一次，并且构造器必须用private修饰
     */
    AccountType() {
        System.out.println("t is a account type");
    }
}
