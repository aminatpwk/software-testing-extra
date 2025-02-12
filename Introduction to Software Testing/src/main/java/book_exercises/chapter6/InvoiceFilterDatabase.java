package book_exercises.chapter6;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Database version
 */
public class InvoiceFilterDatabase {
    public List<Invoice> lowValueInvoices() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        InvoiceService invoiceService = new InvoiceService(dbConnection);

        try {
            List<Invoice> all = invoiceService.all();
            return all.stream()
                    .filter(invoice -> invoice.getValue() < 100)
                    .collect(toList());
        } finally {
            dbConnection.close();
        }
    }
}
