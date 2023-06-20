package Week4_Assignment_II;

import javax.imageio.spi.RegisterableService;

public class Application {
    public static void main(String[] args) {
    Iphone13 tel = new Iphone13();
    tel.addContact(1, 10239,"ofjaf","sadjias");
        tel.addContact(2, 1023339,"zzzz","qqqqqs");
        tel.addContact(3, 11139,"ffff","seeeees");
        tel.addContact(3, 11139,"f","s");
        tel.listaContacte();
        tel.getFirstContact();
        tel.getLastContact();
        tel.sendMessage(10239,"qwertyuiopa");
    }
}
