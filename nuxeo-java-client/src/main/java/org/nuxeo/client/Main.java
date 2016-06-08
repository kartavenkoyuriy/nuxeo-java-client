package org.nuxeo.client;

import org.nuxeo.client.api.NuxeoClient;
import org.nuxeo.client.api.objects.Document;
import org.nuxeo.client.api.objects.Documents;
import org.nuxeo.client.api.objects.Operation;

/**
 * Created by ykartavenko on 08.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        String url = "http://localhost:8080/nuxeo";
        NuxeoClient nuxeoClient = new NuxeoClient(url, "Administrator", "Administrator");

        // Fetch the root document
        Document result = nuxeoClient.automation().param("value", "/").execute("Repository.GetDocument");
        System.out.println(result.getName());

        // Execute query
        Operation operation = nuxeoClient.automation("Repository.Query").param("query", "SELECT * " + "FROM Document");
        Documents result1 = operation.execute();

        System.out.println(result1.size());

    }
}
