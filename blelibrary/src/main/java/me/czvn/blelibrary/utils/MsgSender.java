package me.czvn.blelibrary.utils;

/**
 * Created by andy on 2016/1/13.
 */
public final class MsgSender {
    private static final int DEFAULT_SIZE = 20;
    private ISender sender;


    public MsgSender(ISender sender) {
        this.sender = sender;
    }


    public void sendMessage(byte[] data) {
        sendMessage(data, DEFAULT_SIZE);
    }


    public void sendMessage(byte[] data, int size) {
        int length = data.length;
        int counter = length / size;
        int rest = length % size;
        byte[] buffer = new byte[size];
        byte[] rests = new byte[rest];

        sender.inputData(MsgCommonUtil.goBytes(length));
        for (int i = 0; i < counter; i++) {
            for (int j = 0; j < buffer.length; j++) {
                buffer[j] = data[i * size + j];
            }
            sender.inputData(buffer);
        }
        for (int i = 0; i < rests.length; i++) {
            rests[i] = data[i + counter * size];
        }
        sender.inputData(rests);
    }

    public interface ISender {
        void inputData(byte[] bytes);
    }
}
