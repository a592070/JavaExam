package JavaForReallyImpatientExam.Chapter1Exam;


/**Write a program that reads a string and prints all of its nonempty substrings*/
public class Exam08 {
    public static void main(String[] args) {
        String[] arr = stringToSubstring("Write a program that reads a string and prints all of its nonempty substrings");
        for (String s : arr) {
            System.out.println(s);
        }
    }
    static String[] stringToSubstring(String str){
        String[] arr = str.split("\\ ");
        return arr;
    }
}
