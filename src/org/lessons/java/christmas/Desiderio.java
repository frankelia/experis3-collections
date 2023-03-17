package org.lessons.java.christmas;

import java.util.Objects;

public class Desiderio   {
	private String nome;
	
	private String destinatario;

	public Desiderio(String nome, String destinatario) {
		this.nome = nome;
		this.destinatario = destinatario;
	}

	public String getNome() {
		return nome;
	}

	public String getDestinatario() {
		return destinatario;
	}

	@Override
	public String toString() {
		return "Desiderio [nome=" + nome + ", destinatario=" + destinatario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(destinatario, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desiderio other = (Desiderio) obj;
		return Objects.equals(destinatario, other.destinatario) && Objects.equals(nome, other.nome);
	}
	
	
}
