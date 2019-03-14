import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

public class LetvCASAgent implements Filter {

    private static String LETV_SSO_TRANSCODE_API_URL = "https://t.fsyuncai.com";
    private static String LETV_SSO_PORTAL_APP_SITE = "repository";
    private static String LETV_SSO_PORTAL_APP_KEY = "XXXXXX";

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String mtk = "";
        HttpServletRequest request = (HttpServletRequest) req;
        String cookieStr = request.getHeader("cookie");//得到认证中心的cookie
        String[] cookies = cookieStr.split(";");
        if (cookies != null) {
            for (String cookie : cookies) {
                if (cookie != null) {
                    cookie = cookie.trim();
                    if (cookie.startsWith("m_tk")) {
                        mtk = cookie.substring("m_tk=".length());//找到以m_tk开头的cookie 就把他后面的字符串给截取下来

                    }
                }
            }
        }
        Properties prop = new Properties();
        prop.setProperty("SSO_API", LETV_SSO_TRANSCODE_API_URL);
        prop.setProperty("SSO_KEY", LETV_SSO_PORTAL_APP_KEY);
        prop.setProperty("SSO_SITE", LETV_SSO_PORTAL_APP_SITE);
        //进行重新编码
        String userid = decode(mtk, prop);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    private static String decode(String mtk, Properties prop) {
        try {
            String param = "site=" + prop.getProperty("SSO_SITE", "portal")
                    + "&time=" + System.currentTimeMillis() / 1000
                    + "&type=DECODE&v=";
            String url = prop.getProperty("SSO_API", "") + "?" + param
                    + URLEncoder.encode(mtk, "utf-8") + "&sign="
                    + getMD5(param + mtk + prop.getProperty("SSO_KEY", ""));
            String json = invokeService(url);
            JSONObject result = new JSONObject(json);
            JSONObject repond = result.getJSONObject("respond");
            String status = repond.getString("status");
            if ("1".equals(status)) {
                String objects = result.getString("objects");
                int begin = objects.indexOf("&u=") + 3;
                int end = objects.indexOf("&time=");
                return objects.substring(begin, end);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getMD5(String key) {//得到MD5编码
        StringBuffer buffer = new StringBuffer();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(key.getBytes("UTF-8"));
            for (byte b : digest.digest()) {
                buffer.append(String.format("%02x", b & 0xff));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    private static String invokeService(String spec) {//调用服务 获取网页转为utf——8的形式
        StringBuffer buffer = new StringBuffer();
        try {
            //从Internet 获取网页
            URL url = new URL(spec);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    in, "utf-8"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            in.close();
            reader.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

}
