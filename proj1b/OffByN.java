public class OffByN implements CharacterComparator {

    int diffExpected;
    @Override
    public boolean equalChars(char x, char y) {
        int diffActual = x - y;
        if (diffActual == diffExpected || diffActual == -diffExpected) {
            return true;
        }
        return false;
    }

    public OffByN(int N) {
        this.diffExpected = N;
    }
}
