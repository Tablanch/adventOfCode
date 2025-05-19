### Quando sei nel mezzo di un merge commit manuale
Ad esempio, Git ha fatto il merge tra develop e main, e ora ti chiede di inserire un messaggio di commit per il merge.

Ti si aprirà automaticamente una schermata, l'editor Vim, per scrivere il messaggio di merge.

Il messaggio predefinito è:
```bash
Merge branch 'develop'
```
a questo punto puoi:

- Lasciare questo messaggio (va benissimo così)
- Aggiungere una descrizione, es: + Alias aggiornati + Sync con develop
- Oppure uscire per annullare il merge (ma non è quello che vuoi solitamente)

### Cosa fare

Se vedi la stringa:
 ```bash
-- INSERT --
```
Premi 'ESC' per uscire dalla modalità di aggiornamento

Per confermare il messaggio così com'è:
1. Premi:
    ```bash
    :wq
    [Invio]
    ```
    (:wq Significa “write & quit”)

    Git registrerà il merge con quel messaggio.

3. Una volta chiuso l’editor e completato il merge, a meno che tu non abbia usato un alias che fa già il push, esegui:
    ```bash
    git push origin main
    ```


