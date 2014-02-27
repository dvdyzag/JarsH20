package fiusac.ia1.search;
public enum Reglas{
	LLENAR4,
	LLENAR3,
	VACIAR4,
	VACIAR3,
	TRASLADO43,
	TRASLADO34
	;
	@Override
    public String toString() {
        return this.name();
    }
}
