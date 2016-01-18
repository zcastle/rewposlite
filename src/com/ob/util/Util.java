package com.ob.util;

import com.ob.view.FrmContainer;
import com.ob.view.panel.PnlProducto;
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
        e(message, "ERROR");
    }

    public static final void e(String message, String titulo) {
        if (App.DEBUG) {
            JOptionPane.showMessageDialog(null, message, titulo, JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println(message);
        }
    }

    public static final void i(int message) {
        i(message + "");
    }

    public static void i(Double message) {
        i(message + "");
    }

    public static final void i(String message) {
        System.out.println(message);
    }

    public static final void msg(String message) {
        msg(message, App.MESSAGE_DIALOG_TITLE);
    }

    public static final void msg(String message, String titulo) {
        JOptionPane.showMessageDialog(null, message, titulo, JOptionPane.INFORMATION_MESSAGE);
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
        return App.FORMAT_PRECIO.format(valor);
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
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static void changeCard(JPanel panel, String card) {
        ((CardLayout) panel.getLayout()).show(panel, card);
        if (card.equalsIgnoreCase("Producto")) {
            PnlProducto.getTxtBuscar().grabFocus();
        }
    }

    public static String query(String query) {
        if (App.DEBUG) {
            Util.i(query);
        }
        return query;
    }
    
    public static final String left(String text, int v) {
        return text.concat(Util.repite(" ", v)).substring(0, v);
    }
    
    public static final String left(String text, int v, String c) {
        return text.concat(Util.repite(c, v)).substring(0, v);
    }

    public static final String right(String text, int v) {
        String cadena = Util.repite(" ", v).concat(text);
        return cadena.substring(cadena.length() - v);
    }
    
    public static final String right(String text, int v, String c) {
        String cadena = Util.repite(c, v).concat(text);
        return cadena.substring(cadena.length() - v);
    }

    public static final String repite(String str, int num) {
        int len = num * str.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
