package com.fviel.jsonmngr.FinEvents.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fviel.jsonmngr.FinEvents.model.Account;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Service
public class FinEventsService {

    private static final String FILE = "events.json";
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * List all existing accounts
     * 
     * @return
     */
    public List<Account> list() {
        try {
            File file = new File(FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Account>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    public Account save(Account account) {
        List<Account> accounts = list();
        long newId = accounts.stream()
                .mapToLong(a -> a.id())
                .max()
                .orElse(0L) + 1;

        Account newAccount = new Account(newId, account.ownnerName(), account.initialValue(), account.coin(),
                account.events());

        accounts.add(newAccount);

        persistFile(accounts);

        return newAccount;
    }

    public void persistFile(List<Account> accounts) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE), accounts);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
