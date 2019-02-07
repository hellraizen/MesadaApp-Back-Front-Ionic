package com.dleite.domain.enumaration;

public enum StatusPay {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

	private int cod;
	private String descricao;

	private StatusPay(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusPay toEnum(Integer id) {

		 if (id == null) {
		 return null;
		 }
		 
		 for (StatusPay x : StatusPay.values()) {
			 if (id.equals(x.getCod())) {
				 return x;
			 }
		 }
		 throw new IllegalArgumentException("Id inválido " + id);
	}
	

}
