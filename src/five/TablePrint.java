/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package five;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JTable;
/**
 *
 * @author nukma
 */
public class TablePrint implements Printable {
        private JTable table;

    public TablePrint(JTable table) {
        this.table = table;
    }

    public int print(Graphics g, PageFormat pf, int pageIndex) {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        table.print(g2d);

        return PAGE_EXISTS;
    }

    public static void printTable(JTable table) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new TablePrint(table));

        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}
