package com.ob.ticket;

import com.ob.util.App;
import com.ob.util.Util;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ob.lib.ESCPOSPrinter;

public class Precuenta extends Ticket implements TicketInterface {
    public static boolean CABECERA;

    public Precuenta(String printer, Cabecera cabecera, List<Detalle> detalle) {
        super(printer, cabecera, detalle);
    }

    @Override
    public boolean print() {
        try {
            ESCPOSPrinter print = new ESCPOSPrinter(printer);

            print.setFont(ESCPOSPrinter.FONT_B);
            print.setCenter(true);
            print.println("----------------------------------------");
            print.setDoubleHeight(true);
            print.println("P R E C U E N T A");
            print.setDoubleHeight(false);
            print.setFont(ESCPOSPrinter.FONT_B);
            print.println("Comprobante no autorizado");
            print.setCenter(false);
            print.println("----------------------------------------");
            DateFormat dateFormat = new SimpleDateFormat(App.FORMAT_DATETIME);
            Date date = cabecera.getFechaHora();
            print.println("FECHA : ".concat(dateFormat.format(date)));
            print.println("MESA  : ".concat(cabecera.getMesa()+""));
            print.println("CAJERO: ".concat(cabecera.getCajero()));
            //print.println("MOZO  : ".concat(cabecera.getMozo()));
            print.println("----------------------------------------");
            print.println("CANT PRODUCTO            UNIT. TOTAL S/.");
            print.println("----------------------------------------");
            Double total = 0.0;
            for (Detalle fila : detalle) {
                print.print(Util.left(fila.getCantidad().intValue() + "", 4));
                print.print(Util.left(fila.getProducto(), 17));
                print.print(Util.right(Util.formatNumber(fila.getUnitario()), 9));
                print.println(Util.right(Util.formatNumber(fila.getTotal()), 10));
                total += fila.getTotal();
            }
            print.println("----------------------------------------");
            print.setDoubleHeight(true);
            print.print("TOTAL                 S/.     ");
            print.println(Util.right(Util.formatNumber(total), 10));
            print.setDoubleHeight(false);
            print.setFont(ESCPOSPrinter.FONT_B);
            print.feed(1);
            print.println("RUC:------------------------------------");
            print.feed(1);
            print.println("RAZON SOCIAL:---------------------------");
            print.feed(1);
            print.println("----------------------------------------");
            print.feed(1);
            print.setCenter(true);
            print.println(cabecera.getDespedida());
            print.setCenter(false);
            print.cut();
            return print.send();
        } catch (UnknownHostException ex) {
            Util.i(ex.getMessage());
            Util.i("No se pudo imprimir en: " + printer);
            return false;
        } catch (IOException ex) {
            Util.i(ex.getMessage());
            Util.i("No se pudo imprimir en: " + printer);
            return false;
        }
    }
}
