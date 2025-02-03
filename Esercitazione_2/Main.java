public class Main {
    public static void main(String[] args) {
        StudenteView view = new StudenteView();
        new StudenteController(view);
        view.setVisible(true);
    }
}