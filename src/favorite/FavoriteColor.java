package favorite;



import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.Scanner;

public class FavoriteColor {
    public static void main(String[] args) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode colorsNode = objectMapper.readTree(new File("D:\\JavaProgram\\untitled12\\src\\favorite\\color.json"));


            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите значение id (от 1 до 7): ");
            int userChoice = scanner.nextInt();


            JsonNode selectedColorNode = findColorById(colorsNode, userChoice);
            if (selectedColorNode != null) {
                String colorName = selectedColorNode.get("color").asText();
                String colorValue = selectedColorNode.get("value").asText();


                System.out.println("Мой любимый цвет " + colorName + ", окрашенный в " + colorValue);
            } else {
                System.out.println("Цвет с указанным id не найден.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JsonNode findColorById(JsonNode colorsNode, int id) {
        for (JsonNode colorNode : colorsNode.get("colors")) {
            if (colorNode.get("id").asInt() == id) {
                return colorNode;
            }
        }
        return null;
    }
}
