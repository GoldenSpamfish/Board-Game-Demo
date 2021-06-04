import java.util.Scanner;

public class BoardGameText {


    public static void main(String [] args) {

        //util
        Scanner scan= new Scanner(System.in);

        //variables
        boolean playing = true;
        boolean side = true;
        int input, xIn, yIn;

        //data structure
        DataStructure dataStructure= new DataStructure();


        while (playing) {

            //prints out data structure
            for (int y = 0; y < 10; y++) {
                System.out.println();
                for (int x = 0; x < 10; x++) {

                    System.out.print(dataStructure.getElement(x, y) + "  ");
                }
            }

            //user interface
            System.out.println("\n\nEnter an X coordinate (0-9), -1 to end, or 99 to change sides");
            input=scan.nextInt();

            //checks inputs
            if (input==99){
                side = false;
            }
            else if(input==-1){
                playing=false;
            }
            else if(input<=10){
                //if coordinate input:
                xIn=input;
                System.out.println("Enter a Y coordinate");
                yIn=scan.nextInt();

                //if there is something there, remove it
                if((dataStructure.getElement(xIn, yIn)==1 || (dataStructure.getElement(xIn, yIn)==2))){
                    dataStructure.setElement(xIn, yIn, 0);
                }

                //if it is empty, add color based on which color is selected
                else if(side){
                    dataStructure.setElement(xIn, yIn, 1);
                }
                else {
                    dataStructure.setElement(xIn, yIn, 2);
                }
            }

        }
    }
}
