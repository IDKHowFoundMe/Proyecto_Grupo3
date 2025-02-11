package BusinessLogic.Entities;

import DataAccess.DAO.EstudianteDAO;
import DataAccess.DTO.EstudianteDTO;

public class CodigoBarrasScanner {
    
     public static boolean validar(String codigoBarras) throws Exception {
        EstudianteDAO e = new EstudianteDAO();
        EstudianteDTO estudiante = e.readByCedula(codigoBarras);
        if(estudiante.getCedula().equals(codigoBarras)){
            System.out.println("hola");
                return true;
            }
            System.out.println("No esta correcto");
            return false;
        }
}