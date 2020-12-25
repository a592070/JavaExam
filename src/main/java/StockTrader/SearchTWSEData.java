package StockTrader;

/**
 * 0.導包
 * 1.爬TWSE股票https://mis.twse.com.tw/stock/api/getStockInfo.jsp?ex_ch={stock_id}&={time}\
 *              https://mis.twse.com.tw/stock/api/getStockInfo.jsp?ex_ch=tse_2330.tw&json=1&delay=0&_=1588269794900
 *   stock_id=股票編號  time=系統時間(每5秒更新一次)
 * 2.將上面的json資料解析:
 *      n = 公司名
 *      z = 最近成交價
 *      o = 開盤價格
 *      h = 盤中最高
 *      l = 盤中最低
 * 3.stock_id 輸入
 * 4.設計界面
 *
 * */


import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class SearchTWSEData {

    private static HttpURLConnection connection;

    public static void getRequest() throws Exception {
        try {
            SslUtils.ignoreSSL();
            URL url = new URL("https://mis.twse.com.tw/stock/api/getStockInfo.jsp?ex_ch=tse_2330.tw&json=1&delay=0&_=1588269794900");
            connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            System.out.println("Connected status: "+status);


        } catch(MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } /*finally{
            connection.disconnect();
        }*/
    }
    private int stockID(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public static void getJsonData() throws Exception {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while((line = reader.readLine())!=null){
            responseContent.append(line);
        }
        reader.close();
//        System.out.println(responseContent.toString());
        analyticJson(responseContent.toString());

    }
    public static void analyticJson(String responseBody){
        JSONObject jsonObject = new JSONObject(responseBody);

        String tmp = jsonObject.getJSONArray("msgArray").get(0).toString();
        /**將"msgArray"中的object抓出來*/
        JSONObject jsonObject1 =new JSONObject(tmp);

        System.out.println(jsonObject.getJSONArray("msgArray").get(0));

        /**"z"的位置就是目前價格 "o"是開盤價格*/
        System.out.println("目前成交價格:\t"+jsonObject1.get("z"));

//        Double nowPrice = Double.valueOf(jsonObject1.get("z").toString());
//        System.out.println("目前成交價格:\t"+nowPrice);


        Double openPrice = Double.valueOf(jsonObject1.get("o").toString());

        System.out.println("開盤價格:\t"+openPrice);

    }

    public static void main(String[] args) throws Exception {
//        getRequest();
//        getJsonData();
        Timer timer = new Timer();

        TimerTask task = new SampleTask();
        timer.schedule(task, 0, 5000);



    }
}

class SampleTask extends TimerTask {
    private HttpURLConnection connection;

    public void init() throws Exception{
        SslUtils.ignoreSSL();
        URL url = new URL("https://mis.twse.com.tw/stock/api/getStockInfo.jsp?ex_ch=tse_3008.tw");
        connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status = connection.getResponseCode();
        System.out.println("Connected status: "+status);
    }

    @Override
    public void run() {
        try {
            init();
            getJsonData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private int stockID(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public void getJsonData() throws Exception {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while((line = reader.readLine())!=null){
            responseContent.append(line);
        }
        reader.close();
//        System.out.println(responseContent.toString());
        analyticJson(responseContent.toString());

    }
    public void analyticJson(String responseBody){
        JSONObject jsonObject = new JSONObject(responseBody);

        String tmp = jsonObject.getJSONArray("msgArray").get(0).toString();
        /**將"msgArray"中的object抓出來*/
        JSONObject jsonObject1 =new JSONObject(tmp);

        System.out.println(jsonObject.getJSONArray("msgArray").get(0));

        /**"z"的位置就是目前價格 "o"是開盤價格*/
        System.out.println("目前成交價格:\t"+jsonObject1.get("z"));

//        Double nowPrice = Double.valueOf(jsonObject1.get("z").toString());
//        System.out.println("目前成交價格:\t"+nowPrice);


        Double openPrice = Double.valueOf(jsonObject1.get("o").toString());

        System.out.println("開盤價格:\t"+openPrice);
        System.out.println("當日最高:\t"+jsonObject1.get("h"));
        System.out.println("當日最低:\t"+jsonObject1.get("l"));

    }
}
