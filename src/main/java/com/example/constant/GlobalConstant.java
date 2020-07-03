package com.example.constant;

import java.util.Date;

/**
 * 全局常量配置
 */
public class GlobalConstant {

    public static final String STRING_EMPTY = "";

    public static final String DEFAULT_SEPARATOR = ",";
    public static final String[] DATE_PATTERNS = new String[]{"yyyy", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss"};
    public static final String FLASH_MESSAGE_ATTRIBUTE_NAME = "APP_FLASH_MESSAGE";

    public static String APP_BASE_PATH = null;//应用程序启动时赋值，后续只读
    public static Date APP_DEPLOY_TIME = null;//应用启动时间，后续只读

}
