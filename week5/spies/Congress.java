package week5.spies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Congress implements Observable {

    private Random generator = new Random();

    private List<Observer> members = new ArrayList<>(10);

    public void register(Observer member) {
        members.add(member);
    }

    public void leave() {
        Iterator<Observer> iterator = members.iterator();
        Observer member;
        while (iterator.hasNext()) {
            member = iterator.next();
            System.out.println("Учасник З'їзду корупціонерів в якості шпигуна Антикорупційного агенства " + member + " успішно покинув з'їзд!");
            System.out.println();
            iterator.remove();
        }
    }

    public void conductCongress() {
        System.out.println("Урочисто розпочато черговий З'їзд корупціонерів!");
        System.out.println();
        tryExpose();
        discussionExpandingTheRanks();
        tryExpose();
        discussionHowToHaveMoney();
        tryExpose();
        discussionSourcesOfIncome();
        System.out.println("Черговий З'їзд корупціонерів урочисто завершено!");
        System.out.println();
    }

    public void informAll(Message discussion) {
        Iterator<Observer> iterator = members.iterator();
        while (iterator.hasNext()) {
            iterator.next().informMember(discussion);
        }
    }

    private void discussionExpandingTheRanks() {
        System.out.println("Обговорюється розширення лав корупціонерів...");
        System.out.println();
        informAll(new Message("Корупціонери розширять свої лави за допомогою залучення депутатів від партій, що фінансуються за рахунок олігархічних еліт!"));
    }

    private void discussionHowToHaveMoney() {
        System.out.println("Обговорюються способи відмивання коштів...");
        System.out.println();
        informAll(new Message("Корупціонери розпочнуть контрабандну торгівлю з невизнаними республіками ОРДЛО з подальшим виведенням грошей у банки на Кіпрі!"));
    }

    private void discussionSourcesOfIncome() {
        System.out.println("Обговорюються джерела надходження хабарів...");
        System.out.println();
        informAll(new Message("Корупціонери піднімуть усі тарифи та знизять соціальні виплати за рахунок надання субсидій, які будуть призначатись за хабар!"));
    }

    private void tryExpose() {
        int attempts = generator.nextInt(members.size());
        for (int i = 0; i < attempts; attempts--) {
            Observer member = members.get(generator.nextInt(members.size()));
            if (generator.nextInt(2) == 0) {
                members.remove(member);
                System.out.println("Учасник З'їзду корупціонерів " + member + " виявився шпигуном Антикорупційного агенства і зник за загадкових обставин під час відвідування буфету!");
                System.out.println();
            }
        }
    }

}
