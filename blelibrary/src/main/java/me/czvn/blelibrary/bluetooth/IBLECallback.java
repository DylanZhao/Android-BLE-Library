package me.czvn.blelibrary.bluetooth;

/**
 * Created by andy on 2016/1/14.
 *
 */
public interface IBLECallback {
    /**
     * 连接成功
     */
    void onConnected();

    /**
     * 连接断开
     */
    void onDisconnected();

    /**
     * 此方法会在收到消息时调用
     * @param msg 收到的消息
     */
    void onMessageReceived(String msg);
}
