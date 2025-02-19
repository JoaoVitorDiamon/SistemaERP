package com.system.SystemERP.Services.TypesPayments;

import com.system.SystemERP.Dtos.TypesPayments.TypesPaymentsDTO;
import com.system.SystemERP.Entity.TypesPayments.TypesPayments;
import com.system.SystemERP.Enum.TypesPayments.TypesPaymentsEnum;
import com.system.SystemERP.Repository.TypesPayments.TypesPaymentsRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class TypesPaymentsServicesTest {

    @Mock
    private TypesPaymentsRepository typesPaymentsRepository;

    @InjectMocks
    private TypesPaymentsServices typesPaymentsServices;

    @Captor
    private ArgumentCaptor<TypesPayments> typesPaymentsArgumentCaptor;

    @Nested
    @DisplayName("Should create a Types Payments with success")
    class createTypesPayments {
        @Test
        void shouldCreateATypesPaymentsWithSuccess() {
            var typesPaymentsDTO = new TypesPaymentsDTO(TypesPaymentsEnum.cartao_de_credito);
            var typesPaymentsObject = new TypesPayments(
                    5,
                    typesPaymentsDTO.name().name(),
                    Instant.now(),
                    null
            );

            doReturn(typesPaymentsObject)
                    .when(typesPaymentsRepository)
                    .save(any());

            var input = typesPaymentsServices.createTypePayment(typesPaymentsDTO);

            assertNotNull(input);

        }

        @Test
        @DisplayName("Should Throw Exception When Error Occurs")
        void shouldThrowExceptionWhenErrorOccurs() {
            var typesPaymentsDTO = new TypesPaymentsDTO(TypesPaymentsEnum.cartao_de_credito);
            var typesPaymentsObject = new TypesPayments(
                    5,
                    typesPaymentsDTO.name().name(),
                    Instant.now(),
                    null
            );
            doReturn(new RuntimeException())
                    .when(typesPaymentsRepository)
                    .save(typesPaymentsObject);

            assertThrows(RuntimeException.class,
                    () -> typesPaymentsServices.createTypePayment(typesPaymentsDTO));
        }

        @Test
        @DisplayName("Should Throw Exception When Argument Captor")
        void shouldThrowExceptionWhenArgumentCaptor() {
            var typesPaymentsDTO = new TypesPaymentsDTO(TypesPaymentsEnum.cartao_de_credito);
            var typesPaymentsObject = new TypesPayments(
                    5,
                    typesPaymentsDTO.name().name(),
                    Instant.now(),
                    null
            );

            doReturn(typesPaymentsObject)
                    .when(typesPaymentsRepository)
                    .save(typesPaymentsArgumentCaptor.capture());

            var input = typesPaymentsServices.createTypePayment(typesPaymentsDTO);
            assertNotNull(input);

            var typesPaymentsCapture =  typesPaymentsArgumentCaptor.getValue();
            assertEquals(typesPaymentsDTO.name().name(), typesPaymentsCapture.getTypePayment());


        }
    }

// Falta terminar os testes
}