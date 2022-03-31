package Lab_5_Homework;

public class ListCommand extends  Command{

    public void ListCom(Catalog c){
        System.out.println(c);
    }
    public void showCommand(){
        System.out.println("Comanda de afiasare a catalogului");
    }
}
