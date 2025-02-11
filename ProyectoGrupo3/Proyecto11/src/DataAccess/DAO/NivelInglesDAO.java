package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import DataAccess.IDAO;
import DataAccess.SQLiteDataHelper;
import DataAccess.DTO.NivelInglesDTO;

public class NivelInglesDAO extends SQLiteDataHelper implements IDAO<NivelInglesDTO> {
    @Override
    public boolean create(NivelInglesDTO entity) throws Exception {
        String query="INSERT INTO NivelIngles(Nivel) VALUES(?)";
        try {
            Connection conn=openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1,entity.getNivel());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query="UPDATE NivelIngles SET Estado=? WHERE IdNivelIngles=?";
        try {
            Connection conn=openConnection();
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1,"X");
            ps.setInt(2,id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<NivelInglesDTO> readAll() throws Exception {
        NivelInglesDTO dto;
        List<NivelInglesDTO> lst = new ArrayList<>();
        String query ="SELECT IdNivelIngles "
                        +",Nivel "
                        +",Estado "
                        +",FechaCreacion "
                        +",FechaModifica "
                        +"FROM NivelIngles ";
        try {
            Connection conn = openConnection();    
            Statement  stmt = conn.createStatement();  
            ResultSet rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new NivelInglesDTO(      rs.getInt(1)        
                                        ,rs.getString(2)                
                                        ,rs.getString(3)          
                                        ,rs.getString(4)      
                                        ,rs.getString(5)); 
                lst.add(dto);
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public NivelInglesDTO readBy(Integer id) throws Exception {
        NivelInglesDTO dto = new NivelInglesDTO();
        String  query="SELECT IdNivelIngles "
                        +",Nivel" 
                        +",Estado "   
                        +",FechaCreacion "
                        +",FechaModifica "  
                        +"FROM NivelIngles "
                        +"WHERE Estado ='A' AND IdNivelIngles= "+id.toString();
        try {
            Connection conn = openConnection();   
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                dto = new NivelInglesDTO(  rs.getInt(1)         
                                        ,rs.getString(2)               
                                        ,rs.getString(3)          
                                        ,rs.getString(4)       
                                        ,rs.getString(5));   
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return dto;
    }

    @Override
    public boolean update(NivelInglesDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE NivelIngles SET Nivel= ?, FechaModificacion = ? WHERE IdNivelIngles = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNivel());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdNivelIngles());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; 
        }
    }

}
