import java.util.regex.Pattern;

class Client {
    private String email;
    private String ip;
    private String address;
    private String url;

    public Client(String email, String ip, String address, String url) {
        this.email = email;
        this.ip = ip;
        this.address = address;
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", ip='" + ip + '\'' +
                ", address='" + address + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

class ClientValidator {

    public boolean validateEmail(String email) {
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";
        return email.matches(emailRegex);
    }

    public boolean validateIP(String ip) {
        String ipRegex = "((25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)";
        return ip.matches(ipRegex);
    }

    public boolean validateUrl(String url) {
        String urlRegex = "^(https?://)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}(/[a-zA-Z0-9._-]*)*/?$";
        return url.matches(urlRegex);
    }

    public boolean validateAddress(String address) {
        address = address.replaceAll("[%$@<>?*()]", "").trim();

        //String addressRegex = "^[А-Яа-я.\\s]+ обл\\. [А-Яа-я]+ р-н [А-Яа-я]+ г\\. или д\\. [А-Яа-я]+ ул\\. [А-Яа-я]+ д\\. \\d+$";
        //String addressRegex = "^\\s*[А-Яа-я.\\s]+ обл\\. [А-Яа-я]+ р-н [А-Яа-я]+ г\\. или д\\. [А-Яа-я]+ ул\\. [А-Яа-я]+ д\\. \\d+$";
        String addressRegex = "^\\s*[А-Яа-я.\\s]+ обл\\. [А-Яа-я]+ р-н [А-Яа-я]+ г\\.|д\\. [А-Яа-я]+ ул\\. [А-Яа-я]+ д\\. \\d+$";

        return address.matches(addressRegex);
        //return Pattern.matches(addressRegex,address);
    }

}

public class ClientTest {
    public static void main(String[] args) {
        ClientValidator validator = new ClientValidator();


        Client client1 = new Client("my_email@gmail.com", "127.0.0.1", "Минская обл. Минский р-н г. Минск ул. Пушка д. 123", "https://www.example.com");
        Client client2 = new Client("a.petrov@gmail.com", "192.168.1.1", "Московская обл. Московский р-н г. Пуло ул. Центральная д. 5", "http://example.org");
        Client client3 = new Client("coder-4575@yandex.ru", "10.0.0.1", "Брестская обл. Брестский р-н г. Брест ул. Светлая д. 1", "ftp://ftp.example.net");


        System.out.println(client1);
        System.out.println("Email валиден: " + validator.validateEmail(client1.getEmail()));
        System.out.println("IP валиден: " + validator.validateIP(client1.getIp()));
        System.out.println("URL валиден: " + validator.validateUrl(client1.getUrl()));
        System.out.println("Адрес валиден: " + validator.validateAddress(client1.getAddress()));
        System.out.println();

        System.out.println(client2);
        System.out.println("Email валиден: " + validator.validateEmail(client2.getEmail()));
        System.out.println("IP валиден: " + validator.validateIP(client2.getIp()));
        System.out.println("URL валиден: " + validator.validateUrl(client2.getUrl()));
        System.out.println("Адрес валиден: " + validator.validateAddress(client2.getAddress()));
        System.out.println();

        System.out.println(client3);
        System.out.println("Email валиден: " + validator.validateEmail(client3.getEmail()));
        System.out.println("IP валиден: " + validator.validateIP(client3.getIp()));
        System.out.println("URL валиден: " + validator.validateUrl(client3.getUrl()));
        System.out.println("Адрес валиден: " + validator.validateAddress(client3.getAddress()));
    }
}