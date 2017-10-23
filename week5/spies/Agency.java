package week5.spies;

import java.util.Iterator;
import java.util.List;

public class Agency {

    public void sendForAPurpose(Observer spy, Observable congress) {
        congress.register(spy);
        System.out.println("Шпигун та антикорупціонер " + spy + " був підісланий на Зїзд корупціонерів за завданням Антикорупційного агенства!");
        System.out.println();
    }

    public void makePublic(List<Message> agenda, Observer spy) {
        System.out.println("==============================================================================================================================");
        Iterator<Message> iterator = agenda.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getMessage());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Завзятий антикорупціонер і борець за права громадян " + spy);
        System.out.println("==============================================================================================================================");
        System.out.println();
    }

}