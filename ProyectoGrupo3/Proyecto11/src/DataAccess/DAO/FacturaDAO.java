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
import DataAccess.DTO.FacturaDTO;



public class FacturaDAO extends SQLiteDataHelper implements IDAO<FacturaDTO>{

    @Override
    public FacturaDTO readBy(Integer id) throws Exception {
        FacturaDTO dto = new FacturaDTO();
        String  query="SELECT IdFactura "
                        +",IdEstudiante "
                        +",NumeroFactura "
                        +",Estado "
                        +",FechaCreacion "
                        +",FechaModifica"
                        +"FROM Factura "
                        +"WHERE Estado ='A' AND IdFactura= "+id.toString();
        try {
            Connection conn = openConnection();   
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                dto = new FacturaDTO(  rs.getInt(1)
                                            ,rs.getInt(2)
                                            ,rs.getString(3)
                                            ,rs.getString(4)
                                            ,rs.getString(5)
                                            ,rs.getString(6));            
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return dto;
    }

    @Override
    public List<FacturaDTO> readAll() throws Exception {
        FacturaDTO dto;
        List<FacturaDTO> lst = new ArrayList<>();
        String query ="SELECT IdFactura "
                        +",IdEstudiante "
                        +",NumeroFactura "
                        +",Estado "
                        +",FechaCreacion "
                        +",FechaModifica"
                        +" FROM Factura ";
        try {
            Connection conn = openConnection();    
            Statement  stmt = conn.createStatement();  
            ResultSet rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new FacturaDTO( rs.getInt(1)
                                        ,rs.getInt(2)
                                        ,rs.getString(3)
                                        ,rs.getString(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6)); 
                lst.add(dto);
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean create(FacturaDTO entity) throws Exception {
        String query="INSERT INTO Factura(IdEstudiante,NumeroFactura) VALUES(?,?)";
        try {
            Connection conn=openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
                pstmt.setInt(1,entity.getIdEstudiante());
                pstmt.setString(2,entity.getNumeroFactura());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(FacturaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Factura SET  IdEstudiante= ?, NumeroFactura=? ,FechaModificacion = ? WHERE IdFactura = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdEstudiante());
            pstmt.setString(2, entity.getNumeroFactura());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdFactura());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; 
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query="UPDATE Factura SET Estado=? WHERE Factura=?";
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
    
}
