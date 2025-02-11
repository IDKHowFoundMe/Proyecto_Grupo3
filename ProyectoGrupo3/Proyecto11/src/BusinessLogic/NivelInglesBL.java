package BusinessLogic;

import java.util.List;
import DataAccess.DAO.NivelInglesDAO;
import DataAccess.DTO.NivelInglesDTO;


public class NivelInglesBL {
    private NivelInglesDTO nivel; 
    private NivelInglesDAO DAO = new NivelInglesDAO();

    public NivelInglesBL(){}

    public List<NivelInglesDTO> getAll() throws Exception{
        return DAO.readAll();
    }
    public NivelInglesDTO getByIdNivelIngles(int idNivelIngles) throws Exception{
        nivel = DAO.readBy(idNivelIngles);
        return nivel;
    }
    public boolean create(NivelInglesDTO NivelInglesDTO) throws Exception{   
        return DAO.create(NivelInglesDTO);
    }
    public boolean update(NivelInglesDTO NivelInglesDTO) throws Exception{
        return DAO.update(NivelInglesDTO);
    }
    public boolean delete(int idNivelIngles) throws Exception{
        return DAO.delete(idNivelIngles);
    }
}
