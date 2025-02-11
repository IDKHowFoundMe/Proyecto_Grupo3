package DataAccess.DTO;

public class NivelInglesDTO {
    private Integer IdNivelIngles;
    private String  Nivel;
    private String  Estado;
    private String  FechaCreacion;
    private String  FechaModifica;
    
    public NivelInglesDTO() {
    }
    public NivelInglesDTO(Integer idNivelIngles, String nivel, String estado, String fechaCreacion,
            String fechaModifica) {
        IdNivelIngles = idNivelIngles;
        Nivel = nivel;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }
    public NivelInglesDTO(String nivel) {
        Nivel = nivel;
    }
    public Integer getIdNivelIngles() {
        return IdNivelIngles;
    }
    public void setIdNivelIngles(Integer idNivelIngles) {
        IdNivelIngles = idNivelIngles;
    }
    public String getNivel() {
        return Nivel;
    }
    public void setNivel(String nivel) {
        Nivel = nivel;
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
        + "\n IdNivelIngles          "+ getIdNivelIngles()
        + "\n IdNivel                "+ getNivel()         
        + "\n Estado                 "+ getEstado()       
        + "\n FechaCreacion          "+ getFechaCreacion()
        + "\n FechaModifica          "+ getFechaModifica();
    }
}
