package modelo;

public class Usuario {
	private String dni;
	private char sexo;
	private String cuil;
	
	public Usuario(String dni, char sexo) {
		this.dni = dni;
		this.sexo = sexo;
		this.cuil = crearCuil();
	}
	
	public String crearCuil() {
		String cuilAux= "20"+String.valueOf(dni);
		String nroAMultiplicar= "5432765432";
		int suma=0;
		
		if(sexo=='f') {
			cuilAux="27"+cuilAux.substring(2);
		}
		for (int i=0;i<nroAMultiplicar.length();i++) {
			suma += Character.getNumericValue(cuilAux.charAt(i))*Character.getNumericValue(nroAMultiplicar.charAt(i));
		}
		switch(suma%11) {
		case 0:cuilAux+='0';break;
		case 1:if(sexo=='m') {
			cuilAux="23"+cuilAux.substring(2)+"9";
		}
		else {
			cuilAux="23"+cuilAux.substring(2)+"4";
		}break;
		default:cuilAux=cuilAux+(11-suma%11);break;
		}
		
		
		cuilAux= cuilAux.substring(0, 2)+"-"+cuilAux.substring(2, 10)+"-"+cuilAux.substring(10);
		return cuilAux;
	}
	
	//GST
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", sexo=" + sexo + ", cuil=" + cuil + "]";
	}
	
}
