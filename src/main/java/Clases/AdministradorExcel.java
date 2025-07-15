package Clases;

import Ventanas.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AdministradorExcel {
    Home menu;

    // Método para seleccionar un archivo Excel (.xlsx)
    public static File seleccionarArchivoExcel() {
        JFileChooser filechooser = new JFileChooser();
        filechooser.setDialogTitle("Seleccionar archivo Excel");
        filechooser.setFileFilter(new FileNameExtensionFilter("Archivos Excel (*.xlsx)", "xlsx"));
        int resultado = filechooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            return filechooser.getSelectedFile();
        }
        return null;
    }
    

    // Método para importar la información de los pacientes desde el archivo Excel
    public static ListaSimple importarPacientes(File archivo) {
        ListaSimple lista = new ListaSimple();
        try {
            FileInputStream fis = new FileInputStream(archivo);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet hoja = wb.getSheetAt(0);
            Iterator<Row> filas = hoja.iterator();
            boolean primera = true;

            while (filas.hasNext()) {
                Row fila = filas.next();
                if (primera) {
                    primera = false; // saltar encabezado
                    continue;
                }

                String nombre = fila.getCell(0).getStringCellValue();
                String apellido = fila.getCell(1).getStringCellValue();
                long cedula = (long) fila.getCell(2).getNumericCellValue();
                long telefono = (long) fila.getCell(3).getNumericCellValue();
                int edad = (int) fila.getCell(4).getNumericCellValue();
                String eps = fila.getCell(5).getStringCellValue();
                String sintomas = fila.getCell(6).getStringCellValue();
                int prioridad = (int) fila.getCell(7).getNumericCellValue();
                boolean atendido = Boolean.parseBoolean(fila.getCell(8).getStringCellValue().trim().toLowerCase());


                Paciente paciente = new Paciente(nombre, apellido, cedula, telefono, edad, eps, sintomas, prioridad, atendido);
                lista.InsertarU(paciente);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
     public static File seleccionarRutaParaGuardar() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar archivo Excel");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos Excel (*.xlsx)", "xlsx"));
        int resultado = fileChooser.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            if (!archivo.getName().toLowerCase().endsWith(".xlsx")) {
                archivo = new File(archivo.getAbsolutePath() + ".xlsx");
            }
            return archivo;
        }
        return null;
    }

    public static void exportarEstudiantes(Lista_Doble lista, File archivo) {
        try (
                 Workbook workbook = new XSSFWorkbook() 
                ) {
            org.apache.poi.ss.usermodel.Sheet hoja = workbook.createSheet("Estudiantes"); 
            int filaNum = 0;
            Row encabezado = hoja.createRow(filaNum++);
            encabezado.createCell(0).setCellValue("Nombre");
            encabezado.createCell(1).setCellValue("Apellido");
            encabezado.createCell(2).setCellValue("Cedula");
            encabezado.createCell(3).setCellValue("Telefono");
            encabezado.createCell(4).setCellValue("Edad");
            encabezado.createCell(4).setCellValue("Eps");
            encabezado.createCell(4).setCellValue("Sintomas");
            encabezado.createCell(4).setCellValue("Prioridad");
            encabezado.createCell(5).setCellValue("Atendidos");
            Nodo_Doble actual = lista.getPrimero();
            while (actual != null) {
                Paciente e = (Paciente) actual.getDato(); 
                Row fila = hoja.createRow(filaNum++); 
                fila.createCell(0).setCellValue(e.getNombre());
                fila.createCell(1).setCellValue(e.getApellido());
                fila.createCell(2).setCellValue(String.valueOf(e.getCedula()));
                fila.createCell(3).setCellValue(String.valueOf(e.getTelefono()));
                fila.createCell(4).setCellValue(String.valueOf(e.getEdad()));
                fila.createCell(4).setCellValue(e.getEps());
                fila.createCell(4).setCellValue(e.getSintomas());
                fila.createCell(4).setCellValue(String.valueOf(e.getPrioridad()));
                fila.createCell(5).setCellValue(String.valueOf(e.isAtendido()));
                actual = actual.getSiguiente(); 
            }
            try (FileOutputStream fos = new FileOutputStream(archivo)) {
                workbook.write(fos); 
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
