package Lab_5_Homework;

public class ListCommand extends  Command{
private Catalog c;
    public ListCommand(Catalog c){
    }
    /*public void ListCom(Catalog c){
        System.out.println(c);
    }
     */

    @Override
    public void execute() {
        System.out.println(c);
    }
}
