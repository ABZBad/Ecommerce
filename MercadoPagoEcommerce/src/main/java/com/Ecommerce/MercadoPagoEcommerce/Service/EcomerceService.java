package com.Ecommerce.MercadoPagoEcommerce.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ecommerce.MercadoPagoEcommerce.DTO.PagoRespuesta;
import com.Ecommerce.MercadoPagoEcommerce.DTO.TarjetaPago;
import com.Ecommerce.MercadoPagoEcommerce.Exception.MercadoPagoException;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Identification;
import com.mercadopago.resources.datastructures.payment.Payer;

@Service
public class EcomerceService {
	///Aquí poner la claver del vendedor publica de mercado pago
	@Value("${mercado_pago_sample_access_token}")
    private String mercadoPagoAccessToken;

    public PagoRespuesta processPayment(TarjetaPago cardPaymentDTO) {
        try {
            MercadoPago.SDK.setAccessToken(mercadoPagoAccessToken);

            Payment payment = new Payment();
            payment.setTransactionAmount(cardPaymentDTO.getTransactionAmount())
                    .setToken(cardPaymentDTO.getToken())
                    .setDescription(cardPaymentDTO.getProductDescription())
                    .setInstallments(cardPaymentDTO.getInstallments())
                    .setPaymentMethodId(cardPaymentDTO.getPaymentMethodId());

            Identification identification = new Identification();
            identification.setType(cardPaymentDTO.getPayer().getIdentification().getType())
                    .setNumber(cardPaymentDTO.getPayer().getIdentification().getNumber());

            Payer payer = new Payer();
            payer.setEmail(cardPaymentDTO.getPayer().getEmail());
            payer.setIdentification(identification);

            payment.setPayer(payer);

            Payment createdPayment = payment.save();

            PagoRespuesta paymentResponseDTO = new PagoRespuesta(
                    createdPayment.getId(),
                    String.valueOf(createdPayment.getStatus()),
                    createdPayment.getStatusDetail()
            );

            return paymentResponseDTO;
        } catch (MPException exception) {
            throw new MercadoPagoException(exception.getMessage());
        }
    }
}
