package com.solvd.computer;


import com.solvd.exceptions.ProcessorException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        FIDoSomething f =() -> LOGGER.info("Hello from Computer");
        f.doSmth();

      String path = "C://Users//Marianna//Hello.txt";
      String content = " ";
        try {

           content = Files.readString(Paths.get(path));

       } catch (IOException e) {
            e.printStackTrace();
       }
        String[] words = content.split("\\s*(\\s|,|!|\\.)\\s*");
        Set<String> newWords = new HashSet<String>();
       Collections.addAll(newWords, words);
        File newFile = new File("C://Users//Marianna//newFile1.txt");
       FileUtils.writeStringToFile(newFile, String.valueOf(newWords.size()), (String) null);

        Dell batteryNumber = new Dell();
        batteryNumber.addRandom();

        LOGGER.info("Battery serial number" + batteryNumber.toString());

        HashSet<MacBook> operationSystems = new HashSet<MacBook>();

        operationSystems.add(new MacBook("Windows"));
        operationSystems.add(new MacBook("Linux"));
      operationSystems.add(new MacBook("MacOS"));
        LOGGER.info("Operation Systems:  ", operationSystems);
        for (MacBook m : operationSystems) {

            LOGGER.info(m.getOperationSystem());
       }
        LinkedList<String> processorModels = new LinkedList<>();

        processorModels.add("intel core i9");
        processorModels.add("intel core i7");
        processorModels.addLast("intel xeon e3"); // добавляем на последнее место
        processorModels.addFirst("intel core i5"); // добавляем на первое место
                LOGGER.info(" List has %d elements ", processorModels.size());for (String processorModel : processorModels) {
            LOGGER.info(processorModels);
        }
       List<User> users = new ArrayList<User>();
      users.add(new User("Masha"));
       users.add(new User("Sasha"));
        users.add(new User("Denis"));
        for (User user : users) {
           LOGGER.info("user of computer  " + user.getName());
        }
        CustomLinkedList<Email> emails = new CustomLinkedList<>();
        emails.addFirst(new Email("denis@gmail.ru"));
        emails.addLast(new Email("sasha@mail.ru"));
        LOGGER.info(emails.getFirst().getEmail());
        Dell battery = new Dell();
        battery.getBattery();
       User pasha = new User("Pasha");
        Email email1 = new Email("text1", "test1@gmail.ru");
        Email email2 = new Email("text2", "test2@gmail.ru");
        Computer user2 = new Asus("user2");
        Computer user3 = new Asus("user2");
        LOGGER.info(user2.toString());
        LOGGER.info(user2.equals(user3));
        LOGGER.info(user2 == user3);
        user3.send(pasha, users.stream().filter(u -> u.getName().equals("Sasha")).findFirst().get(), email1);
        user2.send(users.stream().filter(u -> u.getName().equals("Denis")).findFirst().get(), pasha, email2);
        MacBook.checkModel();
        Dell user4 = new Dell("user4");
        user4.resetToDefaultAllDells();
        user4.showMouseModel();
        Asus processor = new Asus("Pasha");
        try {
            processor.setProcessor("asus");
        } catch (ProcessorException e) {
            LOGGER.info(e);
        }
        try {
            user4.typeOfEmail();
        } catch (NullPointerException e ){
            LOGGER.info("not found type of email");
        }
        int windowsIndex = Asus.OperationSystem.WINDOWS.ordinal();
        LOGGER.info(windowsIndex);

    }
}


