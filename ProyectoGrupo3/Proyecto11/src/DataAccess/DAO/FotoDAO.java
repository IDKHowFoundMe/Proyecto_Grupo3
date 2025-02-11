package DataAccess.DAO;

import DataAccess.DTO.FotoDTO;
import DataAccess.IDAO;
import DataAccess.SQLiteDataHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FotoDAO extends SQLiteDataHelper implements IDAO<FotoDTO> {

    @Override
    public FotoDTO readBy(Integer id) throws Exception {
        FotoDTO dto = new FotoDTO();
        String query = "SELECT IdFoto "
                 + ", IdEstudiante "
                 + ", PathFoto "
                 + ", Estado "
                 + ", FechaCreacion "
                 + ", FechaModifica "
                 + "FROM Foto "
                 + "WHERE Estado = 'A' AND IdFoto = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new FotoDTO(rs.getInt(1),
                                  rs.getInt(2),
                                  rs.getString(3),
                                  rs.getString(4),
                                  rs.getString(5),
                                  rs.getString(6));
            }
        } catch (SQLException e) {
            throw e;
        }
        return dto;
    }

    @Override
    public List<FotoDTO> readAll() throws Exception {
        FotoDTO dto;
        List<FotoDTO> lst = new ArrayList<>();
        String query = "SELECT IdFoto "
                 + ", IdEstudiante "
                 + ", PathFoto "
                 + ", Estado "
                 + ", FechaCreacion "
                 + ", FechaModifica "
                 + "FROM Foto";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new FotoDTO(rs.getInt(1),
                                  rs.getInt(2),
                                  rs.getString(3),
                                  rs.getString(4),
                                  rs.getString(5),
                                  rs.getString(6));
                lst.add(dto);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    public String readByEstudiante(Integer idEstudiante) throws Exception {
        String pathFoto = null;
        String query = "SELECT PathFoto "
                     + "FROM Foto "
                     + "WHERE Estado = 'A' "
                     + "AND IdEstudiante = " + idEstudiante.toString();

        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                pathFoto = rs.getString(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return pathFoto;
    }


    @Override
    public boolean create(FotoDTO entity) throws Exception {
        String query = "INSERT INTO Foto (IdEstudiante, PathFoto, Estado, FechaCreacion, FechaModifica) " +
                       "VALUES (?, ?, 'A', datetime('now','localtime'), datetime('now','localtime'))";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdEstudiante());
            pstmt.setString(2, entity.getPathFoto());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(FotoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Foto SET IdEstudiante = ?, PathFoto = ?, FechaModifica = ? WHERE IdFoto = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdEstudiante());
            pstmt.setString(2, entity.getPathFoto());
            pstmt.setString(3, dtf.format(now));
            pstmt.setInt(4, entity.getIdFoto());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Foto SET Estado = 'X' WHERE IdFoto = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
}
