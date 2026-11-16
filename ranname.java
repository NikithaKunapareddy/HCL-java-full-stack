public class ranname{
    public static void main(String[] args) {
        String names[] = {"Nikita", "Teja", "Balu", "Rohit", "Udaya"};
        System.out.println("Random name is: " + names[(int) (Math.random() * names.length)]);
    }
}