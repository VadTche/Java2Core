
    public class MainClass {
        public static void main(String[] args) {

            int itogo = 0;

            //String[][] array = {{"1","1","1","1"},{"2","2","2","2"},{"3","3","3","3"},{"4","4","4","4"}};//Norm
            //String[][] array = {{"1","1","1"},{"2","2","2","2","2"},{"3","3","3","3"},{"4","4","4","4"}};//Size
            String[][] array = {{"1","1","1","ab1"},{"2","2","2","2"},{"3","3","3","3"},{"4","4","4","4"}};//Data

            try {
                itogo = action(array);
            }
            catch(MySizeException | MyDataException e){
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("Сумма элементов массива: " + itogo);
            }
        }

        public static int action(String[][] array) throws MySizeException, MyDataException {
            int fin = 0;
            for (int i=0; i<4; i++) {
            if(array.length != 4 || array[i].length != 4) {
                throw new MySizeException("Размер массива не 4х4");
            }
            }
            for(int i=1;i<5;i++){
                for(int j=1;j<5;j++){
                    try{
                        int value = Integer.parseInt(array[i - 1][j - 1]);
                        fin += value;
                    } catch (NumberFormatException e){
                        String message = "строка " + i +", " + "столбец " + j;
                        e.printStackTrace();
                        throw new MyDataException(message);
                    }
                }
            }

            return fin;
        }
    }
