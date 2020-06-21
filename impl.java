
import java.sql.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class impl implements service {
    @Override
    public profil insert(profil Profil) throws SQLException {
        PreparedStatement st = KoneksiDb.configDB().prepareStatement("insert into Mhs values(?,?,?,?)");
        st.setString(1, Profil.getNim());
 
        st.setInt(2, Profil.getUts());
        st.setInt(3, Profil.getKuis());
        st.setInt(4, Profil.getUas());
        st.setInt(5, Profil.getTp());
        st.setInt(6, Profil.getAbsen());
        st.executeUpdate();



        return Profil;
    }

    @Override
    public void update(profil   Profil) throws SQLException {
        PreparedStatement st = KoneksiDb.configDB().prepareStatement("update Mhs set nama=?,alamat=?,telp=? where id=?");

       
        st.setInt(2, Profil.getUts());
        st.setInt(3, Profil.getKuis());
        st.setInt(4, Profil.getUas());
        st.setInt(5, Profil.getTp());
        st.setInt(6, Profil.getAbsen());
        st.setString(1, Profil.getNim());
        st.executeUpdate();

    }

    @Override
    public void delete(String nim) throws SQLException {
        PreparedStatement st = KoneksiDb.configDB().prepareStatement("delete from Mhs  where id=?");
        st.setString(1, nim);
        st.executeUpdate();
    }

    @Override
    public List getAll() throws SQLException {
        Statement st = KoneksiDb.configDB().createStatement();
        ResultSet rs = st.executeQuery("select * from Mhs");
        List list = new ArrayList();
        while (rs.next()) {
            profil p = new profil();
            p.setNim(rs.getString("Nim"));
            p.setUts(rs.getInt("uts"));
            p.setKuis(rs.getInt("kuis"));
            p.setUas(rs.getInt("uas"));
            p.setTp(rs.getInt("tp"));
            p.setAbsen(rs.getInt("absen"));
            
            list.add(p);
        }
        return list;
    }
}
