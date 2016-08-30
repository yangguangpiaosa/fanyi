package com.taozi.fanyi.support.utils.httpclient;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
	
	public static void main(String [] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://www.baidu.com");
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		// The underlying HTTP connection is still held by the response object
		// to allow the response content to be streamed directly from the network socket.
		// In order to ensure correct deallocation of system resources
		// the user MUST call CloseableHttpResponse#close() from a finally clause.
		// Please note that if response content is not fully consumed the underlying
		// connection cannot be safely re-used and will be shut down and discarded
		// by the connection manager. 
		try {
		    System.out.println(response1.getStatusLine());
		    HttpEntity entity1 = response1.getEntity();
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    InputStream in = null;
		    String result = null;
		    if (entity1 != null) {  
                entity1 = new BufferedHttpEntity(entity1);  
                in = entity1.getContent();  
                byte[] read = new byte[1024];  
                byte[] all = new byte[0];  
                int num;  
                while ((num = in.read(read)) > 0) {  
                    byte[] temp = new byte[all.length + num];  
                    System.arraycopy(all, 0, temp, 0, all.length);  
                    System.arraycopy(read, 0, temp, all.length, num);  
                    all = temp;  
                }  
                result = new String(all, "UTF-8");
            }
		    System.out.println(result);
		    
		    EntityUtils.consume(entity1);
		} finally {
		    response1.close();
		}

		/*HttpPost httpPost = new HttpPost("http://targethost/login");
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("username", "vip"));
		nvps.add(new BasicNameValuePair("password", "secret"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);

		try {
		    System.out.println(response2.getStatusLine());
		    HttpEntity entity2 = response2.getEntity();
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}*/
	}
	
}
