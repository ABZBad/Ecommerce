package com.Ecommerce.MercadoPagoEcommerce.DTO;

import javax.validation.constraints.NotNull;

public class IdentificacionPago {
	 @NotNull
	    private String type;

	    @NotNull
	    private String number;

	    public IdentificacionPago() {
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public String getNumber() {
	        return number;
	    }

	    public void setNumber(String number) {
	        this.number = number;
	    }
}
