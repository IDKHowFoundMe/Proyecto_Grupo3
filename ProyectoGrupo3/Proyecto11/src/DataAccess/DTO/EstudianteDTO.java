package DataAccess.DTO;

public class EstudianteDTO {
    private Integer IdEstudiante;
    private String IdNivelIngles;
    private String IdCiclo;
    private String Cedula;
    private String  Nombre;
    private String  Apellido;
    private String  Usuario;
    private String  Clave;
    private String  Estado;
    private String  FechaCreacion;
    private String  FechaModifica;

    public EstudianteDTO(String idNivelIngles, String idCiclo, String cedula, String nombre, String apellido,
            String usuario, String clave, String estado, String fechaCreacion, String fechaModifica) {
        IdNivelIngles = idNivelIngles;
        IdCiclo = idCiclo;
        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        Usuario = usuario;
        Clave = clave;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public EstudianteDTO(Integer idEstudiante, String idNivelIngles, String idCiclo, String cedula, String nombre,
    String apellido, String usuario, String clave) {
        IdEstudiante = idEstudiante;
        IdNivelIngles = idNivelIngles;
        IdCiclo = idCiclo;
        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        Usuario = usuario;
        Clave = clave;
    }
    
    public EstudianteDTO(Integer idEstudiante, String idNivelIngles, String idCiclo, String cedula, String nombre,
    String apellido, String usuario, String clave, String estado, String fechaCreacion, String fechaModifica) {
        IdEstudiante = idEstudiante;
        IdNivelIngles = idNivelIngles;
        IdCiclo = idCiclo;
        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        Usuario = usuario;
        Clave = clave;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }
    
    public EstudianteDTO() {
    }
    
    public String getCedula() {
        return Cedula;
    }
    public void setCedula(String cedula) {
        Cedula = cedula;
    }


    public Integer getIdEstudiante() {
        return IdEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        IdEstudiante = idEstudiante;
    }

    public String getIdNivelIngles() {
        return IdNivelIngles;
    }

    public void setIdNivelIngles(String idNivelIngles) {
        IdNivelIngles = idNivelIngles;
    }

    public String getIdCiclo() {
        return IdCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        IdCiclo = idCiclo;
    }

    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    
    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdEstudiante:          "+ getIdEstudiante()
        + "\n IdNivelIngles          "+ getIdNivelIngles()
        + "\n IdCiclo                "+ getIdCiclo()
        + "\n Cedula                 "+ getCedula()  
        + "\n Nombre                 "+ getNombre()
        + "\n Apellido               "+ getApellido()
        + "\n Usuario                "+ getUsuario()
        + "\n Clave                  "+ getClave()            
        + "\n Estado                 "+ getEstado()       
        + "\n FechaCreacion          "+ getFechaCreacion()
        + "\n FechaModifica          "+ getFechaModifica();
    }
}
