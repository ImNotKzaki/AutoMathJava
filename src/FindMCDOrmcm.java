public class FindMCDOrmcm {
    private int a;
    private int b;

    public int MCD(int n1, int n2){
        a = n1;
        b = n2;

        while (b != 0) {
            int temp = b;
            b = a % b; // Calcola il resto della divisione
            a = temp;
        }

        return a;

    }

    public int mcm(int n1, int n2){
        return (n1 * n2) / MCD(n1, n2);
    }

}
