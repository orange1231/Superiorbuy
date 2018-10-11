package com.cssl.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;

public class SendCode {

    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
    //获取验证码
    public int getCode(String telephone){

            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod(Url);

            client.getParams().setContentCharset("GBK");
            method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

            int mobile_code = (int)((Math.random()*9+1)*100000);

            String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

            NameValuePair[] data = {//提交短信
                    new NameValuePair("account", "C72007756"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
                    new NameValuePair("password", "c64634db7ed39c34d85dc12e4731f74e "),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                    //new NameValuePair("password", util.CodeUtil.MD5Encode("密码")),
                    //需要发送验证码的手机号
                    new NameValuePair("mobile", telephone),
                    new NameValuePair("content", content),
            };
            method.setRequestBody(data);

            try {
                client.executeMethod(method);

                String SubmitResult =method.getResponseBodyAsString();

                //System.out.println(SubmitResult);

                Document doc = DocumentHelper.parseText(SubmitResult);
                Element root = doc.getRootElement();

                String code = root.elementText("code");
                String msg = root.elementText("msg");
                String smsid = root.elementText("smsid");

                System.out.println(code);
                System.out.println(msg);
                System.out.println(smsid);
                System.out.println(mobile_code);

                if("2".equals(code)){
                    System.out.println("短信提交成功");

                }

            } catch (HttpException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (DocumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return mobile_code;




    }

}
