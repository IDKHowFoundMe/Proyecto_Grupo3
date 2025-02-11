package BusinessLogic;
import java.util.List;

import DataAccess.DAO.CicloDAO;
import DataAccess.DTO.CicloDTO;

public class CicloBL {
    private CicloDTO ciclo; 
    private CicloDAO DAO = new CicloDAO();

    public CicloBL(){}

    public List<CicloDTO> getAll() throws Exception{
        return DAO.readAll();
    }
    public CicloDTO getByIdCiclo(int idCiclo) throws Exception{
        ciclo = DAO.readBy(idCiclo);
        return ciclo;
    }
    public boolean create(CicloDTO cicloDTO) throws Exception{   
        return DAO.create(cicloDTO);
    }
    public boolean update(CicloDTO cicloDTO) throws Exception{
        return DAO.update(cicloDTO);
    }
    public boolean delete(int idCiclo) throws Exception{
        return DAO.delete(idCiclo);
    }
}
