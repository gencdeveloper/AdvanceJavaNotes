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
        tx.addCity("Dallas");
        tx.addCity("Plano");
        tx.addCity("Austin");
        tx.addCity("Houston");

        //Printing stream of stream.Because my cities list of element with 2 obj
        List<State> list = Arrays.asList(va,tx);

        /**solution with map but with stream of stream print*/
       // list.stream().map(state ->state.getCity()).forEach(System.out::println);


        /**solution with flatmap print*/
        //Solution Another way with flatMap
        list.stream()
                .map(state -> state.getCity())
                .flatMap(List::stream)
                .forEach(System.out::println);



    }

}
