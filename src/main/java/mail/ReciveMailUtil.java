package mail;

import com.sun.mail.imap.IMAPFolder;
import file.DateUtil;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.search.SearchTerm;
import java.io.*;
import java.util.Date;
import java.util.Properties;

/**
 * Created by wangyanlong on 2017/4/6.
 */
public class ReciveMailUtil {
    private StringBuffer bodytext = new StringBuffer();//存放邮件内容

    private ReciveMailUtil() {
    }

    private static ReciveMailUtil reciveMailUtil;


    /**
     * @return ReciveMailUtil
     */
    public static ReciveMailUtil getInstance() {
        if (reciveMailUtil == null) {
            synchronized (ReciveMailUtil.class) {
                if (reciveMailUtil == null) {
                    reciveMailUtil = new ReciveMailUtil();
                }
            }
        }
        return reciveMailUtil;
    }

    /**
     * 解析邮件，把得到的邮件内容保存到一个StringBuffer对象中，解析邮件 主要是根据MimeType类型的不同执行不同的操作，一步一步的解析
     */
    public void getMailContent(Part part, ReceiveMail reciveMail) throws Exception {
        String contenttype = part.getContentType();
        int nameindex = contenttype.indexOf("name");
        boolean conname = false;
        if (nameindex != -1)
            conname = true;
        System.out.println("CONTENTTYPE: " + contenttype);
        if (part.isMimeType("text/plain") && !conname) {
            bodytext.append((String) part.getContent());
            reciveMail.setBodytext(bodytext);
        } else if (part.isMimeType("text/html") && !conname) {
            bodytext.append((String) part.getContent());
            reciveMail.setBodytext(bodytext);
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int counts = multipart.getCount();
            for (int i = 0; i < counts; i++) {
                getMailContent(multipart.getBodyPart(i), reciveMail);
            }
        } else if (part.isMimeType("message/rfc822")) {
            getMailContent((Part) part.getContent(), reciveMail);
        }
    }


    /**
     * 判断此邮件是否包含附件
     */
    public boolean isContainAttach(Part part) throws Exception {
        boolean attachflag = false;
        String contentType = part.getContentType();
        if (part.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) part.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                BodyPart mpart = mp.getBodyPart(i);
                String disposition = mpart.getDisposition();
                if ((disposition != null)
                        && ((disposition.equals(Part.ATTACHMENT)) || (disposition
                        .equals(Part.INLINE))))
                    attachflag = true;
                else if (mpart.isMimeType("multipart/*")) {
                    attachflag = isContainAttach((Part) mpart);
                } else {
                    String contype = mpart.getContentType();
                    if (contype.toLowerCase().contains("application"))
                        attachflag = true;
                    if (contype.toLowerCase().contains("name"))
                        attachflag = true;
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            attachflag = isContainAttach((Part) part.getContent());
        }
        return attachflag;
    }

    /**
     * 【保存附件】
     */
    public void saveAttachMent(Part part, ReceiveMail reciveMail) throws Exception {
        String fileName = "";
        if (part.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) part.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                BodyPart mpart = mp.getBodyPart(i);
                String disposition = mpart.getDisposition();
                if ((disposition != null)
                        && ((disposition.equals(Part.ATTACHMENT)) || (disposition
                        .equals(Part.INLINE)))) {
                    fileName = mpart.getFileName();
                    if (fileName != null && fileName.toLowerCase().contains("gb")) {
                        fileName = MimeUtility.decodeText(fileName);
                    }
                    saveFile(fileName, mpart.getInputStream(), reciveMail);
                } else if (mpart.isMimeType("multipart/*")) {
                    saveAttachMent(mpart, reciveMail);
                } else {
                    fileName = mpart.getFileName();
                    if (fileName != null) {
                        if (fileName.toLowerCase().contains("GB")) {
                            fileName = MimeUtility.decodeText(fileName);
                            saveFile(fileName, mpart.getInputStream(), reciveMail);
                        }
                    }

                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            saveAttachMent((Part) part.getContent(), reciveMail);
        }
    }

    /**
     * 【真正的保存附件到指定目录里】
     */
    private void saveFile(String fileName, InputStream in, ReceiveMail reciveMail) throws Exception {
        String osName = System.getProperty("os.name");
        String storedir = reciveMail.getAttachPath();
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
        File storefile = new File(storedir + separator + fileName);
        System.out.println("storefile's path: " + storefile.toString());
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


    public static void reciveMail(ReceiveMail pmm, String fileSavePath) throws Exception {
        Properties props = System.getProperties();
            /*
             *props.put("mail.smtp.host", pmm.getHost());//收件不需要这个
            */
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        URLName urln = new URLName("pop3", pmm.getPopHost(), pmm.getPort(), pmm.getFile(), pmm.getUsername(), pmm.getPassword());
        Store store = session.getStore(urln);
        store.connect();
        Folder folder = store.getFolder("INBOX");
        //判断邮件是否是当天的邮件
        SearchTerm searchTerm = new SearchTerm() {
            @Override
            public boolean match(Message message) {
                String nowTime = DateUtil.getNowTime(DateUtil.DAY_PATTERN);
                String receiveTime = null;
                try {
                    Date sentDate = message.getSentDate();
                    if (sentDate == null) return false;
                    receiveTime = DateUtil.dateFormat(sentDate, DateUtil.DAY_PATTERN);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return nowTime.equals(receiveTime);
            }
        };
        Message message[] = null;
        if (folder != null) {
            folder.open(Folder.READ_ONLY);
            message = folder.search(searchTerm);
        }
        System.out.println("Messages's length: " + message.length);
        for (int i = 0; i < message.length; i++) {
            System.out.println("==========第" + (i + 1) + "份邮件============");
            pmm = new ReceiveMail((MimeMessage) message[i]);
//            boolean aNew = pmm.isNew();
            String messageId = pmm.getMessageId();
            System.out.println(messageId);
            // 获得邮件内容===============
            getInstance().getMailContent((Part) message[i], pmm);
            pmm.setAttachPath(fileSavePath);
            getInstance().saveAttachMent((Part) message[i], pmm);
        }
    }

    /**
     * PraseMimeMessage类测试
     */
    public static void main(String args[]) throws Exception {
        ReceiveMail pmm = new ReceiveMail();
        String popHost = "pop.163.com";
        int port = 110;//端口
        String file = null;
        String username = "wly_whhao@163.com";
        String password = "wly163sqm";


        pmm.setPopHost(popHost);
        pmm.setPort(port);
        pmm.setFile(file);
        pmm.setUsername(username);
        pmm.setPassword(password);
        reciveMail(pmm, "e:\\");//记得设置文件保存路径
    }
}
