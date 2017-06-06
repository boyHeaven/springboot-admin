package cn.com.yxb.springboot.utils;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.zip.GZIPInputStream;

/**
 * Created on 2017/6/6.
 * <p>
 * 公共http请求类.
 *
 * @author bin
 */
public class HttpUtil {

    // 连接池
    private final static HttpConnectionManager httpConnectionManager;
    // 读取超时
    private final static int SOCKET_TIMEOUT = 60000;
    // 连接超时
    private final static int CONNECTION_TIMEOUT = 60000;
    // 每个HOST的最大连接数量
    private final static int MAX_CONN_PRE_HOST = 20;
    // 连接池的最大连接数
    private final static int MAX_CONN = 60;

    static {
        httpConnectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = httpConnectionManager.getParams();
        params.setConnectionTimeout(CONNECTION_TIMEOUT);
        params.setSoTimeout(SOCKET_TIMEOUT);
        params.setDefaultMaxConnectionsPerHost(MAX_CONN_PRE_HOST);
        params.setMaxTotalConnections(MAX_CONN);
    }

    /**
     * 执行方法.
     *
     * @param method the method
     * @param isGzip the is gzip
     * @return string string
     */
    public static String doHttpRequest(HttpMethod method, boolean isGzip) {

        if (method == null) {
            return "";
        }

        HttpClient httpClient = new HttpClient(httpConnectionManager);

        BufferedReader in = null;
        String resultString = "";
        try {

            httpClient.executeMethod(method);

            // 如果设置了gzip格式则isGzip = true
            if (isGzip) {
                in = new BufferedReader(new InputStreamReader(new GZIPInputStream(
                        method.getResponseBodyAsStream()), "UTF-8"));
            } else {
                in = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
            }

            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            resultString = sb.toString();

        } catch (SocketTimeoutException e) {
            System.out.println("连接超时" + e.toString());
        } catch (HttpException e) {
            System.out.println("读取外部服务器数据失败" + e.toString());
        } catch (UnknownHostException e) {
            System.out.println("请求的主机地址无效" + e.toString());
        } catch (IOException e) {
            System.out.println("向外部接口发送数据失败" + e.toString());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            method.releaseConnection();
        }
        return resultString;

    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        getCityNameByLocation();
        System.out.println("++++++++++++++++++++通过经纬度获取城市名完成++++++++++++++");
//        getWeather();
        System.out.println("-----------获取天气信息完成--------------");
    }

    /**
     * Gets city name by location.
     */
    public static void getCityNameByLocation() {
        String url = "http://gc.ditu.aliyun.com/regeocoding";
        GetMethod getMethod = new GetMethod(url);
        HttpMethodParams httpMethodParams = new HttpMethodParams();
        httpMethodParams.setContentCharset("UTF-8");
//        httpMethodParams.setParameter();
        getMethod.setParams(httpMethodParams);

        NameValuePair[] data = new NameValuePair[]{
                new NameValuePair("l", "39.945462,119.604368"),
                new NameValuePair("type", "010")
        };

        getMethod.setQueryString(data);

        int i = 0;
        while (i < 1000) {
            String str = doHttpRequest(getMethod, false);
            System.out.println("++++++返回信息::::::i===" + i + "------" + str);
            i++;
        }
    }


    /**
     * The entry point of application.
     */
    public static void getWeather() {

        // 万年历mini Json
        String url = "http://wthrcdn.etouch.cn/weather_mini";
        // 万年历api XML
//            String url = "http://wthrcdn.etouch.cn/WeatherApi";
        // 中国气象 Json
//            String url = "http://www.weather.com.cn/data/cityinfo/101010100.html";
        // 中国气象 Json
//            String url = "http://www.weather.com.cn/data/sk/101010100.html";
        GetMethod getMethod = new GetMethod(url);
        HttpMethodParams httpMethodParams = new HttpMethodParams();
        httpMethodParams.setContentCharset("UTF-8");
//        httpMethodParams.setParameter();
        getMethod.setParams(httpMethodParams);

        NameValuePair[] data = new NameValuePair[]{
                new NameValuePair("city", "北京")
        };

        getMethod.setRequestHeader("Accept-Encoding", "gzip, deflate");
        getMethod.setQueryString(data);

        int i = 0;
        while (i < 1000) {
            String str = doHttpRequest(getMethod, true);
            System.out.println("++++++返回信息::::::+++++i===" + i + "------" + str);
            i++;
        }
    }

}
