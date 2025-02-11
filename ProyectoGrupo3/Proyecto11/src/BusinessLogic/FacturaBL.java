package BusinessLogic;
import java.util.List;

import DataAccess.DAO.FacturaDAO;
import DataAccess.DTO.FacturaDTO;

public class FacturaBL {
    private FacturaDTO factura; 
    private FacturaDAO DAO = new FacturaDAO();

    public FacturaBL(){}
    

    public List<FacturaDTO> getAll() throws Exception{
        return DAO.readAll();
    }
    public FacturaDTO getByIdFactura(int idFactura) throws Exception{
        factura = DAO.readBy(idFactura);
        return factura;
    }
    public boolean create(FacturaDTO FacturaDTO) throws Exception{   
        return DAO.create(FacturaDTO);
    }
    public boolean update(FacturaDTO FacturaDTO) throws Exception{
        return DAO.update(FacturaDTO);
    }
    public boolean delete(int idFactura) throws Exception{
        return DAO.delete(idFactura);
    }
}
