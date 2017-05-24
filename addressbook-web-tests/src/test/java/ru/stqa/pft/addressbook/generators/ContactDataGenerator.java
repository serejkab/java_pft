package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactFio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SerejKa on 23.05.2017.
 */
public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target File")
    public String file;

    @Parameter(names = "-d", description = "Data fotmat")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);

        try {
            jCommander.parse(args);
        }
        catch (ParameterException ex){
            jCommander.usage();
            return;
        }

        generator.run();

    }

    private void run() throws IOException {
        List<ContactFio> contacts = generateContacts(count);
       if (format.equals("json")){
            saveAsJson(contacts, new File(file));
        }else {
            System.out.println("Unrecognized format" + format);
        }
    }

    private void saveAsJson(List<ContactFio> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private  List<ContactFio> generateContacts(int count) {
        List<ContactFio> contacts = new ArrayList<>();
        for (int i = 0; i <count; i++){
            contacts.add(new ContactFio().withLastname(String.format("lastname %s", i)).withName(String.format("name %s", i)).withAddress(String.format("address %s", i))
                    .withHomePhone(String.format("homephone %s", i)).withEmail(String.format("email %s", i)));
        }
        return contacts;
    }
}

