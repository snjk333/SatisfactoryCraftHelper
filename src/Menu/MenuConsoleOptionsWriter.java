package Menu;

public final class MenuConsoleOptionsWriter {
    private MenuConsoleOptionsWriter() {}
    public static void WriteOptions(){
        System.out.println("Choose what do you want to do? ");
        System.out.println("1 - Find a receipt by name");
        System.out.println("2 - Find a receipt by ingredient ");
        System.out.println("0 - Exit"+'\n');
    }
}
