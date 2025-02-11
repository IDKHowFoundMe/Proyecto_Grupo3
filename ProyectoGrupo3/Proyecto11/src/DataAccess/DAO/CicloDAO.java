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
import DataAccess.DTO.CicloDTO;


public class CicloDAO extends SQLiteDataHelper implements IDAO<CicloDTO> {
    @Override
    public boolean create(CicloDTO entity) throws Exception {
        String query="INSERT INTO Ciclo(Ciclo,FechaInicio,FechaFin) VALUES(?,?,?)";
        try {
            Connection conn=openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
                pstmt.setString(1,entity.getCiclo());
                pstmt.setString(2,entity.getFechaInicio());
                pstmt.setString(3,entity.getFechaFin());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query="UPDATE Ciclo SET Estado=? WHERE IdCiclo=?";
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
    public List<CicloDTO> readAll() throws Exception {
        CicloDTO dto;
        List<CicloDTO> lst = new ArrayList<>();
        String query ="SELECT IdCiclo "
                        +",Ciclo "
                        +",FechaInicio "
                        +",FechaFin "
                        +",Estado "
                        +",FechaCreacion "
                        +",FechaModifica "
                        +"FROM Ciclo ";
        try {
            Connection conn = openConnection();    
            Statement  stmt = conn.createStatement();  
            ResultSet rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new CicloDTO(      rs.getInt(1)        
                                        ,rs.getString(2)                
                                        ,rs.getString(3)          
                                        ,rs.getString(4)      
                                        ,rs.getString(5)
                                        ,rs.getString(6)
                                        ,rs.getString(7)); 
                lst.add(dto);
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public CicloDTO readBy(Integer id) throws Exception {
        CicloDTO dto = new CicloDTO();
        String  query="SELECT IdCiclo "
                        +",Ciclo "
                        +",FechaInicio "
                        +",FechaFin "
                        +",Estado "
                        +",FechaCreacion "
                        +",FechaModifica "
                        +"FROM Ciclo "
                        +"WHERE Estado ='A' AND IdCiclo= "+id.toString();
        try {
            Connection conn = openConnection();   
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                dto = new CicloDTO(  rs.getInt(1)        
                                    ,rs.getString(2)                
                                    ,rs.getString(3)          
                                    ,rs.getString(4)      
                                    ,rs.getString(5)
                                    ,rs.getString(6)
                                    ,rs.getString(7));   
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return dto;
    }
    @Override
    public boolean update(CicloDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Ciclo SET Ciclo= ?, FechaInicio=?, FechaFin=?, FechaModificacion = ? WHERE IdCiclo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getCiclo());
            pstmt.setString(2, entity.getFechaInicio());
            pstmt.setString(3, entity.getFechaFin());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.setInt(5, entity.getIdCiclo());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; 
        }
    }
}
