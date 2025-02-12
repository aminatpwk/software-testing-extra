package book_exercises_tests.chapter6;

import book_exercises.chapter6.DatabaseConnection;
import book_exercises.chapter6.Invoice;
import book_exercises.chapter6.InvoiceFilterDatabase;
import book_exercises.chapter6.InvoiceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InvoiceFilterDatabaseTests {
    private DatabaseConnection db;
    private InvoiceService invoiceService;

    @BeforeEach
    public void open() {
        db = new DatabaseConnection();
        invoiceService = new InvoiceService(db);
        db.resetDatabase();
    }

    @AfterEach
    public void close() {
        if(db != null) {
            db.close();
        }
    }

    @Test
    void testGetAllLowValueInvoices(){
        Invoice test1 = new Invoice("Test1", 10);
        Invoice test2 = new Invoice("Test2", 54);
        Invoice test3 = new Invoice("Test3", 100);

        invoiceService.save(test1);
        invoiceService.save(test2);
        invoiceService.save(test3);

        InvoiceFilterDatabase   filter  = new InvoiceFilterDatabase();

        List<Invoice> invoices = filter.lowValueInvoices();
        assertThat(filter.lowValueInvoices()).containsExactlyInAnyOrder(test2, test1);
    }
}
