# 简介
这是一个的SpringBoot与Mybatis整合工程。
本工程只为实现基本流程工程，并没有考虑其他方便：
如：安全，事务等！

一、单数据源
    1、需要解开对应的MyApplication中的对应注解
    2、需要直接配置对应的文件夹目录即可
二、多数据源
    1、需要解开对应的MyApplication中的对应注解
    2、需要配置各个数据源的对应basePackages
        如：mapper1，mapper2