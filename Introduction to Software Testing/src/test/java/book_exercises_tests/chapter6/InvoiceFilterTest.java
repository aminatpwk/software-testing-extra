package book_exercises_tests.chapter6;

import book_exercises.chapter6.Invoice;
import book_exercises.chapter6.InvoiceFilter;
import book_exercises.chapter6.InvoiceService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InvoiceFilterTest {
    @Test
    void testGetAllLowValueInvoices(){
        InvoiceService invoiceService = mock(InvoiceService.class);

        Invoice test1 = new Invoice("Test1", 10);
        Invoice test2 = new Invoice("Test2", 54);
        Invoice test3 = new Invoice("Test3", 100);
        List<Invoice> invoices = Arrays.asList(test1, test2, test3);

        when(invoiceService.all()).thenReturn(invoices);

        InvoiceFilter filter = new InvoiceFilter(invoiceService);

        assertThat(filter.lowValueInvoices()).containsExactlyInAnyOrder(test2, test1);
    }
}
