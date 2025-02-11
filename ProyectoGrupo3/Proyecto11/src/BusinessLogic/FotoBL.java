package BusinessLogic;

import java.util.List;
import DataAccess.DAO.FotoDAO;
import DataAccess.DTO.FotoDTO;

public class FotoBL {
    private String pathFoto;
    private FotoDTO foto;
    private FotoDAO DAO = new FotoDAO();
    
    public FotoBL() {}
    
    public FotoBL(String pathFoto) {
        this.pathFoto = pathFoto;
    }

    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }


    public String getbyEstudiante(Integer idEstudiante)throws Exception{
        pathFoto = DAO.readByEstudiante(idEstudiante);
        return pathFoto;
    }
    public List<FotoDTO> getAll() throws Exception {
        return DAO.readAll();
    }

    public FotoDTO getByIdFoto(int idFoto) throws Exception {
        foto = DAO.readBy(idFoto);
        return foto;
    }

    public boolean create(FotoDTO fotoDTO) throws Exception {
        return DAO.create(fotoDTO);
    }

    public boolean update(FotoDTO fotoDTO) throws Exception {
        return DAO.update(fotoDTO);
    }

    public boolean delete(int idFoto) throws Exception {
        return DAO.delete(idFoto);
    }

}
