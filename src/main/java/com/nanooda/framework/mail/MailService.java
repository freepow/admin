package com.nanooda.framework.mail;

import com.nanooda.framework.crypto.SimpleCrypto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * 이메일 발송
 *
 * User: JAEGER
 * Date: 13. 8. 19
 * Time: 오후 1:00
 */
public class MailService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 이메일 전송 보내기
     *
     * @param receiveEmail
     * @param sendTitle
     * @param sendContent
     * @return
     */
    public boolean sendMail(String receiveEmail,
                            String sendTitle,
                            String sendContent) {
        // TODO : 향후에 외부 설정으로 빠져야 함.
        String smtpHost = "smtp.gmail.com";
        String smtpPort = "587";    // TLS 포트 번호
        String password = "nanooda07";




        String sendEmail = "nanoodamusic@nanooda.com";
        String sendPassword = "F7428BA29F72F88652B0957B90CC85DE";

        String charset = "UTF-8";

        boolean result = false;

        logger.warn("TLS 방식의 이메일 전송 시작 ");

        // TODO : GMAIL 2단계 인증 설정시 이메일 보내기 실패
        try {
            logger.warn("암호화 시작"+SimpleCrypto.encrypt(SimpleCrypto.seed, password));

            // TLS 방식으로 이메일 전송
            result = sendMailTLS(
                            smtpHost,
                            smtpPort,
                            sendEmail,
                            SimpleCrypto.decrypt(SimpleCrypto.seed, sendPassword),
                            receiveEmail,
                            sendTitle,
                            sendContent,
                            charset
                        );
            logger.debug("TLS 방식의 이메일 전송 결과 : " + result);

            // 이메일 전송 실패시 SSL 방식으로 이메일 전송
            if ( ! result) {
                smtpPort = "465";    // SSL 포트 번호

                result = sendMailSSL(
                                smtpHost,
                                smtpPort,
                                sendEmail,
                                SimpleCrypto.decrypt(SimpleCrypto.seed, sendPassword),
                                receiveEmail,
                                sendTitle,
                                sendContent,
                                charset
                            );
                logger.debug("SSL 방식의 이메일 전송 결과 : " + result);
            }
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    /**
     * SSL 방식의 이메일 보내기
     *
     * @param host
     * @param port
     * @param hostMailId
     * @param hostPassword
     * @param targetId
     * @param title
     * @param content
     * @param charset
     * @return
     */
    private boolean sendMailSSL(String host,
                                String port,
                                String hostMailId,
                                String hostPassword,
                                String targetId,
                                String title,
                                String content,
                                String charset) {
        boolean result = false;
        final String username = hostMailId;
        final String password = hostPassword;

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.port", port);

        Session session = Session.getDefaultInstance(
                                    props,
                                    new javax.mail.Authenticator() {
                                        protected PasswordAuthentication getPasswordAuthentication() {
                                            return new PasswordAuthentication(username, password);
                                        }
                                    }
                                );

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(targetId));
            message.setSubject(title);
            message.setText(content);
            message.setContent(content, "text/html; charset=" + charset);
            message.setHeader("Content-Transfer-Encoding", "quoted-printable");

            logger.debug("### SSL 메일 전송 시작");
            Transport.send(message);
            logger.debug("### SSL 메일 전송 종료");

            result = true;
        } catch (MessagingException e) {
            logger.error("이메일 전송(SSL 방식) 실패하였습니다.", e);
            return result;
        }

        return result;
    }

    /**
     * TLS 방식의 이메일 보내기
     *
     * @param host
     * @param port
     * @param hostMailId
     * @param hostPassword
     * @param targetId
     * @param title
     * @param content
     * @param charset
     * @return
     */
    private boolean sendMailTLS (String host,
                                 String port,
                                 String hostMailId,
                                 String hostPassword,
                                 String targetId,
                                 String title,
                                 String content,
                                 String charset)  {
        boolean result = false;
        final String username = hostMailId;
        final String password = hostPassword;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.port", port);

        Session session = Session.getDefaultInstance(
                props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                }
        );

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(targetId));
            message.setSubject(title);
            message.setText(content);
            message.setContent(content, "text/html; charset=" + charset);
            message.setHeader("Content-Transfer-Encoding", "quoted-printable");

            logger.debug("### TLS 메일 전송 시작");
            Transport.send(message);
            logger.debug("### TLS 메일 전송 종료");

            result = true;
        } catch (MessagingException e) {
            logger.error("이메일 전송(TLS 방식) 실패하였습니다.", e);
            return result;
        }

        return result;
    }

}