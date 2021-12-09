package com.Ecommerce.MercadoPagoEcommerce.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.MercadoPagoEcommerce.DTO.PagoRespuesta;
import com.Ecommerce.MercadoPagoEcommerce.DTO.TarjetaPago;
import com.Ecommerce.MercadoPagoEcommerce.Service.EcomerceService;

@RestController
@RequestMapping("/process_payment")
public class TarjetaPagoController {
	private EcomerceService cardPaymentService;

    @Autowired
    public TarjetaPagoController(EcomerceService cardPaymentService) {
        this.cardPaymentService = cardPaymentService;
    }

    @PostMapping
    public ResponseEntity<PagoRespuesta> processPayment(@RequestBody @Valid TarjetaPago cardPaymentDTO) {
        PagoRespuesta payment = cardPaymentService.processPayment(cardPaymentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
