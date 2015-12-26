package com.ob.util;

import com.ob.controller.PedidoController;
import com.ob.controller.ProductoController;
import com.ob.model.Cia;
import com.ob.model.Usuario;
import java.awt.Color;
import java.awt.Dimension;

public final class App {

    public static boolean ISROOT = false;
    public static boolean DEBUG = true;
    
    public static Double IGV = 0.0;
    public static Double SERVICIO = 0.0;
    public static Cia CIA = null;
    public static Usuario CAJERO = null;
    
    // CONSTANTES FINALES
    /*private static final int HOLO_BLUE_LIGHT = 0xff33b5e5;
    private static final int HOLO_BLUE_DARK = 0xff0099cc;
    private static final int HOLO_BLUE_BRIGHT = 0xff00ddff;
    private static final int HOLO_GREEN_LIGHT = 0xff99cc00;
    private static final int HOLO_GREEN_DARK = 0xff669900;
    private static final int HOLO_RED_LIGHT = 0xffff4444;
    private static final int HOLO_RED_DARK = 0xffcc0000;
    private static final int HOLO_PURPLE = 0xffaa66cc;
    private static final int HOLO_ORANGE_LIGHT = 0xffffbb33;
    private static final int HOLO_ORANGE_DARK = 0xffff8800;*/
    
    public static final Color COLOR_HOLO_BLUE_LIGHT = new Color(0xff33b5e5);
    public static final Color COLOR_HOLO_BLUE_DARK = new Color(0xff0099cc);
    public static final Color COLOR_HOLO_BLUE_BRIGHT = new Color(0xff00ddff);
    public static final Color COLOR_HOLO_GREEN_LIGHT = new Color(0xff99cc00);
    public static final Color COLOR_HOLO_GREEN_DARK = new Color(0xff669900);
    public static final Color COLOR_HOLO_RED_LIGHT = new Color(0xffff4444);
    public static final Color COLOR_HOLO_RED_DARK = new Color(0xffcc0000);
    public static final Color COLOR_HOLO_PURPLE = new Color(0xffaa66cc);
    public static final Color COLOR_HOLO_ORANGE_LIGHT = new Color(0xffffbb33);
    public static final Color COLOR_HOLO_ORANGE_DARK = new Color(0xffff8800);

    public static final Dimension FRMMAIN_DIMENSION = new Dimension(1024, 700);

    public static final String FORMAT_DATE = "dd/MM/yyyy";
    public static final String FORMAT_TIME = "hh:mm:ss";
    public static final String FORMAT_DATETIME = "dd/MM/yyyy HH:mm:ss";
    public static final String FORMAT_PRECIO = "0.00";
    // FIN

    // CONSTANTES TEXTOS
    public static final String MESSAGE_ERROR_INSTANCIA_CARGADA = "El sistema ya se encuentra en ejecucion";
    public static final String MESSAGE_ERROR_PROPERTIES = "No se puede cargar la configuracion de inicio";
    public static final String MESSAGE_ERROR_CLAVE = "Clave Incorrecta, intente de nuevo";
    public static final String MESSAGE_ERROR_DB = "Error al conectar a la Base de Datos";
    
    public static final String MESSAGE_CERRAR_SISTEMA = "Se cerrar el sistema, ¿Continuar?";
    public static final String MESSAGE_SALIENDO_SISTEMA = "Saliendo del sistema";

    public static final String TITULO_MESSAGE_DIALOG = "Mensaje de Sistema";
    // FIN

    // CONSTANTES LOG
    public static final String LOG_INFORMACION = "INF";
    public static final String LOG_ERROR = "ERR";
    // FIN
    
    public static PedidoController PEDIDO = null;
    
    // CONSTANTES OBJETOS DE SESION
    //public static Data DATA = null;
    
    public static ProductoController PRODUCTOS = null;
    // FIN
    
    //
    //public static Conn CONN = null;
}
