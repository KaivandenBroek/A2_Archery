package nl.hva.ict.ads;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Archer> archers = Archer.generateArchers(10);

        Archer.toString(archers);
    }


}
