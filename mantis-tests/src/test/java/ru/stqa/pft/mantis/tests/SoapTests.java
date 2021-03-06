package ru.stqa.pft.mantis.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.mantis.Model.Issue;
import ru.stqa.pft.mantis.Model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by SerejKa on 06.06.2017.
 */
public class SoapTests extends TestBase{

    @Test
    public void testGetProgects() throws MalformedURLException, ServiceException, RemoteException {
        skipIfNotFixed(2);
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());
        for (Project project : projects){
            System.out.println(project.getName());
        }
    }

    @Test
    public void testCreateIssue()  throws MalformedURLException, ServiceException, RemoteException {
        skipIfNotFixed(1);
        Set<Project> projects = app.soap().getProjects();
        Issue issue = new Issue().withSummary("Summary").withDescription("description").withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary());
    }
}
