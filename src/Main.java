import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        InputPersonalData inputPersonalData = new InputPersonalData();
        String[] data = inputPersonalData.readData(); // Возвращает мне массив строк вида [Михайлиди, Владимир, Михайлович, 02.05.1978, 451278, m]
        AnalysisData analysisData = new AnalysisData(data);
        HashMap<String, Object> checkedData = analysisData.checkData();
        WriteFile writeFile = new WriteFile(checkedData.get("lastName") + ".txt");
        StringBuilder sb = new StringBuilder();
        for (String str : checkedData.keySet()) {
            sb.append(checkedData.get(str));
            sb.append(" ");
        }
        System.out.println(checkedData);
        String filePath = writeFile.fileName;
        System.out.println(filePath);
        writeFile.writeData(String.valueOf(sb), filePath);


        }
    }
