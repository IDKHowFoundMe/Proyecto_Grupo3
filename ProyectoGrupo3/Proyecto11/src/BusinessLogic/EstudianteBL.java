package BusinessLogic;
import java.util.List;
import DataAccess.DAO.EstudianteDAO;
import DataAccess.DTO.EstudianteDTO;

public class EstudianteBL {
    private EstudianteDAO DAO;
    private FotoBL fBL;
    private EstudianteDTO estudiante; 
    private String pathFoto;
    private Integer IdEstudiante;
    private String nombre;
    private String apellido;
    private String cedula;
    private String nivelIngles;
    private String usuario;
    private String clave;
    
    public EstudianteBL() {
            this.DAO = new EstudianteDAO();
            this.fBL = new FotoBL();
        }

    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }
    public String getusuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public String getclave() {
        return clave;
    }

    public void setclave(String clave) {
        this.clave = clave;
    }

    public String getNivelIngles() {
        return nivelIngles;
    }

    public void setNivelIngles(String nivelIngles) {
        this.nivelIngles = nivelIngles;
    }

    public Integer getIdEstudiante() {
        return IdEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        IdEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    

    public List<EstudianteDTO> getAll() throws Exception{
        return DAO.readAll();
    }
    public EstudianteDTO getByIdEstudiante(int idEstudiante) throws Exception{
        estudiante = DAO.readBy(idEstudiante);
        return estudiante;
    }
    public boolean create(EstudianteDTO EstudianteDTO) throws Exception{   
        return DAO.create(EstudianteDTO);
    }
    public boolean update(EstudianteDTO estudianteDTO) throws Exception{
        return DAO.update(estudianteDTO);
    }
    public boolean delete(int idEstudiante) throws Exception{
        return DAO.delete(idEstudiante);
    }
    public EstudianteDTO getByCedula(String cedula) throws Exception{
        estudiante = DAO.readByCedula(cedula);
        return estudiante;
    }
        
    public boolean iniciarSesion(String usuario, String clave) throws Exception {
            estudiante = DAO.login(usuario, clave);
            if (estudiante.getUsuario().equals(usuario) && estudiante.getClave().equals(clave)) {
                this.IdEstudiante= estudiante.getIdEstudiante();
                this.nombre= estudiante.getNombre();
                this.apellido= estudiante.getApellido();
                this.cedula= estudiante.getCedula();
                this.nivelIngles= estudiante.getIdNivelIngles();
                this.usuario= estudiante.getUsuario();
                this.clave= estudiante.getClave();
                this.pathFoto= fBL.getbyEstudiante(estudiante.getIdEstudiante());
                return true;
            }
            return false;
    }
    
}


