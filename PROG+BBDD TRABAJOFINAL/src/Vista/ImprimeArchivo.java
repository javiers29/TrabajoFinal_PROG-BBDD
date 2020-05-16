package Vista;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ImprimeArchivo {

	private String filename;
	private String filepath;


	public ImprimeArchivo(String filename, String filepath) {
		super();
		this.filename = filename;
		this.filepath = filepath;
	}



	/* Este m�todo generar� el PDF  */
	public void generarArchivoPDF(Integer num_donante, String nombre, String apellido1, String apellido2, String fecha_nac, String pais_nac,Integer tlfn1) throws FileNotFoundException, DocumentException {

		// Crea el nombre del archivo con el path, el nombre del  fichero y la extensi�n PDF
		String sFileNamePath = filepath + filename+".pdf";

		// Se crea el documento que se va a imprimir
		Document PDFdonante = new Document();
		PDFdonante.setPageSize(PageSize.POSTCARD);
		


		// En principio el tama�o de la p�gina est� paara un A4 en vertical, pero puedes investigar y cambiar el tama�o de la zona de impresi�n
		// Eso s�... te tocar� investigar y buscar: el m�todo setPageSize
		//documento.setPageSize() Lo que le pases como  argumento

		System.out.println(sFileNamePath);

		// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
		FileOutputStream ficheroPdf = new FileOutputStream(sFileNamePath);

		// Se asocia el documento al OutputStream y se indica que el espaciado entre
		// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
		PdfWriter.getInstance(PDFdonante,ficheroPdf).setInitialLeading(20);

		// Se abre el documento.
		PDFdonante.open();

		// La unidad para imprimir es el p�rrafo se pasa el texto del p�rrafo, se pueden poner saltos de l�nea dentro
		// el tipo, tama�o de letra y si es en negrita (BOLD), cursiva (ITALIC), en cursivaNEgrita (BOLDITALIC) o normal (NORMAL)

		Paragraph p1 = new Paragraph("CARNET DE DONANTE ",
		FontFactory.getFont("arial",   // fuente
		14,                            // tama�o
		Font.BOLD));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFY
		p1.setAlignment(Element.ALIGN_CENTER);

		// A�ade el p�rrafo al documeento
		PDFdonante.add(p1);


		Paragraph p2 = new Paragraph("\n Numero de Donante: "+ num_donante +"\n Nombre: "+nombre+"\n Primer Apellido: "+apellido1+"\n Segundo Apellido: "+apellido2+"\n Fecha nacimiento: " + fecha_nac + "\n Pais Nacimiento: "+pais_nac+ "\n Telefono: " + tlfn1,
				FontFactory.getFont("Garamond",   // fuente
				13,                            // tama�o
				Font.ITALIC));

		// Una vez creado el p�rrafo puedes modificar varias opciones... como aqu� la alineaci�n
		// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFY
		p2.setAlignment(Element.ALIGN_LEFT);

		// A�ade el p�rrafo al documeento
		PDFdonante.add(p2);


		// Meter una imagen





		PDFdonante.close();


	}

}

