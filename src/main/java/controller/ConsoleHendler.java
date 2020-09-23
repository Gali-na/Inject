package controller;

import dao.BetDao;
import java.util.Scanner;
import lib.Inject;
import model.Bet;

public class ConsoleHendler {
    @Inject
    BetDao betDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        String comand = scanner.nextLine();
        Bet bet = null;
        try {
            String[] bedData = comand.split(" ");
            int value = Integer.parseInt(bedData[0]);
            double risk = Double.parseDouble(bedData[1]);
            bet = new Bet(value, risk);

        } catch (NumberFormatException e) {
            System.out.println("Введiть коректні данні");
        }
        betDao.add(bet);
        System.out.println(bet.toString());
        System.out.println(betDao.getAll());

    }
}


