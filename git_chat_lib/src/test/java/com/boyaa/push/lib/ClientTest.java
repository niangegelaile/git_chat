package com.boyaa.push.lib;

import com.boyaa.push.lib.service.Client;
import com.boyaa.push.lib.service.ISocketResponse;
import com.boyaa.push.lib.service.Packet;

import org.junit.Test;

/**
 * Created by ange on 2017/12/26.
 */

public class ClientTest {
    @Test
    public void test(){
        Client client=new Client(null, new ISocketResponse() {
            @Override
            public void onConnectStatus(int status) {
                switch (status){
                    case Client.STATE_CLOSE:
                        System.out.println("socket关闭");
                        break;
                    case Client.STATE_CONNECT_FAILED:
                        System.out.println("socket连接失败");
                        break;
                    case Client.STATE_CONNECT_SUCCESS:
                        System.out.println("socket连接成功");
                        break;
                }
            }

            @Override
            public void onSocketResponse(String txt) {
                System.out.println(Thread.currentThread().getName()+":"+txt);
            }
        });

        client.open("112.74.20.198",8800);
        Packet packet=new Packet();
        packet.pack("*SK,6914,002,GJ:90,22.560169,114.024626,80,100#");
        client.send(packet);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
    @Test
    public void test100(){
        for (int i=0;i<1000;i++){
            test();
        }
    }

    public static  void main(String[] s){
        Client client=new Client(null, new ISocketResponse() {
            @Override
            public void onConnectStatus(int status) {
                switch (status){
                    case Client.STATE_CLOSE:
                        System.out.println("socket关闭");
                        break;
                    case Client.STATE_CONNECT_FAILED:
                        System.out.println("socket连接失败");
                        break;
                    case Client.STATE_CONNECT_SUCCESS:
                        System.out.println("socket连接成功");
                        break;
                }
            }

            @Override
            public void onSocketResponse(String txt) {
                System.out.println(Thread.currentThread().getName()+":"+txt);
            }
        });

        client.open("112.74.20.198",8800);
        Packet packet=new Packet();
        packet.pack("*SK,6914,002,GJ:90,22.560169,114.024626,80,100#");
        client.send(packet);
    }
}
