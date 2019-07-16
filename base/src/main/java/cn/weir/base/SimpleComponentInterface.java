package cn.weir.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;

/**
 * @author Weir.
 * @date 2019-07-10.
 */
public class SimpleComponentInterface {

    private static boolean isDebugMode = false;

    /**
     * 必须在[init]前调用，才有效果
     */
    public static void setDebugMode(boolean isDebug) {
        isDebugMode = isDebug;
    }

    /**
     * 框架初始化入口
     */
    public static void init(Application application) {
        //ARouter
        if (isDebugMode) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);

        //utilcode
        Utils.init(application);
        LogUtils.getConfig().setLogSwitch(isDebugMode).setStackDeep(2);
    }
}
