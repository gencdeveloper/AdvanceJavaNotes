package AdvanceJavaNotes;

import java.util.Arrays;
import java.util.List;

public class StateTest {

    public static void main(String[] args) {
        State va = new State();
        va.addCity("Mclean");
        va.addCity("Arlington");
        va.addCity("Fairfax");
        va.addCity("FallsChurc");

        State tx = new State();
        va.addCity("Dallas");
        va.addCity("Plano");
        va.addCity("Austin");
        va.addCity("Houston");

        List<State> list = Arrays.asList(va,tx);




    }

}
