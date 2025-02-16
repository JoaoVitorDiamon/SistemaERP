package com.system.SystemERP.Services.InvoiceTypes;

import com.system.SystemERP.Dtos.InvoiceTypes.InvoiceTypesDTO;
import com.system.SystemERP.Entity.InvoiceTypes.InvoiceTypes;
import com.system.SystemERP.Enum.InvoiceTypes.InvoiceTypesEnum;
import com.system.SystemERP.Repository.InvoiceTypes.InvoiceTypesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InvoiceTypesServicesTest {

    @Mock
    private InvoiceTypesRepository invoiceTypesRepository;

    @InjectMocks
    private InvoiceTypesServices invoiceTypesServices;

    @Captor
    private ArgumentCaptor<InvoiceTypes> invoiceTypesArgumentCaptor;

    @Captor
    private ArgumentCaptor<Integer> invoiceTypesArgumentCaptorID;


    @Nested
    class createInvoice {
        @Test
        @DisplayName("Should create a Invoice Types with success")
        void shouldCreateAInvoiceTypesWithSuccess() {
            var invoiceTypeDTO = new InvoiceTypesDTO(InvoiceTypesEnum.fatura_de_adiantamento);
            var invoice = new InvoiceTypes(
                    21,
                    " fatura_padrao",
                    Instant.now(),
                    null
            );
            doReturn(invoice).when(invoiceTypesRepository).save(any());
            var resultSave = invoiceTypesServices.createInvoice(invoiceTypeDTO);
            assertNotNull(resultSave);
        }


        @Test
        @DisplayName("Should Throw Exception When Error Occurs  - Invoice Types")
        void shouldThrowExceptionWhenErrorOccurs() {
            var invoiceTypeDTO = new InvoiceTypesDTO(InvoiceTypesEnum.fatura_de_adiantamento);
            doReturn(new RuntimeException()).when(invoiceTypesRepository).save(any());
            assertThrows(RuntimeException.class, () -> invoiceTypesServices.createInvoice(invoiceTypeDTO));

        }

        @Test
        @DisplayName("Should Throw Exception When Argument Captor - Invoice Types")
        void shouldThrowExceptionWhenArgumentCaptor() {
            var invoiceTypeDTO = new InvoiceTypesDTO(InvoiceTypesEnum.fatura_de_adiantamento);
            var invoice = new InvoiceTypes(
                    21,
                    " fatura_padrao",
                    Instant.now(),
                    null
            );
            doReturn(invoice)
                    .when(invoiceTypesRepository)
                    .save(invoiceTypesArgumentCaptor.capture());

            var resultSave = invoiceTypesServices.createInvoice(invoiceTypeDTO);
            var invoiceTypesArgumentCaptorResult = invoiceTypesArgumentCaptor.getValue();

            assertNotNull(resultSave);
            assertEquals(invoiceTypeDTO.nome().name(), invoiceTypesArgumentCaptorResult.getInvoiceTypes());
        }


    }

    @Nested
    class findByID {
        @Test
        @DisplayName("Should Get Invoice Types By Id With Success When OptionalIs Present")
        void shouldGetInvoiceTypesByIdWithSuccessWhenOptionalIsPresent() {
            var invoice = new InvoiceTypes(
                    21,
                    " fatura_padrao",
                    Instant.now(),
                    null
            );

            doReturn(Optional.of(invoice))
                    .when(invoiceTypesRepository)
                    .findById(invoiceTypesArgumentCaptorID.capture());

            var output = invoiceTypesServices.getByID(invoice.getIdInvoiceTypes());

            assertTrue(output.isPresent());
            assertEquals(invoice.getIdInvoiceTypes(), invoiceTypesArgumentCaptorID.getValue());
        }

        @Test
        @DisplayName("Should Get Invoice Types By Id With Success When OptionalIs Empty")
        void shouldGetInvoiceTypesByIdWithSuccessWhenOptionalIsEmpty() {
            var invoiceID = 55;
            var invoice = new InvoiceTypes(
                    21,
                    " fatura_padrao",
                    Instant.now(),
                    null
            );


            doReturn(Optional.empty())
                    .when(invoiceTypesRepository)
                    .findById(invoiceTypesArgumentCaptorID.capture());


            var output = invoiceTypesServices.getByID(invoiceID);

            assertTrue(output.isEmpty());
            assertEquals(invoiceID, invoiceTypesArgumentCaptorID.getValue());
        }

    }

    @Nested
    class getAll {

        @Test
        @DisplayName("Should return all Invoice Types with success")
        void shouldReturnAllTermsOfPaymentWithSuccess() {
            var invoice = new InvoiceTypes(
                    21,
                    " fatura_padrao",
                    Instant.now(),
                    null
            );
            var listInvoice = List.of(invoice);
            doReturn(listInvoice).when(invoiceTypesRepository).findAll();

            var output = invoiceTypesServices.getAll();

            assertNotNull(output);
            assertEquals(listInvoice.size(), output.size());
        }


    }

    @Nested
    class delete {
        @Test
        @DisplayName("Should delete  Invoice Types with success when  Invoice Types exists")
        void shouldDeleteInvoiceTypesWithSuccessWhenInvoiceTypesExists() {
            var invoiceID = 55;

            doReturn(true)
                    .when(invoiceTypesRepository)
                    .existsById(invoiceTypesArgumentCaptorID.capture());

            doNothing()
                    .when(invoiceTypesRepository)
                    .deleteById(invoiceTypesArgumentCaptorID.capture());

            invoiceTypesServices.deleteByID(invoiceID);

            var listOfArgumentsValues = invoiceTypesArgumentCaptorID.getAllValues();
            assertEquals(invoiceID, listOfArgumentsValues.get(0));
            assertEquals(invoiceID, listOfArgumentsValues.get(1));

            verify(invoiceTypesRepository, times(1))
                    .existsById(listOfArgumentsValues.get(0));
            verify(invoiceTypesRepository, times(1))
                    .deleteById(listOfArgumentsValues.get(1));
        }

        @Test
        @DisplayName("Should not delete  Invoice Types when  Invoice Types NOT exists")
        void shouldNotDeleteInvoiceTypesTypesWhenInvoiceTypesNotExists() {
            var invoiceID = 55;

            doReturn(false)
                    .when(invoiceTypesRepository)
                    .existsById(invoiceTypesArgumentCaptorID.capture());

            invoiceTypesServices.deleteByID(invoiceID);

            assertEquals(invoiceID, invoiceTypesArgumentCaptorID.getValue());

            verify(invoiceTypesRepository, times(1))
                    .existsById(invoiceTypesArgumentCaptorID.getValue());

            verify(invoiceTypesRepository, times(0))
                    .deleteById(any());
        }


    }
}