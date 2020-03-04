package com.ldr.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * 项目名称：mybatis2
 * 类 名 称：IDUtils
 * 类 描 述：生成随机id
 * 创建时间：2020-03-03 17:19
 * 创 建 人：t4ki
 */

public class IDUtils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void test(){
        System.out.println(getId());
    }

}
