package DataAccess.DTO;

public class FotoDTO {
    private Integer IdFoto;
    private Integer IdEstudiante;
    private String PathFoto;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public FotoDTO() {
    }
    
    public FotoDTO(Integer idFoto, Integer idEstudiante, String pathFoto, String estado,
                   String fechaCreacion, String fechaModifica) {
        IdFoto = idFoto;
        IdEstudiante = idEstudiante;
        PathFoto = pathFoto;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public FotoDTO(Integer idEstudiante, String pathFoto) {
        IdEstudiante = idEstudiante;
        PathFoto = pathFoto;
    }

    public Integer getIdFoto() {
        return IdFoto;
    }

    public void setIdFoto(Integer idFoto) {
        IdFoto = idFoto;
    }

    public Integer getIdEstudiante() {
        return IdEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        IdEstudiante = idEstudiante;
    }

    public String getPathFoto() {
        return PathFoto;
    }

    public void setPathFoto(String pathFoto) {
        PathFoto = pathFoto;
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
    public String toString() {
        return getClass().getName()
                + "\n IdFoto:                " + getIdFoto()
                + "\n IdEstudiante:          " + getIdEstudiante()
                + "\n PathFoto:              " + getPathFoto()
                + "\n Estado:                " + getEstado()
                + "\n FechaCreacion:         " + getFechaCreacion()
                + "\n FechaModifica:         " + getFechaModifica();
    }
}
