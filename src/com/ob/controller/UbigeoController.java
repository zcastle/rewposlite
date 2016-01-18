package com.ob.controller;

import com.ob.model.Departamento;
import com.ob.model.Provincia;
import com.ob.model.Ubigeo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UbigeoController extends Controller {

    public UbigeoController(Connection conn) {
        super(conn);
    }

    public List<Departamento> getDepartamentos() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        Departamento dep;
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT id, nombre FROM ubigeo WHERE co_provincia='00' AND co_distrito='00' ORDER BY nombre;");
        while (rs.next()) {
            int depId = rs.getInt("id");
            dep = new Departamento(depId, rs.getString("nombre"));
            //dep.setProvincias(getProvincias(depId));
            departamentos.add(dep);
        }
        return departamentos;
    }
    
    public List<Provincia> getProvincias(int dep) throws SQLException {
        List<Provincia> provincias = new ArrayList<>();
        Provincia pro;
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT U1.id, U1.nombre FROM ubigeo U1 \n" +
            "WHERE U1.co_departamento=(SELECT co_departamento FROM ubigeo WHERE id="+dep+")\n" +
            "AND U1.co_provincia!='00' AND U1.co_distrito='00' ORDER BY U1.nombre;");
        while (rs.next()) {
            int proId = rs.getInt("id");
            pro = new Provincia(rs.getInt("id"), rs.getString("nombre"));
            //pro.setUbigeo(getUbigeos(proId));
            provincias.add(pro);
        }
        return provincias;
    }
    
    public List<Ubigeo> getUbigeos(int pro) throws SQLException {
        List<Ubigeo> provincias = new ArrayList<>();
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT U1.id, U1.nombre FROM ubigeo U1 \n" +
            "WHERE U1.co_departamento=(SELECT co_departamento FROM ubigeo WHERE id="+pro+") \n" +
            "AND U1.co_provincia=(SELECT co_provincia FROM ubigeo WHERE id="+pro+") \n" +
            "AND U1.co_distrito!='00' ORDER BY U1.nombre;");
        while (rs.next()) {
            provincias.add(new Ubigeo(rs.getInt("id"), rs.getString("nombre")));
        }
        return provincias;
    }

}