package com.joaye.hixgo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

import com.joaye.hixgo.MyApplication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by xuyanjun on 15/10/31.
 */
public class SharedPreferencesUtils {

    private static final String FILE_NAME = "config";
    private static SharedPreferences sp;

    static {
        sp = MyApplication.getContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public static void setData(String key, Object object) {

        String type = object.getClass().getSimpleName();
        SharedPreferences.Editor editor = sp.edit();
        if ("String".equals(type)) {
            editor.putString(key, (String) object);
        } else if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) object);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) object);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) object);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) object);
        }

        editor.commit();
    }

    public static <T> T getData(String key, T defaultObj, Class<T> type) {
        String typeStr = type.getSimpleName();
        if ("String".equals(typeStr)) {
            return (T) sp.getString(key, (String) defaultObj);
        } else if ("Integer".equals(typeStr)) {
            return (T) Integer.valueOf(sp.getInt(key, (Integer) defaultObj));
        } else if ("Boolean".equals(typeStr)) {
            return (T) Boolean.valueOf(sp.getBoolean(key, (Boolean) defaultObj));
        } else if ("Float".equals(typeStr)) {
            return (T) Float.valueOf(sp.getFloat(key, (Float) defaultObj));
        } else if ("Long".equals(typeStr)) {
            return (T) Long.valueOf(sp.getLong(key, (Long) defaultObj));
        }
        return null;
    }

    /**
     * SharedPreferences保存对象
     *
     * @param key
     * @param object
     */
    public static void setObjectData(String key, Object object) {
        String objectBase64 = "";
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            objectBase64 = Base64.encodeToString(baos.toByteArray(),
                    Base64.DEFAULT);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, objectBase64);
        editor.commit();
    }

    /**
     * SharedPreferences取得对象
     *
     * @param key
     * @return
     */
    public static Object getObjectValue(String key) {
        Object object = null;
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            String objectBase64 = sp.getString(key, "");
            if (TextUtils.isEmpty(objectBase64)) {
                throw new NullPointerException("get an empty string accroding key" + key);
            }
            byte[] base64Bytes = Base64.decode(objectBase64.getBytes(),
                    Base64.DEFAULT);
            bais = new ByteArrayInputStream(base64Bytes);
            ois = new ObjectInputStream(bais);
            object = ois.readObject();
        } catch (Exception e) {// 发生异常情况下清空对应缓存
            removeKey(key);
        } finally {
            try {
                if (bais != null) {
                    bais.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    public static void removeKey(String key) {
        sp.edit().remove(key).commit();
    }

    public static boolean constainsKey(String key) {
        return sp.contains(key);
    }

}
