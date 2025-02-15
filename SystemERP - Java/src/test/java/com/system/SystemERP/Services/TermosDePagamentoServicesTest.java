package com.system.SystemERP.Services;

import com.system.SystemERP.Dtos.TermosDePagamentos.TermosDePagamentosDTOS;
import com.system.SystemERP.Entity.TermosDePagamentos.TermosDePagamento;
import com.system.SystemERP.Repository.TermosDePagamento.TermosDePagamentoRepository;
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
class TermosDePagamentoServicesTest {

    @Mock
    private TermosDePagamentoRepository termosDePagamentoRepository;

    @InjectMocks
    private TermosDePagamentoServices termosDePagamentoServices;

    @Captor
    private ArgumentCaptor<TermosDePagamento> termsPaymentArgumentCaptor;

    @Captor
    private ArgumentCaptor<Integer> idArgumentCaptor;

    @Nested
    class createTermsPayment {
        @Test
        @DisplayName("Should create a Terms of Payment with success")
        void shouldCreateATermsOfPaymentWithSuccess() {
            var termsPayment = new TermosDePagamento(1,
                    "cinquenta_cinquenta",
                    Instant.now(),
                    Instant.now());

            var termsPaymentDTO = new TermosDePagamentosDTOS("cinquenta_cinquenta");

            doReturn(termsPayment)
                    .when(termosDePagamentoRepository)
                    .save(any());
            var input = termosDePagamentoServices.createTermosDePagamento(termsPaymentDTO);
            assertNotNull(input);
        }

        @Test
        @DisplayName("Should Throw Exception When Error Occurs")
        void shouldThrowExceptionWhenErrorOccurs() {
            var input = new TermosDePagamentosDTOS("cinquenta_cinquenta");

            doReturn(new RuntimeException()).when(termosDePagamentoRepository).save(any());
            assertThrows(RuntimeException.class, () -> termosDePagamentoServices.createTermosDePagamento(input));
        }


        @Test
        @DisplayName("Should Throw Exception When Argument Captor")
        void shouldThrowExceptionWhenArgumentCaptor() {
            var termsPayment = new TermosDePagamento(1,
                    "cinquenta_cinquenta",
                    Instant.now(),
                    Instant.now());
            var termsPaymentDTO = new TermosDePagamentosDTOS("cinquenta_cinquenta");

            doReturn(termsPayment)
                    .when(termosDePagamentoRepository)
                    .save(termsPaymentArgumentCaptor.capture());

            var input = termosDePagamentoServices.createTermosDePagamento(termsPaymentDTO);

            assertNotNull(input);

            var termsPaymentCapture = termsPaymentArgumentCaptor.getValue();
            assertEquals(termsPaymentDTO.nome(), termsPaymentCapture.getNomeTermosDePagamentos());

        }


    }

    @Nested
    class getByID {

        @Test
        @DisplayName("Should Get Terms Of Payment By Id With Success When OptionalIs Present")
        void shouldGetTermsOfPaymentByIdWithSuccessWhenOptionalIsPresent() {

            var termsPayment = new TermosDePagamento(1,
                    "cinquenta_cinquenta",
                    Instant.now(),
                    Instant.now());
            doReturn(Optional.of(termsPayment))
                    .when(termosDePagamentoRepository)
                    .findById(idArgumentCaptor.capture());

            var output = termosDePagamentoServices.getbyIDTermosDePagamento(termsPayment.getIdTermosDePagamento());

            assertTrue(output.isPresent());
            assertEquals(termsPayment.getIdTermosDePagamento(), idArgumentCaptor.getValue());
        }


        @Test
        @DisplayName("Should Get Terms Of Payment By Id With Success When OptionalIs Empty")
        void shouldGetTermsOfPaymentByIdWithSuccessWhenOptionalIsEmpty() {

            var termsPayment = new TermosDePagamento(1,
                    "cinquenta_cinquenta",
                    Instant.now(),
                    Instant.now());

            var termsPaymentID = 44;
            doReturn(Optional.empty())
                    .when(termosDePagamentoRepository)
                    .findById(idArgumentCaptor.capture());

            var output = termosDePagamentoServices.getbyIDTermosDePagamento(termsPaymentID);

            assertTrue(output.isEmpty());
            assertEquals(termsPaymentID, idArgumentCaptor.getValue());
        }
    }

    @Nested
    class getAll {

        @Test
        @DisplayName("Should return all users with success")
        void shouldReturnAllTermsOfPaymentWithSuccess() {

            var termsPayment = new TermosDePagamento(1,
                    "cinquenta_cinquenta",
                    Instant.now(),
                    Instant.now());

            var listTermsPayments = List.of(termsPayment);
            doReturn(listTermsPayments)
                    .when(termosDePagamentoRepository)
                    .findAll();

            var output = termosDePagamentoServices.getAll();

            assertNotNull(output);
            assertEquals(listTermsPayments.size(), output.size());
        }


    }

    @Nested
    class delete {

        @Test
        @DisplayName("Should delete user with success when user exists")
        void shouldDeleteUserWithSuccessWhenUserExists(){

            doReturn(true).when(termosDePagamentoRepository).existsById(idArgumentCaptor.capture());
            doNothing()
                    .when(termosDePagamentoRepository)
                    .deleteById(idArgumentCaptor.capture());

            var termsOfPaymentID = 55;

            termosDePagamentoServices.delete(termsOfPaymentID);

            var idList = idArgumentCaptor.getAllValues();

            assertEquals(termsOfPaymentID, idList.get(0));
            assertEquals(termsOfPaymentID, idList.get(1));

            verify(termosDePagamentoRepository, times(1)).existsById(idList.get(0));
            verify(termosDePagamentoRepository, times(1)).deleteById(idList.get(1));
        }

        @Test
        @DisplayName("Should not delete terms of payment when user NOT exists")
        void shouldNotDeleteTermsOfPaymentWhenUserNotExists(){

            doReturn(false).when(termosDePagamentoRepository).existsById(idArgumentCaptor.capture());

            var termsOfPaymentID = 55;

            termosDePagamentoServices.delete(termsOfPaymentID);

            assertEquals(termsOfPaymentID, idArgumentCaptor.getValue());

            verify(termosDePagamentoRepository, times(1)).existsById(idArgumentCaptor.getValue());
            verify(termosDePagamentoRepository, times(0)).deleteById(any());
        }
    }


}