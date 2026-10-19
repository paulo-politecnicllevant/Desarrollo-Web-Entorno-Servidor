public interface Facturable {
    int IVA_REDUIT = 10;
    int IVA_GENERAL = 21;

    String concepte();

    double baseImposable();

    int percentatgeIva();

    default double iva() {
        return baseImposable() * percentatgeIva() / 100.0;
    }

    default double total() {
        return baseImposable() + iva();
    }
}
