package org.web3j.crypto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StructuredData {
    public void dependencies(String primaryType) {
        // Recursively finds all the dependencies of a type
        System.out.println(primaryType);

        HashSet<String> deps = new HashSet<>();
        List<String> types = new ArrayList<>();

        types.add(primaryType);

        //        while (types.size() > 0) {
        //            String struct_name = types.get(types.size() - 1);
        //            deps.add(struct_name);
        //
        //            fields = types[struct_name];
        //        }
        //
        //        if (found.includes(primaryType)) {
        //            return found;
        //        }
        //        if (types[primaryType] === undefined) {
        //            return found;
        //        }
        //        found.push(primaryType);
        //        for (let field of types[primaryType]) {
        //            for (let dep of dependencies(field.type, found)) {
        //                if (!found.includes(dep)) {
        //                    found.push(dep);
        //                }
        //            }
        //        }
        //        return found;
    }

    public void parseJSONMessage(String jsonMessageInString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map;

        // convert JSON string to Map
        map = mapper.readValue(jsonMessageInString, new TypeReference<HashMap<String, String>>(){});

        System.out.println(map);
    }

    public static void main(String[] args) throws IOException {
        StructuredData sd = new StructuredData();
        String jsonMessageString = new String(
                Files.readAllBytes(Paths.get("ValidStructuredMessage.json")),
                "UTF-8"
        );
        sd.parseJSONMessage(jsonMessageString);
    }
}
