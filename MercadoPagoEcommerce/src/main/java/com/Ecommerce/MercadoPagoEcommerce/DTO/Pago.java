package com.Ecommerce.MercadoPagoEcommerce.DTO;

import javax.validation.constraints.NotNull;



public class Pago {
    @NotNull
    private String email;

    @NotNull
    private IdentificacionPago identification;

    public Pago() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IdentificacionPago getIdentification() {
        return identification;
    }

    public void setIdentification(IdentificacionPago identification) {
        this.identification = identification;
    }
}
