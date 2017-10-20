package cn.cibn.hostlibrary;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by 15210 on 2017/10/19.
 */

public class HostClass {
    private Object instance;// 反射形式创建的全局变量
    private File file;//获取jar文件
    private File dexOutputDir;
    private DexClassLoader classLoader;
    private Class PlugClass;
    private Method method;
    private Context context;
    private static HostClass hostClass = null;

    private HostClass(Context context){
        this.context = context;
    }

    public static HostClass getInstance(Context context) {
        if (hostClass==null) {
            hostClass = new HostClass(context.getApplicationContext());
        }
        return hostClass;
    }

    public void loadCibnSdk(){
        try {

        } catch (Exception exception) {
            // Handle exception gracefully here.
            exception.printStackTrace();
        }
    }

    public void showLog(){
        try {
            file = new File(Environment
                    .getExternalStorageDirectory().toString()
                    + File.separator
                    + "plug.jar");
            dexOutputDir = context.getDir("dex", 0);
            classLoader = new DexClassLoader(file.getAbsolutePath(),
                    dexOutputDir.getAbsolutePath(), null, context.getClassLoader());
            PlugClass = classLoader.loadClass("cn.cibn.pluglibrary.PlugClass");
            instance = PlugClass.newInstance();
            method = PlugClass.getMethod("plugLog", new Class[0]);
            method.invoke(instance, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
