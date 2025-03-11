
public class Funcoes {

    public int f1(int n) {
        int r = 0;
        for (int i = 0; i < n; i++) {
            r = r + 1;
        }
        return r;
    }

    public int f2aux(int n) {
        int r = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                r = r + 1;

            }
        }
        return r;
    }

    public int f2(int n) {
        int r = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                r = r + 1;

            }
        }
        return r;
    }

    public int f4(int n) {
        int r = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < 2 * i; j++) {
                for (int k = i; k < j; k++) {
                    r = r + 1;
                }
            }
        }
        return r;

    }

    public int f5(int n) {
        int r = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < i + 3; j++) {
                for (int k = i; k < j; k++) {
                    r = r + 1;
                }
            }
        }
        return r;
    }

}
