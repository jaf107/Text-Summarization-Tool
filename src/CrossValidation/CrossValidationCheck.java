package CrossValidation;

public class CrossValidationCheck {
    public static void main(String[] args) {
        String s = "Hey, Whatcha doin?";
        String[] sTable = s.split(" ");
        String t = "Hey";

        if(s.contains(t))
        {
            System.out.println(t);
        }

        for (int i = 0; i < sTable.length; i++) {
            if(sTable[i].contains(t))
            System.out.println(t);
        }
    }
}
