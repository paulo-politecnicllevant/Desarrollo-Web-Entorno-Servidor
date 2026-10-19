public interface Facturable {
    int IVA_REDUIT = 10;
    int IVA_GENERAL = 21;

    String concepte();

    double baseImposable();

    int percentatgeIVA();

    default double iva() {
        return baseImposable() * percentatgeIVA() / 100.0;
    }

    default double total() {
        return baseImposable() + iva();
    }
}
