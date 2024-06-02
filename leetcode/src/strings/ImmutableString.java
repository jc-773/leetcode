package strings;

public class ImmutableString {
    private static  String string1 = "string1";
    private static  String string2 = string1;
    private static  String string3 = "string3";

    private static int string1memoryAddress = System.identityHashCode(string1);
    private static int string2memoryAddress = System.identityHashCode(string2);
    private static int string3memoryAddress = System.identityHashCode(string3);

    public static void main(String[] args) {
        string1 = "nevermind";
        string1memoryAddress = System.identityHashCode(string1);
        System.out.println(
            "String1: " + string1 + " String1 memory address: " + string1memoryAddress +
            "\nString2: " + string2 + " String2 memory address: " + string2memoryAddress + 
            "\nString3: " + string3 + " String3 memory address: " + string3memoryAddress
            );
    }
}
