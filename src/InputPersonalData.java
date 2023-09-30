import java.util.Scanner;

public class InputPersonalData {
    public String[] readData() {
        Scanner iScanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите строку через ПРОБЕЛ (строка должна содержать Ф.И.О, дату рождения - dd.mm.yyyy, номер телефона - цифры, пол - f/m ) : ");
            String data = iScanner.nextLine();
            String[] arrayData = data.split(" ");
            if (arrayData.length == 6) {
                return arrayData;
            } else if (arrayData.length < 6){
                System.out.println("Вы ввели недостаточно данных или не поставили где-то пробел, попробуйте снова");
            } else System.out.println("Вы ввели лишние критерии или поставили лишний пробел, попробуйте снова");
        }

    }

//    @Override
//    public String toString() {
//      for (String item: readData()){
//          System.out.printf("[ %s ]", item);
//      }
//      return "";
//    }
}
