package me.voler.classical.ticket.response;

import me.voler.classical.ticket.ssl.MyX509TrustManager;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Browser {

    /**
     * @param queryUrl 查询链接
     * @return XML格式的查询结果
     */
    public static String searchXML(String queryUrl) {

        StringBuffer buffer = new StringBuffer();

        try {

            URL url = new URL(queryUrl);
            //***********************************************
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setSSLSocketFactory(ssf);
            connection.setRequestMethod("GET");
            //***********************************************
            connection.connect();

            InputStream input = connection.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(input, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            String s;
            while ((s = bufferedReader.readLine()) != null) {
                buffer.append(s);
            }

            bufferedReader.close();
            streamReader.close();
            input.close();
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject json = JSONObject.fromObject(buffer.toString().replaceAll("\"", "\\\""));
        XMLSerializer serializer = new XMLSerializer();

        return serializer.write(json);

    }
}
