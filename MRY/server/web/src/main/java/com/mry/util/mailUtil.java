package com.mry.util;

import org.apache.commons.lang.StringUtils;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 发送邮件的测试程序
 *
 * @author lwq
 */
public class mailUtil {

    public static Map<String, Object> sendMail(String recipientEmail, String path) {
        try {
            // 配置发送邮件的环境属性
            final Properties props = new Properties();
        /*
         * 可用的属性： mail.store.protocol / mail.transport.protocol / mail.host /
         * mail.user / mail.from
         */
            // 表示SMTP发送邮件，需要进行身份验证
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.exmail.qq.com");
            // 发件人的账号
            props.put("mail.user", "info@uyidoctor.com");
            // 访问SMTP服务时需要提供的密码
            props.put("mail.password", "Sa756636");

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            InternetAddress form = new InternetAddress(
                    props.getProperty("mail.user"));
            message.setFrom(form);

            // 设置收件人
            InternetAddress to = new InternetAddress(recipientEmail);
            message.setRecipient(RecipientType.TO, to);

            // 设置抄送
//        InternetAddress cc = new InternetAddress("luo_aaaaa@yeah.net");
//        message.setRecipient(RecipientType.CC, cc);
            Date date1 = new Date();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            String str1 = sdf1.format(date1);

            // 设置邮件标题
            message.setSubject("健康图文报告" + str1);

            // 设置邮件的内容体
            message.setContent("尊敬的优医用户,这是您阶段健康图文报告,请查收(若有疑问 您可联系您的慢病管理师)：PDF下载地址:<a href='" + path + "'>下载PDF</a>", "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
        } catch (MessagingException e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "发送失败");
            return map;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", "发送成功");
        return map;
    }

    /**
     * 刷新服务包需要发送的邮件
     *
     * @param mailContent
     */
    public static void sendMailToRefreshCustomerServiceCount(String mailContent) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.exmail.qq.com");
            props.put("mail.user", "tech.support@uyidoctor.com");
            props.put("mail.password", "tech12345A");
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            Session mailSession = Session.getInstance(props, authenticator);
            MimeMessage message = new MimeMessage(mailSession);
            InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
            message.setFrom(form);
            InternetAddress[] addresses = {new InternetAddress("evan.li@uyidoctor.com"),new InternetAddress("rain.luo@uyidoctor.com")};
            message.setRecipients(RecipientType.TO, addresses);
            LocalDateTime now = LocalDateTime.now();
            message.setSubject("自动刷新用户服务次数---" + now.getYear() + "年" + now.getMonthValue() + "月" + now.getDayOfMonth() + "日");
            String ip = getExternalIp();
            mailContent = StringUtils.isNotBlank(ip) ? mailContent + "-----by：" + ip : mailContent;
            mailContent = "<h1>执行线程名：" + Thread.currentThread() + "</h1>" + mailContent;
            message.setContent(mailContent, "text/html;charset=UTF-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 刷新待办项目需要发送的邮件
     *
     * @param mailContent
     */
    public static void sendMailToRefreshExecutionStatus(String mailContent) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.exmail.qq.com");
            props.put("mail.user", "tech.support@uyidoctor.com");
            props.put("mail.password", "tech12345A");
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            Session mailSession = Session.getInstance(props, authenticator);
            MimeMessage message = new MimeMessage(mailSession);
            InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
            message.setFrom(form);
            InternetAddress[] addresses = {new InternetAddress("evan.li@uyidoctor.com"),new InternetAddress("rain.luo@uyidoctor.com")};
            message.setRecipients(RecipientType.TO, addresses);
            LocalDateTime now = LocalDateTime.now();
            message.setSubject("慢病管理师待办项目刷新---" + now.getYear() + "年" + now.getMonthValue() + "月" + now.getDayOfMonth() + "日");
            String ip = getExternalIp();
            mailContent = StringUtils.isNotBlank(ip) ? mailContent + "-----by：" + ip : mailContent;
            mailContent = "<h1>执行线程名：" + Thread.currentThread() + "</h1>" + mailContent;
            message.setContent(mailContent, "text/html;charset=UTF-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * AOl设备问题邮件
     *
     * @param mailContent
     */
    public static void sendMailToAolUpload(String mailContent) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.exmail.qq.com");
            props.put("mail.user", "tech.support@uyidoctor.com");
            props.put("mail.password", "tech12345A");
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            Session mailSession = Session.getInstance(props, authenticator);
            MimeMessage message = new MimeMessage(mailSession);
            InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
            message.setFrom(form);
            InternetAddress[] addresses = {new InternetAddress("evan.li@uyidoctor.com")};
            message.setRecipients(RecipientType.TO, addresses);
            LocalDateTime now = LocalDateTime.now();
            message.setSubject("Aol发生问题时间---" + now.getYear() + "年" + now.getMonthValue() + "月" + now.getDayOfMonth() + "日");
            String ip = getExternalIp();
            mailContent = StringUtils.isNotBlank(ip) ? mailContent + "-----by：" + ip : mailContent;
            mailContent = "<h1>执行线程名：" + Thread.currentThread() + "</h1>" + mailContent;
            message.setContent(mailContent, "text/html;charset=UTF-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }



    private static String getExternalIp() {
        BufferedReader in = null;
        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } catch (Exception e) {

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}


