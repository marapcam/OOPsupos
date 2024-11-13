public class Main {

    public static int sum(int[] a) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        return total;
    }

    public static int[] cumsum(int[] a) {
        int[] sumArray = new int[a.length];
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            sumArray[i] = a[i] + total;
            total += a[i];
        }
        return sumArray;
    }

    public static int[] positives(int[] a) {
        int current = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0) {
                a[current] = a[i];
                current += 1;
            }
        }
        int[] pos = new int[current];
        for (int j = 0; j < current; j++) {
            pos[j] = a[j];
        }
        return pos;
    }

    public static int[] vectorAdd(int x,int y,int dx, int dy) {
        x=x+dx;
        y=y+dy;
        int[] result = new int[2];
        result[0] = x;
        result[1] = y;
        return result;
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 2;
        int[] result = vectorAdd(a, b, 1, 1);
        a = result[0];
        b = result[1];
        System.out.println(a + "  " + b);
    }
}
