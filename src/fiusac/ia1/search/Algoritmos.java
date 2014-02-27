package fiusac.ia1.search;
public enum Algoritmos {
	ANCHURA,
	PROFUNDIDAD,
	ANCHURA_LIMITADA,
	PROFUNDIDAD_LIMITADA
	;
	@Override
    public String toString() {
        return this.name();
    }
}
