package com.ob.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author jc
 */
public class Util {
    
    public static void showMessageAndExit(String message) {
        Util.e(message);
        Util.i(App.MESSAGE_SALIENDO_SISTEMA);
        System.exit(1);
    }
    
    public static final void e(String message) {
        if(App.DEBUG){
            JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            System.out.println(message);
        }
    }

    public static final void i(String message) {
        System.out.println(message);
    }

    public static final boolean isNumeric(String num) {
        boolean ret = true;
        try {
            Double.parseDouble(num);
        } catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }

    public static final String formatNumber(Double valor) {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        return df.format(valor);
    }

    public static final String formatNumber(String valor) {
        try {
            return formatNumber(Double.parseDouble(valor));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static final boolean isFileshipAlreadyRunning() {
        try {
            final File file = new File("FileshipReserved");
            final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            final FileLock fileLock = randomAccessFile.getChannel().tryLock();
            if (fileLock != null) {
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    @Override
                    public void run() {
                        try {
                            fileLock.release();
                            randomAccessFile.close();
                            file.delete();
                        } catch (IOException e) {
                            Util.e(e.getMessage());
                            //log.error("Unable to remove lock file: " + lockFile, e);
                        }
                    }
                });
                return true;
            }
        } catch (IOException e) {
            Util.e(e.getMessage());
        }
        return false;
    }
    
    public static String getMD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
