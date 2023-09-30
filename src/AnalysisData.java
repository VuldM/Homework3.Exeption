import java.util.HashMap;

public class AnalysisData {
    String[] data;
    AnalysisData(String[] data){
       this.data= data;
    }



    public HashMap<String, Object> checkData(){
        HashMap<String, Object> dataMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String i : data) {
            if (i.length() == 1) {
                if (i.equals("f") || i.equals("m")) {
                    dataMap.put("sex", i);
                } else{
                    try {
                        throw new SexException();
                    } catch (SexException e) {
                        e.sexException(i);
                    }
                }
            } else if (i.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                String[] arrayDate = i.split("\\.");
                boolean flag = false;
                if (Integer.parseInt(arrayDate[0]) < 0 ||
                        Integer.parseInt(arrayDate[0]) > 31 || Integer.parseInt(arrayDate[1]) < 0 ||
                        Integer.parseInt(arrayDate[1]) > 12 || Integer.parseInt(arrayDate[2]) < 0 ||
                        Integer.parseInt(arrayDate[2]) > 2023-18) {
                    try {
                        throw new DateException();
                    } catch (DateException e) {
                        e.dateException(i);
                        throw new RuntimeException();
                    }
                } else {
                    if (Integer.parseInt(arrayDate[2]) % 4 == 0) {// если год високосный
                        if (Integer.parseInt(arrayDate[1]) == 1 ||
                                Integer.parseInt(arrayDate[1]) == 3 ||
                                Integer.parseInt(arrayDate[1]) == 5 ||
                                Integer.parseInt(arrayDate[1]) == 7 ||
                                Integer.parseInt(arrayDate[1]) == 9 ||
                                Integer.parseInt(arrayDate[1]) == 10 ||
                                Integer.parseInt(arrayDate[1]) == 12) {
                            if (Integer.parseInt(arrayDate[0]) < 32) {
                                flag = true;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 2) {
                            if (Integer.parseInt(arrayDate[0]) < 30) {
                                flag = true;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 4 ||
                                Integer.parseInt(arrayDate[1]) == 6 ||
                                Integer.parseInt(arrayDate[1]) == 8 ||
                                Integer.parseInt(arrayDate[1]) == 11) {
                            if (Integer.parseInt(arrayDate[0]) < 31) {
                                flag = true;
                            }
                        }
                    } else {
                        if (Integer.parseInt(arrayDate[1]) == 1 ||
                                Integer.parseInt(arrayDate[1]) == 3 ||
                                Integer.parseInt(arrayDate[1]) == 5 ||
                                Integer.parseInt(arrayDate[1]) == 7 ||
                                Integer.parseInt(arrayDate[1]) == 9 ||
                                Integer.parseInt(arrayDate[1]) == 10 ||
                                Integer.parseInt(arrayDate[1]) == 12) {
                            if (Integer.parseInt(arrayDate[0]) < 32) {
                                flag = true;
                            }
                        } else if (Integer.parseInt(arrayDate[2]) == 2) {
                            if (Integer.parseInt(arrayDate[0]) < 29) {
                                flag = true;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 4 ||
                                Integer.parseInt(arrayDate[1]) == 6 ||
                                Integer.parseInt(arrayDate[1]) == 8 ||
                                Integer.parseInt(arrayDate[1]) == 11) {
                            if (Integer.parseInt(arrayDate[0]) < 31) {
                                flag = true;
                            }
                        }

                    }
                    if (flag) {
                        dataMap.put("date", i);
                    } else try {
                        throw new DateException();
                    } catch (DateException e) {
                        e.dateException(i);
                        throw new RuntimeException();
                    }
                }

            } else if (i.matches("[0-9]+")) {
                dataMap.put("tel", i);
            } else if (i.matches("[A-Za-z]+")) {
                sb.append(i + " ");
            }else if(i.matches("[А-Яа-я]+")){
                sb.append(i + " ");
            } else {
                try {
                    throw new NotLettersNotNumbersException();
                } catch (NotLettersNotNumbersException e) {
                    e.notLettersNotNumbersException(i);
                    throw new RuntimeException();
                }
            }
        }

        String[] fullName = String.valueOf(sb).split(" ");
        if (fullName.length == 3) {
            dataMap.put("firstName", fullName[1]);
            dataMap.put("lastName", fullName[0]);
            dataMap.put("patronymic", fullName[2]);
        }
        return dataMap;
    }
}
