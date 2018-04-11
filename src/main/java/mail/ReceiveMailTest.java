package mail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.MimeUtility;
import javax.mail.search.SearchTerm;
import java.io.*;
import java.security.GeneralSecurityException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static javax.mail.Flags.Flag.SEEN;

public class ReceiveMailTest {
    public static void main(String[] arg) throws GeneralSecurityException, MessagingException {
        String protocol = "imap";
        String host = "imap.exmail.qq.com";
        int port = 993;
        String username = "*****@****.cn";
        String password = "****";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", "smtp.exmail.qq.com");
        prop.put("mail.smtp.auth", "true");
        //开启ssl
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.imap.ssl.enable", "true");
//        prop.setProperty("mail.transport.protocol", protocol);
        //服务器
        prop.setProperty("mail.smtp.host", host);
        //端口
        prop.setProperty("mail.smtp.port", String.valueOf(port));
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.socketFactory", sf);
        Session session = Session.getDefaultInstance(prop, null);
        // MimeMessage message = new MimeMessage(instance);

        URLName urln =
                new URLName(protocol, host, port, null, username, password);
//        session.setDebug(true);
        Store store = session.getStore(urln);
        store.connect();
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_WRITE);

        SearchTerm term = new SearchTerm() {
            @Override
            public boolean match(Message message) {
                try {
                    System.out.println(message.getSentDate());
                    System.out.println(message);
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//                    Date parse = sdf.parse("20171218", new ParsePosition(0));
//                    if (!parse.before(message.getSentDate())){
//                        return false;
//                    }
//                    Flags flags = message.getFlags();
//                    Flags.Flag[] systemFlags = flags.getSystemFlags();
//                    System.out.println(MimeUtility.decodeText(message.getSubject()));
//                    System.out.println(Arrays.toString(systemFlags));
//                    for (Flags.Flag systemFlag : systemFlags) {
//                        if (Flags.Flag.SEEN.equals(systemFlag)) {
//                            System.out.println("===================seen");
//                            System.out.println(MimeUtility.decodeText(message.getSubject()));
//                        } else if (Flags.Flag.RECENT.equals(systemFlag)) {
//                            System.out.println("\n\n\n\n\n\n\n\n\n\nrecent\n\n\n\n\n\n\n\n\n");
//                            System.out.println(MimeUtility.decodeText(message.getSubject()));
//                        }else if (!(Flags.Flag.SEEN.equals(systemFlag))){
//                            System.out.println("\n\n\n\n\n\n\n\n\n\nNot Seen\n\n\n\n\n\n\n\n\n");
//                            System.out.println(MimeUtility.decodeText(message.getSubject()));
//                        }else {
//                            System.out.println("======================other");
//                            System.out.println(MimeUtility.decodeText(message.getSubject()));
//                        }
//                    }
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
//                catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
                return false;
            }
        };
        int messageCount = folder.getMessageCount();
        Message[] messages1 = folder.getMessages(messageCount-50,messageCount);
        Message[] messages = folder.search(term,messages1);
        List<Message> messageList = Arrays.asList(messages);
        Stream<Message> stream = messageList.stream();

        //判断邮件是否是新邮件
        Predicate<? super Message> isMailNew = (Message message) -> {
            boolean isnew = true;
            Flags flags = null;
            try {
                flags = message.getFlags();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            Flags.Flag[] systemFlags = new Flags.Flag[0];
            if (flags != null) {
                systemFlags = flags.getSystemFlags();
            }
            findNew:
            {
                for (Flags.Flag systemFlag : systemFlags) {
                    if (Flags.Flag.SEEN.equals(systemFlag)) {
                        isnew = false;
                        break findNew;
                    }
                }
            }
            return isnew;
        };
        //判断是否是mutipart的
        Predicate<? super Message> isMutipartMail = message -> {
            try {
                try {
                    message.setFlag(SEEN, true);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return message.isMimeType("multipart/*");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return false;
        };
        //判断邮件主题是否正确
        Predicate<? super Message> confirmName = message -> {
            try {
                String subject = message.getSubject();
                System.out.println(subject);
                if (subject != null) {
                    subject = MimeUtility.decodeText(subject);
                }
                if (subject.startsWith("dxt") || subject.startsWith("迪信通")) return true;
            } catch (MessagingException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return false;
        };
        stream.filter(isMailNew)
                .

                        filter(isMutipartMail)
                .

                        filter(confirmName)
                .

                        forEach((Message message) ->

                        {
                            try {
                                Multipart content = (Multipart) message.getContent();
                                int count = content.getCount();
                                String fileName = "";
                                for (int i = 0; i < count; i++) {
                                    BodyPart bodyPart = content.getBodyPart(i);
                                    String disposition = bodyPart.getDisposition();
                                    if (Part.ATTACHMENT.equals(disposition) || Part.INLINE.equals(disposition)) {
                                        fileName = bodyPart.getFileName();
                                        if (fileName != null && fileName.toLowerCase().contains("gb")) {
                                            fileName = MimeUtility.decodeText(fileName);
                                            saveFile(fileName, bodyPart.getInputStream(), "D:/email");
                                            message.setFlag(SEEN, true);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
    }


    private static void saveFile(String fileName, InputStream in, String saveAttachPath) throws Exception {
        String osName = System.getProperty("os.name");
        String storedir = saveAttachPath;
        String separator = "";
        if (osName == null)
            osName = "";
        if (osName.toLowerCase().contains("win")) {
            separator = "\\";
            if (storedir == null || storedir.equals(""))
                storedir = "c:\\tmp";
        } else {
            separator = "/";
            storedir = "/tmp";
        }
        File parent = new File(saveAttachPath);
        if (!parent.exists()) {
            if (!parent.mkdir()) throw new RuntimeException("文件路径不存在");
        }
        File storefile = new File(storedir + separator + fileName);
        for (int i = 0; storefile.exists(); i++) {
            storefile = new File(storedir + separator + fileName + i);
        }
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(storefile));
            bis = new BufferedInputStream(in);
            int c;
            while ((c = bis.read()) != -1) {
                bos.write(c);
                bos.flush();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new Exception("文件保存失败!");
        } finally {
            if (bos != null) {
                bos.close();
            }
            if (bis != null) {
                bis.close();
            }
        }
    }
}
