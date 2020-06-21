
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public interface service {
    profil insert(profil Profil) throws SQLException;
    void update(profil Profil) throws SQLException;
    void delete(String nim) throws SQLException;
    List getAll() throws SQLException;
}
