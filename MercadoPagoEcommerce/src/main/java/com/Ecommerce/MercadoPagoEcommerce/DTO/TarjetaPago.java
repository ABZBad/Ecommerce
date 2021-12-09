package com.Ecommerce.MercadoPagoEcommerce.DTO;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TarjetaPago {
	///Aquí poner la claver del vendedor publica de mercado pago
	 @NotNull
	    private String token;
 
	    private String issuerId;

	    @NotNull
	    private String paymentMethodId;

	    @NotNull
	    private Float transactionAmount;

	    @NotNull
	    private Integer installments;

	    @NotNull
	    @JsonProperty("description")
	    private String productDescription;

	    @NotNull
	    private Pago payer;

	    public TarjetaPago() {
	    }

	    public String getToken() {
	        return token;
	    }

	    public void setToken(String token) {
	        this.token = token;
	    }

	    public String getIssuerId() {
	        return issuerId;
	    }

	    public void setIssuerId(String issuerId) {
	        this.issuerId = issuerId;
	    }

	    public String getPaymentMethodId() {
	        return paymentMethodId;
	    }

	    public void setPaymentMethodId(String paymentMethodId) {
	        this.paymentMethodId = paymentMethodId;
	    }

	    public Float getTransactionAmount() {
	        return transactionAmount;
	    }

	    public void setTransactionAmount(Float transactionAmount) {
	        this.transactionAmount = transactionAmount;
	    }

	    public Integer getInstallments() {
	        return installments;
	    }

	    public void setInstallments(Integer installments) {
	        this.installments = installments;
	    }

	    public String getProductDescription() {
	        return productDescription;
	    }

	    public void setProductDescription(String productDescription) {
	        this.productDescription = productDescription;
	    }

	    public Pago getPayer() {
	        return payer;
	    }

	    public void setPayer(Pago payer) {
	        this.payer = payer;
	    }
}
