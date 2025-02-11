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
import DataAccess.DTO.EstudianteDTO;

public class EstudianteDAO extends SQLiteDataHelper implements IDAO<EstudianteDTO>{

    @Override
    public EstudianteDTO readBy(Integer id) throws Exception {
        EstudianteDTO dto = new EstudianteDTO();
        String query = "SELECT E.IdEstudiante"
                                +", Nl.Nivel"
                                +", Cl.Ciclo"
                                +", E.Cedula"
                                +", E.Nombre"
                                +", E.Apellido"
                                +", E.Usuario"
                                +", E.Clave"
                                +", E.Estado "
                                +", E.FechaCreacion "
                                +", E.FechaModifica "
                        +" FROM Estudiante AS E "
                        +"JOIN Ciclo AS Cl ON Cl.IdCiclo = E.IdCiclo "
                        +"JOIN NivelIngles AS Nl ON Nl.IdNivelIngles = E.IdNivelIngles "
                        +"WHERE E.Estado ='A' AND E.IdEstudiante= "+id.toString();
        try {
            Connection conn = openConnection();   
            Statement  stmt = conn.createStatement();   
            ResultSet rs   = stmt.executeQuery(query);  
            while (rs.next()) {
                dto = new EstudianteDTO(  rs.getInt(1)
                                            ,rs.getString(2)
                                            ,rs.getString(3)
                                            ,rs.getString(4)
                                            ,rs.getString(5)
                                            ,rs.getString(6)
                                            ,rs.getString(7)
                                            ,rs.getString(8)
                                            ,rs.getString(9)
                                            ,rs.getString(10)
                                            ,rs.getString(11));            
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return dto;
    }

    @Override
    public List<EstudianteDTO> readAll() throws Exception {
        EstudianteDTO dto;
        List<EstudianteDTO> lst = new ArrayList<>();
        String query ="SELECT IdEstudiante "
                        +",IdNivelIngles "
                        +",IdCiclo "
                        +",Cedula "
                        +",Nombre "
                        +",Apellido "
                        +",Usuario "
                        +",Clave "
                        +",Estado "
                        +",FechaCreacion "
                        +",FechaModifica "
                        +" FROM Estudiante ";
        try {
            Connection conn = openConnection();    
            Statement  stmt = conn.createStatement();  
            ResultSet rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new EstudianteDTO( rs.getInt(1)
                                            ,rs.getString(2)
                                            ,rs.getString(3)
                                            ,rs.getString(4)
                                            ,rs.getString(5)
                                            ,rs.getString(6)
                                            ,rs.getString(7)
                                            ,rs.getString(8)
                                            ,rs.getString(9)
                                            ,rs.getString(10)
                                            ,rs.getString(11)); 
                lst.add(dto);
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean create(EstudianteDTO entity) throws Exception {
        String query="INSERT INTO Estudiante(IdNivelIngles,IdCiclo,Cedula,Nombre,Apellido,Usuario,Clave) VALUES(?,?,?,?,?,?,?)";
        try {
            Connection conn=openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
                pstmt.setString(1,entity.getIdNivelIngles());
                pstmt.setString(2,entity.getIdCiclo());
                pstmt.setString(3,entity.getCedula());
                pstmt.setString(4,entity.getNombre());
                pstmt.setString(5,entity.getApellido());
                pstmt.setString(5,entity.getUsuario());
                pstmt.setString(5,entity.getClave());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(EstudianteDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Estudiante SET  IdCiclo= ?, Cedula=? ,Nombre=? ,Apellido=? ,Usuario=? ,Clave=?, FechaModificacion = ? WHERE IdEstudiante = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getIdCiclo());
            pstmt.setString(2, entity.getCedula());
            pstmt.setString(3, entity.getNombre());
            pstmt.setString(4, entity.getApellido());
            pstmt.setString(5, entity.getUsuario());
            pstmt.setString(6, entity.getClave());
            pstmt.setString(7, dtf.format(now).toString());
            pstmt.setInt(8, entity.getIdEstudiante());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; 
        }
    }
    

    @Override
    public boolean delete(Integer id) throws Exception {
        String query="UPDATE Estudiante SET Estado=? WHERE IdEstudiante=?";
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

    public EstudianteDTO login(String usuario, String clave) throws Exception {
        EstudianteDTO oS = new EstudianteDTO();
        String query = "SELECT E.IdEstudiante"
                        +", Nl.Nivel"
                        +", Cl.Ciclo"
                        +", E.Cedula"
                        +", E.Nombre"
                        +", E.Apellido"
                        +", E.Usuario"
                        +", E.Clave"
                        +", E.Estado "
                        +", E.FechaCreacion "
                        +", E.FechaModifica "
                   +" FROM Estudiante AS E "
                   +"JOIN Ciclo AS Cl ON Cl.IdCiclo = E.IdCiclo "
                   +"JOIN NivelIngles AS Nl ON Nl.IdNivelIngles = E.IdNivelIngles "
                   +" WHERE E.Estado='A' AND E.Usuario = '" + usuario + "' AND E.Clave = '" + clave + "'";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la consulta
            while (rs.next()) {
                oS = new EstudianteDTO(
                    rs.getInt(1)
                    ,rs.getString(2)
                    ,rs.getString(3)
                    ,rs.getString(4)
                    ,rs.getString(5)
                    ,rs.getString(6)
                    ,rs.getString(7)
                    ,rs.getString(8)
                    ,rs.getString(9)
                    ,rs.getString(10)
                    ,rs.getString(11)
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return oS;
    }

    public EstudianteDTO readByCedula(String cedula) throws Exception {
        EstudianteDTO oS = new EstudianteDTO();
        String query = "SELECT E.IdEstudiante"
                                +", Nl.Nivel"
                                +", Cl.Ciclo"
                                +", E.Cedula"
                                +", E.Nombre"
                                +", E.Apellido"
                                +", E.Usuario"
                                +", E.Clave"
                                +", E.Estado "
                                +", E.FechaCreacion "
                                +", E.FechaModifica "
                        +" FROM Estudiante AS E "
                        +"JOIN Ciclo AS Cl ON Cl.IdCiclo = E.IdCiclo "
                        +"JOIN NivelIngles AS Nl ON Nl.IdNivelIngles = E.IdNivelIngles "
                        +" WHERE E.Estado='A' AND E.Cedula = " + cedula;

        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la consulta
            while (rs.next()) {
                oS = new EstudianteDTO(
                    rs.getInt(1)
                    ,rs.getString(2)
                    ,rs.getString(3)
                    ,rs.getString(4)
                    ,rs.getString(5)
                    ,rs.getString(6)
                    ,rs.getString(7)
                    ,rs.getString(8)
                    ,rs.getString(9)
                    ,rs.getString(10)
                    ,rs.getString(11)
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return oS;
    }

}
