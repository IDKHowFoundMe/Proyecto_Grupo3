package DataAccess.DTO;

public class CicloDTO {
    private Integer IdCiclo;
    private String Ciclo;
    private String FechaInicio;
    private String FechaFin;
    private String Estado;
    private String  FechaCreacion;
    private String  FechaModifica;
    
    public CicloDTO(Integer idCiclo, String ciclo, String fechaInicio, String fechaFin, String estado,
            String fechaCreacion, String fechaModifica) {
        IdCiclo = idCiclo;
        Ciclo = ciclo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }
    public CicloDTO(String ciclo, String fechaInicio, String fechaFin) {
        Ciclo = ciclo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
    }
    public CicloDTO() {
    }

    public Integer getIdCiclo() {
        return IdCiclo;
    }
    public void setIdCiclo(Integer idCiclo) {
        IdCiclo = idCiclo;
    }
    public String getCiclo() {
        return Ciclo;
    }
    public void setCiclo(String ciclo) {
        Ciclo = ciclo;
    }
    public String getFechaInicio() {
        return FechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return FechaFin;
    }
    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
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
        + "\n IdCiclo: "+ getIdCiclo()
        + "\n Ciclo       : "+ getCiclo()
        + "\n FechaInicio       : "+ getFechaInicio()  
        + "\n FechaFin       : "+ getFechaFin()         
        + "\n Estado       : "+ getEstado()       
        + "\n FechaCreacion: "+ getFechaCreacion()
        + "\n FechaModifica: "+ getFechaModifica();
    }
}
