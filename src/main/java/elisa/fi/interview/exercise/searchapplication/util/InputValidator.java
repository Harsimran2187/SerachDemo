package elisa.fi.interview.exercise.searchapplication.util;

import java.util.Arrays;
import java.util.Objects;

public class InputValidator {

    static boolean valid;
    private InputValidator(){}
    public static boolean isValidInput(int[] array) {
        if(array.length == 0 || !isIntArray(array)){
            valid = false;
        } else{
            valid = true;
        }
            return valid;
    }

    public static boolean isIntArray(Object array){
        if(!array.getClass().isArray()){
            return false;
        }
        return array.getClass().getComponentType()==int.class;
    }

}
