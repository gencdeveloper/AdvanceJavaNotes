package Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(2,3,2,10,23);


        /**empty()-->Returns an empty Optional instance*/
        /**isPresent()-->Returns true if a values is present; otherwise return false*/
        System.out.println("**********//empty() -isPresent()*********");
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());
        System.out.println(Optional.of(numbers).isPresent()); //if you convert to Optional that time u can use isPresent for List:)


        /**ifPresent()-->If value is present, invokes the specified consumer with the value; otherwise does nothing*/
        System.out.println("**********//ifPresent*********");
        Optional<Integer> bigNumber = numbers.stream().filter(x -> x>100).findAny();
        bigNumber.ifPresent(System.out::println);

        /**get()--->Returns the value wrapped by this Optional if present; otherwise, throws a NoSuchElementException*/
        System.out.println("**********//get*********");
        System.out.println(bigNumber.get());

        /**orElse()--> Returns the value if present; otherwise, returns the given default value*/
        System.out.println(bigNumber.orElse(0));
    }
}
