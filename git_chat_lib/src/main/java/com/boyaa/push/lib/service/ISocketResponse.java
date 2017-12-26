package com.boyaa.push.lib.service;



/**
 * socket回调
 * @author DexYang
 *
 */
public interface ISocketResponse 
{
	void onConnectStatus(int status);
	void onSocketResponse(String txt);

}
