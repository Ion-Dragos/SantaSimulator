# Santa Simulator
### Ion Dragos - Cosmin

## DESIGN PATTERNS

### SINGLETON -> Pachet simulation -> Clasa Simulation
    Am folosit aici singleton pentru a crea o singura instanta a simularii 
    noastre de fiecare data cand se face un test nou.

### STRATEGY -> Pachet strategy -> Interfata Strategy
    Am utilizat strategy pentru a calcula averageScore-ul pentru fiecare tip
    de copil in parte.

    BabyConcreteStrategy -> Returnam pur si simplu 10
    KidConcreteStrategy -> Facem media aritmetica a averageScore-urilor 
        din niceScoreHistory
    TeenConcreteStrategy -> Facem media ponderata a averageScore-urilor 
        din niceScoreHistory


### FACTORY -> Pachet factory -> Clasa ChildFactory
    In ChildFactory avem metoda createStrategy in care dam ca parametru un child
    si in functie de varsta pe care o are calculam averageScore-ul cu metoda
    corespunzatoare.

### Builder -> Pachet database -> Clasa child
    Am folosit acest design pattern pentru a instantia un copil doar cu
    detaliile pe care le primeste din input, iar pe urma sa adaugam ce
    mai este nevoie de-a lungul programului si pentru output. Ne ajuta acest
    lucru deoarece nu trebuie sa facem mai multi constructori pentru diferite
    cazuri.

## STRUCTURA PROGRAMULUI SI ORGANIZAREA ACESTUIA:

* input -> ChildInput, PresentInput, InitialDataInput, ChildUpdateInput,
  AnnualChangesInput, InputData
    * toate aceste clase au fost facute pentru a putea citi din fisierele json de intrare

* output ->  ChildOutput, ChildrenOutput, DatabaseOutput
    * toate aceste clase au fost dacute pentru a putea citi din fisierele json de iesire

* database -> Child, Gift, Santa, ChildUpdate, AnnualChanges
    * Child:
        * pe langa campurile care se afla in input am adaugat si cele care se afla in output
        * metoda setupChild() este cea care face aceasta diferenta si seteaza strategia care va fi a aleasa
    * Gift:
        * un deep copy la gift-urile din input
    * Santa:
        * am facut aceasta clasa tot singleton deoarece exista un singur Mos Craciun
          de-a lungul jocului.
        * am considera ca bugetul fiecarui copil al trebui sa fie un camp in aceasta clasa si de aceea am facut un map
        * metoda setupChildBudget() face acest lucru conform informatiilor de pe ocw
    * ChildUpdate:
        * un deep copy la update-urile din input
    * AnnualChanges:
        * un deep copy la schimbarile anuale care apar in input

* simulation -> Simulation, SimulationUpdates
    * Simulation:
        * clasa in care se foloseste design pattern-ul singleton
        * metoda startSimulation() este cea in care implementam efectiv logica jocului

    * SimulationUpdates:
        * metoda updateGame() este cea care face update-urile necesare pentru fiecare an care vine
        * restul metodelor care apar aici sunt explicate in javadocs
        

* UPDATE:
    * Simulation:
        * am adaugat in flow-ul programului si niceScoreBonus-ul

    * SimulationUpdates:
        * am modularizat mai mult codul fata de etapa 1 si am modificat functiile
          deja existente cu noile informatii pe care le primim
        * metodele shareGifts() si getSmallestPrice() acum tin cont si de cantitatea
          cadoului
        * metoda applyElf() vede ce elf are fiecare copil si ii modifica
          bugetul in functie de asta
        * metoda chooseMethodSharingGifts() sorteaza copiii in functie de
          cum ne este specificat in fiecare an pentru a imparti corespunzator
          cadourile
        * metoda shareGiftsYellowElf() imparte cadouri copiilor care nu au primit
          nimic in acel an din diferite motive, folosindu-se de metoda
          getSmallestPriceYellow()
    
    



