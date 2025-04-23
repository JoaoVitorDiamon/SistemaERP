package com.system.SystemERP.Services.PaymentTerms;

import com.system.SystemERP.Dtos.PaymentTerms.PaymentTermsDTOS;
import com.system.SystemERP.Entity.PaymentTerms.PaymentTerms;
import com.system.SystemERP.Enum.PaymentTerms.PaymentTermsEnum;
import com.system.SystemERP.Repository.PaymentTerms.PaymentTermsRepository;
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
class PaymentTermsServicesTest {

    @Mock
    private PaymentTermsRepository paymentTermsRepository;

    @InjectMocks
    private PaymentTermsServices paymentTermsServices;

    @Captor
    private ArgumentCaptor<PaymentTerms> termsPaymentArgumentCaptor;

    @Captor
    private ArgumentCaptor<Integer> idArgumentCaptor;

    @Nested
    class createTermsPayment {
        @Test
        @DisplayName("Should create a Terms of Payment with success")
        void shouldCreateATermsOfPaymentWithSuccess() {
            var termsPaymentDTO = new PaymentTermsDTOS(PaymentTermsEnum.Apos_o_Recebimento);
            var termsPayment = new PaymentTerms(1,
                    "cinquenta_cinquenta",
                    Instant.now(),
                    Instant.now());




            doReturn(termsPayment)
                    .when(paymentTermsRepository)
                    .save(any());
            var input = paymentTermsServices.createPaymentTerms(termsPaymentDTO);
            assertNotNull(input);
        }

        @Test
        @DisplayName("Should Throw Exception When Error Occurs")
        void shouldThrowExceptionWhenErrorOccurs() {
            var input = new PaymentTermsDTOS(PaymentTermsEnum.Apos_o_Recebimento);

            doReturn(new RuntimeException()).when(paymentTermsRepository).save(any());
            assertThrows(RuntimeException.class, () -> paymentTermsServices.createPaymentTerms(input));
        }


        @Test
        @DisplayName("Should Throw Exception When Argument Captor")
        void shouldThrowExceptionWhenArgumentCaptor() {
            var termsPayment = new PaymentTerms(1,
                    "cinquenta_cinquenta",
                    Instant.now(),
                    Instant.now());
            var termsPaymentDTO = new PaymentTermsDTOS(PaymentTermsEnum.Apos_o_Recebimento);

            doReturn(termsPayment)
                    .when(paymentTermsRepository)
                    .save(termsPaymentArgumentCaptor.capture());

            var input = paymentTermsServices.createPaymentTerms(termsPaymentDTO);

            assertNotNull(input);

            var termsPaymentCapture = termsPaymentArgumentCaptor.getValue();
            assertEquals(termsPaymentDTO.nome().name(), termsPaymentCapture.getNamePaymentTerms());

        }


    }

    @Nested
    class getByID {

        @Test
        @DisplayName("Should Get Terms Of Payment By Id With Success When OptionalIs Present")
        void shouldGetTermsOfPaymentByIdWithSuccessWhenOptionalIsPresent() {

            var termsPayment = new PaymentTerms(1,
                    "cinquenta_cinquenta",
                    Instant.now(),
                    Instant.now());
            doReturn(Optional.of(termsPayment))
                    .when(paymentTermsRepository)
                    .findById(idArgumentCaptor.capture());

            var output = paymentTermsServices.findByIDPaymentTerms(termsPayment.getIdPaymentTerms());

            assertNotNull(output);
            assertEquals(termsPayment.getIdPaymentTerms(), idArgumentCaptor.getValue());
        }


        @Test
        @DisplayName("Should Get Terms Of Payment By Id With Success When OptionalIs Empty")
        void shouldGetTermsOfPaymentByIdWithSuccessWhenOptionalIsEmpty() {

            var termsPayment = new PaymentTerms(1,
                    "cinquenta_cinquenta",
                    Instant.now(),
                    Instant.now());

            var termsPaymentID = 44;
            doReturn(Optional.empty())
                    .when(paymentTermsRepository)
                    .findById(idArgumentCaptor.capture());

            var output = paymentTermsServices.findByIDPaymentTerms(termsPaymentID);

            assertNull(output);
            assertEquals(termsPaymentID, idArgumentCaptor.getValue());
        }
    }

    @Nested
    class getAll {

        @Test
        @DisplayName("Should return all Payment Terms with success")
        void shouldReturnAllTermsOfPaymentWithSuccess() {

            var termsPayment = new PaymentTerms(1,
                    "cinquenta_cinquenta",
                    Instant.now(),
                    Instant.now());

            var listTermsPayments = List.of(termsPayment);
            doReturn(listTermsPayments)
                    .when(paymentTermsRepository)
                    .findAll();

            var output = paymentTermsServices.getAll();

            assertNotNull(output);
            assertEquals(listTermsPayments.size(), output.size());
        }


    }

    @Nested
    class delete {

        @Test
        @DisplayName("Should delete user with success when user exists")
        void shouldDeleteUserWithSuccessWhenUserExists() {

            doReturn(true).when(paymentTermsRepository).existsById(idArgumentCaptor.capture());
            doNothing()
                    .when(paymentTermsRepository)
                    .deleteById(idArgumentCaptor.capture());

            var termsOfPaymentID = 55;

            paymentTermsServices.delete(termsOfPaymentID);

            var idList = idArgumentCaptor.getAllValues();

            assertEquals(termsOfPaymentID, idList.get(0));
            assertEquals(termsOfPaymentID, idList.get(1));

            verify(paymentTermsRepository, times(1)).existsById(idList.get(0));
            verify(paymentTermsRepository, times(1)).deleteById(idList.get(1));
        }

        @Test
        @DisplayName("Should not delete terms of payment when user NOT exists")
        void shouldNotDeleteTermsOfPaymentWhenUserNotExists() {

            doReturn(false).when(paymentTermsRepository).existsById(idArgumentCaptor.capture());

            var termsOfPaymentID = 55;

            paymentTermsServices.delete(termsOfPaymentID);

            assertEquals(termsOfPaymentID, idArgumentCaptor.getValue());

            verify(paymentTermsRepository, times(1)).existsById(idArgumentCaptor.getValue());
            verify(paymentTermsRepository, times(0)).deleteById(any());
        }
    }


}