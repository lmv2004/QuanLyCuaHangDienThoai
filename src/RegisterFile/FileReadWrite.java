
package RegisterFile;

import java.io.*;

public class FileReadWrite {
    // Phương thức để đọc dữ liệu từ tệp
    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // Phương thức để ghi dữ liệu vào tệp
    public static void writeFile(String fileName, String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

