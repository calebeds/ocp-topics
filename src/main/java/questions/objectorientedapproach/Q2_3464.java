package questions.objectorientedapproach;

class Q2_3464 {
    static int si = 10;
    int i;
    boolean b;
    final boolean bool;

    {si = 5; i = b ? 1000 : 2000;}

    {
        i = 1000;
    }

    {
        bool = (si > 5);
        i = 1000;
    }
}
