package DataAccess.DTO;

public class FacturaDTO {
    private Integer IdFactura;
    private Integer IdEstudiante;
    private String  NumeroFactura;
    private String  Estado;
    private String  FechaCreacion;
    private String  FechaModifica;
    public FacturaDTO() {
    }
    public FacturaDTO(Integer idFactura, Integer idEstudiante, String numeroFactura, String estado,
            String fechaCreacion, String fechaModifica) {
        IdFactura = idFactura;
        IdEstudiante = idEstudiante;
        NumeroFactura = numeroFactura;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }
    public FacturaDTO(Integer idEstudiante, String numeroFactura) {
        IdEstudiante = idEstudiante;
        NumeroFactura = numeroFactura;
    }
    public Integer getIdFactura() {
        return IdFactura;
    }
    public void setIdFactura(Integer idFactura) {
        IdFactura = idFactura;
    }
    public Integer getIdEstudiante() {
        return IdEstudiante;
    }
    public void setIdEstudiante(Integer idEstudiante) {
        IdEstudiante = idEstudiante;
    }
    public String getNumeroFactura() {
        return NumeroFactura;
    }
    public void setNumeroFactura(String numeroFactura) {
        NumeroFactura = numeroFactura;
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
        + "\n IdFactura              "+ getIdFactura()
        + "\n IdEstudiante:          "+ getIdEstudiante()
        + "\n NumeroFactura          "+ getNumeroFactura()         
        + "\n Estado                 "+ getEstado()       
        + "\n FechaCreacion          "+ getFechaCreacion()
        + "\n FechaModifica          "+ getFechaModifica();
    }
}
