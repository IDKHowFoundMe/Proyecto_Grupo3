package BusinessLogic.Entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.sourceforge.jbarcodebean.JBarcodeBean;
import net.sourceforge.jbarcodebean.model.Code128;

public class CodigoBarrasGenerador {
    public String generar(String cedula) throws Exception {
        String filePath = "codigo_barras_" + cedula + ".png";
        generateCode128BarcodeImage(cedula, filePath);
        return filePath;
    }
    
    private static void generateCode128BarcodeImage(String cedula, String filePath) throws IOException {
        JBarcodeBean barcodeBean = new JBarcodeBean();
        barcodeBean.setCodeType(new Code128());

        if (cedula.length() != 10) {
            throw new IllegalArgumentException("La cédula debe tener 10 dígitos.");
        }
        barcodeBean.setCode(cedula);
        BufferedImage bufferedImage = barcodeBean.draw(new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB));

        // Guardar la imagen en un archivo
        File outputFile = new File(filePath);
        ImageIO.write(bufferedImage, "png", outputFile);
    }
}
